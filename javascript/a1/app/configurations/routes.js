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
		}).state('viewProblem.discussions', {
			url : '/discussions',
			templateUrl : resource + 'partials/discussions.html',
			controller : 'discussionsController',
			controllerAs : 'discussions',
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
		});
	}
})();
