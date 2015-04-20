'use strict';

angular.module('webAppApp')
  .controller('StampsCtrl', function($scope, Stamp){

  		var result = {};
  		result=	Stamp.query(
  			function(){
  				$scope.stamps=result.stamps;
  			}
  		);
  		console.log(result)
  		

		// $scope.stamps=[
		// 	{
		// 		url:"http://cdn4.colorlib.com/wp/wp-content/uploads/sites/2/2014/02/2016_Rio_Summer_Olympics_logo.png",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["olimpicos","juegos","rio"],
		// 		name:"Olimpicos rio",
		// 		id:1
		// 	},
		// 	{
		// 		url:"https://d13yacurqjgara.cloudfront.net/users/16705/screenshots/1000396/stark.jpg",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Got","Stark","Game of Thrones"],
		// 		name:"Stark Logo",
		// 		id:3
		// 	},
		// 	{
		// 		url:"https://s-media-cache-ak0.pinimg.com/236x/4f/a6/94/4fa6946dbe07a6700a71bc3269a5f01f.jpg",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Comics","Heroes","Capitan America"],
		// 		name:"Capitan America",
		// 		id:1
		// 	},
		// 	{
		// 		url:"http://static1.squarespace.com/static/5273d513e4b0032d39972946/t/5285d317e4b0911e074eb1b1/1384502043653/pringles+moustache+logo",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Comics","Heroes","Capitan America"],
		// 		name:"Capitan America",
		// 		id:1
		// 	},
		// 	{
		// 		url:"http://cdn.batman-news.com/wp-content/uploads/2013/03/logo.png",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Comics","Heroes","Capitan America"],
		// 		name:"Capitan America",
		// 		id:1
		// 	},
		// 	{
		// 		url:"http://img3.wikia.nocookie.net/__cb20120828183407/marveldatabase/images/f/f7/Uncanny_Avengers_Vol_1_1_Textless.jpg",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Comics","Heroes","Capitan America"],
		// 		name:"Capitan America",
		// 		id:1
		// 	},
		// 	{
		// 		url:"https://illustratedcosmos30.files.wordpress.com/2014/08/vector-tracing-work-by-mel-marcelo-41.jpg",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Comics","Heroes","Capitan America"],
		// 		name:"Capitan America",
		// 		id:1
		// 	},
		// 	{
		// 		url:"http://fc08.deviantart.net/fs70/i/2014/016/2/3/breaking_bad___paper_walter_by_dannykent-d72askl.jpg",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Comics","Heroes","Capitan America"],
		// 		name:"Capitan America",
		// 		id:1
		// 	},
		// 	{
		// 		url:"http://1.bp.blogspot.com/-U9MP8MVJfRc/VECiwuK8QmI/AAAAAAAAA1w/27T9dWOLdhg/s400/l_image.png",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Comics","Heroes","Capitan America"],
		// 		name:"Capitan America",
		// 		id:1
		// 	},
		// 	{
		// 		url:"http://cdn4.colorlib.com/wp/wp-content/uploads/sites/2/2014/02/2016_Rio_Summer_Olympics_logo.png",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["olimpicos","juegos","rio"],
		// 		name:"Olimpicos rio",
		// 		id:1
		// 	},
		// 	{
		// 		url:"https://d13yacurqjgara.cloudfront.net/users/16705/screenshots/1000396/stark.jpg",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Got","Stark","Game of Thrones"],
		// 		name:"Stark Logo",
		// 		id:3
		// 	},
		// 	{
		// 		url:"https://s-media-cache-ak0.pinimg.com/236x/4f/a6/94/4fa6946dbe07a6700a71bc3269a5f01f.jpg",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Comics","Heroes","Capitan America"],
		// 		name:"Capitan America",
		// 		id:1
		// 	},
		// 	{
		// 		url:"http://static1.squarespace.com/static/5273d513e4b0032d39972946/t/5285d317e4b0911e074eb1b1/1384502043653/pringles+moustache+logo",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Comics","Heroes","Capitan America"],
		// 		name:"Capitan America",
		// 		id:1
		// 	},
		// 	{
		// 		url:"http://cdn.batman-news.com/wp-content/uploads/2013/03/logo.png",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Comics","Heroes","Capitan America"],
		// 		name:"Capitan America",
		// 		id:1
		// 	},
		// 	{
		// 		url:"http://img3.wikia.nocookie.net/__cb20120828183407/marveldatabase/images/f/f7/Uncanny_Avengers_Vol_1_1_Textless.jpg",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Comics","Heroes","Capitan America"],
		// 		name:"Capitan America",
		// 		id:1
		// 	},
		// 	{
		// 		url:"https://illustratedcosmos30.files.wordpress.com/2014/08/vector-tracing-work-by-mel-marcelo-41.jpg",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Comics","Heroes","Capitan America"],
		// 		name:"Capitan America",
		// 		id:1
		// 	},
		// 	{
		// 		url:"http://fc08.deviantart.net/fs70/i/2014/016/2/3/breaking_bad___paper_walter_by_dannykent-d72askl.jpg",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Comics","Heroes","Capitan America"],
		// 		name:"Capitan America",
		// 		id:1
		// 	},
		// 	{
		// 		url:"http://1.bp.blogspot.com/-U9MP8MVJfRc/VECiwuK8QmI/AAAAAAAAA1w/27T9dWOLdhg/s400/l_image.png",
		// 		author:{
		// 			id:1,
		// 			name:"John Doe"
		// 		},
		// 		rating:4,
		// 		price:145000.0,
		// 		keyWords:["Comics","Heroes","Capitan America"],
		// 		name:"Capitan America",
		// 		id:1
		// 	},
		// ]
	
		$scope.viewOptions={
 			viewMode:'grid',
 			sortBy:'',
 		}
	})
