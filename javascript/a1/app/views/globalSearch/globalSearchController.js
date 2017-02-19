(function() {
	'use strict';

	angular.module('myindia-app').controller("globalSearchController",
			globalSearchController);

	globalSearchController.$inject = [ '$state', 'globalSearchService' ];

	function globalSearchController($state,globalSearchService) {
		
		var globalSearch=this;
		globalSearch.searchTerm=$state.params.searchTerm;
		globalSearch.searchObjectType="";
		globalSearch.searchResults = [];
		globalSearch.objectsCount = {};
		globalSearch.totalCount = 0;
		globalSearch.search=search;
		
		search('ALL');
		
		function search(searchObjectType){
			
			globalSearch.searchObjectType=searchObjectType;
			
			globalSearchService.search(globalSearch.searchTerm,globalSearch.searchObjectType).then(searchSuccess).catch(searchError);
			
			function searchSuccess(data){
				globalSearch.searchResults = data.searchResults;
				globalSearch.totalCount = data.totalCount;
				globalSearch.objectsCount = data.objectsCount;
			}
			function searchError(error){
				alert(error);
			}
		}
	}
})();
