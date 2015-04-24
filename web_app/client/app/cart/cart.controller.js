'use strict';

angular.module('webAppApp')
  .controller('CartCtrl', ['$scope', '$routeParams','$rootScope', '$location', 'Cart', 'DelCart',
  	function($scope,$routeParams,$rootScope,$location,Cart,DelCart) {
    
    $scope.ErrorCartShow = false;
    $scope.products = [];
    var result = {};
    result= Cart.get({id:$rootScope.userId},
        function(){
            $scope.products=result.products;
            console.log($scope.products);
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

    $scope.deleteFromCart = function (product) {
	      	DelCart.delete({cartId:$scope.idCart, productId:product.id}, function() {
	      		console.log("eliminado correctamente")
	      		var result = {};
			    result= Cart.get({id:$rootScope.userId},
			        function(){
			            $scope.products=result.products;
			            console.log($scope.products);
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

    $scope.getTotal=function(){
        var total = 0;
        for (var i = 0; i < $scope.products.length; i++) {
            var product = $scope.products[i];
            total += (product.price);
        };
        return total;
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
        for (var i = 0; i < $scope.products.length; i++) {
            totalCant += 1;
        };
        return totalCant;
    }

  }])
