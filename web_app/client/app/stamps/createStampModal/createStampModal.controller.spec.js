'use strict';

describe('Controller: CreateStampModalCtrl', function () {

  // load the controller's module
  beforeEach(module('webAppApp'));

  var CreateStampModalCtrl, scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CreateStampModalCtrl = $controller('CreateStampModalCtrl', {
      $scope: scope
    });
  }));

  it('should ...', function () {
    expect(1).toEqual(1);
  });
});
