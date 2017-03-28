(function() {
	'use strict';

	angular.module('myindia-app').factory("viewProblemService",
			viewProblemService);

	viewProblemService.$inject = [ '$q', 'swaggerShareService', '$timeout' ];

	function viewProblemService($q, swaggerShareService, $timeout) {

		var services = {};

		var viewProblemService = {
			getProblemDetails : getProblemDetails
		};

		// Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return viewProblemService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getProblemDetails(problemGuid) {

			let
			deferred = $q.defer();

			if (swaggerPromise) {
				swaggerPromise
						.then(function() {
							services.problem.getProblemByGuid({problemGuid:problemGuid},
									getProblemDetailsSuccess,
									getProblemDetailsFailure);
							swaggerPromise = undefined;
						})
			} else {
				services.problem.getProblemByGuid({problemGuid:problemGuid}, getProblemDetailsSuccess,
						getProblemDetailsFailure);
			}

			return deferred.promise;

			function getProblemDetailsSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getProblemDetailsFailure(error) {
				deferred.reject(error);
			}

		}
	}
})();