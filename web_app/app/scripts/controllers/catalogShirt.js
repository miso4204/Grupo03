'use strict';

/**
 * @ngdoc function
 * @name shirtsApp.controller:catalogShirtCtrl
 * @description
 * # catalogShirtCtrl
 * Controller of the shirtsApp
 */
 angular.module('shirtsApp')
 	.controller('catalogShirtCtrl',function($scope){
 		$scope.size={
 			status : {open:true},
 			values : [{name:'small',display:'S'}, {name:'medium',display:'M'}, {name:'large',display:'L'},{name:'xlarge',display:'XL'}],
 		}
 		$scope.genre={
 			status : {open:true},
 			values : [{name:'male',display:'Hombre'}, {name:'female',display:'Mujer'}, {name:'unisex',display:'Unisex'}]
 		}
 		$scope.type={
 			status : {open:true},
 			values :[
 				{name:'clasica',display:'Clasica'},{name:'cuelloV',display:'Cuello V'},
 				{name:'mangaLarga',display:'Manga Larga'},{name:'esqueleto',display:'Esqueleto'}
 				],
 		}
 		$scope.color={
 			status : {open:true},
 			values : [
	 			{name:'rojo', code:'#A10000'},
	 			{name:'azul rey', code:'#3399FF'},
	 			{name:'azul', code:'#000080'},
	 			{name:'blanco',code:'#FFFFFF'},
	 			{name:'verde', code:'#009933'},
	 			{name:'negro',code:'#000000'},
	 			{name:'naranja', code:'#FF9900'},
	 			{name:'marron',code:'#663300'},
	 			{name:'magenta',code:'#FF66FF'},
	 			{name:'verde claro',code:'#00CC00'},
	 			{name:'amarillo',code:'#FFCC00'},
	 			{name:'lila',code:'#6600CC'},
 			]
 		}
 		$scope.price={
 			status:{open:true},
 			min:0,
 			max:0,
 		}
 		$scope.filters={
 			genre:{
 				male:false,
 				female:false,
 				unisex:true,
 			},
 			size:{
 				small:false,
 				medium:false,
 				large:false,
 				xlarge:false,
 			},
 			type:{
 				clasica:true,
 				cuelloV:false,
 				mangaLarga:false,
 				esqueleto:false,
 			},
 			color:'',
 			price:{
 				min:0,
 				max:0,
 			},
 			searchBox:'',
 		}
 		$scope.filterFuction=function (product) {
 			if($scope.filters.searchBox!=''){
 				return product.keyWords.indexOf($scope.filters.searchBox)>-1;
 			}else{
 				return true;
 			}
 		}
 		$scope.viewOptions={
 			viewMode:'list',
 			sortBy:'',
 		}
 		$scope.products={
 			total:5,
 			products:[
 				{
 					productId:'0000001',
 					name:'Camiseta de James', 
 					price:'80.000', 
 					averageRating:4, 
 					ratings:48,
 					availableColors:[
 						{name:'rojo', code:'#A10000'},
 						{name:'azul rey', code:'#3399FF'},
 						{name:'azul', code:'#000080'},
 					],
 					availableSizes:[
 						{name:'small',display:'S'}, 
 						{name:'medium',display:'M'}, 
 						{name:'large',display:'L'},
 						{name:'xlarge',display:'XL'}
 					],
 					shippingPrice:'5',
 					imgUrl:'http://www.realmadridjerseyspro.com/images/real_madrid/fc-real-madrid_267.jpg',
 					keyWords:['james','real madrid','futbol']
				},
				{
 					productId:'0000002',
 					name:'Camiseta de Falcao', 
 					price:'85.000', 
 					averageRating:5, 
 					ratings:25,
 					availableColors:[
 						{name:'rojo', code:'#A10000'},
 						{name:'azul rey', code:'#3399FF'},
 						{name:'azul', code:'#000080'},
 					],
 					availableSizes:[
 						{name:'small',display:'S'}, 
 						{name:'medium',display:'M'}, 
 						{name:'large',display:'L'},
 						{name:'xlarge',display:'XL'}
 					],
 					shippingPrice:0,
 					imgUrl:'http://www.sportarena.gr/Uploads/Product-Images/17841/Manchester_Utd_1415_home_FALCAO_611031_624_b_s_b1.jpg',
 					keyWords:['falcao','manchester','9', 'futbol']
				},
				{
 					productId:'0000003',
 					name:'Camiseta de Cuadrado', 
 					price:'82.000', 
 					averageRating:'4.7', 
 					ratings:48,
 					availableColors:[
 						{name:'rojo', code:'#A10000'},
 						{name:'azul rey', code:'#3399FF'},
 						{name:'azul', code:'#000080'},
 					],
 					availableSizes:[
 						{name:'small',display:'S'}, 
 						{name:'medium',display:'M'}, 
 						{name:'large',display:'L'},
 						{name:'xlarge',display:'XL'}
 					],
 					shippingPrice:0,
 					imgUrl:'http://www.soccerofficialonline.com/images/products/soccer_jerseys/club/chelsea/fc-chelsea_595.jpg',
 					keyWords:['cuadrado','chelsea','futbol','23']
				},
			],
 		}
 	});
