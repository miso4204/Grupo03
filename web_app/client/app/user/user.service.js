'use strict';

angular.module('webAppApp')
  .factory('User', function ($resource) {
  	var resource =$resource('http://uniandes-msls.rhcloud.com/stamppyProject-service/rest/user-service/user/:id',{});
    return resource;
  });
