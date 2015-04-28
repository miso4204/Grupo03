'use strict';

angular.module('webAppApp')
  .controller('ReportCtrl',  ['$scope','$filter', '$routeParams','$rootScope', '$location', 'ngTableParams', 'ReportSalesId', 'ReportSalesPeriod',
  	'ReportRatingId', 'ReportRatings', 'sessionStorage', 'ListArtist',
  	function ($scope,$filter, $routeParams,$rootScope,$location,ngTableParams,ReportSalesId,ReportSalesPeriod,ReportRatingId,ReportRatings,sessionStorage,ListArtist) {
  		$scope.reportPeriodForm = {};
  		$scope.idsales = [];
  		$scope.sales = [];
  		$scope.artists = [];
  		$scope.idstamps = [];
  		$scope.stamps = [];
  		$scope.limiteBajo = '';
  		$scope.limiteAlto = '';
  		$scope.RatingArtist = null;
  		$scope.SalesArtist = null;
  		var data = [];
  		
  		if (sessionStorage.get("user")) {
	        if(!$rootScope.globals){
	            $rootScope.globals={};
	        }
	        $rootScope.globals.currentUser=sessionStorage.get("user");
	    }

	    var result = {};
	    result= ListArtist.query(
	        function(){
	            $scope.artists=result;
	            console.log($scope.artists);       
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
  	  	}

  	  	$scope.$watch('SalesArtist', function () {
  	  		if ($scope.SalesArtist != null){
	        var result = {};
		    result= ReportSalesId.get({id:$scope.SalesArtist},
		        function(){
		            $scope.idsales=result.sales;
		            console.log($scope.idsales);       
		        }
		    );
			} 
    	});

  	  	$scope.salesPeriod = function () {
	  		$scope.SalesIdShow = false;
  			$scope.SalesPeriodShow = true;
  			$scope.RatingIdShow = false;
  			$scope.RatingsShow = false;
  			$scope.ErrorFechaShow = false;
  			$scope.ReportPeriodShow = false;
  			$scope.ErrorFechaShow = false;
  	  	}

  	  	$scope.genReportPeriod = function (dataPeriod) {
  	  		$scope.limiteBajo = $filter('date')(dataPeriod.limiteIni, 'yyyy-MM-dd');
  	  		$scope.limiteAlto = $filter('date')(dataPeriod.limiteFin, 'yyyy-MM-dd');
	  		if (dataPeriod.limiteIni > dataPeriod.limiteFin) {
	  			$scope.ErrorFechaShow = true;		
	  			$scope.ReportPeriodShow = false;
	  		} else {
	  			$scope.ErrorFechaShow = false;
	  			$scope.ReportPeriodShow = true;
	  			$scope.sales=[];
	  			var result = {};
		    	result=	ReportSalesPeriod.get({limiteBajo:$scope.limiteBajo, limiteAlto:$scope.limiteAlto}, function() {
				    $scope.sales=result.sales;
		            console.log($scope.sales);
		            $scope.data = []; 
		            for (var i = 0; i < $scope.sales.length; i++) {
		            	data.push({
		            		artistName : $scope.sales[i].stamp.artistName,
	                    	id : $scope.sales[i].stamp.id,
	                    	url : $scope.sales[i].stamp.url,
	                    	name : $scope.sales[i].stamp.name,
	                    	price : $scope.sales[i].stamp.price,
	                    	numberSales : $scope.sales[i].numberSales,
	                    	total : (($scope.sales[i].numberSales)*($scope.sales[i].stamp.price)),
		            	})
	                }; 
	                console.log(data)
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
  			
  	  	}

  	  	$scope.$watch('RatingArtist', function () {
  	  		if ($scope.RatingArtist != null){
  	  		console.log("aqui")
	        var result = {};
	        $scope.stamps=[];
	        console.log($scope.idstamps);       
		    result= ReportRatingId.get({artistaId:$scope.RatingArtist},
		        function(){
		            $scope.idstamps=result.stamps;
		            console.log($scope.idstamps);       
		        }
		    );
			}
    	});

  	  	$scope.ratings = function () {
	  		$scope.SalesIdShow = false;
  			$scope.SalesPeriodShow = false;
  			$scope.RatingIdShow = false;
  			$scope.RatingsShow = true;
  			$scope.ReportPeriodShow = false;
  			$scope.ErrorFechaShow = false;
  			var result = {};
  			$scope.stamps=[];
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

	  	$scope.tableParams1 = new ngTableParams({
	        page: 1,            // show first page
	        count: 10,          // count per page
	        sorting: {
	            artist: 'asc'     // initial sorting
	        }
	    }, {
		        total: data.length, // length of data
		        getData: function($defer, params) {
		            // use build-in angular filter
		            var orderedData = params.sorting() ? $filter('orderBy')(data, params.orderBy()) : data;

                	$defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
		        }
	    });

	  	$scope.formats = ['dd-MMMM-yyyy', 'yyyy-MM-dd', 'dd.MM.yyyy', 'shortDate'];
	  	$scope.format = $scope.formats[1];
  }]);
