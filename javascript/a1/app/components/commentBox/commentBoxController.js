(function() {
	'use strict';
	angular.module('myindia-app').controller("commentBoxController",
			commentBoxController);

	commentBoxController.$inject = [ '$scope','commentBoxService','dataShareService','userInfoService' ];

	function commentBoxController($scope,commentBoxService,dataShareService,userInfoService) {
		var commentBox = this;
		commentBox.commentText="";
		commentBox.sendComment = sendComment;
		
		commentBox.userInfo = dataShareService.getUserInfo();
		if (!commentBox.userInfo) {
			userInfoService.getUserInfo().then(userInfoSuccess).catch(userInfoFailure);

			function userInfoSuccess(data){
				dataShareService.setUserInfo(data);
				commentBox.userInfo=data;
			}

			function userInfoFailure(error){
				alert(error);
			}
		}
		
		commentBox.userProfileImageClass = "comment_user_profile_image";
		commentBox.userProfileLabelClass = "comment_user_profile_label";

		function sendComment(){
			let commentData={};
			commentData.objectType=$scope.objectType;
			commentData.objectGuid=$scope.objectGuid;
			commentData.commentText=commentBox.commentText;
			
			commentBoxService.sendComment(commentData).then(sendCommentSuccess).catch(sendCommentFailure);
    		function sendCommentSuccess(data){
    			commentData.commentText="";
    		}
    		function sendCommentFailure(error){
    			alert(error);
    		}
		}
	}
})();
