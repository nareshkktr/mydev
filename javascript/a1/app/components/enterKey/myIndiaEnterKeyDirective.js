(function() {
	'use strict';

	angular.module('myindia-app').directive("myIndiaEnterKey", myIndiaEnterKey);

	function myIndiaEnterKey() {

		function link(scope, element, attrs) {
			element.bind("keydown keypress", function(event) {
				var keyCode = event.which || event.keyCode;

				// If enter key is pressed
				if (keyCode === 13) {
					scope.$apply(function() {
						// Evaluate the expression
						scope.$eval(attrs.myIndiaEnterKey);
					});

					event.preventDefault();
				}
			});
		}
		return {
			restrict : 'A',
			link : link
		}
	}
})();