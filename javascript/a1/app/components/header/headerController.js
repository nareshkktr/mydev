(function() {
	'use strict';
	angular.module('myindia-app').controller("headerController",
			headerController);

	headerController.$inject = [ '$state'];

	function headerController($state) {

		var header = this;
		header.searchTerm = '';
		header.gotoSearch = gotoSearch;
		header.openLocationChangeModal = openLocationChangeModal;
		header.animationsEnabled = true;
		header.locationChangePopUpUrl = resource
				+ "partials/locationChangePopUp.html";
		header.showLocationChangeModal = false;
		header.closeLocationChangeModal = closeLocationChangeModal;

		header.modalControllerName = "locationChangePopUpController";
		header.modalControllerAlias = "locationChangePopUp";

		function gotoSearch() {
			$state.go('search', {
				searchTerm : header.searchTerm
			});
		}

		function openLocationChangeModal() {
			header.showLocationChangeModal = true;
		}
		function closeLocationChangeModal() {
			header.showLocationChangeModal = false;
		}

	}
})();
