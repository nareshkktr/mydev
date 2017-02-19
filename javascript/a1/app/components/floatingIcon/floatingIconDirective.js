(function() {
	'use strict';

	angular.module('myindia-app').directive("floatingIcon", floatingIcon);

	function floatingIcon() {

		var floatingIcon = {
			restrict : 'E',
			link : link,
			templateUrl : resource + 'partials/floatingIcon.html',
			controller : 'floaingIconController',
			controllerAs : 'floatingIcon'
		};

		return floatingIcon;

		function link(scope, element, attrs) {
		}
	}
})();
