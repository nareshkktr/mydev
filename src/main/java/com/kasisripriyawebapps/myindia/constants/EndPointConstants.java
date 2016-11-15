/*
 * 
 */
package com.kasisripriyawebapps.myindia.constants;

// TODO: Auto-generated Javadoc
/**
 * The Class EndPointConstants.
 */
public class EndPointConstants {

	// Http Methods

	/** The Constant HTTP_GET. */
	public static final String HTTP_GET = "GET";

	/** The Constant HTTP_POST. */
	public static final String HTTP_POST = "POST";

	/** The Constant HTTP_PUT. */
	public static final String HTTP_PUT = "PUT";

	/** The Constant HTTP_DELETE. */
	public static final String HTTP_DELETE = "DELETE";

	// Request Mapping Constants Class Level

	/** The Constant ACCOUNT_ENDPOINT_REQUEST_MAPPING. */
	public static final String ACCOUNT_ENDPOINT_REQUEST_MAPPING = "/account";

	/** The Constant ACCOUNT_ENDPOINT_API_VALUE. */
	public static final String ACCOUNT_ENDPOINT_API_VALUE = "account";

	/** The Constant ACCOUNT_ENDPOINT_API_TAGS. */
	public static final String ACCOUNT_ENDPOINT_API_TAGS = "account";

	/** The Constant ACCOUNT_ENDPOINT_API_DESCRIPTION. */
	public static final String ACCOUNT_ENDPOINT_API_DESCRIPTION = "Account Management API";

	// Request Mapping Constants Method Level

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String CREATE_ACCOUNT_REQUEST_MAPPING = "createAccount";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String CREATE_ACCOUNT_API_VALUE = "createAccount";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String CREATE_ACCOUNT_API_NICKNAME = "createAccount";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String CREATE_ACCOUNT_API_DESCRIPTION = "Save User Account Details";

	/** The Constant UPDATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String UPDATE_ACCOUNT_REQUEST_MAPPING = "/updateAccount";

	/** The Constant UPDATE_ACCOUNT_API_VALUE. */
	public static final String UPDATE_ACCOUNT_API_VALUE = "updateAccount";

	/** The Constant UPDATE_ACCOUNT_API_NICKNAME. */
	public static final String UPDATE_ACCOUNT_API_NICKNAME = "updateAccount";

	/** The Constant UPDATE_ACCOUNT_API_DESCRIPTION. */
	public static final String UPDATE_ACCOUNT_API_DESCRIPTION = "Update User Account Details";

	/** The Constant DELETE_ACCOUNT_REQUEST_MAPPING. */
	public static final String DELETE_ACCOUNT_REQUEST_MAPPING = "/deleteAccount/{accountId}";

	/** The Constant DELETE_ACCOUNT_API_VALUE. */
	public static final String DELETE_ACCOUNT_API_VALUE = "deleteAccount/{accountId}";

	/** The Constant DELETE_ACCOUNT_API_NICKNAME. */
	public static final String DELETE_ACCOUNT_API_NICKNAME = "deleteAccount";

	/** The Constant DELETE_ACCOUNT_API_DESCRIPTION. */
	public static final String DELETE_ACCOUNT_API_DESCRIPTION = "Delete User Account Details";

	/** The Constant GET_ACCOUNT_BY_ID_REQUEST_MAPPING. */
	public static final String GET_ACCOUNT_BY_ID_REQUEST_MAPPING = "/getAccountByGuid/{accountId}";

	/** The Constant GET_ACCOUNT_BY_ID_API_VALUE. */
	public static final String GET_ACCOUNT_BY_ID_API_VALUE = "getAccountByGuid/{accountId}";

	/** The Constant GET_ACCOUNT_BY_ID_API_NICKNAME. */
	public static final String GET_ACCOUNT_BY_ID_API_NICKNAME = "getAccountByGuid";

	/** The Constant GET_ACCOUNT_BY_ID_API_DESCRIPTION. */
	public static final String GET_ACCOUNT_BY_ID_API_DESCRIPTION = "Get User Account Details By Account Id";

	/** The Constant GET_ACCOUNT_BY_EMAIL_REQUEST_MAPPING. */
	public static final String GET_ACCOUNT_BY_EMAIL_REQUEST_MAPPING = "/getAccountByEmail/{emailAddress}";

	/** The Constant GET_ACCOUNT_BY_EMAIL_API_VALUE. */
	public static final String GET_ACCOUNT_BY_EMAIL_API_VALUE = "getAccountByEmail/{emailAddress}";

	/** The Constant GET_ACCOUNT_BY_EMAIL_API_NICKNAME. */
	public static final String GET_ACCOUNT_BY_EMAIL_API_NICKNAME = "getAccountByEmail";

	/** The Constant GET_ACCOUNT_BY_EMAIL_DESCRIPTION. */
	public static final String GET_ACCOUNT_BY_EMAIL_DESCRIPTION = "Get User Account Details By E-mail";

	/** The Constant GET_ALL_ACCOUNTS_REQUEST_MAPPING. */
	public static final String GET_ALL_ACCOUNTS_REQUEST_MAPPING = "/getAllAccounts";

	/** The Constant GET_ALL_ACCOUNTS_API_VALUE. */
	public static final String GET_ALL_ACCOUNTS_API_VALUE = "getAllAccounts";

	/** The Constant GET_ALL_ACCOUNTS_API_NICKNAME. */
	public static final String GET_ALL_ACCOUNTS_API_NICKNAME = "getAllAccounts";

	/** The Constant GET_ALL_ACCOUNTS_API_DESCRIPTION. */
	public static final String GET_ALL_ACCOUNTS_API_DESCRIPTION = "Get All User Accounts";

	/** The Constant GET_ACCOUNTS_BY_FILTERS_REQUEST_MAPPING. */
	public static final String GET_ACCOUNTS_BY_FILTERS_REQUEST_MAPPING = "/getAccountsByFilters";

	/** The Constant GET_ACCOUNTS_BY_FILTERS_API_VALUE. */
	public static final String GET_ACCOUNTS_BY_FILTERS_API_VALUE = "getAccountsByFilters";

	/** The Constant GET_ACCOUNTS_BY_FILTERS_API_NICKNAME. */
	public static final String GET_ACCOUNTS_BY_FILTERS_API_NICKNAME = "getAccountsByFilters";

	/** The Constant GET_ACCOUNTS_BY_FILTERS_API_DESCRIPTION. */
	public static final String GET_ACCOUNTS_BY_FILTERS_API_DESCRIPTION = "Get User Accounts By Dynamic Account Filters";

	/** The Constant LOGIN_ACCOUNT_REQUEST_MAPPING. */
	public static final String LOGIN_ACCOUNT_REQUEST_MAPPING = "/login";

	/** The Constant LOGIN_ACCOUNT_API_VALUE. */
	public static final String LOGIN_ACCOUNT_API_VALUE = "login";

	/** The Constant LOGIN_ACCOUNT_API_NICKNAME. */
	public static final String LOGIN_ACCOUNT_API_NICKNAME = "login";

	/** The Constant LOGIN_ACCOUNT_API_DESCRIPTION. */
	public static final String LOGIN_ACCOUNT_API_DESCRIPTION = "Login Into Account";

	/** The Constant USER_ENDPOINT_REQUEST_MAPPING. */
	public static final String USER_ENDPOINT_REQUEST_MAPPING = "/user";

	/** The Constant USER_ENDPOINT_API_VALUE. */
	public static final String USER_ENDPOINT_API_VALUE = "user";

	/** The Constant USER_ENDPOINT_API_TAGS. */
	public static final String USER_ENDPOINT_API_TAGS = "user";

	/** The Constant USER_ENDPOINT_API_DESCRIPTION. */
	public static final String USER_ENDPOINT_API_DESCRIPTION = "User Management API";

	/** The Constant CREATE_USER_REQUEST_MAPPING. */
	public static final String CREATE_USER_REQUEST_MAPPING = "/createUser";

	/** The Constant CREATE_USER_API_VALUE. */
	public static final String CREATE_USER_API_VALUE = "createUser";

	/** The Constant CREATE_USER_API_NICKNAME. */
	public static final String CREATE_USER_API_NICKNAME = "createUser";

	/** The Constant CREATE_USER_API_DESCRIPTION. */
	public static final String CREATE_USER_API_DESCRIPTION = "Save User Details";

	/** The Constant GET_USER_BY_ID_REQUEST_MAPPING. */
	public static final String GET_USER_BY_ID_REQUEST_MAPPING = "/getUserById/{userId}";

	/** The Constant GET_USER_BY_ID_API_VALUE. */
	public static final String GET_USER_BY_ID_API_VALUE = "getUserById/{userId}";

	/** The Constant GET_USER_BY_ID_API_NICKNAME. */
	public static final String GET_USER_BY_ID_API_NICKNAME = "getUserById";

	/** The Constant GET_USER_BY_ID_API_DESCRIPTION. */
	public static final String GET_USER_BY_ID_API_DESCRIPTION = "Get User Details By ID";

	/** The Constant GET_USER_BY_IDTYPE_NO_REQUEST_MAPPING. */
	public static final String GET_USER_BY_IDTYPE_NO_REQUEST_MAPPING = "/getUserByIdTypeNo/{IDType}/{IDNo}";

	/** The Constant GET_USER_BY_IDTYPE_NO_API_VALUE. */
	public static final String GET_USER_BY_IDTYPE_NO_API_VALUE = "getUserByIdTypeNo/{IDType}/{IDNo}";

	/** The Constant GET_USER_BY_IDTYPE_NO_API_NICKNAME. */
	public static final String GET_USER_BY_IDTYPE_NO_API_NICKNAME = "getUserByIdTypeNo";

	/** The Constant GET_USER_BY_IDTYPE_NO_API_DESCRIPTION. */
	public static final String GET_USER_BY_IDTYPE_NO_API_DESCRIPTION = "Get User Details By ID Type And ID No";

	/** The Constant DELETE_USER_REQUEST_MAPPING. */
	public static final String DELETE_USER_REQUEST_MAPPING = "/deleteUser/{userId}";

	/** The Constant DELETE_USER_API_VALUE. */
	public static final String DELETE_USER_API_VALUE = "deleteUser/{userId}";

	/** The Constant DELETE_USER_API_NICKNAME. */
	public static final String DELETE_USER_API_NICKNAME = "deleteUser";

	/** The Constant DELETE_USER_API_DESCRIPTION. */
	public static final String DELETE_USER_API_DESCRIPTION = "Delete User Details";

	/** The Constant GET_ALL_USERS_REQUEST_MAPPING. */
	public static final String GET_ALL_USERS_REQUEST_MAPPING = "/getAllUsers";

	/** The Constant GET_ALL_USERS_API_VALUE. */
	public static final String GET_ALL_USERS_API_VALUE = "getAllUsers";

	/** The Constant GET_ALL_USERS_API_NICKNAME. */
	public static final String GET_ALL_USERS_API_NICKNAME = "getAllUsers";

	/** The Constant GET_ALL_USERS_API_DESCRIPTION. */
	public static final String GET_ALL_USERS_API_DESCRIPTION = "Get All Users";

	/** The Constant UPLOAD_ALL_USERS_REQUEST_MAPPING. */
	public static final String UPLOAD_ALL_USERS_REQUEST_MAPPING = "/uploadAllUsers";

	/** The Constant UPLOAD_ALL_USERS_API_VALUE. */
	public static final String UPLOAD_ALL_USERS_API_VALUE = "uploadAllUsers";

	/** The Constant UPLOAD_ALL_USERS_API_NICKNAME. */
	public static final String UPLOAD_ALL_USERS_API_NICKNAME = "uploadAllUsers";

	/** The Constant UPLOAD_ALL_USERS_API_DESCRIPTION. */
	public static final String UPLOAD_ALL_USERS_API_DESCRIPTION = "Upload All Users";

	public static final String LOCATION_ENDPOINT_REQUEST_MAPPING = "/location";
	public static final String LOCATION_ENDPOINT_API_VALUE = "location";
	public static final String LOCATION_ENDPOINT_API_TAGS = "location";
	public static final String LOCATION_ENDPOINT_API_DESCRIPTION = "Location Management API";
	public static final String UPLOAD_ALL_LOCATIONS_REQUEST_MAPPING = "uploadAllLocations";
	public static final String UPLOAD_ALL_LOCATIONS_API_VALUE = "uploadAllLocations";
	public static final String UPLOAD_ALL_LOCATIONS_API_NICKNAME = "uploadAllLocations";
	public static final String UPLOAD_ALL_LOCATIONS_API_DESCRIPTION = "Upload All Locations";

	public static final String IMAGE_ENDPOINT_REQUEST_MAPPING = "/image";
	public static final String IMAGE_ENDPOINT_API_VALUE = "image";
	public static final String IMAGE_ENDPOINT_API_TAGS = "image";
	public static final String IMAGE_ENDPOINT_API_DESCRIPTION = "Image Management API";

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String ADD_IMAGES_REQUEST_MAPPING = "addImages";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String ADD_IMAGES_API_VALUE = "addImages";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String ADD_IMAGES_API_NICKNAME = "addImages";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String ADD_IMAGES_API_DESCRIPTION = "Add Images";

	/** The Constant UPLOAD_ALL_USERS_REQUEST_MAPPING. */
	public static final String GET_USER_BY_VOTER_ID_NAME_REQUEST_MAPPING = "getUserByVoterIdName";

	/** The Constant UPLOAD_ALL_USERS_API_VALUE. */
	public static final String GET_USER_BY_VOTER_ID_NAME_API_VALUE = "getUserByVoterIdName";

	/** The Constant UPLOAD_ALL_USERS_API_NICKNAME. */
	public static final String GET_USER_BY_VOTER_ID_NAME_API_NICKNAME = "getUserByVoterIdName";

	/** The Constant UPLOAD_ALL_USERS_API_DESCRIPTION. */
	public static final String GET_USER_BY_VOTER_ID_NAME_API_DESCRIPTION = "Get User Info By Voter Id And Name";

	/** The Constant UPLOAD_ALL_USERS_REQUEST_MAPPING. */
	public static final String GET_USER_BY_VOTER_ID_NAME_REFERENCE_REQUEST_MAPPING = "getUserByVoterIdNameAndReference";

	/** The Constant UPLOAD_ALL_USERS_API_VALUE. */
	public static final String GET_USER_BY_VOTER_ID_NAME_REFERENCE_API_VALUE = "getUserByVoterIdNameAndReference";

	/** The Constant UPLOAD_ALL_USERS_API_NICKNAME. */
	public static final String GET_USER_BY_VOTER_ID_NAME_REFERENCE_API_NICKNAME = "getUserByVoterIdNameAndReference";

	/** The Constant UPLOAD_ALL_USERS_API_DESCRIPTION. */
	public static final String GET_USER_BY_VOTER_ID_NAME_REFERENCE_API_DESCRIPTION = "Get User Info By Voter Id,Name,Reference Details";

	/** The Constant ACCOUNT_ENDPOINT_REQUEST_MAPPING. */
	public static final String PROBLEM_TYPE_ENDPOINT_REQUEST_MAPPING = "/problemType";

	/** The Constant ACCOUNT_ENDPOINT_API_VALUE. */
	public static final String PROBLEM_TYPE_ENDPOINT_API_VALUE = "problemType";

	/** The Constant ACCOUNT_ENDPOINT_API_TAGS. */
	public static final String PROBLEM_TYPE_ENDPOINT_API_TAGS = "problemType";

	/** The Constant ACCOUNT_ENDPOINT_API_DESCRIPTION. */
	public static final String PROBLEM_TYPE_ENDPOINT_API_DESCRIPTION = "Problem Types Management API";

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String CREATE_PROBLEM_TYPE_REQUEST_MAPPING = "createProblemType";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String CREATE_PROBLEM_TYPE_API_VALUE = "createProblemType";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String CREATE_PROBLEM_TYPE_API_NICKNAME = "createProblemType";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String CREATE_PROBLEM_TYPE_API_DESCRIPTION = "Create Problem Type";

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String UPDATE_PROBLEM_TYPE_REQUEST_MAPPING = "updateProblemType";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String UPDATE_PROBLEM_TYPE_API_VALUE = "updateProblemType";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String UPDATE_PROBLEM_TYPE_API_NICKNAME = "updateProblemType";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String UPDATE_PROBLEM_TYPE_API_DESCRIPTION = "Update Problem Type";

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String DELETE_PROBLEM_TYPE_REQUEST_MAPPING = "deleteProblemType";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String DELETE_PROBLEM_TYPE_API_VALUE = "deleteProblemType";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String DELETE_PROBLEM_TYPE_API_NICKNAME = "deleteProblemType";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String DELETE_PROBLEM_TYPE_API_DESCRIPTION = "Delete Problem Type";

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String GET_ALL_PROBLEM_TYPES_REQUEST_MAPPING = "getAllProblemTypes/{offset}/{limit}";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String GET_ALL_PROBLEM_TYPES_API_VALUE = "getAllProblemTypes";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String GET_ALL_PROBLEM_TYPES_API_NICKNAME = "getAllProblemTypes";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String GET_ALL_PROBLEM_TYPES_API_DESCRIPTION = "Get All Problem Types";

	/** The Constant ACCOUNT_ENDPOINT_REQUEST_MAPPING. */
	public static final String ACTIVITY_ENDPOINT_REQUEST_MAPPING = "/activity";

	/** The Constant ACCOUNT_ENDPOINT_API_VALUE. */
	public static final String ACTIVITY_ENDPOINT_API_VALUE = "activity";

	/** The Constant ACCOUNT_ENDPOINT_API_TAGS. */
	public static final String ACTIVITY_ENDPOINT_API_TAGS = "activity";

	/** The Constant ACCOUNT_ENDPOINT_API_DESCRIPTION. */
	public static final String ACTIVITY_ENDPOINT_API_DESCRIPTION = "Users Activity Management API";

	/** The Constant ACCOUNT_ENDPOINT_REQUEST_MAPPING. */
	public static final String EVENT_ENDPOINT_REQUEST_MAPPING = "/event";

	/** The Constant ACCOUNT_ENDPOINT_API_VALUE. */
	public static final String EVENT_ENDPOINT_API_VALUE = "event";

	/** The Constant ACCOUNT_ENDPOINT_API_TAGS. */
	public static final String EVENT_ENDPOINT_API_TAGS = "event";

	/** The Constant ACCOUNT_ENDPOINT_API_DESCRIPTION. */
	public static final String EVENT_ENDPOINT_API_DESCRIPTION = "Event Management API";

	/** The Constant ACCOUNT_ENDPOINT_REQUEST_MAPPING. */
	public static final String PARTY_ENDPOINT_REQUEST_MAPPING = "/party";

	/** The Constant ACCOUNT_ENDPOINT_API_VALUE. */
	public static final String PARTY_ENDPOINT_API_VALUE = "party";

	/** The Constant ACCOUNT_ENDPOINT_API_TAGS. */
	public static final String PARTY_ENDPOINT_API_TAGS = "party";

	/** The Constant ACCOUNT_ENDPOINT_API_DESCRIPTION. */
	public static final String PARTY_ENDPOINT_API_DESCRIPTION = "Party Management API";

	/** The Constant ACCOUNT_ENDPOINT_REQUEST_MAPPING. */
	public static final String POLITICIAN_ENDPOINT_REQUEST_MAPPING = "/politician";

	/** The Constant ACCOUNT_ENDPOINT_API_VALUE. */
	public static final String POLITICIAN_ENDPOINT_API_VALUE = "politician";

	/** The Constant ACCOUNT_ENDPOINT_API_TAGS. */
	public static final String POLITICIAN_ENDPOINT_API_TAGS = "politician";

	/** The Constant ACCOUNT_ENDPOINT_API_DESCRIPTION. */
	public static final String POLITICIAN_ENDPOINT_API_DESCRIPTION = "Politician Management API";

	/** The Constant ACCOUNT_ENDPOINT_REQUEST_MAPPING. */
	public static final String POST_ENDPOINT_REQUEST_MAPPING = "/politician";

	/** The Constant ACCOUNT_ENDPOINT_API_VALUE. */
	public static final String POST_ENDPOINT_API_VALUE = "politician";

	/** The Constant ACCOUNT_ENDPOINT_API_TAGS. */
	public static final String POST_ENDPOINT_API_TAGS = "politician";

	/** The Constant ACCOUNT_ENDPOINT_API_DESCRIPTION. */
	public static final String POST_ENDPOINT_API_DESCRIPTION = "Politician Management API";

	/** The Constant ACCOUNT_ENDPOINT_REQUEST_MAPPING. */
	public static final String PROBLEM_ENDPOINT_REQUEST_MAPPING = "/problem";

	/** The Constant ACCOUNT_ENDPOINT_API_VALUE. */
	public static final String PROBLEM_ENDPOINT_API_VALUE = "problem";

	/** The Constant ACCOUNT_ENDPOINT_API_TAGS. */
	public static final String PROBLEM_ENDPOINT_API_TAGS = "problem";

	/** The Constant ACCOUNT_ENDPOINT_API_DESCRIPTION. */
	public static final String PROBLEM_ENDPOINT_API_DESCRIPTION = "Problem Management API";

	/** The Constant ACCOUNT_ENDPOINT_REQUEST_MAPPING. */
	public static final String SEARCH_ENDPOINT_REQUEST_MAPPING = "/search";

	/** The Constant ACCOUNT_ENDPOINT_API_VALUE. */
	public static final String SEARCH_ENDPOINT_API_VALUE = "search";

	/** The Constant ACCOUNT_ENDPOINT_API_TAGS. */
	public static final String SEARCH_ENDPOINT_API_TAGS = "search";

	/** The Constant ACCOUNT_ENDPOINT_API_DESCRIPTION. */
	public static final String SEARCH_ENDPOINT_API_DESCRIPTION = "Search Management API";

	/** The Constant ACCOUNT_ENDPOINT_REQUEST_MAPPING. */
	public static final String SHARE_ENDPOINT_REQUEST_MAPPING = "/share";

	/** The Constant ACCOUNT_ENDPOINT_API_VALUE. */
	public static final String SHARE_ENDPOINT_API_VALUE = "share";

	/** The Constant ACCOUNT_ENDPOINT_API_TAGS. */
	public static final String SHARE_ENDPOINT_API_TAGS = "share";

	/** The Constant ACCOUNT_ENDPOINT_API_DESCRIPTION. */
	public static final String SHARE_ENDPOINT_API_DESCRIPTION = "Share Management API";

	/** The Constant ACCOUNT_ENDPOINT_REQUEST_MAPPING. */
	public static final String THUMBS_UP_DOWN_ENDPOINT_REQUEST_MAPPING = "/thumbsUpDown";

	/** The Constant ACCOUNT_ENDPOINT_API_VALUE. */
	public static final String THUMBS_UP_DOWN_ENDPOINT_API_VALUE = "thumbsUpDown";

	/** The Constant ACCOUNT_ENDPOINT_API_TAGS. */
	public static final String THUMBS_UP_DOWN_ENDPOINT_API_TAGS = "thumbsUpDown";

	/** The Constant ACCOUNT_ENDPOINT_API_DESCRIPTION. */
	public static final String THUMBS_UP_DOWN_ENDPOINT_API_DESCRIPTION = "Like/Dislike Management API";

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String GET_ALL_ACTIVITIES_REQUEST_MAPPING = "getAllActivites";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String GET_ALL_ACTIVITIES_API_VALUE = "getAllActivites";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String GET_ALL_ACTIVITIES_API_NICKNAME = "getAllActivites";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String GET_ALL_ACTIVITIES_API_DESCRIPTION = "Get All Activites";

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String GET_ALL_EVENTS_REQUEST_MAPPING = "getAllEvents";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String GET_ALL_EVENTS_API_VALUE = "getAllEvents";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String GET_ALL_EVENTS_API_NICKNAME = "getAllEvents";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String GET_ALL_EVENTS_API_DESCRIPTION = "Get All Events";

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String GET_ALL_PARTIES_REQUEST_MAPPING = "getAllParties";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String GET_ALL_PARTIES_API_VALUE = "getAllParties";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String GET_ALL_PARTIES_API_NICKNAME = "getAllParties";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String GET_ALL_PARTIES_API_DESCRIPTION = "Get All Parties";

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String GET_ALL_POLITICIANS_REQUEST_MAPPING = "getAllPoliticians";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String GET_ALL_POLITICIANS_API_VALUE = "getAllPoliticians";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String GET_ALL_POLITICIANS_API_NICKNAME = "getAllPoliticians";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String GET_ALL_POLITICIANS_API_DESCRIPTION = "Get All Politicians";

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String GET_ALL_POSTS_REQUEST_MAPPING = "getAllPosts";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String GET_ALL_POSTS_API_VALUE = "getAllPosts";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String GET_ALL_POSTS_API_NICKNAME = "getAllPosts";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String GET_ALL_POSTS_API_DESCRIPTION = "Get All Posts";

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String GET_ALL_PROBLEMS_REQUEST_MAPPING = "getAllProblems";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String GET_ALL_PROBLEMS_API_VALUE = "getAllProblems";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String GET_ALL_PROBLEMS_API_NICKNAME = "getAllProblems";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String GET_ALL_PROBLEMS_API_DESCRIPTION = "Get All Problems";

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String GET_ALL_SEARCH_RESULTS_REQUEST_MAPPING = "getAllSearchResults";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String GET_ALL_SEARCH_RESULTS_API_VALUE = "getAllSearchResults";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String GET_ALL_SEARCH_RESULTS_API_NICKNAME = "getAllSearchResults";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String GET_ALL_SEARCH_RESULTS_API_DESCRIPTION = "Get All Search Results";

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String GET_ALL_SHARE_OBJECTS_REQUEST_MAPPING = "getAllShareObjects";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String GET_ALL_SHARE_OBJECTS_API_VALUE = "getAllShareObjects";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String GET_ALL_SHARE_OBJECTS_API_NICKNAME = "getAllShareObjects";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String GET_ALL_SHARE_OBJECTS_API_DESCRIPTION = "Get All Share Objects";

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String GET_ALL_THUMBS_UP_DOWN_OBJECTS_REQUEST_MAPPING = "getAllThumbsUpDownObjects";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String GET_ALL_THUMBS_UP_DOWN_OBJECTS_API_VALUE = "getAllThumbsUpDownObjects";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String GET_ALL_THUMBS_UP_DOWN_OBJECTS_API_NICKNAME = "getAllThumbsUpDownObjects";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String GET_ALL_THUMBS_UP_DOWN_OBJECTS_API_DESCRIPTION = "Get All Like/Dislike Objects";

	public static final String LOCATION_IMPORT_EXPORT_ENDPOINT_REQUEST_MAPPING = "/locationImportExport";
	public static final String LOCATION_IMPORT_EXPORT_ENDPOINT_API_VALUE = "locationImportExport";
	public static final String LOCATION_IMPORT_EXPORT_ENDPOINT_API_TAGS = "locationImportExport";
	public static final String LOCATION_IMPORT_EXPORT_ENDPOINT_API_DESCRIPTION = "Location Import Export Management API";

	public static final String IMPORT_COUNTRY_LOCATIONS_REQUEST_MAPPING = "importCountryLocations";
	public static final String IMPORT_COUNTRY_LOCATIONS_API_VALUE = "importCountryLocations";
	public static final String IMPORT_COUNTRY_LOCATIONS_API_NICKNAME = "importCountryLocations";
	public static final String IMPORT_COUNTRY_LOCATIONS_API_DESCRIPTION = "Import Country Locations";

	public static final String IMPORT_STATE_LOCATIONS_REQUEST_MAPPING = "importStateLocations";
	public static final String IMPORT_STATE_LOCATIONS_API_VALUE = "importStateLocations";
	public static final String IMPORT_STATE_LOCATIONS_API_NICKNAME = "importStateLocations";
	public static final String IMPORT_STATE_LOCATIONS_API_DESCRIPTION = "Import State Locations";

	public static final String IMPORT_DISTRICT_LOCATIONS_REQUEST_MAPPING = "importDistrictLocations";
	public static final String IMPORT_DISTRICT_LOCATIONS_API_VALUE = "importDistrictLocations";
	public static final String IMPORT_DISTRICT_LOCATIONS_API_NICKNAME = "importDistrictLocations";
	public static final String IMPORT_DISTRICT_LOCATIONS_API_DESCRIPTION = "Import District Locations";

	public static final String IMPORT_SUB_DISTRICT_LOCATIONS_REQUEST_MAPPING = "importSubDistrictLocations";
	public static final String IMPORT_SUB_DISTRICT_LOCATIONS_API_VALUE = "importSubDistrictLocations";
	public static final String IMPORT_SUB_DISTRICT_LOCATIONS_API_NICKNAME = "importSubDistrictLocations";
	public static final String IMPORT_SUB_DISTRICT_LOCATIONS_API_DESCRIPTION = "Import Sub District Locations";

	public static final String IMPORT_MUNCIPAL_CORPORATION_LOCATIONS_REQUEST_MAPPING = "importMuncipalCorporationLocations";
	public static final String IMPORT_MUNCIPAL_CORPORATION_LOCATIONS_API_VALUE = "importMuncipalCorporationLocations";
	public static final String IMPORT_MUNCIPAL_CORPORATION_LOCATIONS_API_NICKNAME = "importMuncipalCorporationLocations";
	public static final String IMPORT_MUNCIPAL_CORPORATION_LOCATIONS_API_DESCRIPTION = "Import Muncipal Corporation Locations";

	public static final String IMPORT_MUNCIPALITY_LOCATIONS_REQUEST_MAPPING = "importMuncipalityLocations";
	public static final String IMPORT_MUNCIPALITY_LOCATIONS_API_VALUE = "importMuncipalityLocations";
	public static final String IMPORT_MUNCIPALITY_LOCATIONS_API_NICKNAME = "importMuncipalityLocations";
	public static final String IMPORT_MUNCIPALITY_LOCATIONS_API_DESCRIPTION = "Import Muncipality Locations";

	public static final String IMPORT_TOWN_PANCHAYATH_LOCATIONS_REQUEST_MAPPING = "importTownPanchayathLocations";
	public static final String IMPORT_TOWN_PANCHAYATH_LOCATIONS_API_VALUE = "importTownPanchayathLocations";
	public static final String IMPORT_TOWN_PANCHAYATH_LOCATIONS_API_NICKNAME = "importTownPanchayathLocations";
	public static final String IMPORT_TOWN_PANCHAYATH_LOCATIONS_API_DESCRIPTION = "Import Town Panchayath Locations";

	public static final String IMPORT_VILLAGE_PANCHAYATH_LOCATIONS_REQUEST_MAPPING = "importVillagePanchayathLocations";
	public static final String IMPORT_VILLAGE_PANCHAYATH_LOCATIONS_API_VALUE = "importVillagePanchayathLocations";
	public static final String IMPORT_VILLAGE_PANCHAYATH_LOCATIONS_API_NICKNAME = "importVillagePanchayathLocations";
	public static final String IMPORT_VILLAGE_PANCHAYATH_LOCATIONS_API_DESCRIPTION = "Import Village Panchayath Locations";

	public static final String IMPORT_VILLAGE_LOCATIONS_REQUEST_MAPPING = "importVillageLocations";
	public static final String IMPORT_VILLAGE_LOCATIONS_API_VALUE = "importVillageLocations";
	public static final String IMPORT_VILLAGE_LOCATIONS_API_NICKNAME = "importVillageLocations";
	public static final String IMPORT_VILLAGE_LOCATIONS_API_DESCRIPTION = "Import Village Locations";

	public static final String EXPORT_COUNTRY_LOCATIONS_REQUEST_MAPPING = "exportCountryLocations";
	public static final String EXPORT_COUNTRY_LOCATIONS_API_VALUE = "exportCountryLocations";
	public static final String EXPORT_COUNTRY_LOCATIONS_API_NICKNAME = "exportCountryLocations";
	public static final String EXPORT_COUNTRY_LOCATIONS_API_DESCRIPTION = "Export Country Locations";

	public static final String EXPORT_STATE_LOCATIONS_REQUEST_MAPPING = "exportStateLocations";
	public static final String EXPORT_STATE_LOCATIONS_API_VALUE = "exportStateLocations";
	public static final String EXPORT_STATE_LOCATIONS_API_NICKNAME = "exportStateLocations";
	public static final String EXPORT_STATE_LOCATIONS_API_DESCRIPTION = "Export State Locations";

	public static final String EXPORT_DISTRICT_LOCATIONS_REQUEST_MAPPING = "exportDistrictLocations";
	public static final String EXPORT_DISTRICT_LOCATIONS_API_VALUE = "exportDistrictLocations";
	public static final String EXPORT_DISTRICT_LOCATIONS_API_NICKNAME = "exportDistrictLocations";
	public static final String EXPORT_DISTRICT_LOCATIONS_API_DESCRIPTION = "Export District Locations";

	public static final String EXPORT_SUB_DISTRICT_LOCATIONS_REQUEST_MAPPING = "exportSubDistrictLocations";
	public static final String EXPORT_SUB_DISTRICT_LOCATIONS_API_VALUE = "exportSubDistrictLocations";
	public static final String EXPORT_SUB_DISTRICT_LOCATIONS_API_NICKNAME = "exportSubDistrictLocations";
	public static final String EXPORT_SUB_DISTRICT_LOCATIONS_API_DESCRIPTION = "Export Sub District Locations";

	public static final String EXPORT_MUNCIPAL_CORPORATION_LOCATIONS_REQUEST_MAPPING = "exportMuncipalCorporationLocations";
	public static final String EXPORT_MUNCIPAL_CORPORATION_LOCATIONS_API_VALUE = "exportMuncipalCorporationLocations";
	public static final String EXPORT_MUNCIPAL_CORPORATION_LOCATIONS_API_NICKNAME = "exportMuncipalCorporationLocations";
	public static final String EXPORT_MUNCIPAL_CORPORATION_LOCATIONS_API_DESCRIPTION = "Export Muncipal Corporation Locations";

	public static final String EXPORT_MUNCIPALITY_LOCATIONS_REQUEST_MAPPING = "exportMuncipalityLocations";
	public static final String EXPORT_MUNCIPALITY_LOCATIONS_API_VALUE = "exportMuncipalityLocations";
	public static final String EXPORT_MUNCIPALITY_LOCATIONS_API_NICKNAME = "exportMuncipalityLocations";
	public static final String EXPORT_MUNCIPALITY_LOCATIONS_API_DESCRIPTION = "Export Muncipality Locations";

	public static final String EXPORT_TOWN_PANCHAYATH_LOCATIONS_REQUEST_MAPPING = "exportTownPanchayathLocations";
	public static final String EXPORT_TOWN_PANCHAYATH_LOCATIONS_API_VALUE = "exportTownPanchayathLocations";
	public static final String EXPORT_TOWN_PANCHAYATH_LOCATIONS_API_NICKNAME = "exportTownPanchayathLocations";
	public static final String EXPORT_TOWN_PANCHAYATH_LOCATIONS_API_DESCRIPTION = "Export Town Panchayath Locations";

	public static final String EXPORT_VILLAGE_PANCHAYATH_LOCATIONS_REQUEST_MAPPING = "exportVillagePanchayathLocations";
	public static final String EXPORT_VILLAGE_PANCHAYATH_LOCATIONS_API_VALUE = "exportVillagePanchayathLocations";
	public static final String EXPORT_VILLAGE_PANCHAYATH_LOCATIONS_API_NICKNAME = "exportVillagePanchayathLocations";
	public static final String EXPORT_VILLAGE_PANCHAYATH_LOCATIONS_API_DESCRIPTION = "Export Village Panchayath Locations";

	public static final String EXPORT_VILLAGE_LOCATIONS_REQUEST_MAPPING = "exportVillageLocations";
	public static final String EXPORT_VILLAGE_LOCATIONS_API_VALUE = "exportVillageLocations";
	public static final String EXPORT_VILLAGE_LOCATIONS_API_NICKNAME = "exportVillageLocations";
	public static final String EXPORT_VILLAGE_LOCATIONS_API_DESCRIPTION = "Export Village Locations";

	public static final String EXPORT_URBAN_REFERENCE_LOCATIONS_REQUEST_MAPPING = "exportUrbanReferenceLocations";
	public static final String EXPORT_URBAN_REFERENCE_LOCATIONS_API_VALUE = "exportUrbanReferenceLocations";
	public static final String EXPORT_URBAN_REFERENCE_LOCATIONS_API_NICKNAME = "exportUrbanReferenceLocations";
	public static final String EXPORT_URBAN_REFERENCE_LOCATIONS_API_DESCRIPTION = "Export Urban (Municipal Corporations,Municipalities and Town Panchayath Parent Locations";

	public static final String EXPORT_VILLAGE_REFERENCE_LOCATIONS_REQUEST_MAPPING = "exportVillageReferenceLocations";
	public static final String EXPORT_VILLAGE_REFERENCE_LOCATIONS_API_VALUE = "exportVillageReferenceLocations";
	public static final String EXPORT_VILLAGE_REFERENCE_LOCATIONS_API_NICKNAME = "exportVillageReferenceLocations";
	public static final String EXPORT_VILLAGE_REFERENCE_LOCATIONS_API_DESCRIPTION = "Export Village Parent Locations";

	public static final String IMPORT_VILLAGE_REFERENCE_LOCATIONS_REQUEST_MAPPING = "importVillageReferenceLocations";
	public static final String IMPORT_VILLAGE_REFERENCE_LOCATIONS_API_VALUE = "importVillageReferenceLocations";
	public static final String IMPORT_VILLAGE_REFERENCE_LOCATIONS_API_NICKNAME = "importVillageReferenceLocations";
	public static final String IMPORT_VILLAGE_REFERENCE_LOCATIONS_API_DESCRIPTION = "Import Village Parent Locations";

	/** The Constant USER_ENDPOINT_REQUEST_MAPPING. */
	public static final String USER_IMPORT_ENDPOINT_REQUEST_MAPPING = "/userImport";

	/** The Constant USER_ENDPOINT_API_VALUE. */
	public static final String USER_IMPORT_ENDPOINT_API_VALUE = "userImport";

	/** The Constant USER_ENDPOINT_API_TAGS. */
	public static final String USER_IMPORT_ENDPOINT_API_TAGS = "userImport";

	/** The Constant USER_ENDPOINT_API_DESCRIPTION. */
	public static final String USER_IMPORT_ENDPOINT_API_DESCRIPTION = "User Import Management API";

	/** The Constant UPLOAD_ALL_USERS_REQUEST_MAPPING. */
	public static final String SAVE_ELECTRORAL_ROLLES_URLS_REQUEST_MAPPING = "saveStateElectroralRolleUrls";

	/** The Constant UPLOAD_ALL_USERS_API_VALUE. */
	public static final String SAVE_ELECTRORAL_ROLLES_URLS_API_VALUE = "saveStateElectroralRolleUrls";

	/** The Constant UPLOAD_ALL_USERS_API_NICKNAME. */
	public static final String SAVE_ELECTRORAL_ROLLES_URLS_API_NICKNAME = "saveStateElectroralRolleUrls";

	/** The Constant UPLOAD_ALL_USERS_API_DESCRIPTION. */
	public static final String SAVE_ELECTRORAL_ROLLES_URLS_API_DESCRIPTION = "Save States Electroral Rolles URLs";

	/** The Constant UPLOAD_ALL_USERS_REQUEST_MAPPING. */
	public static final String SAVE_ELECTRORAL_ROLLES_DATA_REQUEST_MAPPING = "saveStateElectroralRolleData";

	/** The Constant UPLOAD_ALL_USERS_API_VALUE. */
	public static final String SAVE_ELECTRORAL_ROLLES_DATA_API_VALUE = "saveStateElectroralRolleData";

	/** The Constant UPLOAD_ALL_USERS_API_NICKNAME. */
	public static final String SAVE_ELECTRORAL_ROLLES_DATA_API_NICKNAME = "saveStateElectroralRolleData";

	/** The Constant UPLOAD_ALL_USERS_API_DESCRIPTION. */
	public static final String SAVE_ELECTRORAL_ROLLES_DATA_API_DESCRIPTION = "Save States Electroral Rolles Data";

	/** The Constant CREATE_ACCOUNT_REQUEST_MAPPING. */
	public static final String IMPORT_PARTIES_REQUEST_MAPPING = "importParties";

	/** The Constant CREATE_ACCOUNT_API_VALUE. */
	public static final String IMPORT_PARTIES_API_VALUE = "importParties";

	/** The Constant CREATE_ACCOUNT_API_NICKNAME. */
	public static final String IMPORT_PARTIES_API_NICKNAME = "importParties";

	/** The Constant CREATE_ACCOUNT_API_DESCRIPTION. */
	public static final String IMPORT_PARTIES_API_DESCRIPTION = "Import All Parties In India";

	public static final String IMPORT_CONSTITUENCY_LOCATIONS_REQUEST_MAPPING = "importConstituencyLocations";
	public static final String IMPORT_CONSTITUENCY_LOCATIONS_API_VALUE = "importConstituencyLocations";
	public static final String IMPORT_CONSTITUENCY_LOCATIONS_API_NICKNAME = "importConstituencyLocations";
	public static final String IMPORT_CONSTITUENCY_LOCATIONS_API_DESCRIPTION = "Import MLA/MP Constituency Locations";

	public static final String IMPORT_URBAN_REFERENCE_LOCATIONS_REQUEST_MAPPING = "importUrbanReferenceLocations";
	public static final String IMPORT_URBAN_REFERENCE_LOCATIONS_API_VALUE = "importUrbanReferenceLocations";
	public static final String IMPORT_URBAN_REFERENCE_LOCATIONS_API_NICKNAME = "importUrbanReferenceLocations";
	public static final String IMPORT_URBAN_REFERENCE_LOCATIONS_API_DESCRIPTION = "Import Urban Parent Locations";

	public static final String IMPORT_ALL_LOCATIONS_REQUEST_MAPPING = "importAllLocations";
	public static final String IMPORT_ALL_LOCATIONS_API_VALUE = "importAllLocations";
	public static final String IMPORT_ALL_LOCATIONS_API_NICKNAME = "importAllLocations";
	public static final String IMPORT_ALL_LOCATIONS_API_DESCRIPTION = "Import All Locations";

	public static final String EXPORT_ALL_LOCATIONS_REQUEST_MAPPING = "exportAllLocations";
	public static final String EXPORT_ALL_LOCATIONS_API_VALUE = "exportAllLocations";
	public static final String EXPORT_ALL_LOCATIONS_API_NICKNAME = "exportAllLocations";
	public static final String EXPORT_ALL_LOCATIONS_API_DESCRIPTION = "Export All Locations";
	
	public static final String IMPORT_EXPORT_ALL_LOCATIONS_REQUEST_MAPPING = "importExportAllLocations";
	public static final String IMPORT_EXPORT_ALL_LOCATIONS_API_VALUE = "importExportAllLocations";
	public static final String IMPORT_EXPORT_ALL_LOCATIONS_API_NICKNAME = "importExportAllLocations";
	public static final String IMPORT_EXPORT_ALL_LOCATIONS_API_DESCRIPTION = "Import Export All Locations";

}
