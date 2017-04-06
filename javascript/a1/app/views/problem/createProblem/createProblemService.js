(function() {
	'use strict';

	angular.module('myindia-app').factory("createProblemService",
			createProblemService);

	createProblemService.$inject = [ '$q', 'swaggerShareService', '$timeout'];

	function createProblemService($q, swaggerShareService, $timeout) {

		var services = {};

		var createProblemService = {
			getAllProblemTypes : getAllProblemTypes,
			getProblemTypesByCategory: getProblemTypesByCategory,
			saveProblem:saveProblem
		};

		// Call and save the data
		let swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return createProblemService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getAllProblemTypes() {

			let deferred = $q.defer();
			
			if(swaggerPromise){
				swaggerPromise.then(function(){
					services.problemType.getAllProblemTypes({},
						getAllProblemTypesSuccess, getAllProblemTypesFailure);
					swaggerPromise = undefined;
				})
			}else{
				services.problemType.getAllProblemTypes({},
						getAllProblemTypesSuccess, getAllProblemTypesFailure);
			}
			

			return deferred.promise;

			function getAllProblemTypesSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getAllProblemTypesFailure(error) {
				deferred.reject(error);
			}

		}

		function getProblemTypesByCategory(problemCategory) {

			let deferred = $q.defer();
			
			if(swaggerPromise){
				swaggerPromise.then(function(){
					services.problemType.getProblemTypesByCategory({problemCategory:problemCategory},
						getProblemTypesByCategorySuccess, getProblemTypesByCategoryFailure);
					swaggerPromise = undefined;
				})
			}else{
				services.problemType.getProblemTypesByCategory({problemCategory:problemCategory},
						getProblemTypesByCategorySuccess, getProblemTypesByCategoryFailure);
			}
			

			return deferred.promise;

			function getProblemTypesByCategorySuccess(data) {
				deferred.resolve(data.obj);
			}

			function getProblemTypesByCategoryFailure(error) {
				deferred.reject(error);
			}

		}
		
		function saveProblem(problemData){
            let requestBody = {
            		problemName: problemData.grivienceName,
            		problemDesc: problemData.grivienceDescription,
            		problemLocation:problemData.selectedLocation,
            		problemType:problemData.grivienceType,
            		noOfAffectdCitizens:parseInt(problemData.noOfAffectedCitizens),
            		moneyAtStake:parseInt(problemData.moneyAtStake),
            		tags:problemData.tagValues
            }
            let deferred = $q.defer();
            
           
				services.problem.createProblem({body:JSON.stringify(requestBody)},
						saveProblemSuccess, saveProblemFailure);
			
            
            return deferred.promise;

            function saveProblemSuccess(data){
                deferred.resolve(data.obj);
            }

            function saveProblemFailure(error){
                deferred.reject(error);
            }

    	}

	}

})();