'use strict';

/**
 * @ngdoc overview
 * @name shirtsApp
 * @description
 * # shirtsApp
 *
 * Main module of the application.
 */
angular
  .module('shirtsApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ui.bootstrap'
  ])
  .config(function ($routeProvider) {
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
      .when('/catalog',{
        templateUrl:'views/catalogShirt.html',
        controller:'catalogShirtCtrl',
      })
      .when('/catalog/:productId',{
        templateUrl:'views/productDetail.html',
        controller:'productDetailCtrl',
      })
      .when('/login',{
        templateUrl:'views/login.html',
        controller:'loginController'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
