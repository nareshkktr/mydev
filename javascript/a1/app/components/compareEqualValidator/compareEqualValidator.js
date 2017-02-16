(function() {
    'use strict';

    angular.module('myindia-app').directive("compareEqualValidator", compareEqualValidator);

    function compareEqualValidator() {
        
        var compareEqualValidator = {
          link: link,
          require: 'ngModel'
        };
        
        return compareEqualValidator;

        function link(scope, element, attrs, ngModel) {
          /* */

          ngModel.$parsers.unshift(function (value) {
            console.log(value);
            if(scope.signUp.userPassword)
              ngModel.$setValidity('compareEqualValidator', scope.signUp.userPassword === value);
             return value;
          });

        }
    }

})();