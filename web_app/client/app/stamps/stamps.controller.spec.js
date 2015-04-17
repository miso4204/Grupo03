'use strict';

describe('Controller: StampsCtrl', function () {

  // load the controller's module
  beforeEach(module('webAppApp'));

  var StampsCtrl, scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    StampsCtrl = $controller('StampsCtrl', {
      $scope: scope
    });
  }));

  it('should ...', function () {
    expect(1).toEqual(1);
  });
});
