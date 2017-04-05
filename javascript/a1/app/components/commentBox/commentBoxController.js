(function() {
	'use strict';
	angular.module('myindia-app').controller("commentBoxController",
			commentBoxController);

	commentBoxController.$inject = [ '$scope','commentBoxService' ];

	function commentBoxController($scope,commentBoxService) {
		var commentBox = this;
		console.log($scope.objectType);
		console.log($scope.objectGuid);
		commentBox.commentText="";
		commentBox.sendComment = sendComment;
		
		function sendComment(){
			let commentData={};
			commentData.objectType=$scope.objectType;
			commentData.objectGuid=$scope.objectGuid;
			commentData.commentText=commentBox.commentText;
			
			commentBoxService.sendComment(commentData).then(sendCommentSuccess).catch(sendCommentFailure);
    		function sendCommentSuccess(data){
    			alert(data);
    		}
    		function sendCommentFailure(error){
    			alert(error);
    		}
		}
	}
})();
