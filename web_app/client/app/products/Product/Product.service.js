'use strict';

angular.module('webAppApp')
  .service('Product', function ($resource) {
  	var resource = $resource('https://uniandes-msls.rhcloud.com/stamppyProject-service/rest/product-service/product/:id',
  		{
    		'query': {method: 'GET'}
        });
  return resource;      
})

  .service('productService', 
    ['$http', '$cookieStore', '$rootScope', 
    function ($http, $cookieStore, $rootScope) {
   return{
        postProd : function (dataProduct, callback) {

                $http.post('http://uniandes-msls.rhcloud.com/stamppyProject-service/rest/product-service/product', dataProduct)
                .success(function (response) {
                      console.log("Product success!!!");
                      callback(response);
                   });
            }       
      }

    }]);
