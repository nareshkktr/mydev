(function() {
	'use strict';

	angular.module('myindia-app').controller("commentActionsController",
			commentActionsController);
	commentActionsController.$inject = ['$scope'];

	function commentActionsController($scope) {
		var commentActions = this;
		
		commentActions.objectType=$scope.objectType;
		commentActions.objectGuid=$scope.objectGuid;
		commentActions.objectData=$scope.objectData;
		
		console.log(commentActions.objectType);
		console.log(commentActions.objectGuid);
		console.log(commentActions.objectData);
		
	}

})();
