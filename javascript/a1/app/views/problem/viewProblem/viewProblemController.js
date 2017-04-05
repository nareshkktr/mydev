(function() {
	'use strict';

	angular.module('myindia-app').controller("viewProblemController",
			viewProblemController);
	viewProblemController.$inject = ['$state','viewProblemService','filterEntityByCriteria'];

	function viewProblemController($state,viewProblemService,filterEntityByCriteria) {

		var viewProblem = this;
		viewProblem.problemDetails = {};
		viewProblem.objectType="PROBLEM";
		viewProblem.selectedProblemGuid = $state.params.selectedProblemGuid;

		viewProblem.similarProblems = {};
		viewProblem.similarProblems.pageNo = 1;
		viewProblem.similarProblems.pageLimit =4;
		viewProblem.similarProblems.problems = [];

		viewProblemService.getProblemDetails(viewProblem.selectedProblemGuid).then(getProblemDetailsSuccess).catch(getProblemDetailsFailure);

		function getProblemDetailsSuccess(data){
			viewProblem.problemDetails = data;

			// Call to fetch similar problems based on filter criteria
			fetchRelatedProblemsData(viewProblem.similarProblems.pageNo,viewProblem.similarProblems.pageLimit)

		}

		function fetchRelatedProblemsData(pageNo,pageLimit){

			let filterEntityRequest = {
					objectName: viewProblem.problemDetails.problemShortDescription,
					supportingFields: [viewProblem.problemDetails.problemType.problemCategory],
					objectType: "Problem",
					pageNo: pageNo,
					pageLimit: pageLimit
			};

			if(viewProblem.problemDetails.problemType!=undefined){
				filterEntityRequest.supportingFields.push(viewProblem.problemDetails.problemType.problemTypeName);
			}

			if(viewProblem.problemDetails.createdLocation!=undefined){
				filterEntityRequest.locationName = viewProblem.problemDetails.createdLocation.locationName;
			}

			filterEntityByCriteria.filterEntities(filterEntityRequest).then(filterEntitiesSuccess).catch(filterEntitiesFailure);

			function filterEntitiesSuccess(data){
				viewProblem.similarProblems.problems = data;
			}

			function filterEntitiesFailure(error){
				alert(error);
			}

		}

		function getProblemDetailsFailure(error){
			alert(error);
		}
		
	
	}

})();
