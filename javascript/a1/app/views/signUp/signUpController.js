(function() {
	'use strict';

	angular.module('myindia-app').controller("signUpController",
			signUpController);

	signUpController.$inject = [ '$state'];

	function signUpController($state) {

		var signUp = this;
		signUp.gotoSignIn = gotoSignIn;

		function gotoSignIn() {
			$state.go('signIn');
		}
	}
})();
