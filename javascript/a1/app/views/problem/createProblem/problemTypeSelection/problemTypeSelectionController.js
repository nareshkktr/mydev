(function() {
	'use strict';

	angular.module('myindia-app').controller("problemTypeSelectionController",
			problemTypeSelectionController);
	problemTypeSelectionController.$inject = ['$state'];

	function problemTypeSelectionController($state) {

		var problemTypeSelection = this;
		problemTypeSelection.problemTypes = [];
		problemTypeSelection.chooseExistingProblem = chooseExistingProblem;

		for (var i = 0; i < 20; i++) {
			var imageName = "";

			if (i % 2 == 0) {
				imageName = "power_problem.jpg";
			} else if (i % 3 == 0) {
				imageName = "agriculture_problem.jpg";
			} else if (i % 5 == 0) {
				imageName = "water_problem.jpg";
			} else {
				imageName = "road_problem.jpg";
			}
			var problemType = {
				"problemTypeName" : "Problem Type " + i,
				"problemTypeImage" : resource + "problem/" + imageName,
				"guid": 417
			};
			problemTypeSelection.problemTypes.push(problemType);
		}

		function chooseExistingProblem(problemTypeGuid) {
			$state.go('createProblem.problemSelection',{selectedProblemType:problemTypeGuid});
		}

	}

})();
