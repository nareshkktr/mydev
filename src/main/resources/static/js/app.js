(function() {
     'use strict';
	var myIndiaApp=angular.module('myindia-app', ['ui.router','ui.bootstrap']);
	myIndiaApp.run(function($state, $rootScope){
		   $rootScope.$state = $state;
		})
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

	routeConfig.$inject = [ '$stateProvider', '$urlRouterProvider' ];

	function routeConfig($stateProvider, $urlRouterProvider) {

		$urlRouterProvider.otherwise('/home');

		$stateProvider

		// HOME STATES AND NESTED VIEWS ========================================
		.state('home', {
			url : '/home',
			templateUrl : resource + 'partials/home.html',
			controller : 'homeController',
			controllerAs : 'hc'
		}).state('signIn', {
			url : '/signIn',
			templateUrl : resource + 'partials/signIn.html',
			controller : 'signInController',
			controllerAs : 'signIn'
		}).state('signUp', {
			url : '/signUp',
			templateUrl : resource + 'partials/signUp.html',
			controller : 'signUpController',
			controllerAs : 'sUpc'
		}).state('search', {
			url : '/search',
			templateUrl : resource + 'partials/globalSearch.html',
			controller : 'globalSearchController',
			controllerAs : 'gSc'
		});
	}
})();
(function() {
    'use strict';

    angular.module('myindia-app').factory("swaggerShareService", swaggerShareService);

    swaggerShareService.$inject = ['$q'];

    function swaggerShareService($q) {

        var apiMetaData = {};

    	var swaggerShareService = {
    		getAPIMetaData : getAPIMetaData
    	};

        return swaggerShareService;

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

        
    }

})();
(function() {
	'use strict';

	angular.module('myindia-app').controller("globalSearchController",
			globalSearchController);

	globalSearchController.$inject = [ 'swaggerShareService' ];

	function globalSearchController(swaggerShareService) {

		swaggerShareService.getAPIMetaData('http://localhost:8080/',
				setAPIMetaData);

		function setAPIMetaData(metaInfo) {
			alert(metaInfo);
		}
	}

})();
(function() {
    'use strict';

    angular.module('myindia-app').controller("homeController", homeController);

    homeController.$inject = ['swaggerShareService'];

    function homeController(swaggerShareService) {
    	
    }

})();
(function() {
    'use strict';

    angular.module('myindia-app').controller("signInController", signInController);

    signInController.$inject = ['signInService'];

    function signInController(signInService) {

    	var signIn = this;
 		signIn.login = login;

    	function login(){
    		signInService.login(signIn.userName,signIn.password).then(loginSuccess).catch(loginFailiure);

    		function loginSuccess(){
    			alert("Login Success");
    		}

    		function loginFailed(){
    			alert("Login Failed...");
    		}
    	}
    }

})();
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
        
            return deferred;

            function loginSuccess(data){
                deferred.resolve(data);
            }

            function loginFailiure(error){
                deferred.reject(error);
            }

    	}
        
    }

})();
(function() {
	'use strict';

	angular.module('myindia-app').controller("signUpController",
			signUpController);

	signUpController.$inject = [ 'swaggerShareService' ];

	function signUpController(swaggerShareService) {

		swaggerShareService.getAPIMetaData('http://localhost:8080/',
				setAPIMetaData);

		function setAPIMetaData(metaInfo) {
			alert(metaInfo);
		}
	}

})();

//# sourceMappingURL=app.js.map