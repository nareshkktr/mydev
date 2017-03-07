(function() {
	'use strict';

	angular.module('myindia-app').controller("createProblemController",
			createProblemController);
	createProblemController.$inject = [ 'createProblemService','fileUploadService','dataShareService' ];
	
	function createProblemController(createProblemService,fileUploadService,dataShareService) {
		
		var createProblem=this;
		createProblem.problemTypesResults = [];
		createProblem.grivienceName="";
		createProblem.grivienceType="";
		createProblem.grivienceDescription="";
		createProblem.noOfAffectedCitizens="";
		createProblem.moneyAtStake="";
		createProblem.locatedIn=dataShareService.getUserInfo().userLocation;
		createProblem.saveProblem=saveProblem;
		createProblem.locatedInName=dataShareService.getUserInfo().userLocation.locationName;
		createProblem.uploadCover = uploadCover;

		getAllProblemTypes();
		
		function saveProblem(){
			
			createProblemService.saveProblem(createProblem).then(saveProblemSuccess).catch(saveProblemFailure);

    		function saveProblemSuccess(data){
            }
    		function saveProblemFailure(error){
    			alert(error);
    		}
		}
		
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
