(function() {
	'use strict';

	angular.module('myindia-app').controller("addPhotosController",
			addPhotosController);
	addPhotosController.$inject = [ '$scope', 'addPhotosService',
			'$uibModalInstance','objectType','objectGuid' ];

	function addPhotosController($scope, addPhotosService, $uibModalInstance,objectType,objectGuid) {
		var addPhotos = this;
		addPhotos.closePopUp = closePopUp;
		addPhotos.uploadPhotos = uploadPhotos;
		addPhotos.addedPhotos= [];
		addPhotos.getChoosenFiles=getChoosenFiles;
		addPhotos.myInterval = 2000;
		addPhotos.noWrapSlides = false;
		addPhotos.active = 0;
		addPhotos.addedPhotoFiles=new Array();
		addPhotos.objectType = objectType;
		addPhotos.objectGuid = objectGuid;
		
		addPhotos.getMoreChoosenFiles=getMoreChoosenFiles;
		
		function getChoosenFiles(files){
			addPhotos.addedPhotos=files;
			for(let eachFileIndex=0;eachFileIndex<files.length;eachFileIndex++){
				addPhotos.addedPhotoFiles.push(files[eachFileIndex]);
			}
		}
		function getMoreChoosenFiles(moreFiles){
			for(let eachFileIndex=0;eachFileIndex<moreFiles.length;eachFileIndex++){
				addPhotos.addedPhotoFiles.push(moreFiles[eachFileIndex]);
			}
		}
		function closePopUp() {
			$uibModalInstance.dismiss('cancel');
		}
		function uploadPhotos() {
			
			if(addPhotos.addedPhotoFiles!=null && addPhotos.addedPhotoFiles.length>0){
				addPhotosService.uploadPhotos(addPhotos.addedPhotoFiles,addPhotos.objectType,addPhotos.objectGuid).then(uploadPhotosSuccess).catch(uploadPhotosFailure);
				
				function uploadPhotosSuccess(data){
					closePopUp();
				}
				function uploadPhotosFailure(error){
					alert(error);
				}
			}
		}
		
	}
})();
