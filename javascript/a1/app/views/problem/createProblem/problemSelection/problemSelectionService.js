(function() {
	'use strict';

	angular.module('myindia-app').factory("problemSelectionService",
			problemSelectionService);

	problemSelectionService.$inject = [ '$q', 'swaggerShareService'];

	function problemSelectionService($q, swaggerShareService) {

		var services = {};

		var problemSelectionService = {
			getProblemsByCategory: getProblemsByCategory
		};

		// Call and save the data
		let swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return problemSelectionService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getProblemsByCategory(problemTypeCategory) {

			let deferred = $q.defer();
			
			if(swaggerPromise){
				swaggerPromise.then(function(){
					services.problem.getProblemsByProblemCategory({problemTypeCategory:problemTypeCategory},
						getProblemsByProblemCategorySuccess, getProblemsByProblemCategoryFailure);
					swaggerPromise = undefined;
				})
			}else{
				services.problem.getProblemsByProblemCategory({problemTypeCategory:problemTypeCategory},
						getProblemsByProblemCategorySuccess, getProblemsByProblemCategoryFailure);
			}
			

			return deferred.promise;

			function getProblemsByProblemCategorySuccess(data) {
				deferred.resolve(data.obj);
			}

			function getProblemsByProblemCategoryFailure(error) {
				deferred.reject(error);
			}

		}

	}

})();