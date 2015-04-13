'use strict';

/**
* @ngdoc function
* @ngane shirtsApp.controller:stampCatalogCtrl
* @description
* #stampCatalogCtrl
* Controller o the shirstApp
*
*/

angular.module('shirtsApp')
	.controller('stampCatalogCtrl', function($scope){
		$scope.filter={
			categories:['memes','sports','tv','comics','super heros','video games']
		}
		$scope.stamps=[
			{
				url:"http://cdn4.colorlib.com/wp/wp-content/uploads/sites/2/2014/02/2016_Rio_Summer_Olympics_logo.png",
				author:{
					id:1,
					name:"John Doe"
				},
				rating:4,
				price:145000.0,
				keyWords:["olimpicos","juegos","rio"],
				name:"Olimpicos rio",
				id:1
			},
			{
				url:"http://th01.deviantart.net/fs70/PRE/i/2012/290/8/0/gangnam_style_1_by_belu_cute-d5i4daz.png",
				author:{
					id:1,
					name:"John Doe"
				},
				rating:4,
				price:145000.0,
				keyWords:["psy","gangman","meme"],
				name:"PSY",
				id:2
			},
			{
				url:"https://d13yacurqjgara.cloudfront.net/users/16705/screenshots/1000396/stark.jpg",
				author:{
					id:1,
					name:"John Doe"
				},
				rating:4,
				price:145000.0,
				keyWords:["Got","Stark","Game of Thrones"],
				name:"Stark Logo",
				id:3
			},
			{
				url:"http://th01.deviantart.net/fs70/PRE/i/2012/290/8/0/gangnam_style_1_by_belu_cute-d5i4daz.png",
				author:{
					id:1,
					name:"John Doe"
				},
				rating:4,
				price:145000.0,
				keyWords:["psy","gangman","meme"],
				name:"PSY",
				id:2
			},
			{
				url:"https://s-media-cache-ak0.pinimg.com/236x/4f/a6/94/4fa6946dbe07a6700a71bc3269a5f01f.jpg",
				author:{
					id:1,
					name:"John Doe"
				},
				rating:4,
				price:145000.0,
				keyWords:["Comics","Heroes","Capitan America"],
				name:"Capitan America",
				id:1
			},
			{
				url:"https://s-media-cache-ak0.pinimg.com/236x/4f/a6/94/4fa6946dbe07a6700a71bc3269a5f01f.jpg",
				author:{
					id:1,
					name:"John Doe"
				},
				rating:4,
				price:145000.0,
				keyWords:["Comics","Heroes","Capitan America"],
				name:"Capitan America",
				id:1
			},
			{
				url:"http://th01.deviantart.net/fs70/PRE/i/2012/290/8/0/gangnam_style_1_by_belu_cute-d5i4daz.png",
				author:{
					id:1,
					name:"John Doe"
				},
				rating:4,
				price:145000.0,
				keyWords:["psy","gangman","meme"],
				name:"PSY",
				id:2
			},
			{
				url:"https://s-media-cache-ak0.pinimg.com/236x/4f/a6/94/4fa6946dbe07a6700a71bc3269a5f01f.jpg",
				author:{
					id:1,
					name:"John Doe"
				},
				rating:4,
				price:145000.0,
				keyWords:["Comics","Heroes","Capitan America"],
				name:"Capitan America",
				id:1
			},
			{
				url:"https://s-media-cache-ak0.pinimg.com/236x/4f/a6/94/4fa6946dbe07a6700a71bc3269a5f01f.jpg",
				author:{
					id:1,
					name:"John Doe"
				},
				rating:4,
				price:145000.0,
				keyWords:["Comics","Heroes","Capitan America"],
				name:"Capitan America",
				id:1
			},
			{
				url:"https://s-media-cache-ak0.pinimg.com/236x/4f/a6/94/4fa6946dbe07a6700a71bc3269a5f01f.jpg",
				author:{
					id:1,
					name:"John Doe"
				},
				rating:4,
				price:145000.0,
				keyWords:["Comics","Heroes","Capitan America"],
				name:"Capitan America",
				id:1
			},
			
		]
		$scope.totalStamps=1;

		$scope.viewOptions={
 			viewMode:'grid',
 			sortBy:'',
 		}
	})