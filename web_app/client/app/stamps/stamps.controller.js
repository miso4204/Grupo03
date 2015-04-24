'use strict';
angular.module('webAppApp')
  .controller('StampsCtrl', function($scope,$rootScope,$cookieStore,Stamp){
  		$rootScope.globals=$cookieStore.get('globals');
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
