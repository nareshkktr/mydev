(function() {
     'use strict';
	var myIndiaApp=angular.module('myindia-app', ['ui.router','ui.bootstrap','ngAnimate','ngMessages']);
	myIndiaApp.run(function($state, $rootScope){
		   $rootScope.$state = $state;
		})
})();

(function() {
    'use strict';

    angular.module('myindia-app').directive("compareEqualValidator", compareEqualValidator);

    function compareEqualValidator() {
        
        var compareEqualValidator = {
          link: link,
          require: 'ngModel'
        };
        
        return compareEqualValidator;

        function link(scope, element, attrs, ngModel) {
          /* */

          ngModel.$parsers.unshift(function (value) {
            console.log(value);
            if(scope.signUp.userPassword)
              ngModel.$setValidity('compareEqualValidator', scope.signUp.userPassword === value);
             return value;
          });

        }
    }

})();
(function() {
	'use strict';

	angular.module('myindia-app').directive("myIndiaEnterKey", myIndiaEnterKey);

	function myIndiaEnterKey() {

		function link(scope, element, attrs) {
			element.bind("keydown keypress", function(event) {
				var keyCode = event.which || event.keyCode;

				// If enter key is pressed
				if (keyCode === 13) {
					scope.$apply(function() {
						// Evaluate the expression
						scope.$eval(attrs.myIndiaEnterKey);
					});

					event.preventDefault();
				}
			});
		}
		return {
			restrict : 'A',
			link : link
		}
	}
})();
(function() {
	'use strict';
	angular.module('myindia-app').controller("floaingIconController",
			floaingIconController);

	floaingIconController.$inject = [];

	function floaingIconController() {
		var floatingIcon = this;
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').directive("floatingIcon", floatingIcon);

	function floatingIcon() {

		var floatingIcon = {
			restrict : 'E',
			link : link,
			templateUrl : resource + 'partials/floatingIcon.html',
			controller : 'floaingIconController',
			controllerAs : 'floatingIcon'
		};

		return floatingIcon;

		function link(scope, element, attrs) {
		}
	}
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
	angular.module('myindia-app').controller("headerController",
			headerController);
	
	headerController.$inject = [ '$state','dataShareService','$scope'];

	function headerController($state,dataShareService,$scope) {

		var header = this;
		header.searchTerm = '';
		header.gotoSearch = gotoSearch;

		$scope.$on('userInfo',refreshUserInfo);

		function refreshUserInfo(){
			header.userInfo = dataShareService.getUserInfo();

			if(header.userInfo){
				if(!header.userInfo.userImage){
					if(header.userInfo.gender == 'Male'){
						header.userInfo.userImage = resource+'/Users-User-Male-icon.png';
					}else if(header.userInfo.gender == 'Female'){
						header.userInfo.userImage = resource+'/Users-User-Female-icon.png';
					}
				}
			}
		}
		
		

		function gotoSearch() {
			$state.go('search', {
				searchTerm : header.searchTerm
			});
		};
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').directive("myindiaHeader", myIndiaHeader);

	function myIndiaHeader() {

		function link(scope, element, attrs) {

		};

		return {
			restrict : 'E',
			link : link,
			templateUrl : resource + 'partials/header.html',
			controller : 'headerController',
			controllerAs : 'header'
		}
	}

})();

(function() {
	'use strict';
	angular.module('myindia-app').controller("overlayController",
			overlayController);

	overlayController.$inject = [];

	function overlayController() {
		var overlay = this;
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').directive("overlay", overlay);

	function overlay() {

		var overlay = {
			restrict : 'E',
			link : link,
			templateUrl : resource + 'partials/overlay.html',
			controller : 'overlayController',
			controllerAs : 'overlay'
		};

		return overlay;

		function link(scope, element, attrs) {
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
			controllerAs : 'home'
		}).state('signIn', {
			url : '/signIn',
			templateUrl : resource + 'partials/signIn.html',
			controller : 'signInController',
			controllerAs : 'signIn'
		}).state('signUp', {
			url : '/signUp',
			templateUrl : resource + 'partials/signUp.html',
			controller : 'signUpController',
			controllerAs : 'signUp'
		}).state('signUp.validate', {
			url : '/validate',
			templateUrl : resource + 'partials/validateElector.html'
		}).state('signUp.locationSetup', {
			url : '/locationSetup',
			templateUrl : resource + 'partials/userLocationSetup.html'
		}).state('signUp.accountSetup', {
			url : '/accountSetup',
			templateUrl : resource + 'partials/accountSetup.html'
		}).state('search', {
			url : '/search',
			params : {
				'searchTerm' : ''
			},
			templateUrl : resource + 'partials/globalSearch.html',
			controller : 'globalSearchController',
			controllerAs : 'globalSearch'
		});
	}
})();

(function() {
    'use strict';

    angular.module('myindia-app').factory("dataShareService", dataShareService);

    dataShareService.$inject = ['$rootScope'];

    function dataShareService($rootScope) {

        var data = {};

    	var dataShareService = {
    		getUserInfo : getUserInfo,
            setUserInfo: setUserInfo
    	};

        return dataShareService;

    	function getUserInfo(){
            return data.userInfo;
    	}

        function setUserInfo(userInfo){
            data.userInfo = userInfo;
            $rootScope.$broadcast('userInfo',data.userInfo);
        }
    }

})();
(function() {
    'use strict';

    angular.module('myindia-app').factory("swaggerShareService", swaggerShareService);

    swaggerShareService.$inject = ['$q'];

    function swaggerShareService($q) {

        var apiMetaData = {};

        var hostName = 'http://localhost:8080/';

    	var swaggerShareService = {
    		getAPIMetaData : getAPIMetaData
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

	globalSearchController.$inject = [ '$state', 'globalSearchService' ];

	function globalSearchController($state,globalSearchService) {
		
		var globalSearch=this;
		globalSearch.searchTerm=$state.params.searchTerm;
		globalSearch.searchObjectType="";
		globalSearch.searchResults = [];
		globalSearch.objectsCount = {};
		globalSearch.totalCount = 0;
		globalSearch.search=search;
		
		search('ALL');
		
		function search(searchObjectType){
			
			globalSearch.searchObjectType=searchObjectType;
			
			globalSearchService.search(globalSearch.searchTerm,globalSearch.searchObjectType).then(searchSuccess).catch(searchError);
			
			function searchSuccess(data){
				globalSearch.searchResults = data.searchResults;
				globalSearch.totalCount = data.totalCount;
				globalSearch.objectsCount = data.objectsCount;
			}
			function searchError(error){
				alert(error);
			}
		}
	}
})();

(function() {
    'use strict';

    angular.module('myindia-app').factory("globalSearchService", globalSearchService);

    globalSearchService.$inject = ['$q','swaggerShareService'];

    function globalSearchService($q,swaggerShareService) {

        var services = {};

    	var globalSearchService = {
    		search : search
    	};

        // Call and save the data
        swaggerShareService.getAPIMetaData(setAPIMetaData);

        return globalSearchService;

        function setAPIMetaData(metaInfo){
            services = metaInfo;
        }

    	function search(searchTerm,searchObjectType){
    		
    		let requestBody = {
    				searchText: searchTerm,
    				searchObjectType: searchObjectType
                }

            let deferred = $q.defer();

            services.search.getAllGlobalSearchResults({body:JSON.stringify(requestBody)},searchSuccess,searchFailure);
        
            return deferred.promise;

            function searchSuccess(data){
                deferred.resolve(data.obj);
            }

            function searchFailure(error){
                deferred.reject(error);
            }

    	}
        
    }

})();
(function() {
	'use strict';

	angular.module('myindia-app').controller("homeController", homeController);

	homeController.$inject = [ 'swaggerShareService' ];

	function homeController(swaggerShareService) {

		// swaggerShareService.getAPIMetaData('http://'+window.location.host+'/',setAPIMetaData);
		swaggerShareService.getAPIMetaData(setAPIMetaData);

		function setAPIMetaData(metaInfo) {

		}
	}

})();

(function() {
    'use strict';

    angular.module('myindia-app').controller("signInController", signInController);

    signInController.$inject = ['signInService','$state','dataShareService'];

    function signInController(signInService,$state,dataShareService) {

    	var signIn = this;
 		signIn.login = login;
 		signIn.gotoSignUp = gotoSignUp;

    	function login(){
    		signInService.login(signIn.userName,signIn.password).then(loginSuccess).catch(loginFailure);

    		function loginSuccess(data){
    			alert("Login Success");
                dataShareService.setUserInfo(data);
    			$state.go('home');
    		}

    		function loginFailure(error){
    			alert(error);
    		}
    	}
    	
    	function gotoSignUp(){
    		$state.go('signUp.validate');
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
                deferred.resolve(data.obj);
            }

            function loginFailure(error){
                deferred.reject(error);
            }

    	}
        
    }

})();
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
                deferred.resolve(data.obj);
            }

            function createAccountFailure(error){
                deferred.reject(error);
            }

    	}
        
    }

})();
(function() {
    'use strict';

    angular.module('myindia-app').factory("identifyConflictParentLocationsService", identifyConflictParentLocationsService);

    identifyConflictParentLocationsService.$inject = ['$q','swaggerShareService'];

    function identifyConflictParentLocationsService($q,swaggerShareService) {

        var services = {};

    	var identifyConflictParentLocationsService = {
    		setup : setup
    	};

        //Call and save the data
        swaggerShareService.getAPIMetaData(setAPIMetaData);

        return identifyConflictParentLocationsService;

        function setAPIMetaData(metaInfo){
            services = metaInfo;
        }

    	function setup(locationObj){

            let deferred = $q.defer();

            services.user.getReferenceLocationForMaster({body:JSON.stringify(locationObj)},identifyConflictParentLocationsServiceSuccess,identifyConflictParentLocationsServiceFailure);
        
            return deferred.promise;

            function identifyConflictParentLocationsServiceSuccess(data){
                deferred.resolve(data.obj);
            }

            function identifyConflictParentLocationsServiceFailure(error){
                deferred.reject(error);
            }

    	}
        
    }

})();
(function() {
	'use strict';

	angular.module('myindia-app').controller("signUpController",
			signUpController);

	signUpController.$inject = [ '$state','validateElectorService','identifyConflictParentLocationsService','createAccountService','dataShareService' ];

	function signUpController($state,validateElectorService,identifyConflictParentLocationsService,createAccountService,dataShareService) {
		
		var signUp = this;
		signUp.validateElector = validateElector;
		signUp.validationLocationForConflict = validationLocationForConflict;
		signUp.createAccount = createAccount;
		signUp.elector = {};
		signUp.years = [];
		signUp.numberOfYears = 100;
		signUp.gender = 'Male';
		signUp.passwordRegex = "^.*(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&*(),./?]).*$";

		populateYears();

		function validateElector(){

			// Make an API call to valdiate user
			validateElectorService.validate(signUp.electorId,signUp.electorName,signUp.referenceName,signUp.gender,signUp.yob)
									.then(validationSuccess).catch(validationFailure);

			function validationSuccess(data){
				signUp.elector.location = data;
				$state.transitionTo('signUp.locationSetup');
			}

			function validationFailure(error){
				alert(error);
			}
			
		}

		function validationLocationForConflict(){

			if(signUp.elector.conflictParentLocations && signUp.parentLocation){
				$state.transitionTo('signUp.accountSetup');
			}

			// Indetify if there are conflicting parents 
			identifyConflictParentLocationsService.setup(signUp.leafLocation).then(identifyConflictParentLocationsSuccess)
												.catch(identifyConflictParentLocationsFailure);


			function identifyConflictParentLocationsSuccess(data){
				if(data.parentLocations && data.parentLocations.length == 1){
					signUp.parentLocation = data.parentLocations[0];
					$state.transitionTo('signUp.accountSetup');
				}  
				//If not there are multiple location populate them.
				signUp.elector.conflictParentLocations = data.parentLocations;
			}

			function identifyConflictParentLocationsFailure(error){
				alert(error);
			}
		}

		function createAccount(){

			createAccountService.create(signUp.elector.location.userGuid,signUp.userName,signUp.userPassword,signUp.leafLocation,signUp.parentLocation)
								.then(createAccountSuccess).catch(createAccountFailure);

			function createAccountSuccess(data){
				dataShareService.setUserInfo(data);
				$state.transitionTo('home');
			}

			function createAccountFailure(error){
				alert(error);
			}
		}

		function populateYears(){
	    	let currentYear = new Date().getFullYear();
		    //populate default ste of years.
		    for(let start=0;start<signUp.numberOfYears;start++){
		       signUp.years.push(currentYear--);
		    }
		}
	}
})();

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

//# sourceMappingURL=app.js.map