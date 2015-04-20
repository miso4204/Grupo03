'use strict';

angular.module('webAppApp')
  .factory('Stamp', 
    function ($resource) {
      var resource = $resource('http://estampate.jelasticlw.com.br/stamppyProject-service/rest/stamp-service/stamp/:id',
              {},
              {
                'query': {method: 'GET', isArray: false }
              });
      return resource;      
    }
  );
