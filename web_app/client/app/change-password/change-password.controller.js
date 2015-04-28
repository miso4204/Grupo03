'use strict';

angular.module('webAppApp')
  .controller('ChangePasswordCtrl', function ($scope,$routeParams,$rootScope,User,UpdateUser, sessionStorage) {
    if (sessionStorage.get("user")) {
      if(!$rootScope.globals){
        $rootScope.globals={};
      }
      
      $rootScope.globals.currentUser=sessionStorage.get("user");
      console.log(JSON.stringify($rootScope.globals.currentUser))
    }
    
    $scope.oldPassword = "";
    $scope.newPassword = "";
    $scope.newPasswordConfirm = "";
    
    $scope.dataUser = User.get({id:$rootScope.globals.currentUser.userId}, 
      function(){
        console.log(JSON.stringify($scope.dataUser))
      });
    
    $scope.update = function () {
      console.log("Actualizando Contraseña...");
      console.log($scope.dataUser)
      $scope.regSuccessShow = false;
      $scope.regErrorShow = false;
      //console.log("Contraseña Anterior:"+$scope.dataUser.password);
      //console.log("Contraseña Digitada:"+$scope.oldPassword);
      //console.log("Contraseña Nueva:"+$scope.newPassword);
      //console.log("Confirmaciòn:"+$scope.newPasswordConfirm);
      
      if($scope.dataUser.password == $scope.oldPassword) {
        if(($scope.newPassword.length) >= 6){
          if($scope.newPassword == $scope.newPasswordConfirm) {
            $scope.dataUser.password = $scope.newPassword;
            //console.log(JSON.stringify($scope.dataUser));
            status = UpdateUser.update($scope.dataUser);
            //console.log("Register responsed" + JSON.stringify(response))
            $scope.regSuccess= "Cambio de contraseña exitosa";
            $scope.regSuccessShow = true;
            $scope.regErrorShow = false;
            $scope.oldPassword = "";
            $scope.newPassword = "";
            $scope.newPasswordConfirm = "";
          } else {
            $scope.regError= "Las contraseñas no coinciden";
            console.log("error");
            $scope.regSuccessShow = false;
            $scope.regErrorShow = true;    
          }
        } else {
          $scope.regError= "La contraseña debe tener más de 6 caracteres";
          console.log("error");
          $scope.regSuccessShow = false;
          $scope.regErrorShow = true;
        }
      } else {
        $scope.regError= "La contraseña digitada no coincide con la actual";
        console.log("error");
        $scope.regSuccessShow = false;
        $scope.regErrorShow = true;
      }
    }
  });
