(function() {
	'use strict';

	angular.module('myindia-app').controller("accountDetailsController",
			accountDetailsController);

	accountDetailsController.$inject = [ '$state','signUpService','dataShareService'];

	function accountDetailsController($state,signUpService,dataShareService) {
		var accountDetails = this;
		accountDetails.userSignUpInfo = dataShareService.getUserSignUpInfo();

		accountDetails.createAccount = createAccount;
		accountDetails.passwordRegex = "^.*(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&*(),./?]).*$";
		
		function createAccount(){

			signUpService.createAccount(accountDetails.userSignUpInfo.politicianGuid,accountDetails.userSignUpInfo.userGuid,accountDetails.userName,accountDetails.userPassword,accountDetails.userSignUpInfo.leafLocation,accountDetails.userSignUpInfo.parentLocation,accountDetails.emailAddress,accountDetails.userSignUpInfo.occupation)
								.then(createAccountSuccess).catch(createAccountFailure);

			function createAccountSuccess(data){
				dataShareService.setUserInfo(data);
				$state.transitionTo('home');
			}
			function createAccountFailure(error){
				alert(error);
			}
		}
	}
})();
