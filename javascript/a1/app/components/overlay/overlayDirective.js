(function() {
	'use strict';

	angular.module('myindia-app').directive("overlay", overlay);

	function overlay() {

		var overlay = {
			restrict : 'E',
			link : link,
			templateUrl : resource + 'partials/overlay.html',
			controller : 'overlayController',
			controllerAs : 'overlay'
		};

		return overlay;

		function link(scope, element, attrs) {
		}
	}
})();
