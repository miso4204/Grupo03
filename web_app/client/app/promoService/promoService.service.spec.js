'use strict';

describe('Service: promoService', function () {

  // load the service's module
  beforeEach(module('webAppApp'));

  // instantiate service
  var rateService;
  beforeEach(inject(function (_promoService_) {
    _promoService_ = _promoService_;
  }));

  it('should do something', function () {
    expect(!!promoService).toBe(true);
  });

});
