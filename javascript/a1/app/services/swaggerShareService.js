(function() {
    'use strict';

    angular.module('myindia-app').factory("swaggerShareService", swaggerShareService);

    swaggerShareService.$inject = ['$q','$cookies'];

    function swaggerShareService($q,$cookies) {

        var apiMetaData = {};

        var hostName = 'http://localhost:8080/';

    	var swaggerShareService = {
    		getAPIMetaData : getAPIMetaData,
            setAuthorization: setAuthorization
    	};

        return swaggerShareService;

    	function getAPIMetaData(setMetaData){

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
    		
    		let deferred = $q.defer();

    		let swagger = new SwaggerClient({
                url: hostName+'api/swagger.json',
                success: function() {

                    setAuthorization();

                    deferred.resolve(swagger);
                },error: function(error){
                	deferred.reject(error);
                }
        	});

        	return deferred.promise;	

    	}

        function setAuthorization(token){

            let accessToken;

            if($cookies.get("access_token")){
                accessToken = $cookies.get("access_token");      
            }else if(token){
                accessToken = token;
            }

            if(accessToken){
                var apiKeyAuth = new SwaggerClient.ApiKeyAuthorization( "Authorization", "Bearer " + accessToken, "header" );
                apiMetaData.metaInfo.clientAuthorizations.add("bearer",apiKeyAuth);
            }
        }

        
    }

})();