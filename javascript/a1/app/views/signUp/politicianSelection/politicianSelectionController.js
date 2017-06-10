(function() {
	'use strict';

	angular.module('myindia-app').controller("politicianSelectionController",
			politicianSelectionController);

	politicianSelectionController.$inject = [ '$state',
			'signUpService', 'dataShareService' ];

	function politicianSelectionController($state, signUpService,
			dataShareService) {
		
		var politicianSelection = this;
		politicianSelection.userGuid=dataShareService.getUserSignUpInfo().userGuid;
		politicianSelection.politicians=[];
		politicianSelection.selectPolitician=selectPolitician;
		politicianSelection.getLocationSearchResults=getLocationSearchResults;
		politicianSelection.selectElectedLocation=selectElectedLocation;
		politicianSelection.validatePoliticianSelection=validatePoliticianSelection;
		
		politicianSelection.selectedPolitician={politicianGuid:6497,fullName:"ODITE.RAMANAIK",photoURL:null,currentDesignation:"Sarpanch"};
		getMatchingPoliticians(politicianSelection.userGuid);
		getAllParties();
		
		function selectPolitician(selectedPoliticianData){
			politicianSelection.selectedPolitician=selectedPoliticianData;
		}
		
		function getLocationSearchResults(){
			if(politicianSelection.electedLocationSearchTerm.length>=3){
				signUpService.getLocationSearchResults(politicianSelection.electedLocationSearchTerm).then(searchLocationsSuccess).catch(searchLocationsFailure);
	    		function searchLocationsSuccess(data){
	    			politicianSelection.searchLocations=data;
	    		}
	    		function searchLocationsFailure(error){
	    			alert(error);
	    		}
			}
    	}
		function selectElectedLocation(searchLocation){
			politicianSelection.selectedElectedLocation=searchLocation;
			politicianSelection.electedLocationSearchTerm=searchLocation.locationName+" ("+searchLocation.locationType+")";
			politicianSelection.searchLocations=undefined;
		}
		
		function getAllParties(){
			signUpService.getAllParties().then(getAllPartiesSuccess).catch(getAllPartiesFailure);
    		function getAllPartiesSuccess(data){
    			politicianSelection.parties=data;
    		}
    		function getAllPartiesFailure(error){
    			alert(error);
    		}
		}
		
		function getMatchingPoliticians(userGuid){
			signUpService.getMatchingPoliticiansByName(userGuid).then(getMatchingPoliticiansSuccess).catch(getMatchingPoliticiansFailure);
    		function getMatchingPoliticiansSuccess(data){
    			politicianSelection.politicians=data;
    		}
    		function getMatchingPoliticiansFailure(error){
    			alert(error);
    		}
		}
		
		function validatePoliticianSelection(){
			signUpService.validatePoliticianSelection(politicianSelection.selectedPolitician.politicianGuid,politicianSelection.selectedElectedLocation.locationGuid,politicianSelection.politicianParty.guid).then(validatePoliticianSelectionSuccess).catch(validatePoliticianSelectionFailure);
    		function validatePoliticianSelectionSuccess(data){
    			let userSignUpInfo=dataShareService.getUserSignUpInfo();
    			userSignUpInfo.politicianGuid=politicianSelection.selectedPolitician.politicianGuid;
    			dataShareService.setUserSignUpInfo(locationInfo);
    			$state.transitionTo('signUp.accountSetup');
    		}
    		function validatePoliticianSelectionFailure(error){
    			alert(error);
    		}
		}
		
	}
})();
