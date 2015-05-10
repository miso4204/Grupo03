'use strict';

angular.module('webAppApp')
  .controller('AuthorCtrl', function ($scope,StampId,$routeParams,User,$rootScope,sessionStorage) {
  	$rootScope.globals={};

	if (sessionStorage.get("user")) {
      $rootScope.globals.currentUser=sessionStorage.get("user");
      if(sessionStorage.get("products")){
          $rootScope.products=sessionStorage.get("products");
      }
    }
	$scope.result = {};	
	$scope.user = User.get({id:$routeParams.id},function(){
        console.log(JSON.stringify($scope.user))
      });
	var authorId = $routeParams.id;
 	$scope.stamps;
	var result = StampId.get({artistId:authorId},
		function(){
			console.log(result.stamps)
		     $scope.stamps=result.stamps;
		 });  	   		
  });
Object