(function() {
    'use strict';

    angular.module('myindia-app').controller("homeController", homeController);

    homeController.$inject = ['swaggerShareService'];

    function homeController(swaggerShareService) {
 
    	//swaggerShareService.getAPIMetaData('http://'+window.location.host+'/',setAPIMetaData);
    	swaggerShareService.getAPIMetaData('http://localhost:8080/',setAPIMetaData);

    	function setAPIMetaData(metaInfo){
    		alert(metaInfo);
    	}
    }

})();
