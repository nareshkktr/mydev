(function() {
    'use strict';

    angular.module('myindia-app').factory("swaggerShareService", swaggerShareService);

    swaggerShareService.$inject = ['$q'];

    function swaggerShareService($q) {

    	var swaggerShareService = {
    		getAPIMetaData : getAPIMetaData
    	};

    	var apiMetaData = {};

    	function getAPIMetaData(hostName,setMetaData){

    		if(apiMetaData.metaInfo){
    			setMetaData(apiMetaData.metaInfo);
    		}else{
    			fetchAPIMetaData(hostName).then(function(data){
    				apiMetaData.metaInfo = data;
    				setMetaData(apiMetaData.metaInfo);
    			});
    		}

    	}

    	function fetchAPIMetaData(hostName){
    		
    		var deferred = $q.defer();

    		var swagger = new SwaggerClient({
                url: hostName+'api/swagger.json',
                success: function() {
                      deferred.resolve(swagger);
                },error: function(error){
                	deferred.reject(error);
                }
        	});

        	return deferred.promise;	

    	}

        return swaggerShareService;

    }

})();