(function() {
	'use strict';

	angular.module('myindia-app').factory("fileUploadService",
			fileUploadService);

	fileUploadService.$inject = [ '$q', 'swaggerShareService' ];

	function fileUploadService($q, swaggerShareService) {

		var services = {};

		var fileUploadService = {
			uploadFile : uploadFile
		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return fileUploadService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function uploadFile(files, objectType,objectGuid, isMainPhotoURL,
				category) {

			let
			deferred = $q.defer();

			let
			promises = [];

			angular.forEach(files, function(file, key) {
				promises.push(preapreUploadFileRequest(file, objectType,
						objectGuid, isMainPhotoURL,
						category));
			});

			$q.all(promises).then(function(filesData) {

				services.image.addImages({
					body : JSON.stringify(filesData)
				}, uploadSuccess, uploadFailure);

				function uploadSuccess(data) {
					deferred.resolve(data);
				}

				function uploadFailure(error) {
					deferred.reject(error);
				}
			})

			return deferred.promise;

		}

		function preapreUploadFileRequest(file, objectType, objectGuid, isMainPhotoURL,
				category) {

			let
			deferred = $q.defer();

			var name = file.name;
			var reader = new FileReader();
			reader.onload = function() {

				var req = {};
				req.imageName = name;
				req.imageData = reader.result;
				req.objectType = objectType;
				req.objectId = objectGuid;
				req.isMainPhotoURL = isMainPhotoURL;
				req.category = category;

				deferred.resolve(req);
			}
			reader.readAsDataURL(file);

			return deferred.promise;
		}
	}

})();