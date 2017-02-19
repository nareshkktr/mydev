(function() {
    'use strict';

    angular.module('myindia-app').factory("identifyConflictParentLocationsService", identifyConflictParentLocationsService);

    identifyConflictParentLocationsService.$inject = ['$q','swaggerShareService'];

    function identifyConflictParentLocationsService($q,swaggerShareService) {

        var services = {};

    	var identifyConflictParentLocationsService = {
    		setup : setup
    	};

        //Call and save the data
        swaggerShareService.getAPIMetaData(setAPIMetaData);

        return identifyConflictParentLocationsService;

        function setAPIMetaData(metaInfo){
            services = metaInfo;
        }

    	function setup(locationObj){

            let deferred = $q.defer();

            services.user.getReferenceLocationForMaster({body:JSON.stringify(locationObj)},identifyConflictParentLocationsServiceSuccess,identifyConflictParentLocationsServiceFailure);
        
            return deferred.promise;

            function identifyConflictParentLocationsServiceSuccess(data){
                deferred.resolve(data.obj);
            }

            function identifyConflictParentLocationsServiceFailure(error){
                deferred.reject(error);
            }

    	}
        
    }

})();