(function() {
	'use strict';

	angular.module('myindia-app').controller("createProblemController",
			createProblemController);
	createProblemController.$inject = [ 'createProblemService','fileUploadService','dataShareService' ];
	
	function createProblemController(createProblemService,fileUploadService,dataShareService) {
		
		var createProblem=this;
		createProblem.problemTypesResults = [];
		createProblem.grivienceName="";
		createProblem.grivienceType;
		createProblem.grivienceDescription;
		createProblem.noOfAffectedCitizens;
		createProblem.moneyAtStake;
		createProblem.locatedIn=dataShareService.getUserInfo().userLocation;
		createProblem.saveProblem=saveProblem;
		createProblem.locatedInName=dataShareService.getUserInfo().userLocation.locationName;
		createProblem.uploadCover = uploadCover;
		    
		getAllProblemTypes();
		
		function saveProblem(){
			
			createProblemService.saveProblem(createProblem).then(saveProblemSuccess).catch(saveProblemFailure);

    		function saveProblemSuccess(data){
    			if(createProblem.coverPhotoFile!=undefined && createProblem.coverPhotoFile!=null){
    				addMainPhotoToProblem(data.saveUpdateDeleteRecordId);
    			}
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
		}
		
		function addMainPhotoToProblem(problemGuid){

			let files=[createProblem.coverPhotoFile];
	
			fileUploadService.uploadFile(files,"Problem",problemGuid,true,null).then(uploadSuccess).catch(uploadFailure);

			function uploadSuccess(data){
				console.log(data);
			}

			function uploadFailure(error){
				alert(error);
			}
		}
	}

})();
