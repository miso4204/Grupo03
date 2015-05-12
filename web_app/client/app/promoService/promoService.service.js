'use strict';

angular.module('webAppApp')
  .factory('Promotion', function ($resource) {
  	var resource =$resource('http://uniandes-msls.rhcloud.com/offers-service/rest/offers-service/offer', {}, {update: {method: 'PUT'}});
    return resource;
  });
