(function() {
     'use strict';
	var myIndiaApp=angular.module('myindia-app', ['ui.router','ui.bootstrap','ngAnimate']);
	myIndiaApp.run(function($state, $rootScope){
		   $rootScope.$state = $state;
		})
})();
