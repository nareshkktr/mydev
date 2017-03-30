(function() {
	'use strict';

	angular.module('myindia-app').directive("problemDisplay", problemDisplay);

	function problemDisplay() {

		var problemDisplay = {
			restrict : 'E',
			scope: {
				problems: '=',
				columnSplitClass: '='
			},
			templateUrl : resource + 'partials/problemDisplay.html'
		};

		return problemDisplay;

	}

})();
