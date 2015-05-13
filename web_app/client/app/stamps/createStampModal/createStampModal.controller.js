'use strict';

angular.module('webAppApp')
  .controller('CreateStampModalCtrl', function ($scope, $modalInstance,Stamp) {
  	$scope.ok = function () {
    	$modalInstance.close($scope.selected.item);
  	};
	$scope.cancel = function () {
    	$modalInstance.dismiss('cancel');
  	};
  	$scope.addStamp=function(data){
      console.log("SET");
      var stamp = new Stamp();
      stamp.name=data.stampName;
      stamp.price=data.price;
      stamp.url="https://i.imgur.com/mgkcT4G.png",
      stamp.artistId=$rootScope.globals.currentUser.userId;
      stamp.keyWords=data.keywords.toString().split(",");
      console.log(stamp)
      //Stamp.save(stamp,function(response){
      //  console.log(response)
      //})
    }

});