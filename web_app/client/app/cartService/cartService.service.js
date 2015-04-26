'use strict';

angular.module('webAppApp')
  .factory('Cart', 
  	function ($resource) {
      var resource = $resource('http://uniandes-msls.rhcloud.com/stamppyProject-service/rest/cart-service/cart/:id', {id:'@id'});
      return resource;      
    }
  	)
  .factory('DelCart', 
  	function ($resource) {
      var resource = $resource('http://uniandes-msls.rhcloud.com/stamppyProject-service/rest/cart-service/cart/:cartId/:productId', {cartId:'@cartId', productId:'@productId'});
      return resource;      
    }
  	);

