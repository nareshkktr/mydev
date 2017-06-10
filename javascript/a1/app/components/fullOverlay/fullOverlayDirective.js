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
