(function() {
	'use strict';

	angular.module('myindia-app').controller("homeController", homeController);
	homeController.$inject = [ '$scope' ];

	function homeController($scope) {
		var home = this;
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
	}

})();
