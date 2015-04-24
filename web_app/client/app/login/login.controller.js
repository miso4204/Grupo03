'use strict';

angular.module('webAppApp')
  .controller('LoginCtrl',['$scope', '$routeParams','$rootScope', '$location', 'loginService', 'registerService', 'Cart',
		function($scope,$routeParams,$rootScope,$location,loginService,registerService,Cart){
			$rootScope.authenticated = false;
			$scope.loginForm={};
			$scope.registerForm={};
            $scope.products = [];
			loginService.ClearCredentials();
            $scope.test=function(){
                console.log("hola");
            };
            $scope.logout=function() {
                console.log("logout");
                loginService.logout();
            };
			$scope.login = function (credentials) {
				$scope.dataLoading = true;
				loginService.login(credentials,function(response) {
            		if(response.success) {
                		console.log("login responsed" + JSON.stringify(response))
                    	var result = {};
                        result= Cart.get({id:$rootScope.userId},
                            function(){
                                $scope.products=result.products;
                                $rootScope.nroProdCart=products.length;
                            }
                        );
                        loginService.SetCredentials(credentials,response,result.products);
                    	$location.path('/stamps');
                	} else {
                		console.log("login failed" + JSON.stringify(response))
                		$scope.error= "Usuario y/o contraseña incorrectas";
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
                $scope.regSuccessShow = false;
                $scope.regErrorShow = false;
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
