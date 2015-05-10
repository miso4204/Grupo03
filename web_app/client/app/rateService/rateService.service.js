'use strict';

angular.module('webAppApp')
  .service('rateService', 
  	['$http', '$cookieStore', '$rootScope', 
  	function ($http, $cookieStore, $rootScope) {
     return{
        Rate : function (rate, callback) {

                $http.post('http://uniandes-msls.rhcloud.com/stamppyProject-service/rest/stamp-service/rating', rate)
                .success(function (response, status) {
                      console.log(response);
                      console.log("Rating success!!!");
                      callback(response, status);
                   });
            }       
      }

    }]);
