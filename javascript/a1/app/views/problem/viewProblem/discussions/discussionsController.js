(function() {
	'use strict';

	angular.module('myindia-app').controller("discussionsController",
			discussionsController);
	discussionsController.$inject = ['$scope', 'discussionsService' ];

	function discussionsController($scope,discussionsService) {
		var discussions = this;
		discussions.comments = [];
		discussions.problemDetails=$scope.$parent.viewProblem.problemDetails;
		discussions.objectType="PROBLEM";
		discussionsService.getProblemComments(discussions.problemDetails.guid,1,20).then(getProblemCommentsSuccess).catch(getProblemCommentsFailure);

		function getProblemCommentsSuccess(data){
			discussions.comments = data;
		}
		function getProblemCommentsFailure(error){
			alert(error);
		}
	}

})();
