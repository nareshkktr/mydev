(function() {
	'use strict';

	angular.module('myindia-app').controller("createProblemController",
			createProblemController);
	createProblemController.$inject = [ 'createProblemService','fileUploadService','dataShareService','userInfoService','$scope' ];
	
	function createProblemController(createProblemService,fileUploadService,dataShareService,userInfoService,$scope) {
		
		var createProblem=this;
		createProblem.problemTypesResults = [];
		createProblem.grivienceName="";
		createProblem.grivienceType;
		createProblem.grivienceDescription;
		createProblem.noOfAffectedCitizens;
		createProblem.moneyAtStake;

		processUserData();

		//Register event to listen to userinfo chnages 
		$scope.$on('userInfoChanged',function(event){
			processUserData();
		});
		

		createProblem.saveProblem=saveProblem;
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
		
		function processUserData(){
			createProblem.userData = dataShareService.getUserInfo();

			if(!createProblem.userData){
				userInfoService.getUserInfo().then(userInfoSuccess).catch(userInfoFailure);

				function userInfoSuccess(data){
					createProblem.userData = data;
					createProblem.locatedInName = createProblem.userData.userLocation.locationName;
				}

				function userInfoFailure(error){
					alert(error);
				}
			}else if(createProblem.userData.userLocation){
				createProblem.locatedInName = createProblem.userData.userLocation.locationName;
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
