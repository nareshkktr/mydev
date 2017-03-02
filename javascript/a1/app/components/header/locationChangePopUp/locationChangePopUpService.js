(function() {
	'use strict';

	angular.module('myindia-app').factory("locationChangePopUpService",
			locationChangePopUpService);

	locationChangePopUpService.$inject = [ '$q', 'swaggerShareService' ];

	function locationChangePopUpService($q, swaggerShareService) {

		var services = {};

		var locationChangePopUpService = {
			getPopularLocations : getPopularLocations,
			getSearchResults : getSearchResults,
			pinLocation : pinLocation
		};

		// Call and save the data
		swaggerShareService.getAPIMetaData(setAPIMetaData);

		return locationChangePopUpService;

		function setAPIMetaData(metaInfo) {
			services = metaInfo;
		}

		function getPopularLocations() {

			let
			deferred = $q.defer();

			services.location.getPopularLocations({}, popularLocationsSuccess,
					popularLocationsFailure);

			return deferred.promise;

			function popularLocationsSuccess(data) {
				deferred.resolve(data.obj);
			}

			function popularLocationsFailure(error) {
				deferred.reject(error);
			}

		}

		function getSearchResults(searchTerm) {

			let
			deferred = $q.defer();

			services.location.getSearchResultsByLocationName({
				"searchTerm" : searchTerm
			}, searchLocationsSuccess, searchLocationsFailure);

			return deferred.promise;

			function searchLocationsSuccess(data) {
				deferred.resolve(data.obj);
			}

			function searchLocationsFailure(error) {
				deferred.reject(error);
			}

		}

		function pinLocation(selectedLocation) {

			let
			deferred = $q.defer();

			services.user.pinLocation({
				body : JSON.stringify(selectedLocation)
			}, pinLocationSuccess, pinLocationFailure);

			return deferred.promise;

			function pinLocationSuccess(data) {
				deferred.resolve(data.obj);
			}

			function pinLocationFailure(error) {
				deferred.reject(error);
			}

		}

	}

})();