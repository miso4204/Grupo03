'use strict';

angular.module('webAppApp')
  .directive('productItem', function () {
    var controller=['$rootScope','CartP', '$scope','sessionStorage', function($rootScope,CartP,$scope,sessionStorage){
      
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

