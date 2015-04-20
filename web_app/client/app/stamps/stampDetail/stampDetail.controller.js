'use strict';

angular.module('webAppApp')
  .controller('StampDetailCtrl', function ($scope , $routeparms) {
  	$scope.id=$routeParams.id;
    $scope.message = 'Hello';
  });
