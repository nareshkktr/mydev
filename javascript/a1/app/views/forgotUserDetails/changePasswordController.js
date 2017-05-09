/**
 * 
 */
(function() {
	'use strict';

	angular.module('myindia-app').controller("changePasswordController",
			changePasswordController);

	changePasswordController.$inject = [ '$state','forgotPasswordService' ];

	function changePasswordController($state,forgotPasswordService) {
		var changePassword = this;
		changePassword.passwordRegex = "^.*(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&*(),./?]).*$";
		changePassword.baseUserInfo = $state.params.baseUserInfo;
		changePassword.resetPassword=resetPassword;
		
		function resetPassword(){
			forgotPasswordService.resetPassword(changePassword.baseUserInfo.accountGuid,changePassword.confirmPassword)
			.then(resetPasswordSuccess).catch(resetPasswordFailure);

			function resetPasswordSuccess(data){	
				$state.go('signIn');
            }
            function resetPasswordFailure(error){
            	 console.log(error);
            }
		}
	
	}
})();
