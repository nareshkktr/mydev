(function() {
	'use strict';
	angular.module('myindia-app').controller("locationChangePopUpController",
			locationChangePopUpController);

	locationChangePopUpController.$inject = [ '$state',
			'locationChangePopUpService','dataShareService','$uibModalInstance' ];

	function locationChangePopUpController($state, locationChangePopUpService,dataShareService,$uibModalInstance) {
		
		var locationChangePopUp = this;
		locationChangePopUp.popularLocations =[];
		locationChangePopUp.locationSelected=false;
		locationChangePopUp.resultsType="Popular Locations";
		locationChangePopUp.searchTerm="";
		locationChangePopUp.getSearchResults=getSearchResults;
		locationChangePopUp.selectedLocation=null;
		locationChangePopUp.selectLocation = selectLocation;
		locationChangePopUp.pinLocation = pinLocation;
		locationChangePopUp.closePopUp = closePopUp;
		
		getPopularLocations();
		
		function getPopularLocations(){
			locationChangePopUpService.getPopularLocations().then(popularLocationsSuccess).catch(popularLocationsFailure);

    		function popularLocationsSuccess(data){
    			locationChangePopUp.popularLocations=data;
    		}
    		function popularLocationsFailure(error){
    			alert(error);
    		}
    	}
		
		function getSearchResults(){
			if(locationChangePopUp.searchTerm.length>=3){
				locationChangePopUp.resultsType="Search Results For :"+locationChangePopUp.searchTerm;
				locationChangePopUpService.getSearchResults(locationChangePopUp.searchTerm).then(searchLocationsSuccess).catch(searchLocationsFailure);
	
	    		function searchLocationsSuccess(data){
	    			locationChangePopUp.popularLocations=data;
	    		}
	    		function searchLocationsFailure(error){
	    			alert(error);
	    		}
			}
    	}
		
		function selectLocation(searchLocation){
			locationChangePopUp.selectedLocation=searchLocation;
			locationChangePopUp.locationSelected=true;
		}
		
		function closePopUp(){
			 $uibModalInstance.dismiss('cancel');
		}
		
		function pinLocation(){
			let userInfo=dataShareService.getUserInfo();
    		userInfo.userLocation.locationName=locationChangePopUp.selectedLocation.locationName;
    		userInfo.userLocation.locationGuid=locationChangePopUp.selectedLocation.locationGuid;
    		dataShareService.setUserInfo(userInfo);
    		locationChangePopUp.closePopUp();
    	}
	}
	
})();