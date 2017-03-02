(function() {
	'use strict';

	angular.module('myindia-app').directive("fileUpload", fileUpload);

	function fileUpload() {

		var fileUpload = {
			restrict : 'E',
			scope: {
				isMultiple: '@',
				callback: '&'
			},
			templateUrl : resource + 'partials/fileUpload.html',
			controller : 'fileUploadController',
			controllerAs : 'fileUpload'
		};

		return fileUpload;

	}
})();
