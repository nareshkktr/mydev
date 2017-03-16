(function() {
	'use strict';

	angular.module('myindia-app').factory("dataShareService", dataShareService);

	function dataShareService() {

		var data = {};

		var dataShareService = {
			getUserInfo : getUserInfo,
			setUserInfo : setUserInfo
		};

		return dataShareService;

		function getUserInfo() {
			return data.userInfo;
		}

		function setUserInfo(userInfo) {
			data.userInfo = userInfo;
		}
	}

})();