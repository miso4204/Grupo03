'use strict';

angular.module('webAppApp')
  .directive('catalogItem', function(){
  	
	return{
		restrict:'EAC',
		template: '<ng-include src="getTemplateUrl()"/>',
		scope:{
			stamp:'=stamp',
			viewMode:'=viewMode',
		},
		link:function($scope){
			
			$scope.getTemplateUrl=function(){
				if($scope.viewMode=="grid"){
					console.log("grid")
					return 'app/catalogItem/productGridItem.html';
				}
				if($scope.viewMode=="list"){
					console.log("list")
					return 'app/catalogItem/productListItem.html';
				}else{
					return 'app/catalogItem/productGridItem.html';
				}
			}
		},
	}
 	})

  .controller('catalogItem', function ($scope,$rootScope,rateService,sessionStorage,$filter) {
    $scope.isRate = true; 
    $scope.rate1 = {};

    if (sessionStorage.get("user")) {
        if(!$rootScope.globals){
            $rootScope.globals={};
        }
        $rootScope.globals.currentUser=sessionStorage.get("user");
    }
    console.log($rootScope.globals.currentUser.userType);

    $scope.rateFunction = function (calificat) {
        $scope.rate1.stampId = $scope.stamp.id;
        console.log($scope.rate1.calification)
        rateService.Rate($scope.rate1,function(response) {
                    console.log("rating");                    
                });
          
        }     
    
  });