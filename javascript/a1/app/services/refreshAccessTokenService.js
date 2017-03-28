(function() {
	'use strict';

	angular.module('myindia-app').factory("refreshAccessTokenService",
			refreshAccessTokenService);

	refreshAccessTokenService.$inject = [ '$q', 'swaggerShareService', '$interval','$state' ];

	function refreshAccessTokenService($q, swaggerShareService,$interval,$state) {

		var services = {};

		var refreshAccessTokenService = {
			startTokenExpiryTimer: startTokenExpiryTimer,
			stopTokenExpiryTimer: stopTokenExpiryTimer
		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		let interval;

		return refreshAccessTokenService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function startTokenExpiryTimer(intervalTimeout){
			interval = $interval(refreshAccessToken, intervalTimeout);
		}

		function stopTokenExpiryTimer(){
			$interval.cancel(interval);
		}

		function refreshAccessToken() {

			stopTokenExpiryTimer();

			services.account.refreshAccessToken({body: sessionStorage.getItem("refresh_token")}, refreshAccessTokenSuccess,
						refreshAccessTokenFailure);
			
			function refreshAccessTokenSuccess(data){
				swaggerShareService.setAuthorization(data.obj.accessToken,data.obj.refreshToken,data.obj.expirationTimeInSeconds);
				startTokenExpiryTimer(data.obj.expirationTimeInSeconds*100);
			}

			function refreshAccessTokenFailure(error){
				//Remove everything from session
				angular.forEach(sessionStorage, function (item,key) {
	          				sessionStorage.removeItem(key);
	      		});
				// Redirect to signIn . As we cannot do any furthere processing
				$state.go('signIn');
			}

		}
	}

})();