(function() {
	'use strict';

	angular.module('myindia-app').factory("pocService", pocService);

	pocService.$inject = [ '$q', 'swaggerShareService' ];

	function pocService($q, swaggerShareService) {

		var services = {};

		var pocService = {
			uploadFiles : uploadFiles
		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return pocService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function uploadFiles(uploadedFile) {
			let
			deferred = $q.defer();
			 var formData = new FormData();
			 formData.append('file', uploadedFile);
			 
			services.fileUpload.addFiles({
				body : formData
			}, uploadFilesSuccess, uploadFilesFailure);

			return deferred.promise;

			function uploadFilesSuccess(data) {
				deferred.resolve(data.obj);
			}

			function uploadFilesFailure(error) {
				deferred.reject(error);
			}
		}

	}

})();