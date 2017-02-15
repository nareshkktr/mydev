(function() {
	'use strict';
	angular.module('myindia-app').controller("headerController",
			headerController);
	headerController.$inject = [ '$state', '$scope' ];
	function headerController($state, $scope) {
		var header = this;
		header.searchTerm = '';
		header.gotoSearch = function() {
			$state.go('search', {
				searchTerm : header.searchTerm
			});
		};
	}
})();
