(function() {
	'use strict';

	angular.module('myindia-app').factory("commentBoxService",
			commentBoxService);

	commentBoxService.$inject = [ '$q', 'swaggerShareService' ];

	function commentBoxService($q, swaggerShareService) {

		var services = {};

		var commentBoxService = {
				sendComment : sendComment
		};

		// Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return commentBoxService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function sendComment(commentData) {

			let
			deferred = $q.defer();

			if (swaggerPromise) {
				swaggerPromise.then(function() {
					services.comment.getLoggedInUserInfo({},
							sendCommentSuccess, sendCommentFailure);

					swaggerPromise = undefined;
				})
			} else {
				services.comment.getLoggedInUserInfo({}, sendCommentSuccess,
						sendCommentFailure);

			}

			return deferred.promise;

			function sendCommentSuccess(data) {
				deferred.resolve(data.obj);
			}

			function sendCommentFailure(error) {
				deferred.reject(error);
			}

		}

	}

})();