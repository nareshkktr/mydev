(function() {
	'use strict';

	angular.module('myindia-app').controller("contributorController",
			contributorController);
	contributorController.$inject = ['$scope','contributorService'];

	function contributorController($scope,contributorService) {
		var contributor = this;
	}
})();
