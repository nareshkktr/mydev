(function() {
	'use strict';

	angular.module('myindia-app').controller("videoController",
			videoController);
	videoController.$inject = ['$scope','videoService'];

	function videoController($scope,videoService) {
		var video = this;
	}
})();
