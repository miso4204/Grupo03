'use strict';

angular.module('webAppApp', [
  'ngCookies',
  'ngResource',
  'ngSanitize',
  'ngRoute',
  'ui.bootstrap'
])
  .config(function ($routeProvider,$locationProvider) {
    $routeProvider
      .when('/', {
        redirectTo:'login'
        //templateUrl: 'views/main.html',
        //controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
      })
      
      .when('/stamps/:id',{
        templateUrl:'views/stampDetail.html',
        controller:'stampDetailCtrl',
      })
      .when('/authors',{
        templateUrl:'views/authorCatalog.html',
        controller:'authorCatalogCtrl',
      })
      .when('/authors/:id',{
        templateUrl:'views/authorDetail.html',
        controller:'authorDetailCtrl',
      })
      .when('/login',{
        templateUrl:'login/login.html',
        controller:'LoginCtrl'
      })
      .when('/pay',{
        templateUrl:'pay/pay.html',
        controller:'PayCtrl'
      })
      .otherwise({
        redirectTo: '/login'
      });
    $locationProvider.html5Mode(true);
  });