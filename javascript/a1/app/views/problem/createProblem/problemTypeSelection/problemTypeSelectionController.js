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

		function chooseExistingProblem(problemCategory) {

			let problemTypes = problemTypeSelection.problemTypes.filter(function( obj ) {
			  return obj.problemCategory == problemCategory;
			});

			$state.go('createProblem.problemSelection',{selectedProblemCategory:problemCategory,problemTypes:problemTypes});
		}

		function getAllProblemTypes(){
			
			createProblemService.getAllProblemTypes().then(getAllProblemTypesSuccess).catch(getAllProblemTypesFailure);
			
			function getAllProblemTypesSuccess(data){
				
				problemTypeSelection.problemTypes = data;
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
