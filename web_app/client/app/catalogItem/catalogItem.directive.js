'use strict';

angular.module('webAppApp')
  .directive('catalogItem', function(){
  	
	return{
		restrict:'EAC',
		template: '<ng-include src="getTemplateUrl()"/>',
		scope:{
			stamp:'=stamp',
			viewMode:'=viewMode',
		},
		link:function($scope){
			
			$scope.getTemplateUrl=function(){
				console.log("llego****"+ $scope.viewMode)
				console.log("llego****"+ $scope.stamp.price)
				if($scope.viewMode=="grid"){
					console.log("grid")
					return 'app/catalogItem/productGridItem.html';
				}
				if($scope.viewMode=="list"){
					console.log("list")
					return 'app/catalogItem/productListItem.html';
				}else{
					return 'app/catalogItem/productGridItem.html';
				}
			}
		},
	}
 	})

  .controller('catalogItem', function ($scope,rateService) {
    $scope.isRate = true; 

    $scope.rateFunction = function (rate1) {
        $scope.rate.stampId = $scope.stamp.id;
        rateService.Rate(rate1,function(response, status) {
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
                            $scope.REJECTEDShow = true;
                        }
                    } else {
                        $scope.REJECTEDShow = true;
                    }
                });
          
        }     
    
  });