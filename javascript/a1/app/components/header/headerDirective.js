(function() {
	'use strict';

	angular.module('myindia-app').directive("myindiaHeader", myIndiaHeader);

	myIndiaHeader.$inject = ['dataShareService','userInfoService'];

	function myIndiaHeader(dataShareService,userInfoService) {

		function link(scope, element, attrs) {

			processUserInfo(scope);
			
		};

		function processUserInfo(scope){
			scope.header.userInfo = dataShareService.getUserInfo();
			
			if (scope.header.userInfo) {

				// Preapre user profile image
				if (!scope.header.userInfo.userImage) {
					if (scope.header.userInfo.gender == 'Male') {
						scope.header.userInfo.userImage = resource
								+ 'Users-User-Male-icon.png';
					} else if (header.userInfo.gender == 'Female') {
						scope.header.userInfo.userImage = resource
								+ 'Users-User-Female-icon.png';
					}
				}

			}else{

				//If shared data has not been set yet.Call the service.
				userInfoService.getUserInfo().then(userInfoSuccess).catch(userInfoFailure);

				function userInfoSuccess(data){
					scope.header.userInfo = data;
					// Preapre user profile image
					if (!scope.header.userInfo.userImage) {
						if (scope.header.userInfo.gender == 'Male') {
							scope.header.userInfo.userImage = resource
									+ 'Users-User-Male-icon.png';
						} else if (header.userInfo.gender == 'Female') {
							scope.header.userInfo.userImage = resource
									+ 'Users-User-Female-icon.png';
						}
					}
				}

				function userInfoFailure(error){
					alert(error);
				}

			}
		}

		return {
			restrict : 'E',
			link : link,
			templateUrl : resource + 'partials/header.html',
			controller : 'headerController',
			controllerAs : 'header'
		}
	}

})();
