'use strict';

describe('Controller: AuthorsCtrl', function () {

  // load the controller's module
  beforeEach(module('webAppApp'));

  var AuthorsCtrl, scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AuthorsCtrl = $controller('AuthorsCtrl', {
      $scope: scope
    });
  }));

  it('should ...', function () {
    expect(1).toEqual(1);
  });
});
