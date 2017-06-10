(function() {
	'use strict';

	angular.module('myindia-app').directive("activityFeedActions", activityFeedActions);

	function activityFeedActions() {

		var activityFeedActions = {
			restrict : 'E',
			scope : {
				objectType : '=',
				objectGuid : '='
			},
			templateUrl : resource + 'partials/activityFeedActions.html',
			controller : 'activityFeedActionsController',
			controllerAs : 'activityFeedActions'
		};
		return activityFeedActions;
	}

})();
