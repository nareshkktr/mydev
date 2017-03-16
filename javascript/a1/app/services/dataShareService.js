(function() {
	'use strict';

	angular.module('myindia-app').factory("dataShareService", dataShareService);

	dataShareService.$inject = [ '$rootScope', 'userInfoService' ];

	function dataShareService($rootScope, userInfoService) {

		var data = {};

		var dataShareService = {
			getUserInfo : getUserInfo,
			setUserInfo : setUserInfo
		};

		return dataShareService;

		function getUserInfo() {
			if (data.userInfo == undefined) {
				userInfoService.getUserInfo().then(function(data){
					setUserInfo(data);
				});
				
			}
			return data.userInfo;
		}

		function setUserInfo(userInfo) {
			data.userInfo = userInfo;
		}
	}

})();