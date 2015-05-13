'use strict';

describe('Directive: productItem', function () {

  // load the directive's module and view
  beforeEach(module('webAppApp'));
  beforeEach(module('app/products/productItem/productItem.html'));

  var element, scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<product-item></product-item>');
    element = $compile(element)(scope);
    scope.$apply();
    expect(element.text()).toBe('this is the productItem directive');
  }));
});