(function() {
    'use strict';

    angular.module('myindia-app').factory("forgotPasswordService", forgotPasswordService);

    forgotPasswordService.$inject = ['$q','swaggerShareService'];

    function forgotPasswordService($q,swaggerShareService) {

        var services = {};

    	var forgotPasswordService = {
    			validUser : validUser,
    			resetPassword:resetPassword
    	};

        // Call and save the data
        swaggerShareService.getAPIMetaData(setAPIMetaData);

        return forgotPasswordService;

        function setAPIMetaData(metaInfo){
            services = metaInfo;
        }

    	function validUser(userName,referenceName){

            let requestBody = {
            		loginUserName: userName,
            		referenceName: referenceName
            }
            let deferred = $q.defer();

            services.account.forgotPasswordUserValidation({body:JSON.stringify(requestBody)},validUserSuccess,validUserFailure);
        
            return deferred.promise;

            function validUserSuccess(data){
                deferred.resolve(data.obj);
            }
            function validUserFailure(error){
                deferred.reject(error);
            }
    	}
    	function resetPassword(accountGuid,password){

            let requestBody = {
            		accountGuid: accountGuid,
            		password: password
            }
            let deferred = $q.defer();

            services.account.resetPassword({body:JSON.stringify(requestBody)},validUserSuccess,validUserFailure);
        
            return deferred.promise;

            function validUserSuccess(data){
                deferred.resolve(data.obj);
            }
            function validUserFailure(error){
                deferred.reject(error);
            }
    	}
    }
})();