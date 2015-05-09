'use strict';

angular.module('webAppApp')
  .config(function ($routeProvider) {
    $routeProvider
      .when('/change-password', {
        templateUrl: 'app/change-password/change-password.html',
        controller: 'ChangePasswordCtrl'
      })
      .when('/change-password/:id',{
        templateUrl: 'app/change-password/change-password.html',
        controller: 'ChangePasswordCtrl'
      });
  });
