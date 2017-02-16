(function() {
	'use strict';

	angular.module('myindia-app').controller("globalSearchController",
			globalSearchController);

	globalSearchController.$inject = [ '$state', 'globalSearchService' ];

	function globalSearchController($state,globalSearchService) {
		
		var globalSearch=this;
		globalSearch.searchTerm=$state.params.searchTerm;
		globalSearch.searchResults = [];
		
		//Call the search service
		globalSearchService.search(globalSearch.searchTerm).then(searchSuccess).catch(searchError);

		function searchSuccess(data){
			globalSearch.searchResults = data;

			globalSearch.searchResults.PEOPLE = [];
			
			if(globalSearch.searchResults.USER){
				globalSearch.searchResults.PEOPLE = globalSearch.searchResults.PEOPLE.concat(globalSearch.searchResults.USER);
			}
			if (globalSearch.searchResults.PARTY) {
				globalSearch.searchResults.PEOPLE = globalSearch.searchResults.PEOPLE.concat(globalSearch.searchResults.PARTY);
			}
			if (globalSearch.searchResults.POLITICIAN) {
				globalSearch.searchResults.PEOPLE = globalSearch.searchResults.PEOPLE.concat(globalSearch.searchResults.POLITICIAN);
			};

		}

		function searchError(error){
			alert(error);
		}
		
	}
})();
