(function() {
     'use strict';
	var myIndiaApp=angular.module('myindia-app', ['ui.router','ui.bootstrap','ngAnimate','ngMessages','angularTrix','ngTagsInput','nvd3ChartDirectives','angularFileUpload']);
	
})();

(function() {
	'use strict';

	angular.module('myindia-app').controller("activityFeedActionsController",
			activityFeedActionsController);
	activityFeedActionsController.$inject = [];

	function activityFeedActionsController() {
		var activityFeedActions = this;
	}

})();

(function() {
	'use strict';

	angular.module('myindia-app').directive("activityFeedActions", activityFeedActions);

	function activityFeedActions() {

		var activityFeedActions = {
			restrict : 'E',
			scope : {
				objectType : '=',
				objectGuid : '='
			},
			templateUrl : resource + 'partials/activityFeedActions.html',
			controller : 'activityFeedActionsController',
			controllerAs : 'activityFeedActions'
		};
		return activityFeedActions;
	}

})();

(function() {
	'use strict';

	angular.module('myindia-app').controller("commentActionsController",
			commentActionsController);
	commentActionsController.$inject = ['$scope'];

	function commentActionsController($scope) {
		var commentActions = this;
		
		commentActions.objectType=$scope.objectType;
		commentActions.objectGuid=$scope.objectGuid;
		commentActions.objectData=$scope.objectData;
		
		console.log(commentActions.objectType);
		console.log(commentActions.objectGuid);
		console.log(commentActions.objectData);
		
	}

})();

(function() {
	'use strict';

	angular.module('myindia-app').directive("commentActions", commentActions);

	function commentActions() {

		var commentActions = {
			restrict : 'E',
			scope : {
				objectType : '=',
				objectGuid : '=',
				objectData:'='
			},
			templateUrl : resource + 'partials/commentActions.html',
			controller : 'commentActionsController',
			controllerAs : 'commentActions'
		};
		return commentActions;
	}

})();

(function() {
	'use strict';
	angular.module('myindia-app').controller("commentBoxController",
			commentBoxController);

	commentBoxController.$inject = [ '$scope','commentBoxService','dataShareService','userInfoService' ];

	function commentBoxController($scope,commentBoxService,dataShareService,userInfoService) {
		var commentBox = this;
		commentBox.commentText="";
		commentBox.sendComment = sendComment;
		
		commentBox.userInfo = dataShareService.getUserInfo();
		if (!commentBox.userInfo) {
			userInfoService.getUserInfo().then(userInfoSuccess).catch(userInfoFailure);

			function userInfoSuccess(data){
				dataShareService.setUserInfo(data);
				commentBox.userInfo=data;
			}

			function userInfoFailure(error){
				alert(error);
			}
		}
		
		commentBox.userProfileImageClass = "comment_user_profile_image";
		commentBox.userProfileLabelClass = "comment_user_profile_label";

		function sendComment(){
			let commentData={};
			commentData.objectType=$scope.objectType;
			commentData.objectGuid=$scope.objectGuid;
			commentData.commentText=commentBox.commentText;
			
			commentBoxService.sendComment(commentData).then(sendCommentSuccess).catch(sendCommentFailure);
    		function sendCommentSuccess(data){
    			commentData.commentText="";
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
        	 var userPassword=attrs["compareEqualValidator"];
             console.log(userPassword);
             
          ngModel.$parsers.unshift(function (value) {
            console.log(value);
            if(userPassword)
              ngModel.$setValidity('compareEqualValidator', userPassword === value);
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

	angular.module('myindia-app').directive("fullOverlay", fullOverlay);

	function fullOverlay() {

		var fullOverlay = {
			restrict : 'E',
			link : link,
			templateUrl : resource + 'partials/fullOverlay.html'
		};

		return fullOverlay;

		function link(scope, element, attrs) {
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

		header.userProfileImageClass = "user_profile_image";
		header.userProfileLabelClass = "user_profile_label";

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
				modalControllerAlias : '=modalControllerAlias',
				modalSize : '=modalSize',
				objectType : '=objectType',
				objectGuid : '=objectGuid',
				selectedAlbum : '=selectedAlbum'
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
				controllerAs : scope.modalControllerAlias,
				size : scope.modalSize,
				resolve : {
					objectType : function() {
						return scope.objectType;
					},
					objectGuid : function() {
						return scope.objectGuid;
					},
					selectedAlbum : function() {
						return scope.selectedAlbum;
					}
				}
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

	angular.module('myindia-app').directive("userProfileImageDisplay", userProfileImageDisplay);

	function userProfileImageDisplay() {

		var userProfileImageDisplay = {
			restrict : 'E',
			scope: {
				imageUrl: '=',
				name: '=',
				imageClass: '=',
				labelClass: '='
			},
			templateUrl : resource + 'partials/userProfileImageDisplay.html',
			link : link
		};

		return userProfileImageDisplay;

		function link(scope, element, attrs) {

			if(!scope.imageUrl){
				let splitValues = scope.name.split(" ");

				if(splitValues && splitValues.length>1){
					scope.labelName = splitValues[0].charAt(0)+splitValues[1].charAt(0);
				}else if(splitValues && splitValues.length==1){
					scope.labelName = splitValues[0].charAt(0);
				}
			}
			console.log(scope.imageUrl);
		}

	}
})();

(function() {
     'use strict';
	
	angular.module('myindia-app').run(refreshToken);

	refreshToken.$inject = ['refreshAccessTokenService'];

	function refreshToken(refreshAccessTokenService){

		//on page reload if session exists refresh it
		if(sessionStorage.getItem("access_token"))
			refreshAccessTokenService.refreshAccessToken();
	}


})();
(function() {
     'use strict';
	
	angular.module('myindia-app').run(routeTrack);

	routeTrack.$inject = ['$rootScope','$state'];

	function routeTrack($rootScope,$state){
		$rootScope.$state = $state;

		$rootScope.$on("$stateChangeStart",function(event, toState, toParams, fromState, fromParams){

			/*if(toState.name != "signIn" && toState.name.indexOf('signUp') == -1){
				if(!sessionStorage.getItem("access_token")){
					event.preventDefault();
					$state.go('signIn');
				}
			}*/

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
			templateUrl : resource + 'partials/electorDetails.html',
			controller : 'electorDetailsController',
			controllerAs : 'electorDetails'
		}).state('signUp.locationSetup', {
			url : '/locationSetup',
			templateUrl : resource + 'partials/locationDetails.html',
			controller : 'locationDetailsController',
			controllerAs : 'locationDetails'
		}).state('signUp.politicianSelection', {
			url : '/politicianSelection',
			templateUrl : resource + 'partials/politicianSelection.html',
			controller : 'politicianSelectionController',
			controllerAs : 'politicianSelection'
		}).state('signUp.accountSetup', {
			url : '/accountSetup',
			templateUrl : resource + 'partials/accountSetup.html',
			controller : 'accountDetailsController',
			controllerAs : 'accountDetails'
		}).state('search', {
			url : '/search/:searchTerm',
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
			url : '/problemSelection/:selectedProblemCategory',
			templateUrl : resource + 'partials/problemSelection.html',
			controller : 'problemSelectionController',
			controllerAs : 'problemSelection',
			params : {
				'problemTypes' : ''
			}
		}).state('createProblem.logProblem', {
			url : '/logProblem/:selectedProblemCategory',
			templateUrl : resource + 'partials/logProblem.html',
			controller : 'logProblemController',
			controllerAs : 'logProblem',
			params : {
				'problemTypes' : ''
			}
		}).state('viewProblem', {
			url : '/viewProblem/:selectedProblemGuid',
			templateUrl : resource + 'partials/viewProblem.html',
			controller : 'viewProblemController',
			controllerAs : 'viewProblem'
		}).state('viewProblem.overview', {
			url : '/overview',
			templateUrl : resource + 'partials/overview.html'
		}).state('viewProblem.activityFeed', {
			url : '/activityFeed',
			templateUrl : resource + 'partials/activityFeed.html',
			controller : 'activityFeedController',
			controllerAs : 'activityFeed',
		}).state('viewProblem.discussions', {
			url : '/discussions',
			templateUrl : resource + 'partials/discussions.html',
			controller : 'discussionsController',
			controllerAs : 'discussions',
		}).state('viewProblem.photos', {
			url : '/photos',
			templateUrl : resource + 'partials/photos.html',
			controller : 'photosController',
			controllerAs : 'photos'
		}).state('viewProblem.attachments', {
			url : '/attachments',
			templateUrl : resource + 'partials/attachments.html',
			controller : 'attachmentController',
			controllerAs : 'attachment'
		}).state('viewProblem.contributors', {
			url : '/contributors',
			templateUrl : resource + 'partials/contributors.html',
			controller : 'contributorController',
			controllerAs : 'contributor'
		}).state('viewProblem.videos', {
			url : '/videos',
			templateUrl : resource + 'partials/videos.html',
			controller : 'videoController',
			controllerAs : 'video'
		}).state('forgotPassword', {
			url : '/forgotPassword',
			templateUrl : resource + 'partials/forgotPassword.html',
			controller : 'forgotPasswordController',
			controllerAs : 'forgotPassword',
		}).state('forgotPassword.validUser', {
			url : '/forgotPasswordValidUser',
			templateUrl : resource + 'partials/forgotPasswordValidUser.html'
		}).state('forgotPassword.changePassword', {
			url : '/changePassword',
			templateUrl : resource + 'partials/changePassword.html',
			controller : 'changePasswordController',
			controllerAs : 'changePassword',
			params : {
				'baseUserInfo' : ''
			}
		}).state('poc', {
			url : '/poc',
			templateUrl : resource + 'partials/poc.html',
			controller : 'pocController',
			controllerAs : 'poc',
		}).state('user', {
			url : '/user',
			templateUrl : resource + 'partials/user.html',
			controller : 'userController',
			controllerAs : 'user',
		});
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').factory("activityService",
			activityService);

	activityService.$inject = [ '$q', 'swaggerShareService'];

	function activityService($q, swaggerShareService) {

		var services = {};

		var activityService = {
			getAllActivities: getAllActivities
		};

		// Call and save the data
		let swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return activityService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getAllActivities(pageNo,pageLimit) {

			let deferred = $q.defer();
			
			if(swaggerPromise){
				swaggerPromise.then(function(){
					services.activity.getActivities({pageNo:pageNo,pageLimit:pageLimit},
							getAllActivitiesSuccess, getAllActivitiesFailure);
					swaggerPromise = undefined;
				})
			}else{
				services.activity.getActivities({pageNo:pageNo,pageLimit:pageLimit},
						getAllActivitiesSuccess, getAllActivitiesFailure);
			}
			

			return deferred.promise;

			function getAllActivitiesSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getAllActivitiesFailure(error) {
				deferred.reject(error);
			}

		}

	}

})();
(function() {
	'use strict';

	angular.module('myindia-app').factory("dataShareService", dataShareService);

	dataShareService.$inject = [ '$rootScope' ];

	function dataShareService($rootScope) {

		var data = {};
		var userSignUpData = {};

		var dataShareService = {
			getUserInfo : getUserInfo,
			setUserInfo : setUserInfo,
			getUserSignUpInfo : getUserSignUpInfo,
			setUserSignUpInfo : setUserSignUpInfo
		};

		return dataShareService;

		function getUserSignUpInfo() {
			return userSignUpData.responseData;
		}

		function setUserSignUpInfo(userSignUpResponseData) {
			userSignUpData.responseData = userSignUpResponseData;
		}

		function getUserInfo() {
			return data.userInfo;
		}

		function setUserInfo(userInfo) {

			if (userInfo.userSelectedLocation) {
				userInfo.displayLocation = userInfo.userSelectedLocation;
			} else if (data.userInfo && data.userInfo.userSelectedLocation) {
				userInfo.userSelectedLocation = data.userInfo.userSelectedLocation;
				userInfo.displayLocation = userInfo.userSelectedLocation;
			} else if (sessionStorage.getItem("display_location")) {
				userInfo.displayLocation = JSON.parse(sessionStorage
						.getItem("display_location"));
			} else {
				userInfo.displayLocation = userInfo.userLocation;
			}

			sessionStorage.setItem("display_location", JSON
					.stringify(userInfo.displayLocation));

			data.userInfo = userInfo;

			// Broadcast event
			broadcast('userInfoChanged');
		}

		function broadcast(eventName) {
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

	logoutService.$inject = [ '$q', 'swaggerShareService','refreshAccessTokenService' ];

	function logoutService($q, swaggerShareService,refreshAccessTokenService) {

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
				refreshAccessTokenService.stopTokenExpiryTimer();

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
			stopTokenExpiryTimer: stopTokenExpiryTimer,
			refreshAccessToken: refreshAccessToken
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

			if (swaggerPromise) {
				swaggerPromise.then(function() {
					services.account.refreshAccessToken({body: sessionStorage.getItem("refresh_token")}, refreshAccessTokenSuccess,
						refreshAccessTokenFailure);
			

					swaggerPromise = undefined;
				})
			} else {
				services.account.refreshAccessToken({body: sessionStorage.getItem("refresh_token")}, refreshAccessTokenSuccess,
						refreshAccessTokenFailure);
			}

			
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

	angular.module('myindia-app').factory("swaggerShareService",
			swaggerShareService);

	swaggerShareService.$inject = [ '$q' ];

	function swaggerShareService($q) {

		var apiMetaData = {};

		var hostName = window.location.origin+"/";

		var swaggerShareService = {
			getAPIMetaData : getAPIMetaData,
			setAuthorization : setAuthorization
		};

		return swaggerShareService;

		function getAPIMetaData(setMetaData) {

			if (apiMetaData.metaInfo) {
				setMetaData(apiMetaData.metaInfo);
			} else {
				let
				swaggerPromise = fetchAPIMetaData(hostName);
				swaggerPromise.then(function(data) {
					apiMetaData.metaInfo = data;
					setAuthorization();
					setMetaData(apiMetaData.metaInfo);
				});
				return swaggerPromise;
			}

		}

		function fetchAPIMetaData(hostName) {

			let
			deferred = $q.defer();

			let
			swagger = new SwaggerClient({
				url : hostName + 'api/swagger.json',
				success : function() {
					deferred.resolve(swagger);
				},
				error : function(error) {
					deferred.reject(error);
				}
			});

			return deferred.promise;

		}

		function setAuthorization(token, refreshToken, expiresIn) {

			let
			accessToken;

			if (token) {
				accessToken = token;
				sessionStorage.setItem("access_token", accessToken);
				sessionStorage.setItem("refresh_token", refreshToken);
				sessionStorage.setItem("expires_in", expiresIn);
			} else if (sessionStorage.getItem("access_token")) {
				accessToken = sessionStorage.getItem("access_token");
			}

			if (accessToken && apiMetaData.metaInfo) {
				var apiKeyAuth = new SwaggerClient.ApiKeyAuthorization(
						"Authorization", "Bearer " + accessToken, "header");
				apiMetaData.metaInfo.clientAuthorizations.remove("bearer");
				apiMetaData.metaInfo.clientAuthorizations.add("bearer",
						apiKeyAuth);
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
/**
 * 
 */
(function() {
	'use strict';

	angular.module('myindia-app').controller("changePasswordController",
			changePasswordController);

	changePasswordController.$inject = [ '$state','forgotPasswordService' ];

	function changePasswordController($state,forgotPasswordService) {
		var changePassword = this;
		changePassword.passwordRegex = "^.*(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&*(),./?]).*$";
		changePassword.baseUserInfo = $state.params.baseUserInfo;
		changePassword.resetPassword=resetPassword;
		
		function resetPassword(){
			forgotPasswordService.resetPassword(changePassword.baseUserInfo.accountGuid,changePassword.confirmPassword)
			.then(resetPasswordSuccess).catch(resetPasswordFailure);

			function resetPasswordSuccess(data){	
				$state.go('signIn');
            }
            function resetPasswordFailure(error){
            	 console.log(error);
            }
		}
	
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').controller("forgotPasswordController",
			forgotPasswordController);

	forgotPasswordController.$inject = [ '$state','forgotPasswordService' ];

	function forgotPasswordController($state,forgotPasswordService) {
		var forgotPassword = this;
		forgotPassword.validUser = validUser;
		forgotPassword.passwordRegex = "^.*(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&*(),./?]).*$";
		forgotPassword.baseUserInfo = $state.params.baseUserInfo;
	
		function validUser(){
			forgotPasswordService.validUser(forgotPassword.userName,forgotPassword.referenceName)
			.then(validUserSuccess).catch(validUserFailure);

			function validUserSuccess(data){	
				$state.go('forgotPassword.changePassword',{baseUserInfo:data});
            }
            function validUserFailure(error){
            	 console.log(error);
            }
		}
	}
})();

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
				if(globalSearch.searchObjectType == 'ALL'){
					globalSearch.totalCount = data.totalCount;
					globalSearch.objectsCount = data.objectsCount;
				}
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
	homeController.$inject = [ '$scope','activityService','$state' ];

	function homeController($scope,activityService,$state) {
		var home = this;
		home.getAllActivties=getAllActivties;
		home.gotoObject=gotoObject;
		home.pageOffset=1;
		home.pageLimit=6;
		home.xFunction = xFunction;
		home.yFunction = yFunction;
		home.color = [ "#ED1C24", "#EB7422", "#FFDF16", "#0AA24B" ];
		home.problemChartData = [ {
			key : "Critical",
			y : 500
		}, {
			key : "High",
			y : 200
		}, {
			key : "Medium",
			y : 900
		}, {
			key : "Low",
			y : 700
		} ];

		function xFunction() {
			return function(d) {
				return d.key;
			};
		}
		function yFunction() {
			return function(d) {
				return d.y;
			};
		}
		
		getAllActivties();
		
		function getAllActivties(){
			activityService.getAllActivities(home.pageOffset,home.pageLimit).then(getAllActivitiesSuccess).catch(getAllActivitiesFailure);

			function getAllActivitiesSuccess(data){
				home.activities = data;
			}

			function getAllActivitiesFailure(error){
				alert(error);
			}
		}
		
		function gotoObject(activityContent){
			if(activityContent){
				if(activityContent.onObjectType && activityContent.onObjectType!=null){
					if(activityContent.onObjectType=='PROBLEM' || activityContent.onObjectType=='Problem'){
						$state.go('viewProblem', {
							selectedProblemGuid : activityContent.onObjectGuid
						});
					}
				}
			}
		}
	}

})();

(function() {
	'use strict';

	angular.module('myindia-app').controller("pocController", pocController);
	pocController.$inject = [ '$scope','pocService'];
	
	angular.module('myindia-app').directive('fileModel', [ '$parse', function($parse) {
		return {
			restrict : 'A',
			link : function(scope, element, attrs) {
				var model = $parse(attrs.fileModel);
				var modelSetter = model.assign;

				element.bind('change', function() {
					scope.$apply(function() {
						modelSetter(scope, element[0].files[0]);
					});
				});
			}
		};
	} ]);

	function pocController($scope,pocService) {
		var poc = this;
		poc.uploadFile=uploadFile;
		function uploadFile(){
            pocService.uploadFiles(poc.myFile).then(uploadFilesSuccess).catch(uploadFilesFailure);

			function uploadFilesSuccess(data){
			}
			function uploadFilesFailure(error){
				alert(error);
			}
		}
        
	}

})();

(function() {
	'use strict';

	angular.module('myindia-app').factory("pocService", pocService);

	pocService.$inject = [ '$q', 'swaggerShareService' ];

	function pocService($q, swaggerShareService) {

		var services = {};

		var pocService = {
			uploadFiles : uploadFiles
		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return pocService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function uploadFiles(uploadedFile) {
			let
			deferred = $q.defer();
			 var formData = new FormData();
			 formData.append('file', uploadedFile);
			 
			services.fileUpload.addFiles({
				body : formData
			}, uploadFilesSuccess, uploadFilesFailure);

			return deferred.promise;

			function uploadFilesSuccess(data) {
				deferred.resolve(data.obj);
			}

			function uploadFilesFailure(error) {
				deferred.reject(error);
			}
		}

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
			getProblemTypesByCategory: getProblemTypesByCategory,
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

		function getProblemTypesByCategory(problemCategory) {

			let deferred = $q.defer();
			
			if(swaggerPromise){
				swaggerPromise.then(function(){
					services.problemType.getProblemTypesByCategory({problemCategory:problemCategory},
						getProblemTypesByCategorySuccess, getProblemTypesByCategoryFailure);
					swaggerPromise = undefined;
				})
			}else{
				services.problemType.getProblemTypesByCategory({problemCategory:problemCategory},
						getProblemTypesByCategorySuccess, getProblemTypesByCategoryFailure);
			}
			

			return deferred.promise;

			function getProblemTypesByCategorySuccess(data) {
				deferred.resolve(data.obj);
			}

			function getProblemTypesByCategoryFailure(error) {
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

		if($state.params.problemTypes)
			logProblem.problemTypesResults = $state.params.problemTypes;
		else{
			//get problem types by category.
			createProblemService.getProblemTypesByCategory(logProblem.chosenProblemCategory).then(problemTypesSuccess).catch(problemTypesFailure);

			function problemTypesSuccess(data){
				logProblem.problemTypesResults = data;
			}

			function problemTypesFailure(error){
				alert(error);
			}

		}

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

		function chooseExistingProblem(problemCategory) {

			let problemTypes = problemTypeSelection.problemTypes.filter(function( obj ) {
			  return obj.problemCategory == problemCategory;
			});

			$state.go('createProblem.problemSelection',{selectedProblemCategory:problemCategory,problemTypes:problemTypes});
		}

		function getAllProblemTypes(){
			
			createProblemService.getAllProblemTypes().then(getAllProblemTypesSuccess).catch(getAllProblemTypesFailure);
			
			function getAllProblemTypesSuccess(data){
				
				problemTypeSelection.problemTypes = data;
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

	angular.module('myindia-app').controller("activityFeedController",
			activityFeedController);
	activityFeedController.$inject = ['$scope','activityService'];

	function activityFeedController($scope,activityService) {
		var activityFeed = this;
		activityFeed.activities = [];
		activityFeed.pageOffset=1;
		activityFeed.pageLimit=10;
		activityFeed.userProfileImageClass = "activity_user_profile_image";
		activityFeed.userProfileLabelClass = "activity_user_profile_label";
		activityFeed.problemDetails=$scope.$parent.viewProblem.problemDetails;
		activityFeed.objectGuid=activityFeed.problemDetails.guid;
		activityFeed.objectType="ACTIVITY";
		
		getActivitiesByObjectGuid();
		
		function getActivitiesByObjectGuid(){
			activityService.getActivitiesByObjectGuid(activityFeed.objectGuid,activityFeed.pageOffset,activityFeed.pageLimit).then(getActivitiesByObjectGuidSuccess).catch(getActivitiesByObjectGuidFailure);

			function getActivitiesByObjectGuidSuccess(data){
				activityFeed.activities = data;
			}

			function getActivitiesByObjectGuidFailure(error){
				alert(error);
			}
		}
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').factory("activityService", activityService);

	activityService.$inject = [ '$q', 'swaggerShareService' ];

	function activityService($q, swaggerShareService) {

		var services = {};

		var activityService = {
			getAllActivities : getAllActivities,
			getActivitiesByObjectGuid : getActivitiesByObjectGuid
		};

		// Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return activityService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getAllActivities(pageNo, pageLimit) {

			let
			deferred = $q.defer();

			if (swaggerPromise) {
				swaggerPromise.then(function() {
					services.activity.getActivities({
						pageNo : pageNo,
						pageLimit : pageLimit
					}, getAllActivitiesSuccess, getAllActivitiesFailure);
					swaggerPromise = undefined;
				})
			} else {
				services.activity.getActivities({
					pageNo : pageNo,
					pageLimit : pageLimit
				}, getAllActivitiesSuccess, getAllActivitiesFailure);
			}

			return deferred.promise;

			function getAllActivitiesSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getAllActivitiesFailure(error) {
				deferred.reject(error);
			}

		}

		function getActivitiesByObjectGuid(objectGuid,pageNo, pageLimit) {

			let
			deferred = $q.defer();

			services.activity.getActivitiesByObject({
				objectGuid:objectGuid,
				pageNo : pageNo,
				pageLimit : pageLimit
			}, getActivitiesByObjectGuidSuccess, getActivitiesByObjectGuidFailure);

			return deferred.promise;

			function getActivitiesByObjectGuidSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getActivitiesByObjectGuidFailure(error) {
				deferred.reject(error);
			}

		}

	}

})();
(function() {
	'use strict';

	angular.module('myindia-app').controller("attachmentController",
			attachmentController);
	attachmentController.$inject = ['$scope','attachmentService'];

	function attachmentController($scope,attachmentService) {
		var attachment = this;
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').factory("attachmentService", attachmentService);

	attachmentService.$inject = [ '$q', 'swaggerShareService' ];

	function attachmentService($q, swaggerShareService) {

		var services = {};

		var attachmentService = {};

		// Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return attachmentService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}
	}
})();
(function() {
	'use strict';

	angular.module('myindia-app').controller("contributorController",
			contributorController);
	contributorController.$inject = ['$scope','contributorService'];

	function contributorController($scope,contributorService) {
		var contributor = this;
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').factory("contributorService",
			contributorService);

	contributorService.$inject = [ '$q', 'swaggerShareService' ];

	function contributorService($q, swaggerShareService) {

		var services = {};

		var contributorService = {

		};

		// Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return contributorService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}
	}

})();
(function() {
	'use strict';

	angular.module('myindia-app').controller("discussionsController",
			discussionsController);
	discussionsController.$inject = ['$scope', 'discussionsService' ];

	function discussionsController($scope,discussionsService) {
		var discussions = this;
		discussions.comments = [];
		discussions.problemDetails=$scope.$parent.viewProblem.problemDetails;
		discussions.objectType="PROBLEM";
		discussionsService.getProblemComments(discussions.problemDetails.guid,1,20).then(getProblemCommentsSuccess).catch(getProblemCommentsFailure);
		discussions.userProfileImageClass = "discussion_user_profile_image";
		discussions.userProfileLabelClass = "discussion_user_profile_label";

		function getProblemCommentsSuccess(data){
			discussions.comments = data;
		}
		function getProblemCommentsFailure(error){
			alert(error);
		}
	}

})();

(function() {
	'use strict';

	angular.module('myindia-app').factory("discussionsService",
			discussionsService);

	discussionsService.$inject = [ '$q', 'swaggerShareService', '$timeout' ];

	function discussionsService($q, swaggerShareService, $timeout) {

		var services = {};

		var discussionsService = {
			getProblemComments : getProblemComments
		};

		// Call and save the data
		swaggerShareService.getAPIMetaData(setAPIMetaData);

		return discussionsService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getProblemComments(problemGuid,pageNo,limit) {

			let
			deferred = $q.defer();

			services.comment.getFirstLevelComments({
				objectGuid : problemGuid,
				pageNo:pageNo,
				limit:limit
			}, getProblemCommentsSuccess, getProblemCommentsFailure);

			return deferred.promise;

			function getProblemCommentsSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getProblemCommentsFailure(error) {
				deferred.reject(error);
			}

		}
	}
})();
(function() {
	'use strict';

	angular.module('myindia-app').controller("addAlbumController",
			addAlbumController);
	addAlbumController.$inject = [ '$scope', '$uibModalInstance','albumService','objectType',
			'objectGuid','selectedAlbum'];

	function addAlbumController($scope, $uibModalInstance,albumService, objectType,
			objectGuid,selectedAlbum) {
		var addAlbum = this;
		
		addAlbum.addedAlbumPhotoFiles=new Array();
		addAlbum.addedAlbumPhotos= [];
		addAlbum.getChoosenFiles=getChoosenFiles;
		addAlbum.myInterval = 2000;
		addAlbum.noWrapSlides = false;
		addAlbum.active = 0;
		addAlbum.closePopUp = closePopUp;
		addAlbum.objectType = objectType;
		addAlbum.objectGuid = objectGuid;
		addAlbum.getMoreChoosenFiles=getMoreChoosenFiles;
		addAlbum.uploadAlbumPhoto=uploadAlbumPhoto;
		addAlbum.albumPhotoFileAdded=false;
		addAlbum.uploadAlbum=uploadAlbum;
		addAlbum.uploadPhotosToAlbum=uploadPhotosToAlbum;
		addAlbum.selectedAlbum=selectedAlbum;
		if(addAlbum.selectedAlbum){
			addAlbum.albumGuid=addAlbum.selectedAlbum.guid;
			addAlbum.albumName=addAlbum.selectedAlbum.name;
			addAlbum.albumDescription=addAlbum.selectedAlbum.description;
			addAlbum.albumImage = addAlbum.selectedAlbum.imageUrl;
			addAlbum.albumImageName=addAlbum.selectedAlbum.imageUrl.split("/").pop();
			addAlbum.albumPhotoFileAdded=true;
		}
		function getChoosenFiles(files){
			addAlbum.addedAlbumPhotos=files;
			for(let eachFileIndex=0;eachFileIndex<files.length;eachFileIndex++){
				addAlbum.addedAlbumPhotoFiles.push(files[eachFileIndex]);
			}
		}
		function getMoreChoosenFiles(moreFiles){
			for(let eachFileIndex=0;eachFileIndex<moreFiles.length;eachFileIndex++){
				addAlbum.addedAlbumPhotoFiles.push(moreFiles[eachFileIndex]);
			}
		}
		function closePopUp() {
			$uibModalInstance.dismiss('cancel');
		}
		
		function uploadAlbumPhoto(files){
			addAlbum.albumPhotoFile = files[0];
			addAlbum.albumPhotoFileAdded=true;
		}
		
		function uploadAlbum(){
			albumService.createUpdateAlbum(addAlbum.albumGuid,addAlbum.albumName,addAlbum.albumDescription,addAlbum.albumPhotoFile,addAlbum.objectType,addAlbum.objectGuid).then(uploadAlbumSuccess).catch(uploadAlbumFailure);
			function uploadAlbumSuccess(data){
				addAlbum.albumGuid=data.saveUpdateDeleteRecordId;
				uploadPhotosToAlbum(addAlbum.albumGuid);
			}
			function uploadAlbumFailure(error){
				alert(error);
			}
		}
		
		function uploadPhotosToAlbum(){
			let albumPhotos=addAlbum.addedAlbumPhotoFiles;
			if(albumPhotos!=null && albumPhotos.length>0){
				albumService.uploadPhotosToAlbum(addAlbum.albumGuid,albumPhotos,addAlbum.objectType,addAlbum.objectGuid).then(uploadPhotosToAlbumSuccess).catch(uploadPhotosToAlbumFailure);
				function uploadPhotosToAlbumSuccess(data){
					closePopUp();
				}
				function uploadPhotosToAlbumFailure(error){
					alert(error);
				}
			}
		}
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').factory("albumService", albumService);

	albumService.$inject = [ '$q', 'swaggerShareService' ];

	function albumService($q, swaggerShareService) {

		var services = {};

		var albumService = {
			createUpdateAlbum : createUpdateAlbum,
			uploadPhotosToAlbum : uploadPhotosToAlbum,
			getAlbums:getAlbums,
			getProblemPhotos:getProblemPhotos,
			getAlbumPhotos:getAlbumPhotos
		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return albumService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function uploadPhotosToAlbum(albumGuid, files, objectType, objectGuid) {

			let
			deferred = $q.defer();

			let
			promises = [];

			angular.forEach(files, function(file, key) {
				promises.push(preapreUploadFileRequest(file, objectType,
						objectGuid, albumGuid, null));
			});

			$q.all(promises).then(function(filesData) {

				services.image.addPhotosToAlbum({
					body : JSON.stringify(filesData)
				}, uploadPhotosToAlbumSuccess, uploadPhotosToAlbumFailure);

				function uploadPhotosToAlbumSuccess(data) {
					deferred.resolve(data);
				}

				function uploadPhotosToAlbumFailure(error) {
					deferred.reject(error);
				}
			})

			return deferred.promise;
		}

		function createUpdateAlbum(albumGuid,albumName,albumDescription, albumPhotoFile,
				objectType, objectGuid) {

			let
			deferred = $q.defer();

			let
			albumFilePromise = preapreUploadAlbumFileRequest(albumPhotoFile,
					objectType, objectGuid, albumGuid,albumName,albumDescription);

			albumFilePromise.then(function(filesData) {

				services.image.createUpdateAlbum({
					body : JSON.stringify(filesData)
				}, createUpdateAlbumSuccess, createUpdateAlbumFailure);

				function createUpdateAlbumSuccess(data) {
					deferred.resolve(data.obj);
				}

				function createUpdateAlbumFailure(error) {
					deferred.reject(error);
				}
			})

			return deferred.promise;

		}
		function preapreUploadAlbumFileRequest(file, objectType, objectGuid,
				albumGuid, albumName,albumDescription) {

			let
			deferred = $q.defer();

			var name = file.name;
			var reader = new FileReader();
			reader.onload = function() {

				var req = {};
				req.imageName = name;
				req.imageData = reader.result;
				req.objectType = objectType;
				req.objectGuId = objectGuid;
				req.albumDescription = albumDescription;
				req.albumGuid = albumGuid;
				req.albumName = albumName,

				deferred.resolve(req);
			}
			reader.readAsDataURL(file);

			return deferred.promise;
		}
		
		function preapreUploadFileRequest(file, objectType, objectGuid,
				albumGuid, albumName) {

			let
			deferred = $q.defer();

			var name = file.name;
			var reader = new FileReader();
			reader.onload = function() {

				var req = {};
				req.imageName = name;
				req.imageData = reader.result;
				req.objectType = objectType;
				req.objectGuId = objectGuid;
				req.albumGuid = albumGuid;
				req.albumName = albumName,

				deferred.resolve(req);
			}
			reader.readAsDataURL(file);

			return deferred.promise;
		}
		function getProblemPhotos(objectGuid,objectType,pageNo, pageLimit) {

			let
			deferred = $q.defer();
			
			let requestData={
					objectType:objectType,
					objectGuid:objectGuid,
					pageOffset:pageNo,
					pageLimit:pageLimit
			};
			services.image.getPhotosByObject({
				body : JSON.stringify(requestData)
			}, getProblemPhotosSuccess, getProblemPhotosFailure);

			return deferred.promise;

			function getProblemPhotosSuccess(data) {
				deferred.resolve(data.obj);
			}
			function getProblemPhotosFailure(error) {
				deferred.reject(error);
			}
		}
		function getAlbums(objectGuid,objectType,pageNo, pageLimit) {

			let
			deferred = $q.defer();
			
			let requestData={
					objectType:objectType,
					objectGuid:objectGuid,
					pageOffset:pageNo,
					pageLimit:pageLimit
			};
			services.image.getAlbumsByObject({
				body : JSON.stringify(requestData)
			}, getAlbumsSuccess, getAlbumsFailure);

			return deferred.promise;

			function getAlbumsSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getAlbumsFailure(error) {
				deferred.reject(error);
			}

		}
		
		function getAlbumPhotos(albumGuid,objectGuid,objectType,pageNo, pageLimit) {

			let
			deferred = $q.defer();
			
			let requestData={
					objectType:objectType,
					objectGuid:objectGuid,
					pageOffset:pageNo,
					pageLimit:pageLimit,
					subObjectGuid:albumGuid
			};
			services.image.getAlbumPhotosByObject({
				body : JSON.stringify(requestData)
			}, getAlbumPhotosSuccess, getAlbumPhotosFailure);

			return deferred.promise;

			function getAlbumPhotosSuccess(data) {
				deferred.resolve(data.obj);
			}
			function getAlbumPhotosFailure(error) {
				deferred.reject(error);
			}

		}
	}

})();
(function() {
	'use strict';

	angular.module('myindia-app').controller("addPhotosController",
			addPhotosController);
	addPhotosController.$inject = [ '$scope', 'addPhotosService',
			'$uibModalInstance','objectType','objectGuid' ];

	function addPhotosController($scope, addPhotosService, $uibModalInstance,objectType,objectGuid) {
		var addPhotos = this;
		addPhotos.closePopUp = closePopUp;
		addPhotos.uploadPhotos = uploadPhotos;
		addPhotos.addedPhotos= [];
		addPhotos.getChoosenFiles=getChoosenFiles;
		addPhotos.myInterval = 2000;
		addPhotos.noWrapSlides = false;
		addPhotos.active = 0;
		addPhotos.addedPhotoFiles=new Array();
		addPhotos.objectType = objectType;
		addPhotos.objectGuid = objectGuid;
		
		addPhotos.getMoreChoosenFiles=getMoreChoosenFiles;
		
		function getChoosenFiles(files){
			addPhotos.addedPhotos=files;
			for(let eachFileIndex=0;eachFileIndex<files.length;eachFileIndex++){
				addPhotos.addedPhotoFiles.push(files[eachFileIndex]);
			}
		}
		function getMoreChoosenFiles(moreFiles){
			for(let eachFileIndex=0;eachFileIndex<moreFiles.length;eachFileIndex++){
				addPhotos.addedPhotoFiles.push(moreFiles[eachFileIndex]);
			}
		}
		function closePopUp() {
			$uibModalInstance.dismiss('cancel');
		}
		function uploadPhotos() {
			
			if(addPhotos.addedPhotoFiles!=null && addPhotos.addedPhotoFiles.length>0){
				addPhotosService.uploadPhotos(addPhotos.addedPhotoFiles,addPhotos.objectType,addPhotos.objectGuid).then(uploadPhotosSuccess).catch(uploadPhotosFailure);
				
				function uploadPhotosSuccess(data){
					closePopUp();
				}
				function uploadPhotosFailure(error){
					alert(error);
				}
			}
		}
		
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').factory("addPhotosService", addPhotosService);

	addPhotosService.$inject = [ '$q', 'swaggerShareService' ];

	function addPhotosService($q, swaggerShareService) {

		var services = {};

		var addPhotosService = {
			uploadPhotos : uploadPhotos
		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return addPhotosService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function uploadPhotos(files, objectType, objectGuid) {

			let
			deferred = $q.defer();

			let
			promises = [];

			angular.forEach(files, function(file, key) {
				promises.push(preapreUploadFileRequest(file, objectType,
						objectGuid));
			});

			$q.all(promises).then(function(filesData) {

				services.image.addPhotos({
					body : JSON.stringify(filesData)
				}, uploadPhotosSuccess, uploadPhotosFailure);

				function uploadPhotosSuccess(data) {
					deferred.resolve(data);
				}

				function uploadPhotosFailure(error) {
					deferred.reject(error);
				}
			})

			return deferred.promise;
		}

		function preapreUploadFileRequest(file, objectType, objectGuid) {

			let
			deferred = $q.defer();

			var name = file.name;
			var reader = new FileReader();
			reader.onload = function() {

				var req = {};
				req.imageName = name;
				req.imageData = reader.result;
				req.objectType = objectType;
				req.objectGuId = objectGuid;

				deferred.resolve(req);
			}
			reader.readAsDataURL(file);

			return deferred.promise;
		}
	}

})();
(function() {
	'use strict';

	angular.module('myindia-app').controller("photosController",
			photosController);
	photosController.$inject = [ '$scope','albumService'];

	function photosController($scope,albumService) {
		var photos = this;
		photos.openOverlayForCreateProblem = openOverlayForCreateProblem;
		photos.problemDetails=$scope.$parent.viewProblem.problemDetails;
		photos.objectGuid=photos.problemDetails.guid;
		photos.objectType="PROBLEM";
		photos.getProblemAlbums=getProblemAlbums;
		photos.getProblemPhotos=getProblemPhotos
		photos.albumPageOffset=1;
		photos.albumPageLimit=10;
		photos.photoPageOffset=1;
		photos.photoPageLimit=10;
		photos.albumPhotoPageOffset=1;
		photos.albumPhotoPageLimit=10;
		photos.showPhotos=true;
		photos.showAddPhotosPopup=showAddPhotosPopup;
		photos.showAddAlbumPopup=showAddAlbumPopup;
		photos.animationsEnabled = true;
		photos.addPhotosPopUpUrl = resource
				+ "partials/addPhotos.html";
		photos.showAddPhotosModal = false;
		photos.closeAddPhotosModal = closeAddPhotosModal;
		photos.photosModalControllerName = "addPhotosController";
		photos.photosModalControllerAlias = "addPhotos";
		photos.photosModalSize="";
		photos.closeAddAlbumModal = closeAddAlbumModal;
		photos.addAlbumPopUpUrl = resource
		+ "partials/addAlbum.html";
		photos.albumsModalControllerName = "addAlbumController";
		photos.albumsModalControllerAlias = "addAlbum";
		photos.albumsModalSize="lg";
		photos.getAlbumPhotos=getAlbumPhotos;
		photos.closeAlbumPhotosView=closeAlbumPhotosView;
		
		getProblemPhotos();
		
		function openOverlayForCreateProblem() {
			photos.showOverlay = true;
		}
		function getProblemPhotos(){
			albumService.getProblemPhotos(photos.objectGuid,photos.objectType,photos.photoPageOffset,photos.photoPageLimit).then(getProblemPhotosSuccess).catch(getProblemPhotosFailure);
			function getProblemPhotosSuccess(data){
				photos.problemPhotos = data;
			}
			function getProblemPhotosFailure(error){
				alert(error);
			}
		}
		
		function getProblemAlbums(){
			photos.showPhotos=false;
			photos.showAlbums=true;
			albumService.getAlbums(photos.objectGuid,photos.objectType,photos.albumPageOffset,photos.albumPageLimit).then(getAlbumsSuccess).catch(getAlbumsFailure);

			function getAlbumsSuccess(data){
				photos.problemAlbums = data;
				photos.selctedProblemAlbum=photos.problemAlbums[0];
			}
			function getAlbumsFailure(error){
				alert(error);
			}
		}
		
		function showAddPhotosPopup(){
			photos.showAddPhotosModal = true;
		}
		function closeAddPhotosModal(){
			photos.showAddPhotosModal = false;
			getProblemPhotos();
		}
		function showAddAlbumPopup(){
			if(photos.showAlbums){
				photos.selctedProblemAlbum=false;
			}
			photos.showAddAlbumModal = true;
		}
		function closeAddAlbumModal(){
			photos.showAddAlbumModal = false;
			if(photos.showAlbums){
				getProblemAlbums();
			}else{
				getAlbumPhotos(photos.selctedProblemAlbum)
			}
		}
		function getAlbumPhotos(selectedAlbum){
			photos.showAlbums=false;
			photos.showAlbumPhotos=true;
			photos.selctedProblemAlbum=selectedAlbum;
			albumService.getAlbumPhotos(photos.selctedProblemAlbum.guid,photos.objectGuid,photos.objectType,photos.albumPhotoPageOffset,photos.albumPhotoPageLimit).then(getAlbumPhotosSuccess).catch(getAlbumPhotosFailure);

			function getAlbumPhotosSuccess(data){
				photos.problemAlbumPhotos = data;
			}
			function getAlbumPhotosFailure(error){
				alert(error);
			}
		}
		function closeAlbumPhotosView(){
			photos.showPhotos=false;
			photos.showAlbums=true;
			photos.showAlbumPhotos=false;
		}
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').controller("videoController",
			videoController);
	videoController.$inject = ['$scope','videoService'];

	function videoController($scope,videoService) {
		var video = this;
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').factory("videoService", videoService);

	videoService.$inject = [ '$q', 'swaggerShareService' ];

	function videoService($q, swaggerShareService) {

		var services = {};

		var videoService = {
		};

		// Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return videoService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
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
		
		viewProblem.userProfileImageClass = "view_problem_user_profile_image";
		viewProblem.userProfileLabelClass = "view_problem_user_profile_label";

		
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
		
		function changeTab(tabURL,tabName){
			viewProblem.selectedTabName=tabName;
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
 		signIn.gotoForgotPassword = gotoForgotPassword;

        // If user has session storage values redirect to home page
        if(sessionStorage.getItem("access_token")){
            $state.go('home');
        }

    	function login(){
    		signInService.login(signIn.userName,signIn.password).then(loginSuccess).catch(loginFailure);

    		function loginSuccess(data){
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
    	
    	function gotoForgotPassword(){
    		$state.go('forgotPassword.validUser');
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

	angular.module('myindia-app').controller("accountDetailsController",
			accountDetailsController);

	accountDetailsController.$inject = [ '$state','signUpService','dataShareService'];

	function accountDetailsController($state,signUpService,dataShareService) {
		var accountDetails = this;
		accountDetails.userSignUpInfo = dataShareService.getUserSignUpInfo();

		accountDetails.createAccount = createAccount;
		accountDetails.passwordRegex = "^.*(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&*(),./?]).*$";
		
		function createAccount(){

			signUpService.createAccount(accountDetails.userSignUpInfo.politicianGuid,accountDetails.userSignUpInfo.userGuid,accountDetails.userName,accountDetails.userPassword,accountDetails.userSignUpInfo.leafLocation,accountDetails.userSignUpInfo.parentLocation,accountDetails.emailAddress,accountDetails.userSignUpInfo.occupation)
								.then(createAccountSuccess).catch(createAccountFailure);

			function createAccountSuccess(data){
				dataShareService.setUserInfo(data);
				$state.transitionTo('home');
			}
			function createAccountFailure(error){
				alert(error);
			}
		}
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').controller("electorDetailsController",
			electorDetailsController);

	electorDetailsController.$inject = [ '$state', 'signUpService',
			'dataShareService' ];

	function electorDetailsController($state, signUpService, dataShareService) {
		var electorDetails = this;
		electorDetails.years = [];
		electorDetails.numberOfYears = 100;
		electorDetails.validateElector = validateElector;
		electorDetails.gender = 'Male';
		
		populateYears();
		function populateYears(){
	    	let currentYear = new Date().getFullYear();
		    
		    for(let start=0;start<electorDetails.numberOfYears;start++){
		    	electorDetails.years.push(currentYear--);
		    }
		}
		
		function validateElector(){
			signUpService.validateElectorDetails(electorDetails.electorId,electorDetails.electorName,electorDetails.referenceName,electorDetails.gender,electorDetails.yob)
									.then(getUserByVoterCardDetailsSuccess).catch(getUserByVoterCardDetailsFailure);
			function getUserByVoterCardDetailsSuccess(data){
				dataShareService.setUserSignUpInfo(data);
				$state.transitionTo('signUp.locationSetup');
			}
			function getUserByVoterCardDetailsFailure(error){
				alert(error);
			}
		}
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').controller("locationDetailsController",
			locationDetailsController);

	locationDetailsController.$inject = [ '$state', 'signUpService',
			'dataShareService' ];

	function locationDetailsController($state, signUpService, dataShareService) {
		var locationDetails = this;
		locationDetails.validationLocationForConflict = validationLocationForConflict;
		locationDetails.userSignUpInfo =dataShareService.getUserSignUpInfo();

		function validationLocationForConflict(){

			if(locationDetails.conflictParentLocations && locationDetails.parentLocation){
				$state.transitionTo('signUp.accountSetup');
			}

			signUpService.validateLocationForConflict(locationDetails.leafLocation).then(validateLocationForConflictSuccess)
												.catch(validateLocationForConflictFailure);


			function validateLocationForConflictSuccess(data){
				if(data.parentLocations && data.parentLocations.length == 1){
					locationDetails.parentLocation = data.parentLocations[0];
					
					let userSignUpInfo=dataShareService.getUserSignUpInfo();
					userSignUpInfo.parentLocation=locationDetails.parentLocation;
					userSignUpInfo.leafLocation=locationDetails.leafLocation;
					userSignUpInfo.occupation=locationDetails.selectedOccupation;
	    			dataShareService.setUserSignUpInfo(userSignUpInfo);
					
					if(locationDetails.selectedOccupation.occupation!="Politician"){
						$state.transitionTo('signUp.accountSetup');
					}else{
						$state.transitionTo('signUp.politicianSelection');
					}
				}  
				locationDetails.conflictParentLocations = data.parentLocations;
			}
			function validateLocationForConflictFailure(error){
				alert(error);
			}
		}
	}
})();
(function() {
	'use strict';

	angular.module('myindia-app').controller("politicianSelectionController",
			politicianSelectionController);

	politicianSelectionController.$inject = [ '$state',
			'signUpService', 'dataShareService' ];

	function politicianSelectionController($state, signUpService,
			dataShareService) {
		
		var politicianSelection = this;
		politicianSelection.userGuid=dataShareService.getUserSignUpInfo().userGuid;
		politicianSelection.politicians=[];
		politicianSelection.selectPolitician=selectPolitician;
		politicianSelection.getLocationSearchResults=getLocationSearchResults;
		politicianSelection.selectElectedLocation=selectElectedLocation;
		politicianSelection.validatePoliticianSelection=validatePoliticianSelection;
		
		politicianSelection.selectedPolitician={politicianGuid:6497,fullName:"ODITE.RAMANAIK",photoURL:null,currentDesignation:"Sarpanch"};
		getMatchingPoliticians(politicianSelection.userGuid);
		getAllParties();
		
		function selectPolitician(selectedPoliticianData){
			politicianSelection.selectedPolitician=selectedPoliticianData;
		}
		
		function getLocationSearchResults(){
			if(politicianSelection.electedLocationSearchTerm.length>=3){
				signUpService.getLocationSearchResults(politicianSelection.electedLocationSearchTerm).then(searchLocationsSuccess).catch(searchLocationsFailure);
	    		function searchLocationsSuccess(data){
	    			politicianSelection.searchLocations=data;
	    		}
	    		function searchLocationsFailure(error){
	    			alert(error);
	    		}
			}
    	}
		function selectElectedLocation(searchLocation){
			politicianSelection.selectedElectedLocation=searchLocation;
			politicianSelection.electedLocationSearchTerm=searchLocation.locationName+" ("+searchLocation.locationType+")";
			politicianSelection.searchLocations=undefined;
		}
		
		function getAllParties(){
			signUpService.getAllParties().then(getAllPartiesSuccess).catch(getAllPartiesFailure);
    		function getAllPartiesSuccess(data){
    			politicianSelection.parties=data;
    		}
    		function getAllPartiesFailure(error){
    			alert(error);
    		}
		}
		
		function getMatchingPoliticians(userGuid){
			signUpService.getMatchingPoliticiansByName(userGuid).then(getMatchingPoliticiansSuccess).catch(getMatchingPoliticiansFailure);
    		function getMatchingPoliticiansSuccess(data){
    			politicianSelection.politicians=data;
    		}
    		function getMatchingPoliticiansFailure(error){
    			alert(error);
    		}
		}
		
		function validatePoliticianSelection(){
			signUpService.validatePoliticianSelection(politicianSelection.selectedPolitician.politicianGuid,politicianSelection.selectedElectedLocation.locationGuid,politicianSelection.politicianParty.guid).then(validatePoliticianSelectionSuccess).catch(validatePoliticianSelectionFailure);
    		function validatePoliticianSelectionSuccess(data){
    			let userSignUpInfo=dataShareService.getUserSignUpInfo();
    			userSignUpInfo.politicianGuid=politicianSelection.selectedPolitician.politicianGuid;
    			dataShareService.setUserSignUpInfo(locationInfo);
    			$state.transitionTo('signUp.accountSetup');
    		}
    		function validatePoliticianSelectionFailure(error){
    			alert(error);
    		}
		}
		
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').controller("signUpController",
			signUpController);

	signUpController.$inject = [ '$state'];

	function signUpController($state) {

		var signUp = this;
		signUp.gotoSignIn = gotoSignIn;

		function gotoSignIn() {
			$state.go('signIn');
		}
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').factory("signUpService", signUpService);

	signUpService.$inject = [ '$q', 'swaggerShareService','refreshAccessTokenService' ];

	function signUpService($q, swaggerShareService,refreshAccessTokenService) {

		var services = {};

		var signUpService = {
			validateElectorDetails : validateElectorDetails,
			validateLocationForConflict : validateLocationForConflict,
			createAccount : createAccount,
			getLocationSearchResults : getLocationSearchResults,
			getAllParties : getAllParties,
			getMatchingPoliticiansByName : getMatchingPoliticiansByName,
			validatePoliticianSelection : validatePoliticianSelection
		};

		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return signUpService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function validateElectorDetails(electorId, electorName, referenceName,
				gender, yob) {

			let
			requestBody = {
				idCardNo : electorId,
				electorName : electorName,
				referenceName : referenceName,
				gender : gender,
				yearOfBirth : yob
			};

			let
			deferred = $q.defer();

			services.signUp.validateElectorDetails({
				body : JSON.stringify(requestBody)
			}, validateElectorDetailsSuccess, validateElectorDetailsFailure);

			return deferred.promise;

			function validateElectorDetailsSuccess(data) {
				deferred.resolve(data.obj);
			}

			function validateElectorDetailsFailure(error) {
				deferred.reject(error);
			}

		}

		function validateLocationForConflict(locationObj) {

			let
			deferred = $q.defer();

			services.signUp.validateLocationForConflict({
				body : JSON.stringify(locationObj)
			}, validationLocationForConflictSuccess,
					validationLocationForConflictFailure);

			return deferred.promise;

			function validationLocationForConflictSuccess(data) {
				deferred.resolve(data.obj);
			}

			function validationLocationForConflictFailure(error) {
				deferred.reject(error);
			}

		}

		function getLocationSearchResults(searchTerm) {

			let
			deferred = $q.defer();

			services.signUp.getSearchResultsByLocationName({
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

		function getAllParties() {

			let
			deferred = $q.defer();
			if (swaggerPromise) {
				swaggerPromise.then(function() {
					services.party.getAllParties({}, getAllPartiesSuccess,
							getAllPartiesFailure);
					swaggerPromise = undefined;
				})
			} else {
				services.signUp.getAllParties({}, getAllPartiesSuccess,
						getAllPartiesFailure);
			}

			return deferred.promise;

			function getAllPartiesSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getAllPartiesFailure(error) {
				deferred.reject(error);
			}
		}

		function getMatchingPoliticiansByName(userGuid) {

			let
			deferred = $q.defer();
			if (swaggerPromise) {
				swaggerPromise.then(function() {
					services.user.getPoliticiansByName({
						userGuid : userGuid
					}, getMatchingPoliticiansSuccess,
							getMatchingPoliticiansFailure);
					swaggerPromise = undefined;
				})
			} else {
				services.signUp
						.getPoliticiansByName({
							userGuid : userGuid
						}, getMatchingPoliticiansSuccess,
								getMatchingPoliticiansFailure);
			}

			return deferred.promise;

			function getMatchingPoliticiansSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getMatchingPoliticiansFailure(error) {
				deferred.reject(error);
			}
		}

		function validatePoliticianSelection(politicianGuid, locationGuid,
				partyGuid) {

			let
			deferred = $q.defer();

			let
			requestBody = {
				politicianGuid : politicianGuid,
				locationGuid : locationGuid,
				partyGuid : partyGuid
			}

			services.signUp.validatePoliticianSelectionByLocationParty({
				body : JSON.stringify(requestBody)
			}, validatePoliticianSelectionSuccess,
					validatePoliticianSelectionFailure);

			return deferred.promise;

			function validatePoliticianSelectionSuccess(data) {
				deferred.resolve(data.obj);
			}

			function validatePoliticianSelectionFailure(error) {
				deferred.reject(error);
			}

		}

		function createAccount(politicianGuid, userGuid, userName, password,
				childLocation, parentLocation, emailAddress, occupation) {

			let
			requestBody = {
				politicianGuid : politicianGuid,
				loginUserName : userName,
				password : password,
				userGuid : userGuid,
				childLocation : childLocation,
				parentLocation : parentLocation,
				emailAddress : emailAddress,
				occupation : occupation
			};

			let
			deferred = $q.defer();

			services.signUp.createAccount({
				body : JSON.stringify(requestBody)
			}, createAccountSuccess, createAccountFailure);

			return deferred.promise;

			function createAccountSuccess(data) {
				// Process cookie into swagger
				swaggerShareService
						.setAuthorization(data.obj.accessToken,
								data.obj.refreshToken,
								data.obj.expirationTimeInSeconds);

				// Start token expiration timer
				refreshAccessTokenService.startTokenExpiryTimer(sessionStorage
						.getItem("expires_in"));

				deferred.resolve(data.obj);
			}

			function createAccountFailure(error) {
				deferred.reject(error);
			}

		}

	}

})();
(function() {
	'use strict';

	angular.module('myindia-app').controller("userController", userController);
	userController.$inject = [ '$scope', 'userService' ];

	function userController($scope, userService) {
		var user = this;
	}
})();

(function() {
	'use strict';

	angular.module('myindia-app').factory("userService", userService);

	userService.$inject = [ '$q', 'swaggerShareService' ];

	function userService($q, swaggerShareService) {

		var services = {};

		var userService = {

		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return userService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

	}

})();

//# sourceMappingURL=app.js.map