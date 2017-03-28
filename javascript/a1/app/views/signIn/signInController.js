(function() {
    'use strict';

    angular.module('myindia-app').controller("signInController", signInController);

    signInController.$inject = ['signInService','$state','dataShareService'];

    function signInController(signInService,$state,dataShareService) {

    	var signIn = this;
 		signIn.login = login;
 		signIn.gotoSignUp = gotoSignUp;

        //If user has session storage values redirect to home page
        if(sessionStorage.getItem("access_token")){
            $state.go('home');
        }

    	function login(){
    		signInService.login(signIn.userName,signIn.password).then(loginSuccess).catch(loginFailure);

    		function loginSuccess(data){
                dataShareService.setUserInfo(data);
                $state.go('createProblem.problemTypeSelection');
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