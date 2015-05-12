'use strict';

angular.module('webAppApp')
  .directive('productItem', function () {
    var controller=['$rootScope','CartP', '$scope','sessionStorage', 'Cart', function($rootScope,CartP,$scope,sessionStorage,Cart){
      
      $scope.addToCart=function(product){
        console.log(product)
        if(!$rootScope.products){
          $rootScope.products= []
        }
        $rootScope.products.push(product);
        sessionStorage.set('products',$rootScope.products);
        var prod={};
        prod.sta
        CartP.save(product,function(response){
          console.log(response);
          var result = {};
          result= Cart.get({id:$rootScope.globals.currentUser.userId},
              function(){
                        sessionStorage.remove("products");
                        $rootScope.products=result.products;
                        console.log($rootScope.products);
                        sessionStorage.set("products",$rootScope.products);
                        $scope.idCart = result.id;
                        $rootScope.nroProdCart = $rootScope.products.length;
                        console.log($rootScope.nroProdCart)
              }
          );
          $location.path('/products');
        })
      }
    }];
    return {
      templateUrl: 'app/products/productItem/productItem.html',
      restrict: 'EA',
      scope:{
      	product:"=product"
      },
      controller:controller,
      link: function (scope, element, attrs) {
      }
    };
  });

