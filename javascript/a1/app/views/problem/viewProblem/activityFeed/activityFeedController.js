(function() {
	'use strict';

	angular.module('myindia-app').controller("activityFeedController",
			activityFeedController);
	activityFeedController.$inject = ['$scope','activityService'];

	function activityFeedController($scope,activityService) {
		var activityFeed = this;
		activityFeed.activities = [];
		activityFeed.pageOffset=1;
		activityFeed.pageLimit=10;
		activityFeed.userProfileImageClass = "activity_user_profile_image";
		activityFeed.userProfileLabelClass = "activity_user_profile_label";
		activityFeed.problemDetails=$scope.$parent.viewProblem.problemDetails;
		activityFeed.objectGuid=activityFeed.problemDetails.guid;
		activityFeed.objectType="ACTIVITY";
		
		getActivitiesByObjectGuid();
		
		function getActivitiesByObjectGuid(){
			activityService.getActivitiesByObjectGuid(activityFeed.objectGuid,activityFeed.pageOffset,activityFeed.pageLimit).then(getActivitiesByObjectGuidSuccess).catch(getActivitiesByObjectGuidFailure);

			function getActivitiesByObjectGuidSuccess(data){
				activityFeed.activities = data;
			}

			function getActivitiesByObjectGuidFailure(error){
				alert(error);
			}
		}
	}
})();
