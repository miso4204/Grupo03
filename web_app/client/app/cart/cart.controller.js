'use strict';

angular.module('webAppApp')
  .controller('CartCtrl', ['$scope', '$routeParams','$rootScope', '$location', 'Cart', 'DelCart','sessionStorage',
  	function($scope,$routeParams,$rootScope,$location,Cart,DelCart,sessionStorage) {
    $scope.ErrorCartShow = false;
    if (sessionStorage.get("user")) {
        if(!$rootScope.globals){
            $rootScope.globals={};
        }
        $rootScope.globals.currentUser=sessionStorage.get("user");

        var result= Cart.get({id:$rootScope.globals.currentUser.userId},
            function(){
                sessionStorage.remove("products");
                $rootScope.products=result.products;
                sessionStorage.set("products",$rootScope.products);
                console.log($rootScope.products);
                $scope.idCart = result.id;
                $rootScope.nroProdCart = $scope.getCantidad();
                console.log($scope.dataPay)

                if ($rootScope.nroProdCart == 0){
                    $scope.nroProdsCart = true;
                } else {
                    $scope.nroProdsCart = false;
                }
            }
        );
    }
    
    $scope.deleteFromCart = function (product) {
	      	DelCart.delete({cartId:$scope.idCart, productId:product.id}, function() {
	      		console.log("eliminado correctamente")
	      		var result = {};
			    result= Cart.get({id:$rootScope.userId},
			        function(){
                        sessionStorage.remove("products");
			            $rootScope.products=result.products;
			            console.log($rootScope.products);
                        sessionStorage.set("products",$rootScope.products);
			            $scope.idCart = result.id;
			            $rootScope.nroProdCart = $scope.getCantidad();
			            console.log($scope.dataPay)
                        if ($rootScope.nroProdCart == 0){
                            $scope.nroProdsCart = true;
                        } else {
                            $scope.nroProdsCart = false;
                        }
			        }
			    );
	      		$location.path('/cart');
			});
    };
    $scope.goPay=function(){
        if ($rootScope.nroProdCart == 0){
            $scope.ErrorCartShow = true;
        } else {
            $scope.ErrorCartShow = false;
            $location.path('/pay');
        }
    };

    $scope.getCantidad=function(){
        var totalCant = 0;
        for (var i = 0; i < $rootScope.products.length; i++) {
            totalCant += 1;
        };
        return totalCant;
    }
    $scope.getTotal=function() {
        var total = 0;
        if($rootScope.products){
            for (var i = 0; i < $rootScope.products.length; i++) {
                var product = $rootScope.products[i];
                total += (product.price);
            };
        }
        return total;
    };

  }])
