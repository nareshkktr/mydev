(function() {
	'use strict';

	angular.module('myindia-app').factory("signUpService", signUpService);

	signUpService.$inject = [ '$q', 'swaggerShareService','refreshAccessTokenService' ];

	function signUpService($q, swaggerShareService,refreshAccessTokenService) {

		var services = {};

		var signUpService = {
			validateElectorDetails : validateElectorDetails,
			validateLocationForConflict : validateLocationForConflict,
			createAccount : createAccount,
			getLocationSearchResults : getLocationSearchResults,
			getAllParties : getAllParties,
			getMatchingPoliticiansByName : getMatchingPoliticiansByName,
			validatePoliticianSelection : validatePoliticianSelection
		};

		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return signUpService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function validateElectorDetails(electorId, electorName, referenceName,
				gender, yob) {

			let
			requestBody = {
				idCardNo : electorId,
				electorName : electorName,
				referenceName : referenceName,
				gender : gender,
				yearOfBirth : yob
			};

			let
			deferred = $q.defer();

			services.signUp.validateElectorDetails({
				body : JSON.stringify(requestBody)
			}, validateElectorDetailsSuccess, validateElectorDetailsFailure);

			return deferred.promise;

			function validateElectorDetailsSuccess(data) {
				deferred.resolve(data.obj);
			}

			function validateElectorDetailsFailure(error) {
				deferred.reject(error);
			}

		}

		function validateLocationForConflict(locationObj) {

			let
			deferred = $q.defer();

			services.signUp.validateLocationForConflict({
				body : JSON.stringify(locationObj)
			}, validationLocationForConflictSuccess,
					validationLocationForConflictFailure);

			return deferred.promise;

			function validationLocationForConflictSuccess(data) {
				deferred.resolve(data.obj);
			}

			function validationLocationForConflictFailure(error) {
				deferred.reject(error);
			}

		}

		function getLocationSearchResults(searchTerm) {

			let
			deferred = $q.defer();

			services.signUp.getSearchResultsByLocationName({
				"searchTerm" : searchTerm
			}, searchLocationsSuccess, searchLocationsFailure);

			return deferred.promise;

			function searchLocationsSuccess(data) {
				deferred.resolve(data.obj);
			}

			function searchLocationsFailure(error) {
				deferred.reject(error);
			}

		}

		function getAllParties() {

			let
			deferred = $q.defer();
			if (swaggerPromise) {
				swaggerPromise.then(function() {
					services.party.getAllParties({}, getAllPartiesSuccess,
							getAllPartiesFailure);
					swaggerPromise = undefined;
				})
			} else {
				services.signUp.getAllParties({}, getAllPartiesSuccess,
						getAllPartiesFailure);
			}

			return deferred.promise;

			function getAllPartiesSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getAllPartiesFailure(error) {
				deferred.reject(error);
			}
		}

		function getMatchingPoliticiansByName(userGuid) {

			let
			deferred = $q.defer();
			if (swaggerPromise) {
				swaggerPromise.then(function() {
					services.user.getPoliticiansByName({
						userGuid : userGuid
					}, getMatchingPoliticiansSuccess,
							getMatchingPoliticiansFailure);
					swaggerPromise = undefined;
				})
			} else {
				services.signUp
						.getPoliticiansByName({
							userGuid : userGuid
						}, getMatchingPoliticiansSuccess,
								getMatchingPoliticiansFailure);
			}

			return deferred.promise;

			function getMatchingPoliticiansSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getMatchingPoliticiansFailure(error) {
				deferred.reject(error);
			}
		}

		function validatePoliticianSelection(politicianGuid, locationGuid,
				partyGuid) {

			let
			deferred = $q.defer();

			let
			requestBody = {
				politicianGuid : politicianGuid,
				locationGuid : locationGuid,
				partyGuid : partyGuid
			}

			services.signUp.validatePoliticianSelectionByLocationParty({
				body : JSON.stringify(requestBody)
			}, validatePoliticianSelectionSuccess,
					validatePoliticianSelectionFailure);

			return deferred.promise;

			function validatePoliticianSelectionSuccess(data) {
				deferred.resolve(data.obj);
			}

			function validatePoliticianSelectionFailure(error) {
				deferred.reject(error);
			}

		}

		function createAccount(politicianGuid, userGuid, userName, password,
				childLocation, parentLocation, emailAddress, occupation) {

			let
			requestBody = {
				politicianGuid : politicianGuid,
				loginUserName : userName,
				password : password,
				userGuid : userGuid,
				childLocation : childLocation,
				parentLocation : parentLocation,
				emailAddress : emailAddress,
				occupation : occupation
			};

			let
			deferred = $q.defer();

			services.signUp.createAccount({
				body : JSON.stringify(requestBody)
			}, createAccountSuccess, createAccountFailure);

			return deferred.promise;

			function createAccountSuccess(data) {
				// Process cookie into swagger
				swaggerShareService
						.setAuthorization(data.obj.accessToken,
								data.obj.refreshToken,
								data.obj.expirationTimeInSeconds);

				// Start token expiration timer
				refreshAccessTokenService.startTokenExpiryTimer(sessionStorage
						.getItem("expires_in"));

				deferred.resolve(data.obj);
			}

			function createAccountFailure(error) {
				deferred.reject(error);
			}

		}

	}

})();