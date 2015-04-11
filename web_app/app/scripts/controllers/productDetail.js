'use strict';

/**
 * @ngdoc function
 * @name shirtsApp.controller:productDetailCtrl
 * @description
 * #productDetailCtrl
 * Controller of the shirtsApp
 */

  angular.module('shirtsApp')
  	.controller('productDetailCtrl', function($scope,$routeParams){
  		$scope.productId=$routeParams.productId;
  		if($scope.productId=="0000001"){
  			$scope.productInfo={
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
			images:[
				{
					image:'http://image-load-balancer.worldsportshops.com/Images/watermarked_thumbnail.aspx?img=71063~JAMES~10.RE02&photoNum=T1&t=I&catalog=Soccer&w=600&h=600',
					text:'Frente'
				},
				{
					image:'http://image-load-balancer.worldsportshops.com/Images/watermarked_thumbnail.aspx?img=71063~JAMES~10&photoNum=1&t=I&catalog=Soccer&w=600&h=600',
					text:'Espalda'
				},
			],
			keyWords:['james','real madrid','futbol']
			}
		}
		if($scope.productId=="0000002"){
			$scope.productInfo={
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
 					images:[
						{
							image:'http://image-load-balancer.worldsportshops.com/Datafeeds/Graphics/Products/ImageCache/600x600/66368~FALCAO~9.RE02.jpg',
							text:'Frente'
						},
						{
							image:'http://image-load-balancer.worldsportshops.com/Datafeeds/Graphics/Products/ImageCache/600x600/66368~FALCAO~9.jpg',
							text:'Espalda'
						},
					],
 					keyWords:['falcao','manchester','9', 'futbol']
				}
		}
  			
		if($scope.productId=="0000003"){
			$scope.productInfo={
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
 					images:[
						{
							image:'http://image-load-balancer.worldsportshops.com/Images/watermarked_thumbnail.aspx?img=92151&photoNum=1&t=I&catalog=Soccer&w=600&h=600',
							text:'Frente'
						},
						{
							image:'http://image-load-balancer.worldsportshops.com/Images/watermarked_thumbnail.aspx?img=92151~CUADRADO~23&photoNum=1&t=I&catalog=Soccer&w=600&h=600',
							text:'Espalda'
						},
					],
 					keyWords:['cuadrado','chelsea','futbol','23']
				}
		}
  			
		$scope.productOrder={
			productId:$scope.productId,
			selectedColor:{
				name:'',
				code:''
			},
			selectedSize:{
				name:''
			}
		}
  	})