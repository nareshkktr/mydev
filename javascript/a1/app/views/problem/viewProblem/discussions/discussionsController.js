(function() {
	'use strict';

	angular.module('myindia-app').controller("discussionsController",
			discussionsController);
	discussionsController.$inject = [];

	function discussionsController() {
		var discussions = this;
		discussions.comments=[];
		
		for(let i=0;i<20;i++){
			var discussion={};
			discussion.commentor={};
			discussion.commentor.name="YESUDASU ADIPI";
			discussion.commentor.userImage="https://s3.amazonaws.com/myindiaproblems/problems/31/Koala.jpg";
			discussion.commentText=" For register grievance servi For register grievance servi For register grievance servi For register grievance servi For register grievance servi For register grievance servi For register grievance servi";
			discussion.createdTimeStamp="2 Hours Ago";
			discussions.comments.push(discussion);
		}
	}

})();
