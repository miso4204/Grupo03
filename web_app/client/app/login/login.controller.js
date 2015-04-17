'use strict';

angular.module('webAppApp')
  .controller('LoginCtrl',['$scope', '$routeParams','$rootScope', '$location', 'loginService',
		function($scope,$routeParams,$rootScope,$location,loginService){
			$rootScope.authenticated = false;
			$scope.loginForm={};
			$scope.registerForm={};
			loginService.ClearCredentials();
			$scope.login = function (credentials) {
				console.log($location)
				$scope.dataLoading = true;
				loginService.Login(credentials,function(response) {
            		if(response.success) {
                		console.log("login responsed" + JSON.stringify(response))
                    	loginService.SetCredentials(credentials);
                    	$rootScope.authenticated = true;
                    	$location.path('/stamps');
                	} else {
                		console.log("login failed" + JSON.stringify(response))
                		$scope.error= "Usuario y/o contraseña incorrectas";
                    	// $scope.error = response.message;
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
