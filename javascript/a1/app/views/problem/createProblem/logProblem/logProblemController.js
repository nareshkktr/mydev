(function() {
	'use strict';

	angular.module('myindia-app').controller("logProblemController",
			logProblemController);
	logProblemController.$inject = [ 'createProblemService','fileUploadService','dataShareService','userInfoService','$scope','locationChangePopUpService','$state','filterEntityByCriteria' ];
	
	function logProblemController(createProblemService,fileUploadService,dataShareService,userInfoService,$scope,locationChangePopUpService,$state,filterEntityByCriteria) {
		
		var logProblem=this;
		logProblem.chosenProblemCategory = $state.params.selectedProblemCategory;
		logProblem.problemTypesResults = $state.params.problemTypes;
		logProblem.grivienceName="";
		logProblem.grivienceType;
		logProblem.grivienceDescription;
		logProblem.noOfAffectedCitizens;
		logProblem.moneyAtStake;
		logProblem.noOfAffectedCitizensData={4:"<5",3:"Between 5 and 100",2:"Between 100 and 1000",1:">1000"};
		logProblem.moneyAtStakeData={4:"<1,00,000",3:"Between 1,00,000 and 10,00,000",2:"Between 10,00,000 and 50,00,000",1:">50,00,000"};
		logProblem.tags = [];
		logProblem.generateTags=generateTags;
		logProblem.searchLocation=searchLocation;
		logProblem.searchedLocations=[];
		logProblem.selectLocation = selectLocation;
		logProblem.selectedLocation=null;
		logProblem.showLocationSearchBox=false;
		logProblem.locatedIn="";
		logProblem.tagValues="";
		logProblem.problems = [];
		logProblem.changeProblemType=changeProblemType;
		logProblem.similarProblems = {};
		logProblem.similarProblems.pageNo = 1;
		logProblem.similarProblems.pageLimit = 4;


		function changeProblemType(){
			generateTags();
		}
		
		// for (var i = 0; i < 20; i++) {
		// 	var severity = "";

		// 	if (i % 2 == 0) {
		// 		severity = "critical";
		// 	} else if (i % 3 == 0) {
		// 		severity = "high";
		// 	} else if (i % 5 == 0) {
		// 		severity = "medium";
		// 	} else {
		// 		severity = "low";
		// 	}
		// 	var problem = {
		// 		"problemName" : "Water Problem Type Water Problem Type Water Problem Type "
		// 				+ i,
		// 		"locatedIn" : "Pulipadu,Prakasam(District)",
		// 		"severity" : severity,
		// 		"severityLevel" : severity === "critical" ? "C"
		// 				: severity === "high" ? "H"
		// 						: severity === "medium" ? "M" : "L"
		// 	};
		// 	logProblem.problems.push(problem);
		// }

		processUserData();

		$scope.$on('userInfoChanged',function(event){
			processUserData();
		});
		

		logProblem.saveProblem=saveProblem;
		logProblem.uploadCover = uploadCover;
		    
		
		
		function saveProblem(){


			if(logProblem.tags){
				logProblem.tagValues = "";
				for(let i =0; i < logProblem.tags.length; i++){
					logProblem.tagValues+=logProblem.tags[i].text+",";
				}
			}
			
			if(logProblem.tagValues!=undefined){
				logProblem.tagValues=logProblem.tagValues.substr(0,logProblem.tagValues.length-1);
			}
			
			createProblemService.saveProblem(logProblem).then(saveProblemSuccess).catch(saveProblemFailure);

    		function saveProblemSuccess(data){
    			if(logProblem.coverPhotoFile!=undefined && logProblem.coverPhotoFile!=null){
    				addMainPhotoToProblem(data.saveUpdateDeleteRecordId);
    			}
            }
    		function saveProblemFailure(error){
    			alert(error);
    		}
		}
		
		function processUserData(){
			logProblem.userData = dataShareService.getUserInfo();

			if(!logProblem.userData){
				userInfoService.getUserInfo().then(userInfoSuccess).catch(userInfoFailure);

				function userInfoSuccess(data){
					dataShareService.setUserInfo(data);
				}

				function userInfoFailure(error){
					alert(error);
				}
			}else if(logProblem.userData.displayLocation){
				logProblem.selectedLocation = logProblem.userData.displayLocation;
				logProblem.locatedIn=logProblem.userData.displayLocation.locationName;
				
				generateTags();
			}
		}

		function uploadCover(files){
			logProblem.coverPhotoFile = files[0];
		}
		
		function addMainPhotoToProblem(problemGuid){

			let files=[logProblem.coverPhotoFile];
	
			fileUploadService.uploadFile(files,"Problem",problemGuid,true,null).then(uploadSuccess).catch(uploadFailure);

			function uploadSuccess(data){
				console.log(data);
			}

			function uploadFailure(error){
				alert(error);
			}
		}
		
		function generateTags(){

			logProblem.tags = [];
			
			let content=logProblem.chosenProblemCategory;
			content+=" "+logProblem.grivienceName;
			if(logProblem.grivienceType!=undefined){
				content+=" "+logProblem.grivienceType.problemTypeName;
			}
			if(logProblem.selectedLocation!=undefined){
				content+=" "+logProblem.selectedLocation.locationName;
			}
			
			let contentWords = content.split(" ");
			if(contentWords.length>1){
				for(let i =0; i < contentWords.length; i++){
					let tagObj= { text: contentWords[i] };
					if(contentWords[i]!=null && contentWords[i]!=undefined && contentWords[i]!="" && contentWords[i].length>=3 && !arrayContainsValue(contentWords[i])){
						logProblem.tags.push(tagObj);
					}
				}
			}

			//Reset page no to 1.
			logProblem.similarProblems.pageNo = 1;
			// Call to get similar problems based on multiple criteria.
			fetchRelatedProblemsData(logProblem.similarProblems.pageNo,logProblem.similarProblems.pageLimit);
		}

		function fetchRelatedProblemsData(pageNo,pageLimit){

			let filterEntityRequest = {
					objectName: logProblem.grivienceName,
					supportingFields: [logProblem.chosenProblemCategory],
					objectType: "Problem",
					pageNo: pageNo,
					pageLimit: pageLimit
			};

			if(logProblem.grivienceType!=undefined){
				filterEntityRequest.supportingFields.push(logProblem.grivienceType.problemTypeName);
			}

			if(logProblem.selectedLocation!=undefined){
				filterEntityRequest.locationName = logProblem.selectedLocation.locationName;
			}

			filterEntityByCriteria.filterEntities(filterEntityRequest).then(filterEntitiesSuccess).catch(filterEntitiesFailure);

			function filterEntitiesSuccess(data){
				logProblem.problems = data;
			}

			function filterEntitiesFailure(error){
				alert(error);
			}

		}
		
		function arrayContainsValue(tagName){
			var isContained=false;
			for(var i=0;i<logProblem.tags.length;i++){
				var tagObj= logProblem.tags[i];
				if(tagObj.text==tagName){
					isContained=true;
					break;
				}
			}
			return isContained;
		}
		
		function searchLocation(){
			if(logProblem.locatedIn.length>=3){
				logProblem.showLocationSearchBox=true;
				if(logProblem.locatedIn.length>=3){
					locationChangePopUpService.getSearchResults(logProblem.locatedIn).then(searchLocationsSuccess).catch(searchLocationsFailure);
		    		function searchLocationsSuccess(data){
		    			logProblem.searchedLocations=data;
		    		}
		    		function searchLocationsFailure(error){
		    			alert(error);
		    		}
				}
			}
		}
		
		function selectLocation(searchLocation){
			logProblem.selectedLocation=searchLocation;
			logProblem.locatedIn=searchLocation.locationName;
			logProblem.showLocationSearchBox=false;
			generateTags();
		}
	}

})();
