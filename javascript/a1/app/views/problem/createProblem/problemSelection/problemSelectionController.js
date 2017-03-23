(function() {
	'use strict';

	angular.module('myindia-app').controller("problemSelectionController",
			problemSelectionController);
	problemSelectionController.$inject = ['$state','problemSelectionService'];

	function problemSelectionController($state,problemSelectionService) {

		var problemSelection = this;
		problemSelection.problems = [];
		problemSelection.logNewProblem = logNewProblem;

		problemSelectionService.getProblemsByType($state.params.selectedProblemType).then(getProblemsByTypeSuccess).catch(getProblemsByTypeFailure);

		function getProblemsByTypeSuccess(data){
			problemSelection.problems = data;
		}

		function getProblemsByTypeFailure(error){
			alert(error);
		}

		// for (var i = 0; i < 20; i++) {
		// 	// var severity = "";

		// 	// if (i % 2 == 0) {
		// 	// 	severity = "critical";
		// 	// } else if (i % 3 == 0) {
		// 	// 	severity = "high";
		// 	// } else if (i % 5 == 0) {
		// 	// 	severity = "medium";
		// 	// } else {
		// 	// 	severity = "low";
		// 	// }
		// 	// var problem = {
		// 	// 	"problemName" : "Water Problem Type Water Problem Type Water Problem Type "
		// 	// 			+ i,
		// 	// 	"locatedIn" : "Pulipadu,Prakasam(District)",
		// 	// 	"severity" : severity,
		// 	// 	"severityLevel" : severity === "critical" ? "C"
		// 	// 			: severity === "high" ? "H"
		// 	// 					: severity === "medium" ? "M" : "L"
		// 	// };
		// 	// problemSelection.problems.push(problem);
		// }
		
		function logNewProblem() {
			$state.go('createProblem.logProblem');
		}
	}

})();
