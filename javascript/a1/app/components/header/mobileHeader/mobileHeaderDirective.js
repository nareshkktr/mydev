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
