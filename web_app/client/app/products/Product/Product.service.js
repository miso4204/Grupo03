'use strict';

angular.module('webAppApp')
  .service('Product', function ($resource) {
  	var resource = $resource('https://uniandes-msls.rhcloud.com/stamppyProject-service/rest/product-service/product/:id',
  		{
    		'query': {method: 'GET'}
        });
  return resource;      
});
