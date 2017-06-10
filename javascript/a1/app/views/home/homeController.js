(function() {
	'use strict';

	angular.module('myindia-app').controller("homeController", homeController);
	homeController.$inject = [ '$scope','activityService','$state' ];

	function homeController($scope,activityService,$state) {
		var home = this;
		home.getAllActivties=getAllActivties;
		home.gotoObject=gotoObject;
		home.pageOffset=1;
		home.pageLimit=6;
		home.xFunction = xFunction;
		home.yFunction = yFunction;
		home.color = [ "#ED1C24", "#EB7422", "#FFDF16", "#0AA24B" ];
		home.problemChartData = [ {
			key : "Critical",
			y : 500
		}, {
			key : "High",
			y : 200
		}, {
			key : "Medium",
			y : 900
		}, {
			key : "Low",
			y : 700
		} ];

		function xFunction() {
			return function(d) {
				return d.key;
			};
		}
		function yFunction() {
			return function(d) {
				return d.y;
			};
		}
		
		getAllActivties();
		
		function getAllActivties(){
			activityService.getAllActivities(home.pageOffset,home.pageLimit).then(getAllActivitiesSuccess).catch(getAllActivitiesFailure);

			function getAllActivitiesSuccess(data){
				home.activities = data;
			}

			function getAllActivitiesFailure(error){
				alert(error);
			}
		}
		
		function gotoObject(activityContent){
			if(activityContent){
				if(activityContent.onObjectType && activityContent.onObjectType!=null){
					if(activityContent.onObjectType=='PROBLEM' || activityContent.onObjectType=='Problem'){
						$state.go('viewProblem', {
							selectedProblemGuid : activityContent.onObjectGuid
						});
					}
				}
			}
		}
	}

})();
