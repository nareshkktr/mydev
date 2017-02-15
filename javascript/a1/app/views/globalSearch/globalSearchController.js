(function() {
	'use strict';

	angular.module('myindia-app').controller("globalSearchController",
			globalSearchController);

	globalSearchController.$inject = [ '$state', 'swaggerShareService' ];

	function globalSearchController($state, swaggerShareService) {
		var globalSearch=this;
		globalSearch.searchTerm=$state.params.searchTerm;
		swaggerShareService.getAPIMetaData('http://localhost:8080/',
				setAPIMetaData);
		function setAPIMetaData(metaInfo) {
			alert(metaInfo);
		}
	}
})();
