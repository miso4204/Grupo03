'use strict';

describe('Service: Stamp', function () {

  // load the service's module
  beforeEach(module('webAppApp'));

  // instantiate service
  var Stamp;
  beforeEach(inject(function (_Stamp_) {
    Stamp = _Stamp_;
  }));

  it('should do something', function () {
    expect(!!Stamp).toBe(true);
  });

});
