(function() {
     'use strict';
	var myIndiaApp=angular.module('myindia-app', ['ui.router','ui.bootstrap','ngAnimate','ngMessages','ngCookies','angularTrix']);
	myIndiaApp.run(function($state, $rootScope){
		   $rootScope.$state = $state;
		})
})();
