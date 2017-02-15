(function() {
     'use strict';
	var myIndiaApp=angular.module('myindia-app', ['ui.router','ui.bootstrap']);
	myIndiaApp.run(function($state, $rootScope){
		   $rootScope.$state = $state;
		})
})();