(function() {
	'use strict';

	angular.module('myindia-app').factory("userService", userService);

	userService.$inject = [ '$q', 'swaggerShareService' ];

	function userService($q, swaggerShareService) {

		var services = {};

		var userService = {

		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return userService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

	}

})();