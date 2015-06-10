'use strict';

// Declare app level module which depends on views, and components
angular.module('devnation2015app', [
  'ngRoute',
  'devnation2015app.view1',
  'devnation2015app.view2',
  'devnation2015app.version'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/view1'});
}]);
