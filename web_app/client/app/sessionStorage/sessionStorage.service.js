'use strict';

angular.module('webAppApp')
  .service('sessionStorage', function ($window) {
    return {
    	set: function(key ,value){
    		if(angular.isObject(value)){
    			var newVal=JSON.stringify(value);
    		}else{
    			var newVal=value
    		}
    		$window.sessionStorage.setItem(key,newVal);
    	},
    	get:function(key){
    		var value = $window.sessionStorage.getItem(key);
    		try {
    			var result = angular.fromJson(value);
		    } catch (e) {
		        var result = value
		    }
		    return result;
    	},
    	remove:function(key){
    		$window.sessionStorage.removeItem(key);
    	},
    	clear:function(){
    		$window.sessionStorage.clear();
    	}
    }
  });
