/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.dao.UserDao;
import com.kasisripriyawebapps.myindia.dto.ExternalServiceResponse;
import com.kasisripriyawebapps.myindia.dto.UserElectroralData;
import com.kasisripriyawebapps.myindia.dto.UserElectroralResponse;
import com.kasisripriyawebapps.myindia.entity.User;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyResponse;
import com.kasisripriyawebapps.myindia.service.ExternalService;
import com.kasisripriyawebapps.myindia.service.UserService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	ExternalService externalService;

	Map<String, Integer> userSearchTermFoundResults = new HashMap<String, Integer>();
	Map<String, Integer> userSearchTermFilledResults = new HashMap<String, Integer>();
	int pageOffSet = ServiceConstants.DEAFULT_PAGE_OFFSET;

	@Override
	@Transactional
	public void uploadAllUsers() throws InternalServerException {
		List<UserElectroralData> userElectroralList = new ArrayList<UserElectroralData>();
		ExternalServiceResponse serviceResponse = CommonUtil.callURL(ApplicationConstants.ELECTRORAL_SEARCH_FULL_URL);
		getCaptcha(serviceResponse, userElectroralList);
	}

	private void getUsersData(String captcha, ExternalServiceResponse serviceResponseObj, String searchTerm,
			List<UserElectroralData> userElectroralList) throws InternalServerException {
		String responseCookieHeaders = getResposeCookieHeaders(serviceResponseObj.getResponseHeaders());
		Map<String, Object> serviceParams = new HashMap<String, Object>();
		Map<String, Object> requestParamInfo = new HashMap<String, Object>();

		requestParamInfo.put(ServiceConstants.REQUEST_PARAM_LOCATION_RANGE, 20);
		requestParamInfo.put(ServiceConstants.REQUEST_PARAM_NAME, searchTerm);
		requestParamInfo.put(ServiceConstants.REQUEST_PARAM_PAGE_NO, pageOffSet);
		requestParamInfo.put(ServiceConstants.REQUEST_PARAM_RESULT_PER_PGAE, ServiceConstants.DEAFULT_PAGE_LIMIT);
		requestParamInfo.put(ServiceConstants.REQUEST_PARAM_SEARCH_TYPE, "details");
		requestParamInfo.put(ServiceConstants.REQUEST_PARAM_TEXT_CAPTCHA, captcha);
		requestParamInfo.put(ServiceConstants.REUREUREIRED, getReureureired(serviceResponseObj.getResponse()));
		serviceParams.put(ServiceConstants.BASE_URL, ApplicationConstants.ELECTRORAL_SEARCH);
		serviceParams.put(ServiceConstants.SERVICE_URL, ApplicationConstants.ELECTRORAL_SEARCH_SERVICE_URL);
		serviceParams.put(ServiceConstants.REQUEST_TYPE, ServiceConstants.REQUEST_TYPE_GET);
		serviceParams.put(ServiceConstants.REQUEST_PARAMS_INFO, requestParamInfo);
		serviceParams.put(ServiceConstants.COOKIES, responseCookieHeaders);

		ExternalServiceResponse serviceResponse = externalService.invokeExternalService(serviceParams);
		if (serviceResponse != null) {
			if (serviceResponse.getStatusCode() == 200) {
				if (!serviceResponse.getResponse().isEmpty()) {
					if (serviceResponse.getResponse().equalsIgnoreCase(ServiceConstants.INVALID_CAPTCHA)) {
						ExternalServiceResponse serviceResponseObject = CommonUtil
								.callURL(ApplicationConstants.ELECTRORAL_SEARCH_FULL_URL);
						getCaptcha(serviceResponseObject, userElectroralList);
					} else {
						try {
							JSONObject jsonObject = new JSONObject(serviceResponse.getResponse());
							JSONObject finalResponse = jsonObject.getJSONObject("response");

							final Gson gson = new Gson();
							final Type listType = new TypeToken<UserElectroralResponse>() {
							}.getType();
							UserElectroralResponse userElectroralResponse = gson.fromJson(finalResponse.toString(),
									listType);

							if (userElectroralResponse != null) {
								for (UserElectroralData eachData : userElectroralResponse.getDocs()) {
									if (!userElectroralList.contains(eachData)) {
										userElectroralList.add(eachData);
									}
									userSearchTermFilledResults.put(searchTerm, userElectroralList.size());
								}
								if (userElectroralResponse.getNumFound() > 0) {
									userSearchTermFoundResults.put(searchTerm, userElectroralResponse.getNumFound());
								}
							}

							if (userElectroralList != null && !userElectroralList.isEmpty()
									&& userElectroralList.size() >= 100) {
								saveUserData(userElectroralList.subList(0, 100));
								userElectroralList.subList(0, 100).clear();
							}

							if (userSearchTermFoundResults.get(searchTerm)
									.equals(userSearchTermFilledResults.get(searchTerm))) {
								pageOffSet = 1;
								getUsersData(captcha, serviceResponseObj, searchTerm, userElectroralList);
							} else {
								pageOffSet += 1;
								getUsersData(captcha, serviceResponseObj, searchTerm, userElectroralList);
							}

						} catch (JSONException e) {
							new InternalServerException(e.getMessage());
						}
					}
				}
			} else {
				throw new InternalServerException(serviceResponse.getErrorMessage());
			}
		}
	}

	private void getCaptcha(ExternalServiceResponse serviceResponseObj, List<UserElectroralData> userElectroralList)
			throws InternalServerException {
		String responseCookieHeaders = getResposeCookieHeaders(serviceResponseObj.getResponseHeaders());
		Map<String, Object> serviceParams = new HashMap<String, Object>();
		Map<String, Object> requestParamInfo = new HashMap<String, Object>();
		requestParamInfo.put(ServiceConstants.REQUEST_PARAM_IMAGE, ServiceConstants.BOOLEAN_FALSE);
		serviceParams.put(ServiceConstants.BASE_URL, ApplicationConstants.ELECTRORAL_SEARCH);
		serviceParams.put(ServiceConstants.SERVICE_URL, ApplicationConstants.ELECTRORAL_CAPTCHA_SERVICE_URL);
		serviceParams.put(ServiceConstants.REQUEST_PARAMS_INFO, requestParamInfo);
		serviceParams.put(ServiceConstants.REQUEST_TYPE, ServiceConstants.REQUEST_TYPE_GET);
		serviceParams.put(ServiceConstants.COOKIES, responseCookieHeaders);
		ExternalServiceResponse serviceResponse = externalService.invokeExternalService(serviceParams);
		if (serviceResponse != null) {
			File captchaFile = new File(CommonUtil.getImageLocation(serviceResponse.getResponse(),
					ServiceConstants.CAPTCHA_IMAGE_FILE_NAME));
			String captchFileName = captchaFile.getAbsolutePath();
			BytePointer outText;
			TessBaseAPI api = new TessBaseAPI();
			if (api.Init(
					"C:\\Users\\kanduk\\Documents\\My Work\\Documents\\My Web Sites\\Spring Suite Workspace\\spring-boot-samples-master\\spring-boot-mysql-hibernate\\src\\main\\java\\com\\kasisripriyawebapps\\myindia\\util\\",
					"ENG") != 0) {

				System.exit(1);
			}
			// Open input image with leptonica library
			PIX image = pixRead(captchFileName);
			api.SetImage(image);
			// Get OCR result
			outText = api.GetUTF8Text();
			String captcha = outText.getString();
			captcha = CommonUtil.getFinalCaptcha(captcha);
			api.End();
			outText.deallocate();
			pixDestroy(image);
			getUsersData(captcha, serviceResponseObj, CommonUtil.searchTerms.get(0), userElectroralList);
		}
	}

	private String getResposeCookieHeaders(Map<String, List<String>> map) {
		String cookieHeaders = "";
		StringJoiner joiner = new StringJoiner(",");
		if (map != null) {
			List<String> cookiesList = map.get("Set-Cookie");
			if (null != cookiesList && !cookiesList.isEmpty()) {
				for (String eachCookie : cookiesList) {
					joiner.add(eachCookie);
				}
			}
		}
		cookieHeaders = joiner.toString();
		return cookieHeaders;
	}

	private String getReureureired(String webSiteResponse) {
		int indexOf = webSiteResponse.indexOf("_aquire");
		String subStr = webSiteResponse.substring(indexOf, indexOf + 100);
		int subStrIndexOf = subStr.indexOf("return");
		int subStrIndexOf1 = subStr.indexOf(";");
		String subStr1 = subStr.substring(subStrIndexOf + 8, subStrIndexOf1 - 1);
		return subStr1;
	}

	private void saveUserData(List<UserElectroralData> userElectroralList) throws InternalServerException {
		List<User> users = new ArrayList<User>();
		for (UserElectroralData eachData : userElectroralList) {
			final Gson gson = new Gson();
			String eachDataJson = gson.toJson(eachData);
			User user = gson.fromJson(eachDataJson, User.class);
			user.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			user.setIdCardType(ApplicationConstants.IDENTITY_CARD_TYPE_VOTER_ID);
			user.setIdCardNo(eachData.getEpIcNo());
			users.add(user);
		}
		if (users != null && !users.isEmpty()) {
			userDao.saveUsers(users);
		}
	}

	@Transactional
	@Override
	public GetUserByPropertyResponse getUserByVoterIdName(GetUserByPropertyRequest getUserByPropertyRequest)
			throws InternalServerException, RecordNotFoundException {
		GetUserByPropertyResponse response = null;
		User user = userDao.getUserByIDTypeAndNo(getUserByPropertyRequest.getIdCardType(),
				getUserByPropertyRequest.getIdCardNo());
		if (user != null) {
			user = userDao.getUserByIDTypeNoAndName(getUserByPropertyRequest.getIdCardType(),
					getUserByPropertyRequest.getIdCardNo(), getUserByPropertyRequest.getUserName());
			if (user != null) {
				response = new GetUserByPropertyResponse();
				response.setReferenceType(user.getFatherOrHusband());
			} else {
				throw new RecordNotFoundException(ExceptionConstants.INVALID_ID_CARD_NO_NAME);
			}
		} else {
			throw new RecordNotFoundException(ExceptionConstants.INVALID_ID_CARD_NO);
		}
		return response;
	}

	@Transactional
	@Override
	public GetUserByPropertyResponse getUserByVoterIdNameAndReference(GetUserByPropertyRequest getUserByPropertyRequest)
			throws InternalServerException, RecordNotFoundException {
		GetUserByPropertyResponse response = null;
		User user = null;
		if (getUserByVoterIdName(getUserByPropertyRequest) != null) {
			user = userDao.getUserByIDTypeNoNameAndReference(getUserByPropertyRequest.getIdCardType(),
					getUserByPropertyRequest.getIdCardNo(), getUserByPropertyRequest.getUserName(),
					getUserByPropertyRequest.getReferenceType(), getUserByPropertyRequest.getReferenceName());
			if (user != null) {
				response = new GetUserByPropertyResponse();
				response.setLocationState(user.getState());
				response.setLocationDistrict(user.getDistrict());
				response.setLocationMpConstituency(user.getPcName());
				response.setLocationMLAConstituency(user.getAssemblyConstituencyName());
			} else {
				throw new RecordNotFoundException(ExceptionConstants.INVALID_REFERENCE_DETAILS_NAME);
			}
		}
		return response;
	}

}
