'use strict';

angular.module('webAppApp')
  .controller('NavBarCtrl', ['$scope', '$routeParams','$rootScope', '$location', 'loginService','sessionStorage',
		function($scope,$routeParams,$rootScope,$location,loginService,sessionStorage){
    
			$scope.logout=function() {
				console.log("logout");
              	loginService.ClearCredentials();
            };
    
  }]);
