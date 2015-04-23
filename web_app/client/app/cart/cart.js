'use strict';

angular.module('webAppApp')
  .config(function ($routeProvider) {
    $routeProvider
      .when('/cart', {
        templateUrl: 'app/cart/cart.html',
        controller: 'CartCtrl'
      });
  });
