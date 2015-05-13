'use strict';

angular.module('webAppApp')
  .config(function ($routeProvider) {
    $routeProvider
      .when('/report', {
        templateUrl: 'app/report/report.html',
        controller: 'ReportCtrl'
      });
  });
