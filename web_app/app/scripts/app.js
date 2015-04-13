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
    'ui.bootstrap',
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
      .when('/stamps',{
        templateUrl:'views/stampCatalog.html',
        controller:'stampCatalogCtrl',
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
        templateUrl:'views/login.html',
        controller:'loginController'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
