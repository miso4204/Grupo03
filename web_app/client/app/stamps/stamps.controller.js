'use strict';
angular.module('webAppApp')
  .controller('StampsCtrl', function($scope,$rootScope,$modal,Stamp,sessionStorage,Cart){
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

 
    $scope.open = function () {
      $modal.open(
        {
          templateUrl: 'createStampModal.html',
          controller: 'CreateStampModalCtrl',
          size: 's',
          backdrop: true,
           resolve: {
              newStamp: function () {
                  return $scope.newStamp;
              },
          }
        }
      )
    }


    $scope.createStamp=function(){
      console.log("SET");
    }
    $scope.newStamp={
      stampName:null,
      price:null,
      keywords:null
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


  .controller('CreateStampModalCtrl', function ($scope, $modalInstance,Stamp,$rootScope,newStamp,Upload) {
    $scope.newStamp=newStamp;
    $scope.stamp={}
    $scope.crear = function () {
      $modalInstance.close($scope.selected.item);
    };
     $scope.cancel = function () {
      $modalInstance.dismiss('cancel');
    };
    $scope.addStamp=function(){
      console.log(newStamp)
        var stamp = new Stamp();
        $scope.stamp.name=newStamp.stampName;
        $scope.stamp.price=newStamp.price;
        $scope.stamp.artistId=$rootScope.globals.currentUser.userId;
        $scope.stamp.keyWords=newStamp.keywords.toString().split(",");
        console.log($scope.stamp)
        Stamp.save($scope.stamp,function(response){
          console.log(response)
        })
    }

   //Image Upload//
    $scope.$watch('files', function () {
        $scope.upload($scope.files);
        console.log("test")
    });
    $scope.imageLoaded=false;
    $scope.upload = function (files) {
        if (files && files.length) {
            for (var i = 0; i < files.length; i++) {
                var file = files[i];
                Upload.http({
                    url: 'https://api.imgur.com/3/image',
                    data: file,
                    headers: {
                      'Content-Type': file.type,
                      'Authorization':'Client-ID cc9ca4703814e55'
                    },
                }).progress(function (evt) {
                    var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                    console.log(progressPercentage+" :%")
                }).success(function (data, status, headers, config) {
                    $scope.stamp.url=data.data.link;
                    $scope.imageLoaded=true;
                    if(!$scope.$$phase) {
                      $scope.$apply();
                    }
                }).error(function(response){
                  console.log(response)
                });
            }
        }
    };
  })

  .controller('UploadCtrl', ['$scope', 'Upload', function ($scope, Upload) {

}]);