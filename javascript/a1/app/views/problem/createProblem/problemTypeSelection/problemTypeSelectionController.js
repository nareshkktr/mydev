(function() {
	'use strict';

	angular.module('myindia-app').controller("problemTypeSelectionController",
			problemTypeSelectionController);
	problemTypeSelectionController.$inject = ['$state','createProblemService'];

	function problemTypeSelectionController($state,createProblemService) {

		var problemTypeSelection = this;
		problemTypeSelection.problemTypes = [];
		problemTypeSelection.problemTypeCategories = [];
		problemTypeSelection.chooseExistingProblem = chooseExistingProblem;

		getAllProblemTypes();

		// for (var i = 0; i < 20; i++) {
		// 	var imageName = "";

		// 	if (i % 2 == 0) {
		// 		imageName = "power_problem.jpg";
		// 	} else if (i % 3 == 0) {
		// 		imageName = "agriculture_problem.jpg";
		// 	} else if (i % 5 == 0) {
		// 		imageName = "water_problem.jpg";
		// 	} else {
		// 		imageName = "road_problem.jpg";
		// 	}
		// 	var problemType = {
		// 		"problemTypeName" : "Problem Type " + i,
		// 		"problemTypeImage" : resource + "problem/" + imageName,
		// 		"guid": 417
		// 	};
		// 	problemTypeSelection.problemTypes.push(problemType);
		// }

		function chooseExistingProblem(problemCategory) {

			let problemTypes = problemTypeSelection.problemTypes.filter(function( obj ) {
			  return obj.problemCategory == problemCategory;
			});

			$state.go('createProblem.problemSelection',{selectedProblemCategory:problemCategory,problemTypes:problemTypes});
		}

		function getAllProblemTypes(){
			
			createProblemService.getAllProblemTypes().then(getAllProblemTypesSuccess).catch(getAllProblemTypesFailure);
			
			function getAllProblemTypesSuccess(data){
				// let tempResults = data.map(function(a) {return a.problemCategory;});
				problemTypeSelection.problemTypes = data;
				// problemTypeSelection.problemTypeCategories = tempResults.filter((v, i, a) => a.indexOf(v) === i); 

				// array.map(item => item.problemCategory)
  				// 				.filter((value, index, self) => self.indexOf(value) === index)
  				let categories = [];
  				angular.forEach(data,function(problemType){
  					if(categories.indexOf(problemType.problemCategory) == -1){
  						categories.push(problemType.problemCategory);
  						problemTypeSelection.problemTypeCategories.push(problemType);
  					}
  				})

				console.log(problemTypeSelection.problemTypes);
			}
			function getAllProblemTypesFailure(error){
				alert(error);
			}
		}

	}

})();
