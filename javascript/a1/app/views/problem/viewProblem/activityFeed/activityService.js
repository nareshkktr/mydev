(function() {
	'use strict';

	angular.module('myindia-app').factory("activityService", activityService);

	activityService.$inject = [ '$q', 'swaggerShareService' ];

	function activityService($q, swaggerShareService) {

		var services = {};

		var activityService = {
			getAllActivities : getAllActivities,
			getActivitiesByObjectGuid : getActivitiesByObjectGuid
		};

		// Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return activityService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getAllActivities(pageNo, pageLimit) {

			let
			deferred = $q.defer();

			if (swaggerPromise) {
				swaggerPromise.then(function() {
					services.activity.getActivities({
						pageNo : pageNo,
						pageLimit : pageLimit
					}, getAllActivitiesSuccess, getAllActivitiesFailure);
					swaggerPromise = undefined;
				})
			} else {
				services.activity.getActivities({
					pageNo : pageNo,
					pageLimit : pageLimit
				}, getAllActivitiesSuccess, getAllActivitiesFailure);
			}

			return deferred.promise;

			function getAllActivitiesSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getAllActivitiesFailure(error) {
				deferred.reject(error);
			}

		}

		function getActivitiesByObjectGuid(objectGuid,pageNo, pageLimit) {

			let
			deferred = $q.defer();

			services.activity.getActivitiesByObject({
				objectGuid:objectGuid,
				pageNo : pageNo,
				pageLimit : pageLimit
			}, getActivitiesByObjectGuidSuccess, getActivitiesByObjectGuidFailure);

			return deferred.promise;

			function getActivitiesByObjectGuidSuccess(data) {
				deferred.resolve(data.obj);
			}

			function getActivitiesByObjectGuidFailure(error) {
				deferred.reject(error);
			}

		}

	}

})();