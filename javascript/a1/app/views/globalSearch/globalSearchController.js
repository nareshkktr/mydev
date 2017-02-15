(function() {
	'use strict';

	angular.module('myindia-app').controller("globalSearchController",
			globalSearchController);

	globalSearchController.$inject = [ 'swaggerShareService' ];

	function globalSearchController(swaggerShareService) {

		swaggerShareService.getAPIMetaData('http://localhost:8080/',
				setAPIMetaData);

		function setAPIMetaData(metaInfo) {
			alert(metaInfo);
		}
	}

})();