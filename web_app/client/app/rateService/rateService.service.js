'use strict';

angular.module('webAppApp')
  .service('rateService', 
  	['$http', '$cookieStore', '$rootScope', 
  	function ($http, $cookieStore, $rootScope) {
     return{
        Rate : function (rate1, callback) {

                $http.post('http://uniandes-msls.rhcloud.com/stamppyProject-service/rest/stamp-service/rating', rate1)
                .success(function (response, status) {
                      console.log(response);
                      console.log("Rating success!!!");
                      callback(response, status);
                   });
            }
          }

    }])

    .service('rateServiceProd', 
    ['$http', '$cookieStore', '$rootScope', 
    function ($http, $cookieStore, $rootScope) {
     return{

        RateProd : function (rate1, callback) {

                $http.post('http://uniandes-msls.rhcloud.com/stamppyProject-service/rest/product-service/rating', rate1)
                .success(function (response, status) {
                      console.log(response);
                      console.log("Rating success!!!");
                      callback(response, status);
                   });
            }    


          }

    }]);
