(function() {
     'use strict';
	var myIndiaApp=angular.module('myindia-app', ['ui.router','ui.bootstrap','ngAnimate','ngMessages','angularTrix','ngTagsInput']);
	
})();

(function() {
	'use strict';
	angular.module('myindia-app').controller("commentBoxController",
			commentBoxController);

	commentBoxController.$inject = [ '$scope','commentBoxService' ];

	function commentBoxController($scope,commentBoxService) {
		var commentBox = this;
		console.log($scope.objectType);
		console.log($scope.objectGuid);
		commentBox.commentText="";
		commentBox.sendComment = sendComment;
		
		function sendComment(){
			let commentData={};
			commentData.objectType=$scope.objectType;
			commentData.objectGuid=$scope.objectGuid;
			commentData.commentText=commentBox.commentText;
			
			commentBoxService.sendComment(commentData).then(sendCommentSuccess).catch(sendCommentFailure);
    		function sendCommentSuccess(data){
    			alert(data);
    		}
    		function sendCommentFailure(error){
    			alert(error);
    		}
		}
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').directive("commentBox", commentBox);

	function commentBox() {

		var commentBox = {
			restrict : 'E',
			scope : {
				objectType : '=',
				objectGuid : '='
			},
			templateUrl : resource + 'partials/commentBox.html',
			controller : 'commentBoxController',
			controllerAs : 'commentBox'
		};

		return commentBox;
	}

})();

(function() {
	'use strict';

	angular.module('myindia-app').factory("commentBoxService",
			commentBoxService);

	commentBoxService.$inject = [ '$q', 'swaggerShareService' ];

	function commentBoxService($q, swaggerShareService) {

		var services = {};

		var commentBoxService = {
			sendComment : sendComment
		};

		// Call and save the data
		swaggerShareService.getAPIMetaData(setAPIMetaData);

		return commentBoxService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function sendComment(commentData) {

			let
			deferred = $q.defer();

			services.comment.postComment({
				body : JSON.stringify(commentData)
			}, sendCommentSuccess, sendCommentFailure);

			return deferred.promise;

			function sendCommentSuccess(data) {
				deferred.resolve(data.obj);
			}

			function sendCommentFailure(error) {
				deferred.reject(error);
			}

		}

	}

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

	angular.module('myindia-app').controller("fileUploadController",
			fileUploadController);

	fileUploadController.$inject = ['$scope'];

	function fileUploadController($scope) {
		var fileUpload = this;
		
		fileUpload.uploadFile = uploadFile;

		function uploadFile(){
			//return the selected files to parent.
			$scope.callback()($scope.files);
		}

	}


})();

(function() {
	'use strict';

	angular.module('myindia-app').directive("fileUpload", fileUpload);

	function fileUpload() {

		var fileUpload = {
			restrict : 'E',
			scope: {
				type: '@',
				acceptType: '@',
				callback: '&'
			},
			templateUrl : resource + 'partials/fileUpload.html',
			controller : 'fileUploadController',
			controllerAs : 'fileUpload'
		};

		return fileUpload;

	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').directive("setFileAttributes", setFileAttributes);

	function setFileAttributes() {

		var setFileAttributes = {
			restrict : 'A',
			link : link
		};

		return setFileAttributes;

		function link(scope, element, attrs) {

			//Set selection Type.
			if(scope.type == 'Multiple')
				element[0].multiple  = true;

			//Select accepts
			if(scope.acceptType == 'Image'){
				element[0].accept = 'image/*';
			}

			element.bind("change", function (changeEvent) {
                scope.$apply(function () {
                    scope.files = changeEvent.target.files;
                    //call the function that uploads the files..
                    scope.fileUpload.uploadFile();
                });
            });

		}
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').directive("showPreview", showPreview);

	function showPreview() {

		var showPreview = {
			restrict : 'A',
			scope:{
				file:'='
			},
			link : link
		};

		return showPreview;

		function link(scope, element, attrs) {

			scope.$watch('file',function(){
				if(scope.file){
					var reader = new FileReader();
				    reader.onload = function(){
				      element[0].src = reader.result;
				    };
	    			reader.readAsDataURL(scope.file);
				}
			});
		}
	}
})();

(function() {
	'use strict';
	angular.module('myindia-app').controller("floaingIconController",
			floaingIconController);

	floaingIconController.$inject = ['$state'];

	function floaingIconController($state) {
		var floatingIcon = this;
		floatingIcon.showOverlay = false;
		floatingIcon.toggleOverlay = toggleOverlay;
		floatingIcon.gotoCreateProblem=gotoCreateProblem;
		
		function toggleOverlay() {
			floatingIcon.showOverlay = !floatingIcon.showOverlay;
		}

		function gotoCreateProblem() {
			toggleOverlay();
			$state.go('createProblem.problemTypeSelection');
		}
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

	angular.module('myindia-app').controller("footerController",
			footerController);

	footerController.$inject = [ '$state' ];

	function footerController($state) {

		var footer = this;
		footer.searchTerm = '';
		footer.gotoSearch = gotoSearch;
		footer.showSearchBox = true;
		footer.showFooterSearchBox = showFooterSearchBox;

		function gotoSearch() {
			$state.go('search', {
				searchTerm : footer.searchTerm
			});
		}

		function showFooterSearchBox() {
			footer.showSearchBox = !footer.showSearchBox;
		}
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
            controller:'footerController',
            controllerAs : 'footer'
    		
    	}	
    }

})();
(function() {
	'use strict';
	angular.module('myindia-app').controller("headerController",
			headerController);

	headerController.$inject = [ '$state','logoutService'];

	function headerController($state,logoutService) {

		var header = this;
		header.searchTerm = '';
		header.gotoSearch = gotoSearch;
		header.openLocationChangeModal = openLocationChangeModal;
		header.animationsEnabled = true;
		header.locationChangePopUpUrl = resource
				+ "partials/locationChangePopUp.html";
		header.showLocationChangeModal = false;
		header.closeLocationChangeModal = closeLocationChangeModal;

		header.modalControllerName = "locationChangePopUpController";
		header.modalControllerAlias = "locationChangePopUp";
		header.logout = logout;

		function gotoSearch() {
			$state.go('search', {
				searchTerm : header.searchTerm
			});
		}

		function openLocationChangeModal() {
			header.showLocationChangeModal = true;
		}
		function closeLocationChangeModal() {
			header.showLocationChangeModal = false;
		}

		function logout(){

			logoutService.logout().then(logoutSuccess).catch(logoutFailure);

			function logoutSuccess(data){
				$state.go('signIn');
			}

			function logoutFailure(error){
				alert(error);
			}
		}

	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').directive("myindiaHeader", myIndiaHeader);

	myIndiaHeader.$inject = ['dataShareService','userInfoService'];

	function myIndiaHeader(dataShareService,userInfoService) {

		function link(scope, element, attrs) {

			processUserInfo(scope);

			//Register event to listen to userinfo chnages 
			scope.$on('userInfoChanged',function(event){
				processUserInfo(scope);
			});
			
		};

		function processUserInfo(scope){
			scope.header.userInfo = dataShareService.getUserInfo();
			
			if (scope.header.userInfo) {

				// Preapre user profile image
				if (!scope.header.userInfo.userImage) {
					if (scope.header.userInfo.gender == 'Male') {
						scope.header.userInfo.userImage = resource
								+ 'Users-User-Male-icon.png';
					} else if (header.userInfo.gender == 'Female') {
						scope.header.userInfo.userImage = resource
								+ 'Users-User-Female-icon.png';
					}
				}

			}else if(sessionStorage.getItem("access_token")){

				//If shared data has not been set yet.Call the service.
				userInfoService.getUserInfo().then(userInfoSuccess).catch(userInfoFailure);

				function userInfoSuccess(data){
					dataShareService.setUserInfo(data);
				}

				function userInfoFailure(error){
					alert(error);
				}

			}
		}

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
	angular.module('myindia-app').controller("locationChangePopUpController",
			locationChangePopUpController);

	locationChangePopUpController.$inject = [ '$state',
			'locationChangePopUpService','dataShareService','$uibModalInstance' ];

	function locationChangePopUpController($state, locationChangePopUpService,dataShareService,$uibModalInstance) {
		
		var locationChangePopUp = this;
		locationChangePopUp.popularLocations =[];
		locationChangePopUp.locationSelected=false;
		locationChangePopUp.resultsType="Popular Locations";
		locationChangePopUp.searchTerm="";
		locationChangePopUp.getSearchResults=getSearchResults;
		locationChangePopUp.selectedLocation=null;
		locationChangePopUp.selectLocation = selectLocation;
		locationChangePopUp.pinLocation = pinLocation;
		locationChangePopUp.closePopUp = closePopUp;
		
		getPopularLocations();
		
		function getPopularLocations(){
			locationChangePopUpService.getPopularLocations().then(popularLocationsSuccess).catch(popularLocationsFailure);

    		function popularLocationsSuccess(data){
    			locationChangePopUp.popularLocations=data;
    		}
    		function popularLocationsFailure(error){
    			alert(error);
    		}
    	}
		
		function getSearchResults(){
			if(locationChangePopUp.searchTerm.length>=3){
				locationChangePopUp.resultsType="Search Results For :"+locationChangePopUp.searchTerm;
				locationChangePopUpService.getSearchResults(locationChangePopUp.searchTerm).then(searchLocationsSuccess).catch(searchLocationsFailure);
	
	    		function searchLocationsSuccess(data){
	    			locationChangePopUp.popularLocations=data;
	    		}
	    		function searchLocationsFailure(error){
	    			alert(error);
	    		}
			}
    	}
		
		function selectLocation(searchLocation){
			locationChangePopUp.selectedLocation=searchLocation;
			locationChangePopUp.locationSelected=true;
		}
		
		function closePopUp(){
			 $uibModalInstance.dismiss('cancel');
		}
		
		function pinLocation(){
			let userInfo=dataShareService.getUserInfo();
			if(userInfo){
    			userInfo.userSelectedLocation=locationChangePopUp.selectedLocation;
    			dataShareService.setUserInfo(userInfo);
    		}
    		locationChangePopUp.closePopUp();
    	}
	}
	
})();
(function() {
	'use strict';

	angular.module('myindia-app').factory("locationChangePopUpService",
			locationChangePopUpService);

	locationChangePopUpService.$inject = [ '$q', 'swaggerShareService' ];

	function locationChangePopUpService($q, swaggerShareService) {

		var services = {};

		var locationChangePopUpService = {
			getPopularLocations : getPopularLocations,
			getSearchResults : getSearchResults,
			pinLocation : pinLocation
		};

		// Call and save the data
		swaggerShareService.getAPIMetaData(setAPIMetaData);

		return locationChangePopUpService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getPopularLocations() {

			let
			deferred = $q.defer();

			services.location.getPopularLocations({}, popularLocationsSuccess,
					popularLocationsFailure);

			return deferred.promise;

			function popularLocationsSuccess(data) {
				deferred.resolve(data.obj);
			}

			function popularLocationsFailure(error) {
				deferred.reject(error);
			}

		}

		function getSearchResults(searchTerm) {

			let
			deferred = $q.defer();

			services.location.getSearchResultsByLocationName({
				"searchTerm" : searchTerm
			}, searchLocationsSuccess, searchLocationsFailure);

			return deferred.promise;

			function searchLocationsSuccess(data) {
				deferred.resolve(data.obj);
			}

			function searchLocationsFailure(error) {
				deferred.reject(error);
			}

		}

		function pinLocation(selectedLocation) {

			let
			deferred = $q.defer();

			services.user.pinLocation({
				body : JSON.stringify(selectedLocation)
			}, pinLocationSuccess, pinLocationFailure);

			return deferred.promise;

			function pinLocationSuccess(data) {
				deferred.resolve(data.obj);
			}

			function pinLocationFailure(error) {
				deferred.reject(error);
			}

		}

	}

})();
(function() {
	'use strict';
	angular.module('myindia-app').controller("mobileHeaderController",
			mobileHeaderController);

	function mobileHeaderController() {

		var mobileHeader = this;

	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').directive("myindiaMobileHeader",
			myindiaMobileHeader);

	function myindiaMobileHeader() {

		function link(scope, element, attrs) {
		}
		
		return {
			restrict : 'E',
			link : link,
			templateUrl : resource + 'partials/mobileHeader.html',
			controller : 'mobileHeaderController',
			controllerAs : 'mobileHeader'
		}
	}

})();

(function() {
	'use strict';

	angular.module('myindia-app').directive("modal", modal);

	modal.$inject = [ '$uibModal', '$log' ];

	function modal($uibModal, $log) {

		var modal = {
			link : link,
			scope : {
				animationsEnabled : '=animationsEnabled',
				modalTemplateUrl : '=modalTemplateUrl',
				dismissModal : '=',
				modalControllerName : '=modalControllerName',
				modalControllerAlias : '=modalControllerAlias'
			}
		};

		return modal;

		function link(scope, element, attrs) {
			var modalInstance = $uibModal.open({
				animation : scope.animationsEnabled,
				ariaLabelledBy : 'modal-title',
				ariaDescribedBy : 'modal-body',
				templateUrl : scope.modalTemplateUrl,
				controller : scope.modalControllerName,
				controllerAs : scope.modalControllerAlias
			});
			modalInstance.result.then(function() {
			}, function() {
				scope.$eval(attrs.dismissModal);
				$log.info('Modal dismissed at: ' + new Date());
			});
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
	angular.module('myindia-app').controller("problemDisplayController",
			problemDisplayController);

	problemDisplayController.$inject = ['$state'];

	function problemDisplayController($state) {
		var problemDisplay = this;
		problemDisplay.viewProblem = viewProblem;

		function viewProblem(problemGuid) {
			$state.go('viewProblem', {
				selectedProblemGuid : problemGuid
			});
		}
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').directive("problemDisplay", problemDisplay);

	function problemDisplay() {

		var problemDisplay = {
			restrict : 'E',
			scope: {
				problems: '=',
				columnSplitClass: '='
			},
			templateUrl : resource + 'partials/problemDisplay.html',
			controller : 'problemDisplayController',
			controllerAs : 'problemDisplay'
		};

		return problemDisplay;

	}

})();

(function() {
    'use strict';
    angular.module('angularTrix', []).directive('angularTrix', function() {
        return {
            restrict: 'A',
            require: 'ngModel',
            scope: {
                trixInitialize: '&',
                trixChange: '&',
                trixSelectionChange: '&',
                trixFocus: '&',
                trixBlur: '&',
                trixFileAccept: '&',
                trixAttachmentAdd: '&',
                trixAttachmentRemove: '&'
            },
            link: function(scope, element, attrs, ngModel) {

                element.on('trix-initialize', function() {
                    if (ngModel.$modelValue) {
                        element[0].editor.loadHTML(ngModel.$modelValue);
                    }
                });

                ngModel.$render = function() {
                    if (element[0].editor) {
                        element[0].editor.loadHTML(ngModel.$modelValue);
                    }

                    element.on('trix-change', function() {
                        ngModel.$setViewValue(element.html());
                    });
                };

                var registerEvents = function(type, method) {
                    element[0].addEventListener(type, function(e) {
                        if (type === 'trix-file-accept' && attrs.preventTrixFileAccept === 'true') {
                            e.preventDefault();
                        }

                        scope[method]({
                            e: e,
                            editor: element[0].editor
                        });
                    });
                };

                registerEvents('trix-initialize', 'trixInitialize');
                registerEvents('trix-change', 'trixChange');
                registerEvents('trix-selection-change', 'trixSelectionChange');
                registerEvents('trix-focus', 'trixFocus');
                registerEvents('trix-blur', 'trixBlur');
                registerEvents('trix-file-accept', 'trixFileAccept');
                registerEvents('trix-attachment-add', 'trixAttachmentAdd');
                registerEvents('trix-attachment-remove', 'trixAttachmentRemove');

            }
        };
    });

}());

(function() {
     'use strict';
	
	angular.module('myindia-app').run(routeTrack);

	routeTrack.$inject = ['$rootScope','$state'];

	function routeTrack($rootScope,$state){
		$rootScope.$state = $state;

		$rootScope.$on("$stateChangeStart",function(event, toState, toParams, fromState, fromParams){

			if(toState.name != "signIn" && toState.name.indexOf('signUp') == -1){
				if(!sessionStorage.getItem("access_token")){
					event.preventDefault();
					$state.go('signIn');
				}
			}

		});
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
		}).state('createProblem', {
			url : '/createProblem',
			templateUrl : resource + 'partials/createProblem.html',
			controller : 'createProblemController',
			controllerAs : 'createProblem'
		}).state('createProblem.problemTypeSelection', {
			url : '/problemTypeSelection',
			templateUrl : resource + 'partials/problemTypeSelection.html',
			controller : 'problemTypeSelectionController',
			controllerAs : 'problemTypeSelection'
		}).state('createProblem.problemSelection', {
			url : '/problemSelection',
			templateUrl : resource + 'partials/problemSelection.html',
			controller : 'problemSelectionController',
			controllerAs : 'problemSelection',
			params : {
				'selectedProblemCategory' : '',
				'problemTypes' : ''
			}
		}).state('createProblem.logProblem', {
			url : '/logProblem',
			templateUrl : resource + 'partials/logProblem.html',
			controller : 'logProblemController',
			controllerAs : 'logProblem',
			params : {
				'selectedProblemCategory' : '',
				'problemTypes' : ''
			}
		}).state('viewProblem', {
			url : '/viewProblem',
			templateUrl : resource + 'partials/viewProblem.html',
			controller : 'viewProblemController',
			controllerAs : 'viewProblem',
			params : {
				'selectedProblemGuid' : ''
			}
		}).state('viewProblem.overview', {
			url : '/overview',
			templateUrl : resource + 'partials/overview.html'
		}).state('viewProblem.discussions', {
			url : '/discussions',
			templateUrl : resource + 'partials/discussions.html',
			controller : 'discussionsController',
			controllerAs : 'discussions',
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
			setUserInfo : setUserInfo
		};

		return dataShareService;

		function getUserInfo() {
			return data.userInfo;
		}

		function setUserInfo(userInfo) {

			if(userInfo.userSelectedLocation){
				userInfo.displayLocation = userInfo.userSelectedLocation;
			}else if(data.userInfo && data.userInfo.userSelectedLocation){
				userInfo.userSelectedLocation = data.userInfo.userSelectedLocation;
				userInfo.displayLocation = userInfo.userSelectedLocation;
			}else if(sessionStorage.getItem("display_location")){
				userInfo.displayLocation = JSON.parse(sessionStorage.getItem("display_location"));
			}else{
				userInfo.displayLocation = userInfo.userLocation;
			}

			sessionStorage.setItem("display_location",JSON.stringify(userInfo.displayLocation));

			data.userInfo = userInfo;

			// Broadcast event
			broadcast('userInfoChanged');
		}

		function broadcast(eventName){
			$rootScope.$broadcast(eventName);
		}
	}

})();
(function() {
	'use strict';

	angular.module('myindia-app').factory("fileUploadService",
			fileUploadService);

	fileUploadService.$inject = [ '$q', 'swaggerShareService' ];

	function fileUploadService($q, swaggerShareService) {

		var services = {};

		var fileUploadService = {
			uploadFile : uploadFile
		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return fileUploadService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function uploadFile(files, objectType,objectGuid, isMainPhotoURL,
				category) {

			let
			deferred = $q.defer();

			let
			promises = [];

			angular.forEach(files, function(file, key) {
				promises.push(preapreUploadFileRequest(file, objectType,
						objectGuid, isMainPhotoURL,
						category));
			});

			$q.all(promises).then(function(filesData) {

				services.image.addImages({
					body : JSON.stringify(filesData)
				}, uploadSuccess, uploadFailure);

				function uploadSuccess(data) {
					deferred.resolve(data);
				}

				function uploadFailure(error) {
					deferred.reject(error);
				}
			})

			return deferred.promise;

		}

		function preapreUploadFileRequest(file, objectType, objectGuid, isMainPhotoURL,
				category) {

			let
			deferred = $q.defer();

			var name = file.name;
			var reader = new FileReader();
			reader.onload = function() {

				var req = {};
				req.imageName = name;
				req.imageData = reader.result;
				req.objectType = objectType;
				req.objectId = objectGuid;
				req.isMainPhotoURL = isMainPhotoURL;
				req.category = category;

				deferred.resolve(req);
			}
			reader.readAsDataURL(file);

			return deferred.promise;
		}
	}

})();
(function() {
	'use strict';

	angular.module('myindia-app').factory("filterEntityByCriteria",
			filterEntityByCriteria);

	filterEntityByCriteria.$inject = [ '$q', 'swaggerShareService' ];

	function filterEntityByCriteria($q, swaggerShareService) {

		var services = {};

		var filterEntityByCriteria = {
			filterEntities : filterEntities
		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return filterEntityByCriteria;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function filterEntities(filterRequest) {

			let
			deferred = $q.defer();

			services.search.filterEntity({body:JSON.stringify(filterRequest)}, filterEntitySuccess,
						filterEntityFailure);
			
			function filterEntitySuccess(data){
				deferred.resolve(data.obj);
			}

			function filterEntityFailure(error){
				deferred.reject(error);
			}

			return deferred.promise;

		}
	}

})();
(function() {
	'use strict';

	angular.module('myindia-app').factory("logoutService",
			logoutService);

	logoutService.$inject = [ '$q', 'swaggerShareService' ];

	function logoutService($q, swaggerShareService) {

		var services = {};

		var logoutService = {
			logout : logout
		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return logoutService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function logout() {

			let
			deferred = $q.defer();

			services.account.logout({}, logoutSuccess,
						logoutFailure);
			
			function logoutSuccess(data){
				//Remove everything from session
				angular.forEach(sessionStorage, function (item,key) {
	          				sessionStorage.removeItem(key);
	      		});

				//Stop timer for refresh token
				refreshAccessTokenService.stopTokenExpiryTimer(expiresIn);

				deferred.resolve(data);
			}

			function logoutFailure(error){
				deferred.reject(error);
			}

			return deferred.promise;

		}
	}

})();
(function() {
	'use strict';

	angular.module('myindia-app').factory("refreshAccessTokenService",
			refreshAccessTokenService);

	refreshAccessTokenService.$inject = [ '$q', 'swaggerShareService', '$interval','$state' ];

	function refreshAccessTokenService($q, swaggerShareService,$interval,$state) {

		var services = {};

		var refreshAccessTokenService = {
			startTokenExpiryTimer: startTokenExpiryTimer,
			stopTokenExpiryTimer: stopTokenExpiryTimer
		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		let interval;

		return refreshAccessTokenService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function startTokenExpiryTimer(intervalTimeoutInSeconds){
			interval = $interval(refreshAccessToken, intervalTimeoutInSeconds*1000);
		}

		function stopTokenExpiryTimer(){
			$interval.cancel(interval);
		}

		function refreshAccessToken() {

			stopTokenExpiryTimer();

			services.account.refreshAccessToken({body: sessionStorage.getItem("refresh_token")}, refreshAccessTokenSuccess,
						refreshAccessTokenFailure);
			
			function refreshAccessTokenSuccess(data){
				swaggerShareService.setAuthorization(data.obj.accessToken,data.obj.refreshToken,data.obj.expirationTimeInSeconds);
				startTokenExpiryTimer(data.obj.expirationTimeInSeconds);
			}

			function refreshAccessTokenFailure(error){
				//Remove everything from session
				angular.forEach(sessionStorage, function (item,key) {
	          				sessionStorage.removeItem(key);
	      		});
				// Redirect to signIn . As we cannot do any furthere processing
				$state.go('signIn');
			}

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

    	function setAuthorization(token,refreshToken,expiresIn){

            let accessToken;

            if(token){
                accessToken = token;
                sessionStorage.setItem("access_token",accessToken);
                sessionStorage.setItem("refresh_token",refreshToken);
                sessionStorage.setItem("expires_in",expiresIn);
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
(function() {
	'use strict';

	angular.module('myindia-app').factory("userInfoService", userInfoService);

	userInfoService.$inject = [ '$q', 'swaggerShareService' ];

	function userInfoService($q, swaggerShareService) {

		var services = {};

		var userInfoService = {
			getUserInfo : getUserInfo
		};

		// Call and save the data
		let swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);


		return userInfoService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getUserInfo() {

			let
			deferred = $q.defer();

			if (swaggerPromise) {
				swaggerPromise.then(function() {
					services.account.getLoggedInUserInfo({},
							getUserInfoSuccess, getUserInfoFailure);

					swaggerPromise = undefined;
				})
			} else {
				services.account.getLoggedInUserInfo({}, getUserInfoSuccess,
						getUserInfoFailure);

			}

			return deferred.promise;

			function getUserInfoSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getUserInfoFailure(error) {
				deferred.reject(error);
			}

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

	function homeController() {
	}

})();

(function() {
	'use strict';

	angular.module('myindia-app').controller("createProblemController",
			createProblemController);
	createProblemController.$inject = [];

	function createProblemController() {

		var createProblem = this;

	}

})();

(function() {
	'use strict';

	angular.module('myindia-app').factory("createProblemService",
			createProblemService);

	createProblemService.$inject = [ '$q', 'swaggerShareService', '$timeout'];

	function createProblemService($q, swaggerShareService, $timeout) {

		var services = {};

		var createProblemService = {
			getAllProblemTypes : getAllProblemTypes,
			saveProblem:saveProblem
		};

		// Call and save the data
		let swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return createProblemService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getAllProblemTypes() {

			let deferred = $q.defer();
			
			if(swaggerPromise){
				swaggerPromise.then(function(){
					services.problemType.getAllProblemTypes({},
						getAllProblemTypesSuccess, getAllProblemTypesFailure);
					swaggerPromise = undefined;
				})
			}else{
				services.problemType.getAllProblemTypes({},
						getAllProblemTypesSuccess, getAllProblemTypesFailure);
			}
			

			return deferred.promise;

			function getAllProblemTypesSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getAllProblemTypesFailure(error) {
				deferred.reject(error);
			}

		}
		
		function saveProblem(problemData){
            let requestBody = {
            		problemName: problemData.grivienceName,
            		problemDesc: problemData.grivienceDescription,
            		problemLocation:problemData.selectedLocation,
            		problemType:problemData.grivienceType,
            		noOfAffectdCitizens:parseInt(problemData.noOfAffectedCitizens),
            		moneyAtStake:parseInt(problemData.moneyAtStake),
            		tags:problemData.tagValues
            }
            let deferred = $q.defer();
            
           
				services.problem.createProblem({body:JSON.stringify(requestBody)},
						saveProblemSuccess, saveProblemFailure);
			
            
            return deferred.promise;

            function saveProblemSuccess(data){
                deferred.resolve(data.obj);
            }

            function saveProblemFailure(error){
                deferred.reject(error);
            }

    	}

	}

})();
(function() {
	'use strict';

	angular.module('myindia-app').controller("logProblemController",
			logProblemController);
	logProblemController.$inject = [ 'createProblemService','fileUploadService','dataShareService','userInfoService','$scope','locationChangePopUpService','$state','filterEntityByCriteria' ];
	
	function logProblemController(createProblemService,fileUploadService,dataShareService,userInfoService,$scope,locationChangePopUpService,$state,filterEntityByCriteria) {
		
		var logProblem=this;
		logProblem.chosenProblemCategory = $state.params.selectedProblemCategory;
		logProblem.problemTypesResults = $state.params.problemTypes;
		logProblem.grivienceName="";
		logProblem.grivienceType;
		logProblem.grivienceDescription;
		logProblem.noOfAffectedCitizens;
		logProblem.moneyAtStake;
		logProblem.noOfAffectedCitizensData={4:"<5",3:"Between 5 and 100",2:"Between 100 and 1000",1:">1000"};
		logProblem.moneyAtStakeData={4:"<1,00,000",3:"Between 1,00,000 and 10,00,000",2:"Between 10,00,000 and 50,00,000",1:">50,00,000"};
		logProblem.tags = [];
		logProblem.generateTags=generateTags;
		logProblem.searchLocation=searchLocation;
		logProblem.searchedLocations=[];
		logProblem.selectLocation = selectLocation;
		logProblem.selectedLocation=null;
		logProblem.showLocationSearchBox=false;
		logProblem.locatedIn="";
		logProblem.tagValues="";
		logProblem.problems = [];
		logProblem.changeProblemType=changeProblemType;
		logProblem.similarProblems = {};
		logProblem.similarProblems.pageNo = 1;
		logProblem.similarProblems.pageLimit = 4;


		function changeProblemType(){
			generateTags();
		}
		
		// for (var i = 0; i < 20; i++) {
		// 	var severity = "";

		// 	if (i % 2 == 0) {
		// 		severity = "critical";
		// 	} else if (i % 3 == 0) {
		// 		severity = "high";
		// 	} else if (i % 5 == 0) {
		// 		severity = "medium";
		// 	} else {
		// 		severity = "low";
		// 	}
		// 	var problem = {
		// 		"problemName" : "Water Problem Type Water Problem Type Water Problem Type "
		// 				+ i,
		// 		"locatedIn" : "Pulipadu,Prakasam(District)",
		// 		"severity" : severity,
		// 		"severityLevel" : severity === "critical" ? "C"
		// 				: severity === "high" ? "H"
		// 						: severity === "medium" ? "M" : "L"
		// 	};
		// 	logProblem.problems.push(problem);
		// }

		processUserData();

		$scope.$on('userInfoChanged',function(event){
			processUserData();
		});
		

		logProblem.saveProblem=saveProblem;
		logProblem.uploadCover = uploadCover;
		    
		
		
		function saveProblem(){


			if(logProblem.tags){
				logProblem.tagValues = "";
				for(let i =0; i < logProblem.tags.length; i++){
					logProblem.tagValues+=logProblem.tags[i].text+",";
				}
			}
			
			if(logProblem.tagValues!=undefined){
				logProblem.tagValues=logProblem.tagValues.substr(0,logProblem.tagValues.length-1);
			}
			
			createProblemService.saveProblem(logProblem).then(saveProblemSuccess).catch(saveProblemFailure);

    		function saveProblemSuccess(data){
    			if(logProblem.coverPhotoFile!=undefined && logProblem.coverPhotoFile!=null){
    				addMainPhotoToProblem(data.saveUpdateDeleteRecordId);
    			}
            }
    		function saveProblemFailure(error){
    			alert(error);
    		}
		}
		
		function processUserData(){
			logProblem.userData = dataShareService.getUserInfo();

			if(!logProblem.userData){
				userInfoService.getUserInfo().then(userInfoSuccess).catch(userInfoFailure);

				function userInfoSuccess(data){
					dataShareService.setUserInfo(data);
				}

				function userInfoFailure(error){
					alert(error);
				}
			}else if(logProblem.userData.displayLocation){
				logProblem.selectedLocation = logProblem.userData.displayLocation;
				logProblem.locatedIn=logProblem.userData.displayLocation.locationName;
				
				generateTags();
			}
		}

		function uploadCover(files){
			logProblem.coverPhotoFile = files[0];
		}
		
		function addMainPhotoToProblem(problemGuid){

			let files=[logProblem.coverPhotoFile];
	
			fileUploadService.uploadFile(files,"Problem",problemGuid,true,null).then(uploadSuccess).catch(uploadFailure);

			function uploadSuccess(data){
				console.log(data);
			}

			function uploadFailure(error){
				alert(error);
			}
		}
		
		function generateTags(){

			logProblem.tags = [];
			
			let content=logProblem.chosenProblemCategory;
			content+=" "+logProblem.grivienceName;
			if(logProblem.grivienceType!=undefined){
				content+=" "+logProblem.grivienceType.problemTypeName;
			}
			if(logProblem.selectedLocation!=undefined){
				content+=" "+logProblem.selectedLocation.locationName;
			}
			
			let contentWords = content.split(" ");
			if(contentWords.length>1){
				for(let i =0; i < contentWords.length; i++){
					let tagObj= { text: contentWords[i] };
					if(contentWords[i]!=null && contentWords[i]!=undefined && contentWords[i]!="" && contentWords[i].length>=3 && !arrayContainsValue(contentWords[i])){
						logProblem.tags.push(tagObj);
					}
				}
			}

			//Reset page no to 1.
			logProblem.similarProblems.pageNo = 1;
			// Call to get similar problems based on multiple criteria.
			fetchRelatedProblemsData(logProblem.similarProblems.pageNo,logProblem.similarProblems.pageLimit);
		}

		function fetchRelatedProblemsData(pageNo,pageLimit){

			let filterEntityRequest = {
					objectName: logProblem.grivienceName,
					supportingFields: [logProblem.chosenProblemCategory],
					objectType: "Problem",
					pageNo: pageNo,
					pageLimit: pageLimit
			};

			if(logProblem.grivienceType!=undefined){
				filterEntityRequest.supportingFields.push(logProblem.grivienceType.problemTypeName);
			}

			if(logProblem.selectedLocation!=undefined){
				filterEntityRequest.locationName = logProblem.selectedLocation.locationName;
			}

			filterEntityByCriteria.filterEntities(filterEntityRequest).then(filterEntitiesSuccess).catch(filterEntitiesFailure);

			function filterEntitiesSuccess(data){
				logProblem.problems = data;
			}

			function filterEntitiesFailure(error){
				alert(error);
			}

		}
		
		function arrayContainsValue(tagName){
			var isContained=false;
			for(var i=0;i<logProblem.tags.length;i++){
				var tagObj= logProblem.tags[i];
				if(tagObj.text==tagName){
					isContained=true;
					break;
				}
			}
			return isContained;
		}
		
		function searchLocation(){
			if(logProblem.locatedIn.length>=3){
				logProblem.showLocationSearchBox=true;
				if(logProblem.locatedIn.length>=3){
					locationChangePopUpService.getSearchResults(logProblem.locatedIn).then(searchLocationsSuccess).catch(searchLocationsFailure);
		    		function searchLocationsSuccess(data){
		    			logProblem.searchedLocations=data;
		    		}
		    		function searchLocationsFailure(error){
		    			alert(error);
		    		}
				}
			}
		}
		
		function selectLocation(searchLocation){
			logProblem.selectedLocation=searchLocation;
			logProblem.locatedIn=searchLocation.locationName;
			logProblem.showLocationSearchBox=false;
			generateTags();
		}
	}

})();

(function() {
	'use strict';

	angular.module('myindia-app').controller("problemSelectionController",
			problemSelectionController);
	problemSelectionController.$inject = ['$state','problemSelectionService'];

	function problemSelectionController($state,problemSelectionService) {

		var problemSelection = this;
		problemSelection.problems = [];
		problemSelection.chosenProblemCategory = $state.params.selectedProblemCategory;
		problemSelection.problemTypes = $state.params.problemTypes;
		problemSelection.logNewProblem=logNewProblem;

		problemSelectionService.getProblemsByCategory(problemSelection.chosenProblemCategory).then(getProblemsByTypeSuccess).catch(getProblemsByTypeFailure);

		function getProblemsByTypeSuccess(data){
			problemSelection.problems = data;
		}

		function getProblemsByTypeFailure(error){
			alert(error);
		}
		
		function logNewProblem() {
			$state.go('createProblem.logProblem',{selectedProblemCategory:problemSelection.chosenProblemCategory,problemTypes:problemSelection.problemTypes});
		}
	}

})();

(function() {
	'use strict';

	angular.module('myindia-app').factory("problemSelectionService",
			problemSelectionService);

	problemSelectionService.$inject = [ '$q', 'swaggerShareService'];

	function problemSelectionService($q, swaggerShareService) {

		var services = {};

		var problemSelectionService = {
			getProblemsByCategory: getProblemsByCategory
		};

		// Call and save the data
		let swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return problemSelectionService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getProblemsByCategory(problemTypeCategory) {

			let deferred = $q.defer();
			
			if(swaggerPromise){
				swaggerPromise.then(function(){
					services.problem.getProblemsByProblemCategory({problemTypeCategory:problemTypeCategory},
						getProblemsByProblemCategorySuccess, getProblemsByProblemCategoryFailure);
					swaggerPromise = undefined;
				})
			}else{
				services.problem.getProblemsByProblemCategory({problemTypeCategory:problemTypeCategory},
						getProblemsByProblemCategorySuccess, getProblemsByProblemCategoryFailure);
			}
			

			return deferred.promise;

			function getProblemsByProblemCategorySuccess(data) {
				deferred.resolve(data.obj);
			}

			function getProblemsByProblemCategoryFailure(error) {
				deferred.reject(error);
			}

		}

	}

})();
(function() {
	'use strict';

	angular.module('myindia-app').controller("problemTypeSelectionController",
			problemTypeSelectionController);
	problemTypeSelectionController.$inject = ['$state','createProblemService'];

	function problemTypeSelectionController($state,createProblemService) {

		var problemTypeSelection = this;
		problemTypeSelection.problemTypes = [];
		problemTypeSelection.problemTypeCategories = [];
		problemTypeSelection.chooseExistingProblem = chooseExistingProblem;

		getAllProblemTypes();

		// for (var i = 0; i < 20; i++) {
		// 	var imageName = "";

		// 	if (i % 2 == 0) {
		// 		imageName = "power_problem.jpg";
		// 	} else if (i % 3 == 0) {
		// 		imageName = "agriculture_problem.jpg";
		// 	} else if (i % 5 == 0) {
		// 		imageName = "water_problem.jpg";
		// 	} else {
		// 		imageName = "road_problem.jpg";
		// 	}
		// 	var problemType = {
		// 		"problemTypeName" : "Problem Type " + i,
		// 		"problemTypeImage" : resource + "problem/" + imageName,
		// 		"guid": 417
		// 	};
		// 	problemTypeSelection.problemTypes.push(problemType);
		// }

		function chooseExistingProblem(problemCategory) {

			let problemTypes = problemTypeSelection.problemTypes.filter(function( obj ) {
			  return obj.problemCategory == problemCategory;
			});

			$state.go('createProblem.problemSelection',{selectedProblemCategory:problemCategory,problemTypes:problemTypes});
		}

		function getAllProblemTypes(){
			
			createProblemService.getAllProblemTypes().then(getAllProblemTypesSuccess).catch(getAllProblemTypesFailure);
			
			function getAllProblemTypesSuccess(data){
				// let tempResults = data.map(function(a) {return a.problemCategory;});
				problemTypeSelection.problemTypes = data;
				// problemTypeSelection.problemTypeCategories = tempResults.filter((v, i, a) => a.indexOf(v) === i); 

				// array.map(item => item.problemCategory)
  				// 				.filter((value, index, self) => self.indexOf(value) === index)
  				let categories = [];
  				angular.forEach(data,function(problemType){
  					if(categories.indexOf(problemType.problemCategory) == -1){
  						categories.push(problemType.problemCategory);
  						problemTypeSelection.problemTypeCategories.push(problemType);
  					}
  				})

				console.log(problemTypeSelection.problemTypes);
			}
			function getAllProblemTypesFailure(error){
				alert(error);
			}
		}

	}

})();

(function() {
	'use strict';

	angular.module('myindia-app').controller("discussionsController",
			discussionsController);
	discussionsController.$inject = [];

	function discussionsController() {
		var discussions = this;
		discussions.comments=[];
		
		for(let i=0;i<20;i++){
			var discussion={};
			discussion.commentor={};
			discussion.commentor.name="YESUDASU ADIPI";
			discussion.commentor.userImage="https://s3.amazonaws.com/myindiaproblems/problems/31/Koala.jpg";
			discussion.commentText=" For register grievance servi For register grievance servi For register grievance servi For register grievance servi For register grievance servi For register grievance servi For register grievance servi";
			discussion.createdTimeStamp="2 Hours Ago";
			discussions.comments.push(discussion);
		}
	}

})();

(function() {
	'use strict';

	angular.module('myindia-app').controller("viewProblemController",
			viewProblemController);
	viewProblemController.$inject = ['$state','viewProblemService','filterEntityByCriteria'];

	function viewProblemController($state,viewProblemService,filterEntityByCriteria) {

		var viewProblem = this;
		viewProblem.problemDetails = {};
		viewProblem.objectType="PROBLEM";
		viewProblem.selectedProblemGuid = $state.params.selectedProblemGuid;
		viewProblem.similarProblems = {};
		viewProblem.similarProblems.pageNo = 1;
		viewProblem.similarProblems.pageLimit =4;
		viewProblem.similarProblems.problems = [];
		viewProblem.changeTab=changeTab;
		
		changeTab('viewProblem.overview');
		
		viewProblemService.getProblemDetails(viewProblem.selectedProblemGuid).then(getProblemDetailsSuccess).catch(getProblemDetailsFailure);

		function getProblemDetailsSuccess(data){
			viewProblem.problemDetails = data;

			// Call to fetch similar problems based on filter criteria
			fetchRelatedProblemsData(viewProblem.similarProblems.pageNo,viewProblem.similarProblems.pageLimit)

		}

		function fetchRelatedProblemsData(pageNo,pageLimit){

			let filterEntityRequest = {
					objectName: viewProblem.problemDetails.problemShortDescription,
					supportingFields: [viewProblem.problemDetails.problemType.problemCategory],
					objectType: "Problem",
					pageNo: pageNo,
					pageLimit: pageLimit
			};

			if(viewProblem.problemDetails.problemType!=undefined){
				filterEntityRequest.supportingFields.push(viewProblem.problemDetails.problemType.problemTypeName);
			}

			if(viewProblem.problemDetails.createdLocation!=undefined){
				filterEntityRequest.locationName = viewProblem.problemDetails.createdLocation.locationName;
			}

			filterEntityByCriteria.filterEntities(filterEntityRequest).then(filterEntitiesSuccess).catch(filterEntitiesFailure);

			function filterEntitiesSuccess(data){
				viewProblem.similarProblems.problems = data;
			}

			function filterEntitiesFailure(error){
				alert(error);
			}
		}
		function getProblemDetailsFailure(error){
			alert(error);
		}
		
		function changeTab(tabURL){
			$state.go(tabURL);
		}
	}

})();

(function() {
	'use strict';

	angular.module('myindia-app').factory("viewProblemService",
			viewProblemService);

	viewProblemService.$inject = [ '$q', 'swaggerShareService', '$timeout' ];

	function viewProblemService($q, swaggerShareService, $timeout) {

		var services = {};

		var viewProblemService = {
			getProblemDetails : getProblemDetails
		};

		// Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return viewProblemService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getProblemDetails(problemGuid) {

			let
			deferred = $q.defer();

			if (swaggerPromise) {
				swaggerPromise
						.then(function() {
							services.problem.getProblemByGuid({problemGuid:problemGuid},
									getProblemDetailsSuccess,
									getProblemDetailsFailure);
							swaggerPromise = undefined;
						})
			} else {
				services.problem.getProblemByGuid({problemGuid:problemGuid}, getProblemDetailsSuccess,
						getProblemDetailsFailure);
			}

			return deferred.promise;

			function getProblemDetailsSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getProblemDetailsFailure(error) {
				deferred.reject(error);
			}

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

        //If user has session storage values redirect to home page
        if(sessionStorage.getItem("access_token")){
            $state.go('home');
        }

    	function login(){
    		signInService.login(signIn.userName,signIn.password).then(loginSuccess).catch(loginFailure);

    		function loginSuccess(data){
                dataShareService.setUserInfo(data);
                $state.go('createProblem.problemTypeSelection');
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
                refreshAccessTokenService.startTokenExpiryTimer(sessionStorage.getItem("expires_in"));


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

    createAccountService.$inject = ['$q','swaggerShareService','refreshAccessTokenService'];

    function createAccountService($q,swaggerShareService,refreshAccessTokenService) {

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
                swaggerShareService.setAuthorization(data.obj.accessToken,data.obj.refreshToken,data.obj.expirationTimeInSeconds);

                //Start token expiration timer
                refreshAccessTokenService.startTokenExpiryTimer(sessionStorage.getItem("expires_in"));

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
		signUp.gotoSignIn = gotoSignIn;
		
		populateYears();
		
		function gotoSignIn(){
    		$state.go('signIn');
    	}

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
				// If not there are multiple location populate them.
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
		    // populate default ste of years.
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