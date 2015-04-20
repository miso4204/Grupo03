'use strict';

angular.module('webAppApp')
  .config(function ($routeProvider) {
    $routeProvider
      .when('/pay', {
        templateUrl: 'app/pay/pay.html',
        controller: 'PayCtrl'
      });
  });
