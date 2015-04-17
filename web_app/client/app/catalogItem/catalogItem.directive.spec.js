'use strict';

describe('Directive: catalogItem', function () {

  // load the directive's module and view
  beforeEach(module('webAppApp'));
  beforeEach(module('app/catalogItem/catalogItem.html'));

  var element, scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<catalog-item></catalog-item>');
    element = $compile(element)(scope);
    scope.$apply();
    expect(element.text()).toBe('this is the catalogItem directive');
  }));
});