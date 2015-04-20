'use strict';

describe('Service: payService', function () {

  // load the service's module
  beforeEach(module('webAppApp'));

  // instantiate service
  var payService;
  beforeEach(inject(function (_payService_) {
    payService = _payService_;
  }));

  it('should do something', function () {
    expect(!!payService).toBe(true);
  });

});
