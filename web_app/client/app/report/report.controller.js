'use strict';

angular.module('webAppApp')
  .controller('ReportCtrl',  ['$scope','$filter', '$routeParams','$rootScope', '$location', 'ngTableParams', 'ReportSalesId', 'ReportSalesPeriod',
  	'ReportRatingId', 'ReportRatings',
  	function ($scope,$filter, $routeParams,$rootScope,$location,ngTableParams,ReportSalesId,ReportSalesPeriod,ReportRatingId,ReportRatings) {
  		$scope.reportPeriodForm = {};
  		$scope.sales = [];
  		$scope.stamps = [];
  		$scope.limiteBajo = '';
  		$scope.limiteAlto = '';
  		var result = {};
		    result= ReportSalesId.get({id:1},
		        function(){
		            $scope.sales=result.sales;
		            console.log($scope.sales);       
		        }
		    );

  		$scope.SalesIdShow = true;
  		$scope.SalesPeriodShow = false;
  		$scope.RatingIdShow = false;
  		$scope.RatingsShow = false;
  		$scope.ReportPeriodShow = false;
  		$scope.ErrorFechaShow = false;

  	  	$scope.salesId = function () {
	  		$scope.SalesIdShow = true;
  			$scope.SalesPeriodShow = false;
  			$scope.RatingIdShow = false;
  			$scope.RatingsShow = false;
  			$scope.ReportPeriodShow = false;
  			$scope.ErrorFechaShow = false;
  			var result = {};
		    result= ReportSalesId.get({id:1},
		        function(){
		            $scope.sales=result.sales;
		            console.log($scope.sales);       
		        }
		    );
  	  	}

  	  	$scope.salesPeriod = function () {
	  		$scope.SalesIdShow = false;
  			$scope.SalesPeriodShow = true;
  			$scope.RatingIdShow = false;
  			$scope.RatingsShow = false;
  			$scope.ErrorFechaShow = false;
  			$scope.ReportPeriodShow = false;
  			$scope.ErrorFechaShow = false;
  	  	}

  	  	$scope.genReport = function (dataPeriod) {
	  		if ($scope.limiteBajo > $scope.limiteAlto) {
	  			$scope.ErrorFechaShow = true;		
	  			$scope.ReportPeriodShow = false;
	  		} else {
	  			$scope.ErrorFechaShow = false;
	  			$scope.ReportPeriodShow = true;
	  			var result = {};
		    	result=	ReportSalesPeriod.get({limiteBajo:dataPeriod.limiteIni, limiteAlto:dataPeriod.limiteFin}, function() {
				    $scope.sales=result.sales;
		            console.log($scope.sales);  
				});
	  		}
  	  	}

  	  	$scope.ratingId = function () {
	  		$scope.SalesIdShow = false;
  			$scope.SalesPeriodShow = false;
  			$scope.RatingIdShow = true;
  			$scope.RatingsShow = false;
  			$scope.ReportPeriodShow = false;
  			$scope.ErrorFechaShow = false;
  			var result = {};
		    result= ReportRatingId.get({artistaId:1},
		        function(){
		            $scope.stamps=result.stamps;
		            console.log($scope.stamps);       
		        }
		    );
  	  	}

  	  	$scope.ratings = function () {
	  		$scope.SalesIdShow = false;
  			$scope.SalesPeriodShow = false;
  			$scope.RatingIdShow = false;
  			$scope.RatingsShow = true;
  			$scope.ReportPeriodShow = false;
  			$scope.ErrorFechaShow = false;
  			var result = {};
		    result= ReportRatings.get(
		        function(){
		            $scope.stamps=result.stamps;
		            console.log($scope.stamps);       
		        }
		    );
  	  	}

	  	$scope.clear = function () {
	    	$scope.dt = null;
	  	};

	  	$scope.open1 = function($event) {
	    	$event.preventDefault();
	    	$event.stopPropagation();

		    $scope.opened1 = true;
		    $scope.opened2 = false;
	  	};

	  	$scope.open2 = function($event) {
	    	$event.preventDefault();
	    	$event.stopPropagation();

	    	$scope.opened1 = false;
	    	$scope.opened2 = true;
	  	};

	  	$scope.dateOptions = {
	    	format: 'yyyy-MM-dd',
	    	startingDay: 1,
	    	pickTime: false
	  	};

	  	$scope.tableParams = new ngTableParams({
	        page: 1,            // show first page
	        count: 10,          // count per page
	        sorting: {
	            name: 'asc'     // initial sorting
	        }
	    });

	  	$scope.formats = ['dd-MMMM-yyyy', 'yyyy-MM-dd', 'dd.MM.yyyy', 'shortDate'];
	  	$scope.format = $scope.formats[1];
  }]);
