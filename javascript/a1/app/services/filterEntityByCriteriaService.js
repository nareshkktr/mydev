(function() {
	'use strict';

	angular.module('myindia-app').factory("filterEntityByCriteria",
			filterEntityByCriteria);

	filterEntityByCriteria.$inject = [ '$q', 'swaggerShareService' ];

	function filterEntityByCriteria($q, swaggerShareService) {

		var services = {};

		var filterEntityByCriteria = {
			filterEntities : filterEntities
		};

		// // Call and save the data
		let
		swaggerPromise = swaggerShareService.getAPIMetaData(setAPIMetaData);

		return filterEntityByCriteria;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function filterEntities(filterRequest) {

			let
			deferred = $q.defer();

			services.search.filterEntity({body:JSON.stringify(filterRequest)}, filterEntitySuccess,
						filterEntityFailure);
			
			function filterEntitySuccess(data){
				deferred.resolve(data.obj);
			}

			function filterEntityFailure(error){
				deferred.reject(error);
			}

			return deferred.promise;

		}
	}

})();