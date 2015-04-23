'use strict';

angular.module('webAppApp')
  .service('registerService', 
  	['$http', '$cookieStore', '$rootScope', 
  	function ($http, $cookieStore, $rootScope) {
    	return{
    		Register : function (dataUser, callback) {
                dataUser.id = null;
                $http.post('http://uniandes-msls.rhcloud.com/stamppyProject-service/rest/user-service/user/', dataUser)
                .success(function (response, status) {
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
