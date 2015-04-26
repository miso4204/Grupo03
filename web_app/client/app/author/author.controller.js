'use strict';

angular.module('webAppApp')
  .controller('AuthorCtrl', function ($scope) {
   	$scope.myInterval=500;
   	$scope.slides=[
   		{url:"http://i.imgur.com/0w2Jx7Cm.png",text:"hola"},
   		{url:"http://i.imgur.com/uKwBXQnm.jpg",text:"hola1"},
   		{url:"http://i.imgur.com/0w2Jx7Cm.png",text:"hola2"},
   		{url:"http://i.imgur.com/uKwBXQnm.jpg",text:"hola3"},
   		{url:"http://i.imgur.com/0w2Jx7Cm.png",text:"hola4"},
   	]
  });
