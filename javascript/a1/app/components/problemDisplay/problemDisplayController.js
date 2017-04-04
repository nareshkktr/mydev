(function() {
	'use strict';
	angular.module('myindia-app').controller("problemDisplayController",
			problemDisplayController);

	problemDisplayController.$inject = ['$state'];

	function problemDisplayController($state) {
		var problemDisplay = this;
		problemDisplay.viewProblem = viewProblem;

		function viewProblem(problemGuid) {
			$state.go('viewProblem', {
				selectedProblemGuid : problemGuid
			});
		}
	}
})();
