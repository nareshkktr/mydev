(function() {
     'use strict';
	
	angular.module('myindia-app').run(routeTrack);

	routeTrack.$inject = ['$rootScope','$state'];

	function routeTrack($rootScope,$state){
		$rootScope.$state = $state;
	}


})();