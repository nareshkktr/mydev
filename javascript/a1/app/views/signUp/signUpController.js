(function() {
	'use strict';

	angular.module('myindia-app').controller("signUpController",
			signUpController);

	signUpController.$inject = [ 'swaggerShareService' ];

	function signUpController(swaggerShareService) {

		swaggerShareService.getAPIMetaData('http://localhost:8080/',
				setAPIMetaData);

		function setAPIMetaData(metaInfo) {
			alert(metaInfo);
		}
	}

})();