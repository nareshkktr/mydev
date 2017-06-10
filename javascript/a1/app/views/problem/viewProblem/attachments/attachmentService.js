(function() {
	'use strict';

	angular.module('myindia-app').factory("attachmentService", attachmentService);

	attachmentService.$inject = [ '$q', 'swaggerShareService' ];

	function attachmentService($q, swaggerShareService) {

		var services = {};

		var attachmentService = {};

		// Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return attachmentService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}
	}
})();