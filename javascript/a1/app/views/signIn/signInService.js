(function() {
    'use strict';

    angular.module('myindia-app').factory("signInService", signInService);

    signInService.$inject = ['$q','swaggerShareService','refreshAccessTokenService'];

    function signInService($q,swaggerShareService,refreshAccessTokenService) {

        var services = {};

    	var signInService = {
    		login : login
    	};

        //Call and save the data
        swaggerShareService.getAPIMetaData(setAPIMetaData);

        return signInService;

        function setAPIMetaData(metaInfo){
            services = metaInfo;
        }

    	function login(userName,password){

            let requestBody = {
                loginUserName: userName,
                password: password
            }
            let deferred = $q.defer();

            services.account.login({body:JSON.stringify(requestBody)},loginSuccess,loginFailure);
        
            return deferred.promise;

            function loginSuccess(data){
                //Process cookie into swagger
                swaggerShareService.setAuthorization(data.obj.accessToken,data.obj.refreshToken,data.obj.expirationTimeInSeconds);

                //Start token expiration timer
                refreshAccessTokenService.startTokenExpiryTimer(sessionStorage.getItem("expires_in")*100);


                deferred.resolve(data.obj);
            }

            function loginFailure(error){
                deferred.reject(error);
            }

    	}
        
    }

})();