(function() {
	
	'use strict';

	angular.module('myindia-app').controller("fileUploadController",
			fileUploadController);

	fileUploadController.$inject = ['$scope'];

	function fileUploadController($scope) {
		var fileUpload = this;
		
		fileUpload.uploadFile = uploadFile;

		function uploadFile(){
			//return the selected files to parent.
			$scope.callback()($scope.files);
		}

	}


})();
