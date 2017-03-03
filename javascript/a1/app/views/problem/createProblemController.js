(function() {
	'use strict';

	angular.module('myindia-app').controller("createProblemController",
			createProblemController);
	createProblemController.$inject = [ 'createProblemService' ];
	
	function createProblemController(createProblemService) {
		
		var createProblem=this;
		createProblem.problemTypesResults = [];
		createProblem.grivienceTyp="";
		createProblem.grivienceDescription="";
		
		getAllProblemTypes();
		
		function getAllProblemTypes(){
			
			createProblemService.getAllProblemTypes().then(getAllProblemTypesSuccess).catch(getAllProblemTypesFailure);
			
			function getAllProblemTypesSuccess(data){
				createProblem.problemTypesResults = data;
				console.log(createProblem.problemTypesResults);
			}
			function getAllProblemTypesFailure(error){
				alert(error);
			}
		}
	}

})();
