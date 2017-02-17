(function() {
	'use strict';

	angular.module('myindia-app').controller("signUpController",
			signUpController);

	signUpController.$inject = [ '$state','validateElectorService' ];

	function signUpController($state,validateElectorService) {
		
		var signUp = this;
		signUp.validateElector = validateElector;
		signUp.elector = {};
		signUp.years = [];
		signUp.numberOfYears = 100;
		signUp.gender = 'Male';
		signUp.passwordRegex = "^.*(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&*(),./?]).*$";

		populateYears();

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

		function populateYears(){
	    	let currentYear = new Date().getFullYear();
		    //populate default ste of years.
		    for(let start=0;start<signUp.numberOfYears;start++){
		       signUp.years.push(currentYear--);
		    }
		}
	}
})();
