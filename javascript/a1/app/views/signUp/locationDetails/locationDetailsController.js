(function() {
	'use strict';

	angular.module('myindia-app').controller("locationDetailsController",
			locationDetailsController);

	locationDetailsController.$inject = [ '$state', 'signUpService',
			'dataShareService' ];

	function locationDetailsController($state, signUpService, dataShareService) {
		var locationDetails = this;
		locationDetails.validationLocationForConflict = validationLocationForConflict;
		locationDetails.userSignUpInfo =dataShareService.getUserSignUpInfo();

		function validationLocationForConflict(){

			if(locationDetails.conflictParentLocations && locationDetails.parentLocation){
				$state.transitionTo('signUp.accountSetup');
			}

			signUpService.validateLocationForConflict(locationDetails.leafLocation).then(validateLocationForConflictSuccess)
												.catch(validateLocationForConflictFailure);


			function validateLocationForConflictSuccess(data){
				if(data.parentLocations && data.parentLocations.length == 1){
					locationDetails.parentLocation = data.parentLocations[0];
					
					let userSignUpInfo=dataShareService.getUserSignUpInfo();
					userSignUpInfo.parentLocation=locationDetails.parentLocation;
					userSignUpInfo.leafLocation=locationDetails.leafLocation;
					userSignUpInfo.occupation=locationDetails.selectedOccupation;
	    			dataShareService.setUserSignUpInfo(userSignUpInfo);
					
					if(locationDetails.selectedOccupation.occupation!="Politician"){
						$state.transitionTo('signUp.accountSetup');
					}else{
						$state.transitionTo('signUp.politicianSelection');
					}
				}  
				locationDetails.conflictParentLocations = data.parentLocations;
			}
			function validateLocationForConflictFailure(error){
				alert(error);
			}
		}
	}
})();