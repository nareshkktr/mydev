(function() {
	'use strict';

	angular.module('myindia-app').factory("videoService", videoService);

	videoService.$inject = [ '$q', 'swaggerShareService' ];

	function videoService($q, swaggerShareService) {

		var services = {};

		var videoService = {
		};

		// Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return videoService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}
	}
})();