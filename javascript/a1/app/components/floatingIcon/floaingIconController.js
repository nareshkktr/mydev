(function() {
	'use strict';
	angular.module('myindia-app').controller("floaingIconController",
			floaingIconController);

	floaingIconController.$inject = [];
	
	function floaingIconController() {
		var floatingIcon = this;
		floatingIcon.showOverlay = false;
		floatingIcon.toggleOverlay = toggleOverlay;

		function toggleOverlay() {
			floatingIcon.showOverlay = !floatingIcon.showOverlay;
		}
	}
})();
