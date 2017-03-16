(function() {
	'use strict';

	angular.module('myindia-app').factory("userInfoService", userInfoService);

	userInfoService.$inject = [ '$q', 'swaggerShareService' ];

	function userInfoService($q, swaggerShareService) {

		var services = {};

		var userInfoService = {
			getUserInfo : getUserInfo
		};

		// Call and save the data
		let swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);


		return userInfoService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getUserInfo() {

			let
			deferred = $q.defer();

			if (swaggerPromise) {
				swaggerPromise.then(function() {
					services.account.getLoggedInUserInfo({},
							getUserInfoSuccess, getUserInfoFailure);

					swaggerPromise = undefined;
				})
			} else {
				services.account.getLoggedInUserInfo({}, getUserInfoSuccess,
						getUserInfoFailure);

			}

			return deferred.promise;

			function getUserInfoSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getUserInfoFailure(error) {
				deferred.reject(error);
			}

		}

	}

})();