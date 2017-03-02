(function() {
	'use strict';

	angular.module('myindia-app').directive("setFileAttributes", setFileAttributes);

	function setFileAttributes() {

		var setFileAttributes = {
			restrict : 'A',
			link : link
		};

		return setFileAttributes;

		function link(scope, element, attrs) {

			//Set selection Type.
			if(scope.type == 'Multiple')
				element[0].multiple  = true;

			//Select accepts
			if(scope.acceptType == 'Image'){
				element[0].accept = 'image/*';
			}

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
