'use strict';

angular.module('webAppApp')
  .controller('PayCtrl',['$scope', '$routeParams','$rootScope', '$location', 'Cart', 'payService', 
        function($scope,$routeParams,$rootScope,$location,Cart,payService){
            $scope.payForm1={};
            $scope.payForm2={};
            $scope.payForm3={}; 
            $scope.products = [];
            $scope.dataPay = {};
            var result = {};
            result= Cart.get({id:$rootScope.userId},
                function(){
                    $scope.products=result.products;
                    console.log($scope.products);
                    $rootScope.nroProdCart = $scope.getCantidad();
                    $scope.dataPay.price = $scope.getTotal();
                    $scope.dataPay.cartId = result.id;
                    console.log($scope.dataPay)
                }
            );

            $scope.formVisibility1 =false;
            $scope.formVisibility2 =false;
            $scope.formVisibility3 =false;

            $scope.ShowForm1 =function(){
                $scope.formVisibility1 =true; 
                $scope.formVisibility2 =false; 
                $scope.formVisibility3 =false;      
            }

            $scope.ShowForm2 =function(){
                $scope.formVisibility1 =false; 
                $scope.formVisibility2 =true; 
                $scope.formVisibility3 =false;
            }

            $scope.ShowForm3 =function(){
                $scope.formVisibility1 =false; 
                $scope.formVisibility2 =false; 
                $scope.formVisibility3 =true;       
            }

            $scope.getTotal=function(){
                var total = 0;
                for (var i = 0; i < $scope.products.length; i++) {
                    var product = $scope.products[i];
                    total += (product.price);
                };
                return total;
            }

            $scope.getCantidad=function(){
                var totalCant = 0;
                for (var i = 0; i < $scope.products.length; i++) {
                    totalCant += 1;
                };
                return totalCant;
            }

            $scope.pay = function (dataPay) {
                console.log($location)
                console.log(dataPay)
                payService.Pay(dataPay,function(response, status) {
                    console.log(status);
                    if(status == 200) {
                        console.log("Register responsed" + response)
                        $scope.regSuccess= "Registro exitoso, por favor Inicie Sesión";
                        $scope.regSuccessShow = true;
                        $scope.regErrorShow = false;
                        $scope.dataPay.type = "CREDIT_CARD";
                    } else {
                        console.log(status);
                        console.log("register failed" + response)
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
                };

    }])


	