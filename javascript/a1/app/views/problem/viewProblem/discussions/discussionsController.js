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
		discussions.userProfileImageClass = "discussion_user_profile_image";
		discussions.userProfileLabelClass = "discussion_user_profile_label";

		function getProblemCommentsSuccess(data){
			discussions.comments = data;
		}
		function getProblemCommentsFailure(error){
			alert(error);
		}
	}

})();
