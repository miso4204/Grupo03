'use strict';

/**
 * @ngdoc function
 * @name shirtsApp.directive:productListItem
 * @description
 * #productListItem
 * Custom directive productListItem
 */
 angular.module('shirtsApp')
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
 						return '/scripts/directives/templates/productGridItem.html';
 					}
 					if($scope.viewMode=="list"){
 						return '/scripts/directives/templates/productListItem.html';
 					}
 				}
 			},
 		}
 	})

