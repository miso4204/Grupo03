'use strict';

angular.module('webAppApp')
  .config(function ($routeProvider) {
    $routeProvider
      .when('/stamps', {
        templateUrl: 'app/stamps/stamps.html',
        controller: 'StampsCtrl'
      })
      .when('/stamps/:id', {
        templateUrl: 'app/stamps/stampDetail/stampDetail.html',
        controller: 'StampDetailCtrl'
      });
  });
