(function() {
	'use strict';

	angular.module('myindia-app').controller("electorDetailsController",
			electorDetailsController);

	electorDetailsController.$inject = [ '$state', 'signUpService',
			'dataShareService' ];

	function electorDetailsController($state, signUpService, dataShareService) {
		var electorDetails = this;
		electorDetails.years = [];
		electorDetails.numberOfYears = 100;
		electorDetails.validateElector = validateElector;
		electorDetails.gender = 'Male';
		
		populateYears();
		function populateYears(){
	    	let currentYear = new Date().getFullYear();
		    
		    for(let start=0;start<electorDetails.numberOfYears;start++){
		    	electorDetails.years.push(currentYear--);
		    }
		}
		
		function validateElector(){
			signUpService.validateElectorDetails(electorDetails.electorId,electorDetails.electorName,electorDetails.referenceName,electorDetails.gender,electorDetails.yob)
									.then(getUserByVoterCardDetailsSuccess).catch(getUserByVoterCardDetailsFailure);
			function getUserByVoterCardDetailsSuccess(data){
				dataShareService.setUserSignUpInfo(data);
				$state.transitionTo('signUp.locationSetup');
			}
			function getUserByVoterCardDetailsFailure(error){
				alert(error);
			}
		}
	}
})();
