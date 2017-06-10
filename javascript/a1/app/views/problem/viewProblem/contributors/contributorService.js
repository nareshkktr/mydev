(function() {
	'use strict';

	angular.module('myindia-app').factory("contributorService",
			contributorService);

	contributorService.$inject = [ '$q', 'swaggerShareService' ];

	function contributorService($q, swaggerShareService) {

		var services = {};

		var contributorService = {

		};

		// Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return contributorService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}
	}

})();