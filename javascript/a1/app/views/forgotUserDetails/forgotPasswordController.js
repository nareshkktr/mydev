(function() {
	'use strict';

	angular.module('myindia-app').controller("forgotPasswordController",
			forgotPasswordController);

	forgotPasswordController.$inject = [ '$state','forgotPasswordService' ];

	function forgotPasswordController($state,forgotPasswordService) {
		var forgotPassword = this;
		forgotPassword.validUser = validUser;
		forgotPassword.passwordRegex = "^.*(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&*(),./?]).*$";
		forgotPassword.baseUserInfo = $state.params.baseUserInfo;
	
		function validUser(){
			forgotPasswordService.validUser(forgotPassword.userName,forgotPassword.referenceName)
			.then(validUserSuccess).catch(validUserFailure);

			function validUserSuccess(data){	
				$state.go('forgotPassword.changePassword',{baseUserInfo:data});
            }
            function validUserFailure(error){
            	 console.log(error);
            }
		}
	}
})();
