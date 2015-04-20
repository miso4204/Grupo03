'use strict';

angular.module('webAppApp')
  .config(function ($routeProvider) {
    $routeProvider
      .when('/authors', {
        templateUrl: 'app/authors/authors.html',
        controller: 'AuthorsCtrl'
      });
  });
