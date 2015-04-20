'use strict';

angular.module('webAppApp')
  .controller('PayCtrl', ['$scope', '$routeParams','$rootScope', '$location', 'payService', 
		function($scope,$routeParams,$rootScope,$location,payService){
    $scope.prods = [
		{name: 'Camiseta portero primera equipación Real Madrid Replica', genero: "Hombre", color: "Azul/Blanco", talla: "L", valor: 219900, cantidad: 1, url: "http://demandware.edgesuite.net/sits_pod20-adidas/dw/image/v2/aaqx_prd/on/demandware.static/Sites-adidas-CO-Site/Sites-adidas-products/es_CO/v1428309236102/zoom/S05454_01_laydown.jpg?sw=230&sfrm=jpg"},
		{name: 'Camiseta portero primera equipación Real Madrid Replica', genero: "Hombre", color: "Azul/Blanco", talla: "L", valor: 219900, cantidad: 1, url: "http://demandware.edgesuite.net/sits_pod20-adidas/dw/image/v2/aaqx_prd/on/demandware.static/Sites-adidas-CO-Site/Sites-adidas-products/es_CO/v1428309236102/zoom/G92151_000_plp_model.jpg?sw=230&sfrm=jpg"},
		{name: 'Camiseta portero primera equipación Real Madrid Replica', genero: "Hombre", color: "Azul/Blanco", talla: "L", valor: 219900, cantidad: 1, url: "http://demandware.edgesuite.net/sits_pod20-adidas/dw/image/v2/aaqx_prd/on/demandware.static/Sites-adidas-CO-Site/Sites-adidas-products/es_CO/v1428309236102/zoom/S05454_01_laydown.jpg?sw=230&sfrm=jpg"},
		{name: 'Camiseta portero primera equipación Real Madrid Replica', genero: "Hombre", color: "Azul/Blanco", talla: "L", valor: 219900, cantidad: 2, url: "http://demandware.edgesuite.net/sits_pod20-adidas/dw/image/v2/aaqx_prd/on/demandware.static/Sites-adidas-CO-Site/Sites-adidas-products/es_CO/v1428309236102/zoom/S05454_01_laydown.jpg?sw=230&sfrm=jpg"},
		{name: 'Camiseta portero primera equipación Real Madrid Replica', genero: "Hombre", color: "Azul/Blanco", talla: "L", valor: 219900, cantidad: 1, url: "http://demandware.edgesuite.net/sits_pod20-adidas/dw/image/v2/aaqx_prd/on/demandware.static/Sites-adidas-CO-Site/Sites-adidas-products/es_CO/v1428309236102/zoom/G92151_000_plp_model.jpg?sw=230&sfrm=jpg"},
		{name: 'Camiseta portero primera equipación Real Madrid Replica', genero: "Hombre", color: "Azul/Blanco", talla: "L", valor: 219900, cantidad: 1, url: "http://demandware.edgesuite.net/sits_pod20-adidas/dw/image/v2/aaqx_prd/on/demandware.static/Sites-adidas-CO-Site/Sites-adidas-products/es_CO/v1428309236102/zoom/S05454_01_laydown.jpg?sw=230&sfrm=jpg"},
		{name: 'Camiseta portero primera equipación Real Madrid Replica', genero: "Hombre", color: "Azul/Blanco", talla: "L", valor: 219900, cantidad: 1, url: "http://demandware.edgesuite.net/sits_pod20-adidas/dw/image/v2/aaqx_prd/on/demandware.static/Sites-adidas-CO-Site/Sites-adidas-products/es_CO/v1428309236102/zoom/S05454_01_laydown.jpg?sw=230&sfrm=jpg"}
	];

	$scope.formVisibility1 =false;
	$scope.formVisibility2 =false;
	$scope.formVisibility3 =false;

    $scope.ShowForm1 =function(){
		$scope.formVisibility1 =true; 
		$scope.formVisibility2 =false; 
		$scope.formVisibility3 =false;   	
    }

    $scope.ShowForm2 =function(){
		$scope.formVisibility1 =false; 
		$scope.formVisibility2 =true; 
		$scope.formVisibility3 =false;
    }

    $scope.ShowForm3 =function(){
		$scope.formVisibility1 =false; 
		$scope.formVisibility2 =false; 
		$scope.formVisibility3 =true;   	
    }

    $scope.getTotal=function(){
    	var total = 0;
    	for (var i = 0; i < $scope.prods.length; i++) {
    	 	var product = $scope.prods[i];
    	 	total += (product.valor * product.cantidad);
    	};
    	return total;
    }

    $scope.getCantidad=function(){
    	var totalCant = 0;
    	for (var i = 0; i < $scope.prods.length; i++) {
    	 	var product1 = $scope.prods[i];
    	 	totalCant += (product1.cantidad);
    	};
    	return totalCant;
    }

 	}])
