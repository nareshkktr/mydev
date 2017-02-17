(function() {
    'use strict';

    angular.module('myindia-app').controller("signInController", signInController);

    signInController.$inject = ['signInService','$state'];

    function signInController(signInService,$state) {

    	var signIn = this;
 		signIn.login = login;

    	function login(){
    		signInService.login(signIn.userName,signIn.password).then(loginSuccess).catch(loginFailure);

    		function loginSuccess(){
    			alert("Login Success");
    			$state.go('home');
    		}

    		function loginFailure(){
    			alert("Login Failed...");
    		}
    	}
    }

})();