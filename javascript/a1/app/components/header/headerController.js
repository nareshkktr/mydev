(function() {
	'use strict';
	angular.module('myindia-app').controller("headerController",
			headerController);

	headerController.$inject = [ '$state', 'dataShareService', 'ModalService' ];

	function headerController($state, dataShareService, ModalService) {

		var header = this;
		header.searchTerm = '';
		header.gotoSearch = gotoSearch;
		header.openLocationChangeModal = openLocationChangeModal;
		header.closeLocationChangeModal = closeLocationChangeModal;

		header.userInfo = dataShareService.getUserInfo();

		if(header.userInfo){

			//Preapre user profile image
			if(!header.userInfo.userImage){
				if(header.userInfo.gender == 'Male'){
					header.userInfo.userImage = resource+'Users-User-Male-icon.png';
				}else if(header.userInfo.gender == 'Female'){
					header.userInfo.userImage = resource+'Users-User-Female-icon.png';
				}
			}

			//Prepare location information
			if(header.userInfo.userLocation.locationVillage){
				header.userInfo.location = header.userInfo.userLocation.locationVillage;
			}else if(header.userInfo.userLocation.locationMunicipality){
				header.userInfo.location = header.userInfo.userLocation.locationMunicipality; 
			}else if(header.userInfo.userLocation.locationMunicipalCorporation){
				header.userInfo.location = header.userInfo.userLocation.locationMunicipalCorporation; 
			}else if(header.userInfo.userLocation.locationTownPanchayat){
				header.userInfo.location = header.userInfo.userLocation.locationTownPanchayat; 
			} 

			if(header.userInfo.userLocation.locationState)
				header.userInfo.location += "," + header.userInfo.userLocation.locationDistrict;

		}
		
		function gotoSearch() {
			$state.go('search', {
				searchTerm : header.searchTerm
			});
		}

		function openLocationChangeModal(id) {
			ModalService.Open(id);
		}

		function closeLocationChangeModal(id) {
			ModalService.Close(id);
		}
	}
})();
