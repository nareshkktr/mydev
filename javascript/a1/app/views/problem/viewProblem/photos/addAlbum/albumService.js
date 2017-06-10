(function() {
	'use strict';

	angular.module('myindia-app').factory("albumService", albumService);

	albumService.$inject = [ '$q', 'swaggerShareService' ];

	function albumService($q, swaggerShareService) {

		var services = {};

		var albumService = {
			createUpdateAlbum : createUpdateAlbum,
			uploadPhotosToAlbum : uploadPhotosToAlbum,
			getAlbums:getAlbums,
			getProblemPhotos:getProblemPhotos,
			getAlbumPhotos:getAlbumPhotos
		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return albumService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function uploadPhotosToAlbum(albumGuid, files, objectType, objectGuid) {

			let
			deferred = $q.defer();

			let
			promises = [];

			angular.forEach(files, function(file, key) {
				promises.push(preapreUploadFileRequest(file, objectType,
						objectGuid, albumGuid, null));
			});

			$q.all(promises).then(function(filesData) {

				services.image.addPhotosToAlbum({
					body : JSON.stringify(filesData)
				}, uploadPhotosToAlbumSuccess, uploadPhotosToAlbumFailure);

				function uploadPhotosToAlbumSuccess(data) {
					deferred.resolve(data);
				}

				function uploadPhotosToAlbumFailure(error) {
					deferred.reject(error);
				}
			})

			return deferred.promise;
		}

		function createUpdateAlbum(albumGuid,albumName,albumDescription, albumPhotoFile,
				objectType, objectGuid) {

			let
			deferred = $q.defer();

			let
			albumFilePromise = preapreUploadAlbumFileRequest(albumPhotoFile,
					objectType, objectGuid, albumGuid,albumName,albumDescription);

			albumFilePromise.then(function(filesData) {

				services.image.createUpdateAlbum({
					body : JSON.stringify(filesData)
				}, createUpdateAlbumSuccess, createUpdateAlbumFailure);

				function createUpdateAlbumSuccess(data) {
					deferred.resolve(data.obj);
				}

				function createUpdateAlbumFailure(error) {
					deferred.reject(error);
				}
			})

			return deferred.promise;

		}
		function preapreUploadAlbumFileRequest(file, objectType, objectGuid,
				albumGuid, albumName,albumDescription) {

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
				req.albumDescription = albumDescription;
				req.albumGuid = albumGuid;
				req.albumName = albumName,

				deferred.resolve(req);
			}
			reader.readAsDataURL(file);

			return deferred.promise;
		}
		
		function preapreUploadFileRequest(file, objectType, objectGuid,
				albumGuid, albumName) {

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
				req.albumGuid = albumGuid;
				req.albumName = albumName,

				deferred.resolve(req);
			}
			reader.readAsDataURL(file);

			return deferred.promise;
		}
		function getProblemPhotos(objectGuid,objectType,pageNo, pageLimit) {

			let
			deferred = $q.defer();
			
			let requestData={
					objectType:objectType,
					objectGuid:objectGuid,
					pageOffset:pageNo,
					pageLimit:pageLimit
			};
			services.image.getPhotosByObject({
				body : JSON.stringify(requestData)
			}, getProblemPhotosSuccess, getProblemPhotosFailure);

			return deferred.promise;

			function getProblemPhotosSuccess(data) {
				deferred.resolve(data.obj);
			}
			function getProblemPhotosFailure(error) {
				deferred.reject(error);
			}
		}
		function getAlbums(objectGuid,objectType,pageNo, pageLimit) {

			let
			deferred = $q.defer();
			
			let requestData={
					objectType:objectType,
					objectGuid:objectGuid,
					pageOffset:pageNo,
					pageLimit:pageLimit
			};
			services.image.getAlbumsByObject({
				body : JSON.stringify(requestData)
			}, getAlbumsSuccess, getAlbumsFailure);

			return deferred.promise;

			function getAlbumsSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getAlbumsFailure(error) {
				deferred.reject(error);
			}

		}
		
		function getAlbumPhotos(albumGuid,objectGuid,objectType,pageNo, pageLimit) {

			let
			deferred = $q.defer();
			
			let requestData={
					objectType:objectType,
					objectGuid:objectGuid,
					pageOffset:pageNo,
					pageLimit:pageLimit,
					subObjectGuid:albumGuid
			};
			services.image.getAlbumPhotosByObject({
				body : JSON.stringify(requestData)
			}, getAlbumPhotosSuccess, getAlbumPhotosFailure);

			return deferred.promise;

			function getAlbumPhotosSuccess(data) {
				deferred.resolve(data.obj);
			}
			function getAlbumPhotosFailure(error) {
				deferred.reject(error);
			}

		}
	}

})();