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
 						return 'app/catalogItem/productGridItem.html';
 					}
 					if($scope.viewMode=="list"){
 						return 'app/catalogItem/productListItem.html';
 					}
 				}
 			},
 		}
 	})