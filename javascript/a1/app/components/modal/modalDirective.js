(function() {
	'use strict';

	angular.module('myindia-app').directive("modal", modal);

	modal.$inject = [ '$uibModal', '$log' ];

	function modal($uibModal, $log) {

		var modal = {
			link : link,
			scope : {
				animationsEnabled : '=animationsEnabled',
				modalTemplateUrl : '=modalTemplateUrl',
				dismissModal : '=',
				modalControllerName : '=modalControllerName',
				modalControllerAlias : '=modalControllerAlias',
				modalSize : '=modalSize',
				objectType : '=objectType',
				objectGuid : '=objectGuid',
				selectedAlbum : '=selectedAlbum'
			}
		};

		return modal;

		function link(scope, element, attrs) {
			var modalInstance = $uibModal.open({
				animation : scope.animationsEnabled,
				ariaLabelledBy : 'modal-title',
				ariaDescribedBy : 'modal-body',
				templateUrl : scope.modalTemplateUrl,
				controller : scope.modalControllerName,
				controllerAs : scope.modalControllerAlias,
				size : scope.modalSize,
				resolve : {
					objectType : function() {
						return scope.objectType;
					},
					objectGuid : function() {
						return scope.objectGuid;
					},
					selectedAlbum : function() {
						return scope.selectedAlbum;
					}
				}
			});
			modalInstance.result.then(function() {
			}, function() {
				scope.$eval(attrs.dismissModal);
				$log.info('Modal dismissed at: ' + new Date());
			});
		}
	}
})();