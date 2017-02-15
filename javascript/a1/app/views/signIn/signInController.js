(function() {
    'use strict';

    angular.module('myindia-app').controller("signInController", signInController);

    signInController.$inject = ['signInService'];

    function signInController(signInService) {

    	var signIn = this;
 		signIn.login = login;

    	function login(){
    		signInService.login(signIn.userName,signIn.password).then(loginSuccess).catch(loginFailure);

    		function loginSuccess(){
    			alert("Login Success");
    		}

    		function loginFailure(){
    			alert("Login Failed...");
    		}
    	}
    }

})();