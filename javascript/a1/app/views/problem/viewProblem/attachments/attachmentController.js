(function() {
	'use strict';

	angular.module('myindia-app').controller("attachmentController",
			attachmentController);
	attachmentController.$inject = ['$scope','attachmentService'];

	function attachmentController($scope,attachmentService) {
		var attachment = this;
	}
})();
