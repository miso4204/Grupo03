'use strict';

angular.module('webAppApp')
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        // templateUrl: 'app/main/main.html',
        // controller: 'MainCtrl'
        redirectTo:'login'
      });
  });