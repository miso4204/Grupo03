'use strict';

angular.module('webAppApp')
  .factory('ReportSalesId', 
  	function ($resource) {
      var resource = $resource('http://uniandes-msls.rhcloud.com/salesReport-service/rest/salesReport-service/sales/:id', {id:'@id'});
      return resource;      
    }
  	)
  .factory('ReportSalesPeriod', 
  	function ($resource) {
      var resource = $resource('http://uniandes-msls.rhcloud.com/salesReport-service/rest/salesReport-service/sales/:limiteBajo/:limiteAlto', {limiteBajo:'@limiteBajo', limiteAlto:'@limiteAlto'});
      return resource;      
    }
  	)
  .factory('ReportRatingId', 
    function ($resource) {
      var resource = $resource('http://uniandes-msls.rhcloud.com/ratingReport-service/rest/ratingReport-service/rating/:artistaId', {artistaId:'@artistaId'});
      return resource;      
    }
    )
  .factory('ReportRatings', 
    function ($resource) {
      var resource = $resource('http://uniandes-msls.rhcloud.com/ratingReport-service/rest/ratingReport-service/rating');
      return resource;      
    }
    )
  .factory('ListArtist', 
    function ($resource) {
      var resource = $resource('http://uniandes-msls.rhcloud.com/stamppyProject-service/rest/user-service/artists');
      return resource;      
    }
    );
