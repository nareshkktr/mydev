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
				modalControllerAlias : '=modalControllerAlias'
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
				controllerAs : scope.modalControllerAlias
			});
			modalInstance.result.then(function() {
			}, function() {
				scope.$eval(attrs.dismissModal);
				$log.info('Modal dismissed at: ' + new Date());
			});
		}
	}
})();