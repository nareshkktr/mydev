(function() {
	'use strict';
	angular.module('myindia-app').controller("headerController",
			headerController);

	headerController.$inject = [ '$state','logoutService'];

	function headerController($state,logoutService) {

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
		header.logout = logout;

		header.userProfileImageClass = "user_profile_image";
		header.userProfileLabelClass = "user_profile_label";

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

		function logout(){

			logoutService.logout().then(logoutSuccess).catch(logoutFailure);

			function logoutSuccess(data){
				$state.go('signIn');
			}

			function logoutFailure(error){
				alert(error);
			}
		}

	}
})();
