(function() {
	'use strict';

	angular.module('myindia-app').directive("selectedFiles", selectedFiles);

	function selectedFiles() {

		var selectedFiles = {
			restrict : 'A',
			link : link
		};

		return selectedFiles;

		function link(scope, element, attrs) {

			element.bind("change", function (changeEvent) {
                scope.$apply(function () {
                    scope.files = changeEvent.target.files;
                    //call the function that uploads the files..
                    scope.fileUpload.uploadFile();
                });
            });

		}
	}
})();
