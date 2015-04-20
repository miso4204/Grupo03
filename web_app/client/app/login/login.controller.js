'use strict';

angular.module('webAppApp')
  .controller('LoginCtrl',['$scope', '$routeParams','$rootScope', '$location', 'loginService', 'registerService',
		function($scope,$routeParams,$rootScope,$location,loginService,registerService){
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
			};
            $scope.register = function (dataUser) {
                console.log($location)
                console.log($scope.dataUser)
                if(($scope.dataUser.password.length) >= 6){
                    if($scope.dataUser.password == $scope.passwordConfirm){
                        registerService.Register(dataUser,function(response, status) {
                            if(status == 200) {
                                console.log("Register responsed" + JSON.stringify(response))
                                $scope.regSuccess= "Registro exitoso, por favor Inicie Sesión";
                                $scope.regSuccessShow = true;
                                $scope.regErrorShow = false;
                                $scope.dataUser.username = "";
                                $scope.dataUser.name = "";
                                $scope.dataUser.lastName = "";
                                $scope.dataUser.email = "";
                                $scope.dataUser.password = "";
                                $scope.passwordConfirm = "";
                                $scope.userType = "CLIENT";
                            } else {
                                console.log(status);
                                console.log("register failed" + JSON.stringify(response))
                                if(status == 204){
                                    $scope.regError= "El usuario " + dataUser.username + " ya existe.";
                                } else {
                                    $scope.regError= "Se ha presentado un problema con el proceso de Registro";
                                }
                                console.log("error");
                                $scope.regSuccessShow = false;
                                $scope.regErrorShow = true;
                            }
                        });
                    } else {
                        $scope.regError= "Las contraseñas no coinciden";
                        console.log("error");
                        $scope.regSuccessShow = false;
                        $scope.regErrorShow = true;    
                    };
                } else{
                    $scope.regError= "La contraseña debe tener más de 6 caracteres";
                    console.log("error");
                    $scope.regSuccessShow = false;
                    $scope.regErrorShow = true;
                };
            };
	}])
