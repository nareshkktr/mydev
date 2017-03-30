(function() {
	'use strict';

	angular.module('myindia-app').controller("viewProblemController",
			viewProblemController);
	viewProblemController.$inject = ['$state','viewProblemService','filterEntityByCriteria'];

	function viewProblemController($state,viewProblemService,filterEntityByCriteria) {

		var viewProblem = this;
		viewProblem.problemDetails = {};
		viewProblem.selectedProblemGuid = $state.params.selectedProblemGuid;

		viewProblem.similarProblems = {};
		viewProblem.similarProblems.pageNo = 1;
		viewProblem.similarProblems.pageLimit =4;
		viewProblem.similarProblems.problems = [];

		for (var i = 0; i < 20; i++) {
			var severity = "";

			if (i % 2 == 0) {
				severity = "critical";
			} else if (i % 3 == 0) {
				severity = "high";
			} else if (i % 5 == 0) {
				severity = "medium";
			} else {
				severity = "low";
			}
			var problem = {
				"problemShortDescription" : "Water Problem Type Water Problem Type Water Problem Type "
						+ i,
				"locatedIn" : "Pulipadu,Prakasam(District)",
				"severity" : severity,
				"severityLevelCode" : severity === "critical" ? "C"
						: severity === "high" ? "H"
								: severity === "medium" ? "M" : "L"
			};
			viewProblem.similarProblems.problems.push(problem);
		}
		
		viewProblemService.getProblemDetails(viewProblem.selectedProblemGuid).then(getProblemDetailsSuccess).catch(getProblemDetailsFailure);

		

		function getProblemDetailsSuccess(data){
			viewProblem.problemDetails = data;

			//Call to fetch similar problems based on filter criteria
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
