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
        	 var userPassword=attrs["compareEqualValidator"];
             console.log(userPassword);
             
          ngModel.$parsers.unshift(function (value) {
            console.log(value);
            if(userPassword)
              ngModel.$setValidity('compareEqualValidator', userPassword === value);
             return value;
          });

        }
    }

})();