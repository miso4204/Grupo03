'use strict';

angular.module('webAppApp')
  .factory('Stamp', 
    function ($resource) {
      var resource = $resource('https://uniandes-msls.rhcloud.com/stamppyProject-service/rest/stamp-service/stamp/:id',
              {},
              {
                'query': {method: 'GET', isArray: false }
              });
      return resource;      
    }
  )
  .factory('StampId', 
    function ($resource) {
      var resource = $resource('http://uniandes-msls.rhcloud.com/stamppyProject-service/rest/stamp-service/:artistId/stamp',
              {artistId:'@artistId'});
      return resource;      
    }
  );
