(function() {
	'use strict';

	angular.module('myindia-app').directive("commentActions", commentActions);

	function commentActions() {

		var commentActions = {
			restrict : 'E',
			scope : {
				objectType : '=',
				objectGuid : '='
			},
			templateUrl : resource + 'partials/commentActions.html',
			controller : 'commentActionsController',
			controllerAs : 'commentActions'
		};
		return commentActions;
	}

})();
