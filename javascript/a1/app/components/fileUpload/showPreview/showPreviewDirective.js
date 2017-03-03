(function() {
	'use strict';

	angular.module('myindia-app').directive("showPreview", showPreview);

	function showPreview() {

		var showPreview = {
			restrict : 'A',
			scope:{
				file:'='
			},
			link : link
		};

		return showPreview;

		function link(scope, element, attrs) {

			scope.$watch('file',function(){
				if(scope.file){
					var reader = new FileReader();
				    reader.onload = function(){
				      element[0].src = reader.result;
				    };
	    			reader.readAsDataURL(scope.file);
				}
			});
		}
	}
})();
