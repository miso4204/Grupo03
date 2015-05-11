'use strict';

angular.module('webAppApp')
  .factory('twitterService', 
  	function ($resource) {
      var resource = $resource('http://uniandes-msls.rhcloud.com/stamppyProject-service/rest/socialNetwork-service/twitter');
      return resource;      
    }
  	)
  .factory('facebookService', 
  	function ($resource) {
      var resource = $resource('http://uniandes-msls.rhcloud.com/stamppyProject-service/rest/socialNetwork-service/facebook');
      return resource;      
    }
  	);
