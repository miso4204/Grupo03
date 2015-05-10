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
				console.log("llego****"+ $scope.viewMode)
				console.log("llego****"+ $scope.stamp.price)
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