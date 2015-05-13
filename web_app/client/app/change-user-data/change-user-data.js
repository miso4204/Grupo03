'use strict';

angular.module('webAppApp')
  .config(function ($routeProvider) {
    $routeProvider
      .when('/change-user-data', {
        templateUrl: 'app/change-user-data/change-user-data.html',
        controller: 'ChangeUserDataCtrl'
      })
      .when('/change-user-data/:id',{
        templateUrl: 'app/change-user-data/change-user-data.html',
        controller: 'ChangeUserDataCtrl'
      });
  });
