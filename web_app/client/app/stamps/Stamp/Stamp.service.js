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
  );
