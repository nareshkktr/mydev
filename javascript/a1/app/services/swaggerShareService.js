(function() {
    'use strict';

    angular.module('myindia-app').factory("swaggerShareService", swaggerShareService);

    swaggerShareService.$inject = ['$q'];

    function swaggerShareService($q) {

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
                let swaggerPromise = fetchAPIMetaData(hostName);
    			swaggerPromise.then(function(data){
    				apiMetaData.metaInfo = data;
                    setAuthorization();
    				setMetaData(apiMetaData.metaInfo);
    			});
                return swaggerPromise;
    		}

    	}

    	function fetchAPIMetaData(hostName){
    		
    		let deferred = $q.defer();

    		let swagger = new SwaggerClient({
                url: hostName+'api/swagger.json',
                success: function() {
                    deferred.resolve(swagger);
                },error: function(error){
                	deferred.reject(error);
                }
        	});

        	return deferred.promise;	

    	}

    	function setAuthorization(token){

            let accessToken;

            if(token){
                accessToken = token;
                sessionStorage.setItem("access_token",accessToken);
            }else if(sessionStorage.getItem("access_token")){
                accessToken = sessionStorage.getItem("access_token");   
            }

            if(accessToken && apiMetaData.metaInfo){
                var apiKeyAuth = new SwaggerClient.ApiKeyAuthorization( "Authorization", "Bearer " + accessToken, "header" );
                apiMetaData.metaInfo.clientAuthorizations.remove("bearer");
                apiMetaData.metaInfo.clientAuthorizations.add("bearer",apiKeyAuth);
            }
        }

        
    }

})();