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
		})
		.state('signUp.validate', {
			url : '/validate',
			templateUrl : resource + 'partials/validateElector.html'
		}).state('signUp.setup', {
			url : '/setup',
			templateUrl : resource + 'partials/accountSetup.html'
		}).state('search', {
			url : '/search',
			params : {
				'searchTerm' : ''
			},
			templateUrl : resource + 'partials/globalSearch.html',
			controller : 'globalSearchController',
			controllerAs : 'search'
		});
	}
})();
