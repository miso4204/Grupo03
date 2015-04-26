'use strict';

angular.module('webAppApp')
  .controller('StampDetailCtrl',
  	function ($scope,$routeParams,$rootScope,Stamp,sessionStorage,Cart,$location) {
      if (sessionStorage.get("user")) {
        if(!$rootScope.globals){
            $rootScope.globals={};
        }
        $rootScope.globals.currentUser=sessionStorage.get("user");
        if(sessionStorage.get("products")){
            $rootScope.products=sessionStorage.get("products");
        }
      }

  		$scope.stamp = Stamp.get({id:$routeParams.id});
  		$scope.shirtOptions={
  			gender:{
  				female:{
  					value:"F",
  					name:"Mujer",
  					url:"http://i.imgur.com/EFb17uK.png",
            urlm:"http://i.imgur.com/EFb17uKt.png",
  					price:12000
	  			},
	  			male:{
	  				value:"M",
	  				name:"Hombre",
	  				url:"http://i.imgur.com/UTpxQpN.png",
            urlm:"http://i.imgur.com/UTpxQpNt.png",
	  				price:15000
	  			}
  			},
  			color:{
  				red:{
  					name:"red",
  					code:"#FF1919"
  				},
  				blue:{
  					name:"blue",
  					code:"#000066"
  				},
  				yellow:{
  					name:"yellow",
  					code:"#FFCC00"
  				},
  				green:{
  					name:"green",
  					code:"#009900"
  				},
  				white:{
  					name:"white",
  					code:"#FFFFFF"
  				},
  				gray:{
  					name:"gray",
  					code:"#B2B2B2"
  				},
  				black:{
  					name:"black",
  					code:"#000000"
  				},
  			},
  			size:{
  				small:{
  					name:"Small",
  					value:"S"
  				},
  				medium:{
  					name:"Medium",
  					value:"M"
  				},
  				large:{
  					name:"Large",
  					value:"L"
  				},
  				xlarge:{
  					name:"Extra Large",
  					value:"XL"
  				},
  			}
  		};

   		
      $scope.currentProduct={
        stampId:$routeParams.id,
  			size:"M",
  			color:"green",
  			gender:"male",
  			stamp:$routeParams.id,
  			text:{
  				color:"red",
  				value:""
  			},
        price:0,
  		};
      $scope.calcPrice=function(){
        return $scope.stamp.price + $scope.shirtOptions.gender[$scope.currentProduct.gender].price;
      };
      $scope.addToCart=function(product){
        if(!$rootScope.products){
          $rootScope.products= []
        }

        $scope.currentProduct.price=$scope.calcPrice();
        $scope.currentProduct.url=$scope.stamp.url;
        $scope.currentProduct.colorCode=$scope.shirtOptions.color[$scope.currentProduct.color].code;
        $rootScope.products.push(product);
        sessionStorage.set('products',$rootScope.products);
        var prod = new Cart();
        prod.stampId=$scope.currentProduct.stampId;
        prod.price=$scope.currentProduct.price;
        prod.shippingPrice=5000;
        prod.size=$scope.currentProduct.size;
        prod.color=$scope.currentProduct.color.toUpperCase();
        prod.url=$scope.stamp.url;
        prod.text=$scope.currentProduct.text.value;
        console.log($rootScope.globals.currentUser.userId)
        prod.userId=$rootScope.globals.currentUser.userId

        Cart.save(prod,function(response){
          console.log(response);
          $location.path('/stamps');
        })
        
      };
  });
