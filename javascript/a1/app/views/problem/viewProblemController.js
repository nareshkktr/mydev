(function() {
	'use strict';

	angular.module('myindia-app').controller("viewProblemController",
			viewProblemController);
	viewProblemController.$inject = [];

	function viewProblemController() {

		var viewProblem = this;
		viewProblem.problemBasicDetails = {};

		viewProblem.problemBasicDetails.problemMainPhotoURL = resource+"problem/water_problem.jpg";
	}

})();
