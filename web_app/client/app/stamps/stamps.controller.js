'use strict';
angular.module('webAppApp')
  .controller('StampsCtrl', function($scope,Stamp){
  		var result = {};
  		result=	Stamp.query(
  			function(){
  				$scope.stamps=result.stamps;
  			}
  		);
		$scope.viewOptions={
 			viewMode:'grid',
 			sortBy:'',
 		}
	})
