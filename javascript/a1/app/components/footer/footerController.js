(function() {
	'use strict';

	angular.module('myindia-app').controller("footerController",
			footerController);

	footerController.$inject = [ '$state' ];

	function footerController($state) {

		var footer = this;
		footer.searchTerm = '';
		footer.gotoSearch = gotoSearch;
		footer.showSearchBox = true;
		footer.showFooterSearchBox = showFooterSearchBox;

		function gotoSearch() {
			$state.go('search', {
				searchTerm : footer.searchTerm
			});
		}

		function showFooterSearchBox() {
			footer.showSearchBox = !footer.showSearchBox;
		}
	}

})();