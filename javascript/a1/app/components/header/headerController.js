(function() {
	'use strict';
	angular.module('myindia-app').controller("headerController",
			headerController);

	headerController.$inject = [ '$state', 'dataShareService' ];

	function headerController($state, dataShareService) {

		var header = this;
		header.searchTerm = '';
		header.gotoSearch = gotoSearch;
		header.openLocationChangeModal = openLocationChangeModal;
		header.animationsEnabled = true;
		header.locationChangePopUpUrl = resource
				+ "partials/locationChangePopUp.html";
		header.showLocationChangeModal = false;
		header.closeLocationChangeModal = closeLocationChangeModal;
		header.userInfo = dataShareService.getUserInfo();

		header.modalControllerName = "locationChangePopUpController";
		header.modalControllerAlias = "locationChangePopUp";

		if (header.userInfo) {

			// Preapre user profile image
			if (!header.userInfo.userImage) {
				if (header.userInfo.gender == 'Male') {
					header.userInfo.userImage = resource
							+ 'Users-User-Male-icon.png';
				} else if (header.userInfo.gender == 'Female') {
					header.userInfo.userImage = resource
							+ 'Users-User-Female-icon.png';
				}
			}

		}

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
