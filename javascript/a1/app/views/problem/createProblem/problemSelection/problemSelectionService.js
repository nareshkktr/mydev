(function() {
	'use strict';

	angular.module('myindia-app').factory("problemSelectionService",
			problemSelectionService);

	problemSelectionService.$inject = [ '$q', 'swaggerShareService'];

	function problemSelectionService($q, swaggerShareService) {

		var services = {};

		var problemSelectionService = {
			getProblemsByType: getProblemsByType
		};

		// Call and save the data
		let swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return problemSelectionService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getProblemsByType(problemTypeGuid) {

			let deferred = $q.defer();
			
			if(swaggerPromise){
				swaggerPromise.then(function(){
					services.problem.getProblemsByType({problemTypeGuid:problemTypeGuid},
						getProblemsByTypeSuccess, getProblemsByTypeFailure);
					swaggerPromise = undefined;
				})
			}else{
				services.problem.getProblemsByType({problemTypeGuid:problemTypeGuid},
						getProblemsByTypeSuccess, getProblemsByTypeFailure);
			}
			

			return deferred.promise;

			function getProblemsByTypeSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getProblemsByTypeFailure(error) {
				deferred.reject(error);
			}

		}

	}

})();