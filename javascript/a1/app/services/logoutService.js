(function() {
	'use strict';

	angular.module('myindia-app').factory("logoutService",
			logoutService);

	logoutService.$inject = [ '$q', 'swaggerShareService','refreshAccessTokenService' ];

	function logoutService($q, swaggerShareService,refreshAccessTokenService) {

		var services = {};

		var logoutService = {
			logout : logout
		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return logoutService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function logout() {

			let
			deferred = $q.defer();

			services.account.logout({}, logoutSuccess,
						logoutFailure);
			
			function logoutSuccess(data){
				//Remove everything from session
				angular.forEach(sessionStorage, function (item,key) {
	          				sessionStorage.removeItem(key);
	      		});

				//Stop timer for refresh token
				refreshAccessTokenService.stopTokenExpiryTimer();

				deferred.resolve(data);
			}

			function logoutFailure(error){
				deferred.reject(error);
			}

			return deferred.promise;

		}
	}

})();