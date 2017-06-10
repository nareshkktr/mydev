(function() {
	'use strict';

	angular.module('myindia-app').factory("addPhotosService", addPhotosService);

	addPhotosService.$inject = [ '$q', 'swaggerShareService' ];

	function addPhotosService($q, swaggerShareService) {

		var services = {};

		var addPhotosService = {
			uploadPhotos : uploadPhotos
		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return addPhotosService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function uploadPhotos(files, objectType, objectGuid) {

			let
			deferred = $q.defer();

			let
			promises = [];

			angular.forEach(files, function(file, key) {
				promises.push(preapreUploadFileRequest(file, objectType,
						objectGuid));
			});

			$q.all(promises).then(function(filesData) {

				services.image.addPhotos({
					body : JSON.stringify(filesData)
				}, uploadPhotosSuccess, uploadPhotosFailure);

				function uploadPhotosSuccess(data) {
					deferred.resolve(data);
				}

				function uploadPhotosFailure(error) {
					deferred.reject(error);
				}
			})

			return deferred.promise;
		}

		function preapreUploadFileRequest(file, objectType, objectGuid) {

			let
			deferred = $q.defer();

			var name = file.name;
			var reader = new FileReader();
			reader.onload = function() {

				var req = {};
				req.imageName = name;
				req.imageData = reader.result;
				req.objectType = objectType;
				req.objectGuId = objectGuid;

				deferred.resolve(req);
			}
			reader.readAsDataURL(file);

			return deferred.promise;
		}
	}

})();