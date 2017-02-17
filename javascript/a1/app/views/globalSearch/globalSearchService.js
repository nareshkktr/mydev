(function() {
    'use strict';

    angular.module('myindia-app').factory("globalSearchService", globalSearchService);

    globalSearchService.$inject = ['$q','swaggerShareService'];

    function globalSearchService($q,swaggerShareService) {

        var services = {};

    	var globalSearchService = {
    		search : search
    	};

        //Call and save the data
        swaggerShareService.getAPIMetaData(setAPIMetaData);

        return globalSearchService;

        function setAPIMetaData(metaInfo){
            services = metaInfo;
        }

    	function search(searchTerm){

            let deferred = $q.defer();

            services.search.getAllGlobalSearchResults({searchTerm:searchTerm},searchSuccess,searchFailure);
        
            return deferred.promise;

            function searchSuccess(data){
                deferred.resolve(data.obj);
            }

            function searchFailure(error){
                deferred.reject(error);
            }

    	}
        
    }

})();