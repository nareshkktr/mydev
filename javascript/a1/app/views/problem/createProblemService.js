(function() {
	'use strict';

	angular.module('myindia-app').factory("createProblemService",
			createProblemService);

	createProblemService.$inject = [ '$q', 'swaggerShareService', '$timeout' ];

	function createProblemService($q, swaggerShareService, $timeout) {

		var services = {};

		var createProblemService = {
			getAllProblemTypes : getAllProblemTypes,
			saveProblem:saveProblem
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
		
		function saveProblem(problemData){

            let requestBody = {
                loginUserName: problemData,
                password: problemData
            }
            let deferred = $q.defer();

            services.account.login({body:JSON.stringify(requestBody)},saveProblemSuccess,saveProblemFailure);
        
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