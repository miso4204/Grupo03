'use strict';

describe('Service: sessionStorage', function () {

  // load the service's module
  beforeEach(module('webAppApp'));

  // instantiate service
  var sessionStorage;
  beforeEach(inject(function (_sessionStorage_) {
    sessionStorage = _sessionStorage_;
  }));

  it('should do something', function () {
    expect(!!sessionStorage).toBe(true);
  });

});
