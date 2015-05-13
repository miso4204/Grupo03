'use strict';
angular.module('webAppApp')
  .controller('StampsCtrl', function($scope,$rootScope,$modal,Stamp,sessionStorage,Cart,StampId,ListArtist){
    $rootScope.globals={};
    $scope.artists = [];    

		if (sessionStorage.get("user")) {
      $rootScope.globals.currentUser=sessionStorage.get("user");
      if(sessionStorage.get("products")){
          $rootScope.products=sessionStorage.get("products");
      }
    }

    if ($rootScope.globals.currentUser.userType=='ARTIST' ){
      $scope.showStamps = true ;  
      $scope.showStampsAdmin = false ;  
    }else{
      $scope.showStamps = false ;  
      $scope.showStampsAdmin = true ;
    }

    $scope.$watch('viewStamps', function () {
     
      if ($scope.viewStamps =='Todas') {
        var result = {};
        result= Stamp.query(
          function(){
            $scope.stamps=result.stamps;
          }
        );  
      };
      
      if ($scope.viewStamps=='Artist') {
        var result = {};
        result= StampId.get({artistId:$rootScope.globals.currentUser.userId},
          function(){
            $scope.stamps=result.stamps;
          }
        );  
      };

    });
    $scope.searchValue="";
    $scope.$watch('viewStampsAdmin', function () {
     
      var result1 = {};
      result1= ListArtist.query(
          function(){
              $scope.artists=result1;
              console.log("artists");       
          }
      );
      
      if ($scope.viewStampsAdmin =='Todas') {
        var result = {};
        console.log("Admin")
        result= Stamp.query(
          function(){
            $scope.stamps=result.stamps;
          }
        );  
      }else {
        var result = {};
        result= StampId.get({artistId:$scope.viewStampsAdmin},
          function(){
            $scope.stamps=result.stamps;
          }
        );  
      };

    });
    $scope.openModal=function(mode){
      if(mode=="draw"){
        $modal.open(
        {
          templateUrl: 'drawStampModal.html',
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
      }else{
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
    if (sessionStorage.get("user")) {
      var result1 = {};
      var user =sessionStorage.get("user");
      if ($rootScope.globals.currentUser.userType=='CLIENT'){
        result1= Cart.get({id:user.userId},
            function(response){
                $rootScope.products=response.products;
                $rootScope.nroProdCart=$rootScope.products.length;
                sessionStorage.set('products',$rootScope.products);
            }
        );
      }
    }
    
	})

  .controller('CreateStampModalCtrl', function ($scope, $modalInstance,Stamp,$rootScope,newStamp,Upload) {
    $scope.newStamp=newStamp;
    $scope.stamp={}
    $scope.showAlert=false;
    $scope.alertError=false;
    $scope.addButton=true;
    $scope.imageLoaded=false;
    $scope.cancel = function () {
      $modalInstance.close();
    };
    $scope.addStamp=function(){
      var stamp = new Stamp();
      $scope.stamp.name=$scope.newStamp.stampName;
      $scope.stamp.price=$scope.newStamp.price;
      $scope.stamp.artistId=$rootScope.globals.currentUser.userId;
      if($scope.stamp.keyWords){
        $scope.stamp.keyWords=$scope.newStamp.keywords.toString().split(",");
      }else{
        $scope.stamp.keyWords=[];
      }
      if($scope.imageLoaded){
        //TODO Error handling on save
       Stamp.save($scope.stamp,function(response){
            $scope.showAlert=true;
            $scope.alertError=false;
            $scope.alertMessage="Se ha agregado tu estampa";
            $scope.addButton=false;
        })
      }else{
        $scope.showAlert=true;
        $scope.alertError=true;
        $scope.alertMessage="Agrega la imagen de tu estampa"
      }
    }
    //Canvas Upload
    $scope.uploadCanvas=function(){
      console.log("da");
      var canvas = document.getElementById('pwCanvasMain');
      var file=canvas.mozGetAsFile("canvas.png"); 
      var files=[];
      files.push(file);
      console.log(file);
      $scope.uploadFromCanvas(files);
    }

    //Image Upload//
    $scope.$watch('files', function () {
        $scope.upload($scope.files);
    });
    $scope.imageLoaded=false;
    $scope.upload = function (files) {
        if (files && files.length) {
            for (var i = 0; i < files.length; i++) {
                $scope.loadValue=0;
                var file = files[i];
                Upload.http({
                    url: 'https://api.imgur.com/3/image',
                    data: file,
                    headers: {
                      'Content-Type': file.type,
                      'Authorization':'Client-ID cc9ca4703814e55'
                    },
                }).progress(function (evt) {
                    $scope.loadValue = parseInt(100.0 * evt.loaded / evt.total);
                }).success(function (data, status, headers, config) {
                    $scope.stamp.url=data.data.link;
                    $scope.showAlert=false;
                    $scope.imageLoaded=true;
                    if(!$scope.$$phase) {
                      $scope.$apply();
                    }
                }).error(function(response){
                  $scope.showAlert=true;
                  $scope.alertError=true;
                  $scope.alertMessage="Ha ocurrido un error al subir la imagen"
                });
            }
        }
    };
    $scope.uploadFromCanvas = function (files) {
        if (files && files.length) {
            for (var i = 0; i < files.length; i++) {
                $scope.loadValue=0;
                var file = files[i];
                Upload.http({
                    url: 'https://api.imgur.com/3/image',
                    data: file,
                    headers: {
                      'Content-Type': file.type,
                      'Authorization':'Client-ID cc9ca4703814e55'
                    },
                }).progress(function (evt) {
                    $scope.loadValue = parseInt(100.0 * evt.loaded / evt.total);
                }).success(function (data, status, headers, config) {
                    $scope.stamp.url=data.data.link;
                    $scope.showAlert=false;
                    $scope.imageLoaded=true;
                    if(!$scope.$$phase) {
                      $scope.$apply();
                    }
                    $scope.addStamp();
                }).error(function(response){
                  $scope.showAlert=true;
                  $scope.alertError=true;
                  $scope.alertMessage="Ha ocurrido un error al subir la imagen"
                });
            }
        }
    };
  })

  .filter('keyWordsFilter',function(){
    return function(items, searchValue){
      if(items){
        var filtered=[];
        var len=items.length
        for (var i = 0 ;i<len;i++) {
          var item=items[i];
          var keywords = item.keyWords.toString();
          var name=item.name?item.name:""
          if(keywords.indexOf(searchValue)>-1 || name.indexOf(searchValue)>-1)
          filtered.push(item);        
        };
      }else{
        return;
      }
      return filtered;
    }
  })
