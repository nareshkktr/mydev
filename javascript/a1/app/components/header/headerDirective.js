(function() {
	'use strict';

	angular.module('myindia-app').directive("myindiaHeader", myIndiaHeader);

	function myIndiaHeader() {

		function link(scope, element, attrs) {

		}
		;

		return {
			restrict : 'E',
			link : link,
			templateUrl : resource + 'partials/header.html',
			controller : 'headerController',
			controllerAs : 'header'
		}
	}

})();
