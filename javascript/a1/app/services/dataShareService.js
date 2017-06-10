(function() {
	'use strict';

	angular.module('myindia-app').factory("dataShareService", dataShareService);

	dataShareService.$inject = [ '$rootScope' ];

	function dataShareService($rootScope) {

		var data = {};
		var userSignUpData = {};

		var dataShareService = {
			getUserInfo : getUserInfo,
			setUserInfo : setUserInfo,
			getUserSignUpInfo : getUserSignUpInfo,
			setUserSignUpInfo : setUserSignUpInfo
		};

		return dataShareService;

		function getUserSignUpInfo() {
			return userSignUpData.responseData;
		}

		function setUserSignUpInfo(userSignUpResponseData) {
			userSignUpData.responseData = userSignUpResponseData;
		}

		function getUserInfo() {
			return data.userInfo;
		}

		function setUserInfo(userInfo) {

			if (userInfo.userSelectedLocation) {
				userInfo.displayLocation = userInfo.userSelectedLocation;
			} else if (data.userInfo && data.userInfo.userSelectedLocation) {
				userInfo.userSelectedLocation = data.userInfo.userSelectedLocation;
				userInfo.displayLocation = userInfo.userSelectedLocation;
			} else if (sessionStorage.getItem("display_location")) {
				userInfo.displayLocation = JSON.parse(sessionStorage
						.getItem("display_location"));
			} else {
				userInfo.displayLocation = userInfo.userLocation;
			}

			sessionStorage.setItem("display_location", JSON
					.stringify(userInfo.displayLocation));

			data.userInfo = userInfo;

			// Broadcast event
			broadcast('userInfoChanged');
		}

		function broadcast(eventName) {
			$rootScope.$broadcast(eventName);
		}
	}

})();