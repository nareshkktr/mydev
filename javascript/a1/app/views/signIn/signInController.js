(function() {
    'use strict';

    angular.module('myindia-app').controller("signInController", signInController);

    signInController.$inject = ['signInService','$state','dataShareService'];

    function signInController(signInService,$state,dataShareService) {

    	var signIn = this;
 		signIn.login = login;
 		signIn.gotoSignUp = gotoSignUp;

    	function login(){
    		signInService.login(signIn.userName,signIn.password).then(loginSuccess).catch(loginFailure);

    		function loginSuccess(data){
    			alert("Login Success");
                dataShareService.setUserInfo(data);
    			$state.go('createProblem');
    		}

    		function loginFailure(error){
    			alert(error);
    		}
    	}
    	
    	function gotoSignUp(){
    		$state.go('signUp.validate');
    	}
    	
    	
    }

})();