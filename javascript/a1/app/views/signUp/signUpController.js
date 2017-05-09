(function() {
	'use strict';

	angular.module('myindia-app').controller("signUpController",
			signUpController);

	signUpController.$inject = [ '$state','validateElectorService','identifyConflictParentLocationsService','createAccountService','dataShareService' ];

	function signUpController($state,validateElectorService,identifyConflictParentLocationsService,createAccountService,dataShareService) {
		
		var signUp = this;
		signUp.validateElector = validateElector;
		signUp.validationLocationForConflict = validationLocationForConflict;
		signUp.createAccount = createAccount;
		signUp.elector = {};
		signUp.years = [];
		signUp.numberOfYears = 100;
		signUp.gender = 'Male';
		signUp.passwordRegex = "^.*(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&*(),./?]).*$";
		signUp.gotoSignIn = gotoSignIn;
		signUp.occupations=["Engineering","Computer Professional","Farming","Fishing and Forestry","Education","Training and Library","Arts", "Media and Sports","Financial Services","Business","Military","Legal","Politician","Others"];
		
		populateYears();
		
		function gotoSignIn(){
    		$state.go('signIn');
    	}

		function validateElector(){

			// Make an API call to valdiate user
			validateElectorService.validate(signUp.electorId,signUp.electorName,signUp.referenceName,signUp.gender,signUp.yob)
									.then(validationSuccess).catch(validationFailure);

			function validationSuccess(data){
				signUp.elector.location = data;
				$state.transitionTo('signUp.locationSetup');
			}

			function validationFailure(error){
				alert(error);
			}
			
		}

		function validationLocationForConflict(){

			if(signUp.elector.conflictParentLocations && signUp.parentLocation){
				$state.transitionTo('signUp.accountSetup');
			}

			// Indetify if there are conflicting parents
			identifyConflictParentLocationsService.setup(signUp.leafLocation).then(identifyConflictParentLocationsSuccess)
												.catch(identifyConflictParentLocationsFailure);


			function identifyConflictParentLocationsSuccess(data){
				if(data.parentLocations && data.parentLocations.length == 1){
					signUp.parentLocation = data.parentLocations[0];
					$state.transitionTo('signUp.accountSetup');
				}  
				// If not there are multiple location populate them.
				signUp.elector.conflictParentLocations = data.parentLocations;
			}

			function identifyConflictParentLocationsFailure(error){
				alert(error);
			}
		}

		function createAccount(){

			createAccountService.create(signUp.elector.location.userGuid,signUp.userName,signUp.userPassword,signUp.leafLocation,signUp.parentLocation,signUp.emailAddress,signUp.occupation)
								.then(createAccountSuccess).catch(createAccountFailure);

			function createAccountSuccess(data){
				dataShareService.setUserInfo(data);
				$state.transitionTo('home');
			}

			function createAccountFailure(error){
				alert(error);
			}
		}

		function populateYears(){
	    	let currentYear = new Date().getFullYear();
		    // populate default ste of years.
		    for(let start=0;start<signUp.numberOfYears;start++){
		       signUp.years.push(currentYear--);
		    }
		}
	}
})();
