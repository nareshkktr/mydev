(function() {
	'use strict';
	angular.module('myindia-app').controller("headerController",
			headerController);

	headerController.$inject = [ '$state','ModalService'];

	function headerController($state,ModalService) {

		var header = this;
		header.searchTerm = '';
		header.gotoSearch = gotoSearch;
		header.openLocationChangeModal = openLocationChangeModal;
		header.closeLocationChangeModal = closeLocationChangeModal;

		function gotoSearch() {
			$state.go('search', {
				searchTerm : header.searchTerm
			});
		}
	
		function openLocationChangeModal(id) {
			ModalService.Open(id);
		}

		function closeLocationChangeModal(id) {
			ModalService.Close(id);
		}
	}
})();
