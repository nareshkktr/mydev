(function() {
	'use strict';

	angular.module('myindia-app').controller("userController", userController);
	userController.$inject = [ '$scope', 'userService' ];

	function userController($scope, userService) {
		var user = this;
	}
})();
