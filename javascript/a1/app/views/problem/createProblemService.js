(function() {
	'use strict';

	angular.module('myindia-app').factory("createProblemService",
			createProblemService);

	createProblemService.$inject = [ '$q', 'swaggerShareService', '$timeout' ];

	function createProblemService($q, swaggerShareService, $timeout) {

		var services = {};

		var createProblemService = {
			getAllProblemTypes : getAllProblemTypes
		};

		// Call and save the data
		swaggerShareService.getAPIMetaData(setAPIMetaData);

		return createProblemService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getAllProblemTypes() {

			let
			deferred = $q.defer();
			$timeout(function() {
				services.problemType.getAllProblemTypes({},
						getAllProblemTypesSuccess, getAllProblemTypesFailure);
			}, 2000);
			return deferred.promise;

			function getAllProblemTypesSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getAllProblemTypesFailure(error) {
				deferred.reject(error);
			}

		}

	}

})();