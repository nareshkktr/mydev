(function() {
	'use strict';

	angular.module('myindia-app').controller("createProblemController",
			createProblemController);
	createProblemController.$inject = [ 'createProblemService','fileUploadService' ];
	
	function createProblemController(createProblemService,fileUploadService) {
		
		var createProblem=this;
		createProblem.problemTypesResults = [];
		createProblem.grivienceTyp="";
		createProblem.grivienceDescription="";
		createProblem.uploadCover = uploadCover;
		
		getAllProblemTypes();
		
		function getAllProblemTypes(){
			
			createProblemService.getAllProblemTypes().then(getAllProblemTypesSuccess).catch(getAllProblemTypesFailure);
			
			function getAllProblemTypesSuccess(data){
				createProblem.problemTypesResults = data;
				console.log(createProblem.problemTypesResults);
			}
			function getAllProblemTypesFailure(error){
				alert(error);
			}
		}

		function uploadCover(files){
			createProblem.coverPhotoFile = files[0];
			
			// Move it to  a place where u are going to create problem.
			fileUploadService.uploadFile(files,12,"Problem").then(uploadSuccess).catch(uploadFailure);

			function uploadSuccess(data){
				console.log(data);
			}

			function uploadFailure(error){
				alert(error);
			}
		}
	}

})();
