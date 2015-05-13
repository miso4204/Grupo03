'use strict';

describe('Controller: NavBarCtrl', function () {

  // load the controller's module
  beforeEach(module('webAppApp'));

  var NavBarCtrl, scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    NavBarCtrl = $controller('NavBarCtrl', {
      $scope: scope
    });
  }));

  it('should ...', function () {
    expect(1).toEqual(1);
  });
});
