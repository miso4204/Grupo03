'use strict';

angular.module('webAppApp')
  .controller('LoginCtrl',['$scope', '$routeParams','$rootScope', '$location', 'loginService', 'registerService', 'Cart','sessionStorage',
		function($scope,$routeParams,$rootScope,$location,loginService,registerService,Cart,sessionStorage){
			$rootScope.globals={};
            if (sessionStorage.get("user")) {
              if(!$rootScope.globals){
                  $rootScope.globals={};
              }
              $rootScope.globals.currentUser=sessionStorage.get("user");
              if(sessionStorage.get("products")){
                  $rootScope.products=sessionStorage.get("products");
              }
            }
            if($rootScope.globals.currentUser){
                if($rootScope.globals.currentUser.authenticated)
                    $location.path('/stamps');
            }
            
            $scope.loginForm={};
			$scope.registerForm={};
            $scope.products = [];
            $scope.dataUser = {};
            $scope.dataUser.email = "";
            $scope.dataUser.password = "";
            $scope.passwordConfirm = "";
            $scope.test=function(){
                console.log("hola");
            };
			$scope.login = function (credentials) {
				loginService.login(credentials,function(response) {
            		if(response.success) {
                        loginService.SetCredentials(credentials,response);
                        $scope.loadProducts();
                    	$location.path('/stamps');

                	} else {
                		$scope.error= "Usuario y/o contraseña incorrectas";
                	}
            	});
        	};
            $scope.loadProducts=function(){
                var result = {};
                var user =sessionStorage.get("user");
                if ($rootScope.globals.currentUser.userType=='CLIENT'){
                    result= Cart.get({id:user.userId},
                        function(response){
                            $rootScope.products=response.products;
                            $rootScope.nroProdCart=$rootScope.products.length;
                            sessionStorage.set('products',$rootScope.products);
                    }
                );    
                }
                
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
