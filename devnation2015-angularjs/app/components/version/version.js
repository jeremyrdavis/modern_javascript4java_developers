'use strict';

angular.module('devnation2015app.version', [
  'devnation2015app.version.interpolate-filter',
  'devnation2015app.version.version-directive'
])

.value('version', '0.1');
