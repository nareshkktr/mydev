(function() {
	'use strict';

	angular.module('myindia-app').factory("discussionsService",
			discussionsService);

	discussionsService.$inject = [ '$q', 'swaggerShareService', '$timeout' ];

	function discussionsService($q, swaggerShareService, $timeout) {

		var services = {};

		var discussionsService = {
			getProblemComments : getProblemComments
		};

		// Call and save the data
		swaggerShareService.getAPIMetaData(setAPIMetaData);

		return discussionsService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getProblemComments(problemGuid,pageNo,limit) {

			let
			deferred = $q.defer();

			services.comment.getFirstLevelComments({
				objectGuid : problemGuid,
				pageNo:pageNo,
				limit:limit
			}, getProblemCommentsSuccess, getProblemCommentsFailure);

			return deferred.promise;

			function getProblemCommentsSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getProblemCommentsFailure(error) {
				deferred.reject(error);
			}

		}
	}
})();