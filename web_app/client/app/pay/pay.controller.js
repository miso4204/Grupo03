'use strict';

angular.module('webAppApp')
  .controller('PayCtrl', 
        function($scope,$routeParams,$rootScope,$location,Cart,payService,sessionStorage){
             if (sessionStorage.get("user")) {

                if(!$rootScope.globals){
                    $rootScope.globals={};
                }
                $rootScope.globals.currentUser=sessionStorage.get("user");
                if(sessionStorage.get("products")){
                    $rootScope.products=sessionStorage.get("products");
                }
            }
            $scope.payForm1={};
            $scope.payForm2={};
            $scope.payForm3={}; 
            $scope.products = [];
            $scope.dataPay = {};
            $scope.responsePay = {}
            $scope.payVisibility = true;
            $scope.APPROVEDShow = false;
            $scope.REJECTEDShow = false;
            $scope.DELIVERYShow = false;
            var result = {};
            result= Cart.get({id:$rootScope.globals.currentUser.userId},
                function(){
                    $scope.products=result.products;
                    console.log($scope.products);
                    $rootScope.nroProdCart = $scope.getCantidad();
                    $scope.dataPay.price = $scope.getTotal();
                    $scope.dataPay.cartId = result.id;
                    console.log($scope.dataPay)
                    if ($rootScope.nroProdCart == 0){
                        $scope.nroProdsCart = true;
                    } else {
                        $scope.nroProdsCart = false;
                    }
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
                for (var i = 0; i < $rootScope.products.length; i++) {
                    var product = $rootScope.products[i];
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

            $scope.terminar=function(){
                $location.path('/stamps');
            };

            $scope.regresar=function(){
                $location.path('/cart');
            };

            $scope.pay = function (dataPay) {
                console.log($location)
                console.log(dataPay)
                payService.Pay(dataPay,function(response, status) {
                    console.log(status);
                    $scope.payVisibility = false;
                    if(status == 200) {
                        $scope.responsePay = response;
                        if (response.status == "APPROVED"){
                            $scope.APPROVEDShow = true;
                            result= Cart.get({id:$rootScope.userId},
                                function(){
                                    $scope.products=result.products;
                                    console.log($scope.products);
                                    $rootScope.nroProdCart = $scope.getCantidad();
                                    console.log($scope.dataPay)
                                    if ($rootScope.nroProdCart == 0){
                                        $scope.nroProdsCart = true;
                                    } else {
                                        $scope.nroProdsCart = false;
                                    }
                                }
                            );
                        } else {
                            if (response.status == "WAITING_FOR_PAYMENT"){
                                $scope.DELIVERYShow = true;
                            } else {
                                $scope.REJECTEDShow = true;
                            }
                        }
                    } else {
                        $scope.REJECTEDShow = true;
                    }
                });
                };

    })


	