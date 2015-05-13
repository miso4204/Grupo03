'use strict';

describe('Service: rateService', function () {

  // load the service's module
  beforeEach(module('webAppApp'));

  // instantiate service
  var rateService;
  beforeEach(inject(function (_rateService_) {
    rateService = _rateService_;
  }));

  it('should do something', function () {
    expect(!!rateService).toBe(true);
  });

});
