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