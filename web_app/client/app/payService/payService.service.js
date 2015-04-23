'use strict';

angular.module('webAppApp')
  .service('payService', 
    ['$http', '$cookieStore', '$rootScope', 
    function ($http, $cookieStore, $rootScope) {
   return{
        Pay : function (dataPay, callback) {

                $http.post('http://uniandes-msls.rhcloud.com/stamppyProject-service/rest/cart-service/payment', dataPay)
                .success(function (response, status) {
                      console.log(response);
                      console.log("Register success!!!");
                      if(status == 200){
                        response.result=true;
                      }else{
                        response.result=false;
                      }
                      callback(response, status);
                   });
            }       
      }

    }]);
