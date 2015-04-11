'use strict';

/**
 * @ngdoc function
 * @name shirtsApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the shirtsApp
 */
angular.module('shirtsApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
