'use strict';

angular.module('webAppApp')
  .config(function ($routeProvider) {
    $routeProvider
      .when('/stamps', {
        templateUrl: 'app/stamps/stamps.html',
        controller: 'StampsCtrl'
      });
  });
