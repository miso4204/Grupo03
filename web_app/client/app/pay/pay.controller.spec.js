'use strict';

describe('Controller: PayCtrl', function () {

  // load the controller's module
  beforeEach(module('webAppApp'));

  var PayCtrl, scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PayCtrl = $controller('PayCtrl', {
      $scope: scope
    });
  }));

  it('should ...', function () {
    expect(1).toEqual(1);
  });
});
