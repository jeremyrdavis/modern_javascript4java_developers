'use strict';

describe('devnation2015app.version module', function() {
  beforeEach(module('devnation2015app.version'));

  describe('version service', function() {
    it('should return current version', inject(function(version) {
      expect(version).toEqual('0.1');
    }));
  });
});
