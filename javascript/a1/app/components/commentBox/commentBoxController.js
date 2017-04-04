(function() {
	'use strict';
	angular.module('myindia-app').controller("commentBoxController",
			commentBoxController);

	commentBoxController.$inject = [ '$scope','commentBoxService' ];

	function commentBoxController($scope,commentBoxService) {
		var commentBox = this;
		console.log($scope.objectType);
		console.log($scope.objectGuid);
		commentBox.sendComment = sendComment;
		function sendComment(){
			
		}
	}
})();
