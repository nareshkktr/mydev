(function() {
     'use strict';
	
	angular.module('myindia-app').run(routeTrack);

	routeTrack.$inject = ['$rootScope','$state'];

	function routeTrack($rootScope,$state){
		$rootScope.$state = $state;

		$rootScope.$on("$stateChangeStart",function(event, toState, toParams, fromState, fromParams){

			/*if(toState.name != "signIn" && toState.name.indexOf('signUp') == -1){
				if(!sessionStorage.getItem("access_token")){
					event.preventDefault();
					$state.go('signIn');
				}
			}*/

		});
	}


})();