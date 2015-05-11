'use strict';

angular.module('webAppApp')
  .controller('SocialCtrl', ['$scope', '$routeParams','$rootScope', '$location', 'twitterService', 'facebookService',
  	function ($scope,$routeParams,$rootScope,$location,twitterService,facebookService) {
    	
    	$scope.showTwitter = false;
    	$scope.showFacebook = false;

    	var result= twitterService.get(
            function(){
                $scope.showTwitter = result;
            }
        );

        var result1= facebookService.get(
            function(){
                $scope.showFacebook = result1;
            }
        );

  }]);
