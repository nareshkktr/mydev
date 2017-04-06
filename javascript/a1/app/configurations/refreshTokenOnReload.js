(function() {
     'use strict';
	
	angular.module('myindia-app').run(refreshToken);

	refreshToken.$inject = ['refreshAccessTokenService'];

	function refreshToken(refreshAccessTokenService){

		//on page reload if session exists refresh it
		if(sessionStorage.getItem("access_token"))
			refreshAccessTokenService.refreshAccessToken();
	}


})();