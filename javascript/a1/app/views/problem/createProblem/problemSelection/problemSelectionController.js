(function() {
	'use strict';

	angular.module('myindia-app').controller("problemSelectionController",
			problemSelectionController);
	problemSelectionController.$inject = ['$state','problemSelectionService'];

	function problemSelectionController($state,problemSelectionService) {

		var problemSelection = this;
		problemSelection.problems = [];
		problemSelection.chosenProblemCategory = $state.params.selectedProblemCategory;
		problemSelection.problemTypes = $state.params.problemTypes;
		problemSelection.logNewProblem=logNewProblem;

		problemSelectionService.getProblemsByCategory(problemSelection.chosenProblemCategory).then(getProblemsByTypeSuccess).catch(getProblemsByTypeFailure);

		function getProblemsByTypeSuccess(data){
			problemSelection.problems = data;
		}

		function getProblemsByTypeFailure(error){
			alert(error);
		}
		
		function logNewProblem() {
			$state.go('createProblem.logProblem',{selectedProblemCategory:problemSelection.chosenProblemCategory,problemTypes:problemSelection.problemTypes});
		}
	}

})();
