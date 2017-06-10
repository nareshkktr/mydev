(function() {
	'use strict';

	angular.module('myindia-app').controller("addAlbumController",
			addAlbumController);
	addAlbumController.$inject = [ '$scope', '$uibModalInstance','albumService','objectType',
			'objectGuid','selectedAlbum'];

	function addAlbumController($scope, $uibModalInstance,albumService, objectType,
			objectGuid,selectedAlbum) {
		var addAlbum = this;
		
		addAlbum.addedAlbumPhotoFiles=new Array();
		addAlbum.addedAlbumPhotos= [];
		addAlbum.getChoosenFiles=getChoosenFiles;
		addAlbum.myInterval = 2000;
		addAlbum.noWrapSlides = false;
		addAlbum.active = 0;
		addAlbum.closePopUp = closePopUp;
		addAlbum.objectType = objectType;
		addAlbum.objectGuid = objectGuid;
		addAlbum.getMoreChoosenFiles=getMoreChoosenFiles;
		addAlbum.uploadAlbumPhoto=uploadAlbumPhoto;
		addAlbum.albumPhotoFileAdded=false;
		addAlbum.uploadAlbum=uploadAlbum;
		addAlbum.uploadPhotosToAlbum=uploadPhotosToAlbum;
		addAlbum.selectedAlbum=selectedAlbum;
		if(addAlbum.selectedAlbum){
			addAlbum.albumGuid=addAlbum.selectedAlbum.guid;
			addAlbum.albumName=addAlbum.selectedAlbum.name;
			addAlbum.albumDescription=addAlbum.selectedAlbum.description;
			addAlbum.albumImage = addAlbum.selectedAlbum.imageUrl;
			addAlbum.albumImageName=addAlbum.selectedAlbum.imageUrl.split("/").pop();
			addAlbum.albumPhotoFileAdded=true;
		}
		function getChoosenFiles(files){
			addAlbum.addedAlbumPhotos=files;
			for(let eachFileIndex=0;eachFileIndex<files.length;eachFileIndex++){
				addAlbum.addedAlbumPhotoFiles.push(files[eachFileIndex]);
			}
		}
		function getMoreChoosenFiles(moreFiles){
			for(let eachFileIndex=0;eachFileIndex<moreFiles.length;eachFileIndex++){
				addAlbum.addedAlbumPhotoFiles.push(moreFiles[eachFileIndex]);
			}
		}
		function closePopUp() {
			$uibModalInstance.dismiss('cancel');
		}
		
		function uploadAlbumPhoto(files){
			addAlbum.albumPhotoFile = files[0];
			addAlbum.albumPhotoFileAdded=true;
		}
		
		function uploadAlbum(){
			albumService.createUpdateAlbum(addAlbum.albumGuid,addAlbum.albumName,addAlbum.albumDescription,addAlbum.albumPhotoFile,addAlbum.objectType,addAlbum.objectGuid).then(uploadAlbumSuccess).catch(uploadAlbumFailure);
			function uploadAlbumSuccess(data){
				addAlbum.albumGuid=data.saveUpdateDeleteRecordId;
				uploadPhotosToAlbum(addAlbum.albumGuid);
			}
			function uploadAlbumFailure(error){
				alert(error);
			}
		}
		
		function uploadPhotosToAlbum(){
			let albumPhotos=addAlbum.addedAlbumPhotoFiles;
			if(albumPhotos!=null && albumPhotos.length>0){
				albumService.uploadPhotosToAlbum(addAlbum.albumGuid,albumPhotos,addAlbum.objectType,addAlbum.objectGuid).then(uploadPhotosToAlbumSuccess).catch(uploadPhotosToAlbumFailure);
				function uploadPhotosToAlbumSuccess(data){
					closePopUp();
				}
				function uploadPhotosToAlbumFailure(error){
					alert(error);
				}
			}
		}
	}
})();
