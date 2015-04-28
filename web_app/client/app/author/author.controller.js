'use strict';

angular.module('webAppApp')
  .controller('AuthorCtrl', function ($scope,StampId,$routeParams,User) {
   	$scope.myInterval=10000;
	$scope.result = {};	
	$scope.user = User.get({id:$routeParams.id},function(){
        console.log(JSON.stringify($scope.user))
      });
	
	
	
	var authorId = $routeParams.id;
	var result = StampId.get({artistId:authorId},
				  				function(){
          						     $scope.slides=result.stamps;
       							 });  	   		
   	
  });
