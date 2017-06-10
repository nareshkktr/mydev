(function() {
	'use strict';

	angular.module('myindia-app').directive("myindiaHeader", myIndiaHeader);

	myIndiaHeader.$inject = ['dataShareService','userInfoService'];

	function myIndiaHeader(dataShareService,userInfoService) {

		function link(scope, element, attrs) {

			processUserInfo(scope);

			//Register event to listen to userinfo chnages 
			scope.$on('userInfoChanged',function(event){
				processUserInfo(scope);
			});
			
		};

		function processUserInfo(scope){
			scope.header.userInfo = dataShareService.getUserInfo();
			
			if (scope.header.userInfo) {
			}else if(sessionStorage.getItem("access_token")){

				//If shared data has not been set yet.Call the service.
				userInfoService.getUserInfo().then(userInfoSuccess).catch(userInfoFailure);

				function userInfoSuccess(data){
					dataShareService.setUserInfo(data);
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
