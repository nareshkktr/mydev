(function() {
    'use strict';

    angular.module('myindia-app').factory("validateElectorService", validateElectorService);

    validateElectorService.$inject = ['$q','swaggerShareService'];

    function validateElectorService($q,swaggerShareService) {

        var services = {};

    	var validateElectorService = {
    		validate : validate
    	};

        //Call and save the data
        swaggerShareService.getAPIMetaData(setAPIMetaData);

        return validateElectorService;

        function setAPIMetaData(metaInfo){
            services = metaInfo;
        }

    	function validate(electorId,electorName,referenceName,gender,yob){

            let requestBody = {
                idCardNo: electorId,
                userName: electorName,
                referenceName: referenceName,
                gender: gender,
                yearOfBirth: yob
            };

            let deferred = $q.defer();

            services.user.getUserByVoterCardDetails({body:JSON.stringify(requestBody)},validationSuccess,validationFailure);
        
            return deferred.promise;

            function validationSuccess(data){
                deferred.resolve(data.obj);
            }

            function validationFailure(error){
                deferred.reject(error);
            }

    	}
        
    }

})();