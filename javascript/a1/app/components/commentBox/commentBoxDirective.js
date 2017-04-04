(function() {
	'use strict';

	angular.module('myindia-app').directive("commentBox", commentBox);

	function commentBox() {

		var commentBox = {
			restrict : 'E',
			scope : {
				objectType : '=',
				objectGuid : '='
			},
			templateUrl : resource + 'partials/commentBox.html',
			controller : 'commentBoxController',
			controllerAs : 'commentBox'
		};

		return commentBox;
	}

})();
