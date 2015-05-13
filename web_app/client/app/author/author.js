'use strict';

angular.module('webAppApp')
  .config(function ($routeProvider) {
    $routeProvider
      .when('/author', {
        templateUrl: 'app/author/author.html',
        controller: 'AuthorCtrl'
      })
	  .when('/author/:id',{
       templateUrl: 'app/author/author.html',
        controller: 'AuthorCtrl'
      })
	  ;
  });
