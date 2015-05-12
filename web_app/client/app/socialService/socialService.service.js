'use strict';

angular.module('webAppApp')
  .service('facebookService', 
    ['$http', '$cookieStore', '$rootScope', 
    function ($http, $cookieStore, $rootScope) {
   return{
        getFacebook : function (callback) {

                $http.get('http://uniandes-msls.rhcloud.com/stamppyProject-service/rest/socialNetwork-service/facebook')
                .success(function (response, status) {
                      console.log(response);
                      console.log("Social success!!!");
                      callback(response, status);
                   });
            }       
      }

    }])

  .service('twitterService', 
    ['$http', '$cookieStore', '$rootScope', 
    function ($http, $cookieStore, $rootScope) {
   return{
        getTwitter : function (callback) {

                $http.get('http://uniandes-msls.rhcloud.com/stamppyProject-service/rest/socialNetwork-service/twitter')
                .success(function (response, status) {
                      console.log(response);
                      console.log("Social success!!!");
                      callback(response, status);
                   });
            }       
      }

    }]);
