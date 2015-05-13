'use strict';

angular.module('webAppApp')
  .controller('SocialCtrl', ['$scope', '$routeParams','$rootScope', '$location', 'twitterService', 'facebookService',
  	function ($scope,$routeParams,$rootScope,$location,twitterService,facebookService) {
    	
    	$scope.showTwitter = false;
    	$scope.showFacebook = false;

    	twitterService.getTwitter(
            function(response,status){
                console.log(status);
                if(status == 200){
                    $scope.showTwitter = true;
                }else{
                    $scope.showTwitter = false;
                }
                
            }
        );

        facebookService.getFacebook(
            function(response,status){
                console.log(status);
                if(status == 200){
                    $scope.showFacebook = true;
                }else{
                    $scope.showFacebook = false;
                }
                
            }
        );

  }]);
