'use strict';

describe('Controller: ChangeUserDataCtrl', function () {

  // load the controller's module
  beforeEach(module('webAppApp'));

  var ChangePasswordCtrl, scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ChangeUserDataCtrl = $controller('ChangeUserDataCtrl', {
      $scope: scope
    });
  }));

  it('should ...', function () {
    expect(1).toEqual(1);
  });
});
