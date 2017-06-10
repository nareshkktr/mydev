(function() {
	'use strict';

	angular.module('myindia-app').controller("photosController",
			photosController);
	photosController.$inject = [ '$scope','albumService'];

	function photosController($scope,albumService) {
		var photos = this;
		photos.openOverlayForCreateProblem = openOverlayForCreateProblem;
		photos.problemDetails=$scope.$parent.viewProblem.problemDetails;
		photos.objectGuid=photos.problemDetails.guid;
		photos.objectType="PROBLEM";
		photos.getProblemAlbums=getProblemAlbums;
		photos.getProblemPhotos=getProblemPhotos
		photos.albumPageOffset=1;
		photos.albumPageLimit=10;
		photos.photoPageOffset=1;
		photos.photoPageLimit=10;
		photos.albumPhotoPageOffset=1;
		photos.albumPhotoPageLimit=10;
		photos.showPhotos=true;
		photos.showAddPhotosPopup=showAddPhotosPopup;
		photos.showAddAlbumPopup=showAddAlbumPopup;
		photos.animationsEnabled = true;
		photos.addPhotosPopUpUrl = resource
				+ "partials/addPhotos.html";
		photos.showAddPhotosModal = false;
		photos.closeAddPhotosModal = closeAddPhotosModal;
		photos.photosModalControllerName = "addPhotosController";
		photos.photosModalControllerAlias = "addPhotos";
		photos.photosModalSize="";
		photos.closeAddAlbumModal = closeAddAlbumModal;
		photos.addAlbumPopUpUrl = resource
		+ "partials/addAlbum.html";
		photos.albumsModalControllerName = "addAlbumController";
		photos.albumsModalControllerAlias = "addAlbum";
		photos.albumsModalSize="lg";
		photos.getAlbumPhotos=getAlbumPhotos;
		photos.closeAlbumPhotosView=closeAlbumPhotosView;
		
		getProblemPhotos();
		
		function openOverlayForCreateProblem() {
			photos.showOverlay = true;
		}
		function getProblemPhotos(){
			albumService.getProblemPhotos(photos.objectGuid,photos.objectType,photos.photoPageOffset,photos.photoPageLimit).then(getProblemPhotosSuccess).catch(getProblemPhotosFailure);
			function getProblemPhotosSuccess(data){
				photos.problemPhotos = data;
			}
			function getProblemPhotosFailure(error){
				alert(error);
			}
		}
		
		function getProblemAlbums(){
			photos.showPhotos=false;
			photos.showAlbums=true;
			albumService.getAlbums(photos.objectGuid,photos.objectType,photos.albumPageOffset,photos.albumPageLimit).then(getAlbumsSuccess).catch(getAlbumsFailure);

			function getAlbumsSuccess(data){
				photos.problemAlbums = data;
				photos.selctedProblemAlbum=photos.problemAlbums[0];
			}
			function getAlbumsFailure(error){
				alert(error);
			}
		}
		
		function showAddPhotosPopup(){
			photos.showAddPhotosModal = true;
		}
		function closeAddPhotosModal(){
			photos.showAddPhotosModal = false;
			getProblemPhotos();
		}
		function showAddAlbumPopup(){
			if(photos.showAlbums){
				photos.selctedProblemAlbum=false;
			}
			photos.showAddAlbumModal = true;
		}
		function closeAddAlbumModal(){
			photos.showAddAlbumModal = false;
			if(photos.showAlbums){
				getProblemAlbums();
			}else{
				getAlbumPhotos(photos.selctedProblemAlbum)
			}
		}
		function getAlbumPhotos(selectedAlbum){
			photos.showAlbums=false;
			photos.showAlbumPhotos=true;
			photos.selctedProblemAlbum=selectedAlbum;
			albumService.getAlbumPhotos(photos.selctedProblemAlbum.guid,photos.objectGuid,photos.objectType,photos.albumPhotoPageOffset,photos.albumPhotoPageLimit).then(getAlbumPhotosSuccess).catch(getAlbumPhotosFailure);

			function getAlbumPhotosSuccess(data){
				photos.problemAlbumPhotos = data;
			}
			function getAlbumPhotosFailure(error){
				alert(error);
			}
		}
		function closeAlbumPhotosView(){
			photos.showPhotos=false;
			photos.showAlbums=true;
			photos.showAlbumPhotos=false;
		}
	}
})();
