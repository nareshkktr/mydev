(function() {
	'use strict';

	angular.module('myindia-app').directive("userProfileImageDisplay", userProfileImageDisplay);

	function userProfileImageDisplay() {

		var userProfileImageDisplay = {
			restrict : 'E',
			scope: {
				imageUrl: '=',
				name: '=',
				imageClass: '=',
				labelClass: '='
			},
			templateUrl : resource + 'partials/userProfileImageDisplay.html',
			link : link
		};

		return userProfileImageDisplay;

		function link(scope, element, attrs) {

			if(!scope.imageUrl){
				let splitValues = scope.name.split(" ");

				if(splitValues && splitValues.length>1){
					scope.labelName = splitValues[0].charAt(0)+splitValues[1].charAt(0);
				}else if(splitValues && splitValues.length>0){
					scope.labelName = splitValues[0].charAt(0);
				}
			}
			console.log(scope.imageUrl);
		}

	}
})();
