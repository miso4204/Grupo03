'use strict';

/**
 * @ngdoc function
 * @name shirtsApp.controller:loginController
 * @description
 * #loginController
 * Controller of the shirtsApp
 */
angular.module('shirtsApp')
	.controller('loginController',['$scope', '$rootScope','$routeParams', '$location', 'serviceA',
		function($scope,$routeParams,$rootScope,$location,serviceA){
			$rootScope.authenticated = false;
			$scope.loginForm={};
			$scope.registerForm={};
			serviceA.ClearCredentials();
			$scope.login = function (credentials) {
				console.log($location)
				$scope.dataLoading = true;
				serviceA.Login(credentials,function(response) {
            		if(response.success) {
                		console.log("login responsed" + JSON.stringify(response))
                    	serviceA.SetCredentials(credentials);
                    	$rootScope.authenticated = true;
                    	$location.path('/catalog');
                	} else {
                		console.log("login failed" + JSON.stringify(response))
                    	$scope.error = response.message;
                    	$scope.dataLoading = false;
                    	console.log("error");
                	}
            	});
        	};
			$scope.getFieldCssClass=function(ngModelController){
				if(ngModelController.$pristine) return "";
				return ngModelController.$valid ? "valid-field" : "invalid-field";
			}
	}])
