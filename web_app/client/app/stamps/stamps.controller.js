'use strict';
angular.module('webAppApp')
  .controller('StampsCtrl', function($scope,$rootScope,$cookieStore,Stamp,sessionStorage,Cart){
		if (sessionStorage.get("user")) {
      if(!$rootScope.globals){
          $rootScope.globals={};
      }
      $rootScope.globals.currentUser=sessionStorage.get("user");
      if(sessionStorage.get("products")){
          $rootScope.products=sessionStorage.get("products");
      }
    }

		var result = {};
		result=	Stamp.query(
			function(){
				$scope.stamps=result.stamps;
			}
		);

    $scope.addStamp=function(){
      console.log("SET");
      var stamp = new Stamp();
      stamp.name=newStamp.data.stampName;
      stamp.price=newStamp.data.price;
      stamp.url="https://i.imgur.com/mgkcT4G.png",
      stamp.artistId=$rootScope.globals.currentUser.userId;
      stamp.keyWords=newStamp.data.keywords.toString().split(",");
      console.log(stamp)
      //Stamp.save(stamp,function(response){
      //  console.log(response)
      //})
      
    }
    $scope.createStamp=function(){
      console.log("SET");
    }
		$scope.viewOptions={
 			viewMode:'grid',
 			sortBy:'',
 		}

    var result1 = {};
    var user =sessionStorage.get("user");
    result1= Cart.get({id:user.userId},
        function(response){
            $rootScope.products=response.products;
            $rootScope.nroProdCart=$rootScope.products.length;
            sessionStorage.set('products',$rootScope.products);
        }
    );
	})
