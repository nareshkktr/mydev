(function() {
	'use strict';
	angular.module('myindia-app').controller("floaingIconController",
			floaingIconController);

	floaingIconController.$inject = ['$state'];

	function floaingIconController($state) {
		var floatingIcon = this;
		floatingIcon.showOverlay = false;
		floatingIcon.toggleOverlay = toggleOverlay;
		floatingIcon.gotoCreateProblem=gotoCreateProblem;
		
		function toggleOverlay() {
			floatingIcon.showOverlay = !floatingIcon.showOverlay;
		}

		function gotoCreateProblem() {
			toggleOverlay();
			$state.go('createProblem.problemTypeSelection');
		}
	}
})();
