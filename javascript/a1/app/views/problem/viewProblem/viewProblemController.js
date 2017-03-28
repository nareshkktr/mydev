(function() {
	'use strict';

	angular.module('myindia-app').controller("viewProblemController",
			viewProblemController);
	viewProblemController.$inject = ['$state','viewProblemService'];

	function viewProblemController($state,viewProblemService) {

		var viewProblem = this;
		viewProblem.problemDetails = {};
		viewProblem.selectedProblemGuid = $state.params.selectedProblemGuid;
		
		viewProblemService.getProblemDetails(viewProblem.selectedProblemGuid).then(getProblemDetailsSuccess).catch(getProblemDetailsFailure);

		function getProblemDetailsSuccess(data){
			viewProblem.problemDetails = data;
		}

		function getProblemDetailsFailure(error){
			alert(error);
		}
		
	
	}

})();
