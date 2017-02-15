(function() {
    'use strict';

    angular.module('myindia-app').factory("signInService", signInService);

    signInService.$inject = ['$q','swaggerShareService'];

    function signInService($q,swaggerShareService) {

        var services = {};

    	var signInService = {
    		login : login
    	};

        //Call and save the data
        swaggerShareService.getAPIMetaData('http://localhost:8080/',setAPIMetaData);

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
                deferred.resolve(data);
            }

            function loginFailure(error){
                deferred.reject(error);
            }

    	}
        
    }

})();