(function() {
	'use strict';
	angular.module('myindia-app').controller("headerController",
			headerController);
	
	headerController.$inject = [ '$state','dataShareService','$scope'];

	function headerController($state,dataShareService,$scope) {

		var header = this;
		header.searchTerm = '';
		header.gotoSearch = gotoSearch;

		
		header.userInfo = dataShareService.getUserInfo();

		if(header.userInfo){
			if(!header.userInfo.userImage){
				if(header.userInfo.gender == 'Male'){
					header.userInfo.userImage = resource+'/Users-User-Male-icon.png';
				}else if(header.userInfo.gender == 'Female'){
					header.userInfo.userImage = resource+'/Users-User-Female-icon.png';
				}
			}
		}
		
		

		function gotoSearch() {
			$state.go('search', {
				searchTerm : header.searchTerm
			});
		};
	}
})();
