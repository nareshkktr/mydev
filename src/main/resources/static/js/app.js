(function() {
     'use strict';
	
	angular.module('myindia-app', ['ui.router']);

})();
(function() {
    'use strict';

    angular.module('myindia-app').controller("footerController", footerController);


    function footerController() {

    }

})();
(function() {
    'use strict';

    angular.module('myindia-app').directive("myindiaFooter", myIndiaFooter);


    function myIndiaFooter() {

        function link(scope, element, attrs) {
        	
        };
        
        return {
            restrict:'E',
            link:link,
            templateUrl: resource+'partials/footer.html', 
            controller:'footerController'
    		
    	}	
    }

})();
(function() {
    'use strict';

    angular.module('myindia-app').controller("headerController", headerController);


    function headerController() {

    }

})();
(function() {
    'use strict';

    angular.module('myindia-app').directive("myindiaHeader", myIndiaHeader);


    function myIndiaHeader() {

        function link(scope, element, attrs) {
        	
        };
        
        return {
            restrict:'E',
            link:link,
            templateUrl: resource+'partials/header.html', 
            controller:'headerController'
    		
    	}	
    }

})();
(function() {
    'use strict';

    angular.module('myindia-app').config(routeConfig);

    routeConfig.$inject = ['$stateProvider','$urlRouterProvider'];

    function routeConfig($stateProvider, $urlRouterProvider) {
        
        $urlRouterProvider.otherwise('/home');
        
        $stateProvider
            
            // HOME STATES AND NESTED VIEWS ========================================
            .state('home', {
                url: '/home',
                templateUrl: resource+'partials/home.html',
                controller: 'homeController',
                controllerAs: 'hc'
            })
            
            // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
            .state('about', {
                // we'll get to this in a bit       
            });
            
    };

}) ();
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
(function() {
    'use strict';

    angular.module('myindia-app').controller("homeController", homeController);

    homeController.$inject = ['swaggerShareService'];

    function homeController(swaggerShareService) {
    	alert('In home controller');

    	//swaggerShareService.getAPIMetaData('http://'+window.location.host+'/',setAPIMetaData);
    	swaggerShareService.getAPIMetaData('http://localhost:8080/',setAPIMetaData);

    	function setAPIMetaData(metaInfo){
    		alert(metaInfo);
    	}
    }

})();

//# sourceMappingURL=app.js.map