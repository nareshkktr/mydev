(function() {
	'use strict';

	angular.module('myindia-app').controller("pocController", pocController);
	pocController.$inject = [ '$scope','pocService'];
	
	angular.module('myindia-app').directive('fileModel', [ '$parse', function($parse) {
		return {
			restrict : 'A',
			link : function(scope, element, attrs) {
				var model = $parse(attrs.fileModel);
				var modelSetter = model.assign;

				element.bind('change', function() {
					scope.$apply(function() {
						modelSetter(scope, element[0].files[0]);
					});
				});
			}
		};
	} ]);

	function pocController($scope,pocService) {
		var poc = this;
		poc.uploadFile=uploadFile;
		function uploadFile(){
            pocService.uploadFiles(poc.myFile).then(uploadFilesSuccess).catch(uploadFilesFailure);

			function uploadFilesSuccess(data){
			}
			function uploadFilesFailure(error){
				alert(error);
			}
		}
        
	}

})();
