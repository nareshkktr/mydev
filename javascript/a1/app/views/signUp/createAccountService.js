(function() {
    'use strict';

    angular.module('myindia-app').factory("createAccountService", createAccountService);

    createAccountService.$inject = ['$q','swaggerShareService'];

    function createAccountService($q,swaggerShareService) {

        var services = {};

    	var createAccountService = {
    		create : create
    	};

        //Call and save the data
        swaggerShareService.getAPIMetaData(setAPIMetaData);

        return createAccountService;

        function setAPIMetaData(metaInfo){
            services = metaInfo;
        }

    	function create(userGuid,userName,password,childLocation,parentLocation){

            let requestBody = {
                loginUserName: userName,
                password: password,
                userGuid: userGuid,
                childLocation: childLocation,
                parentLocation: parentLocation
            };

            let deferred = $q.defer();

            services.account.createAccount({body:JSON.stringify(requestBody)},createAccountSuccess,createAccountFailure);
        
            return deferred.promise;

            function createAccountSuccess(data){
                //Process cookie into swagger
                swaggerShareService.setAuthorization(data.obj.accessToken);
                deferred.resolve(data.obj);
            }

            function createAccountFailure(error){
                deferred.reject(error);
            }

    	}
        
    }

})();