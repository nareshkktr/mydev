(function() {
	'use strict';
	angular.module('myindia-app').controller("headerController",
			headerController);
	
	headerController.$inject = [ '$state'];

	function headerController($state) {

		var header = this;
		header.searchTerm = '';
		header.gotoSearch = gotoSearch;

		function gotoSearch() {
			$state.go('search', {
				searchTerm : header.searchTerm
			});
		};
	}
})();
