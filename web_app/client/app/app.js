'use strict';

angular.module('webAppApp', [
  'ngCookies',
  'ngResource',
  'ngSanitize',
  'ngRoute',
  'ui.bootstrap',
  'ngAnimate', 
  'ngSanitize', 
  'ngTable', 
  'highcharts-ng',
  'ngFileUpload',
])
  .config(function ($routeProvider,$locationProvider) {
    $routeProvider
      .when('/', {
        redirectTo:'login'
        //templateUrl: 'views/main.html',
        //controller: 'MainCtrl'
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
      .when('/cart',{
        templateUrl:'cart/cart.html',
        controller:'CartCtrl'
      })
      .when('/report',{
        templateUrl:'report/report.html',
        controller:'ReportCtrl'
      })
      .otherwise({
        redirectTo: '/login'
      });
    $locationProvider.html5Mode(true);
  
})
