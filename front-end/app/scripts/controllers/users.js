'use strict';

var app = angular.module('myOrderApp')
	.controller('UsersCtrl', [ '$scope', '$store', 'flash', 'UserListService', 'UserService', function ($scope, $store, flash, userListService, userService) {

    // Create newUser
    $scope.newUser = {};

    $scope.loadUsers = function(){
        userListService.get(null, null, function(response){
          $scope.users = response.users;
        }, function(response) {
          console.log(response);
        });
    };

    $scope.saveUser = function() {
      if($scope.newUser.id) {
        $scope.editUser();
      } else {
        $scope.addUser();
      }
    }

    $scope.addUser = function() {

      userService.post(null, {
        name: $scope.newUser.name,
        phone: $scope.newUser.phone,
        email: $scope.newUser.email,
        password: $scope.newUser.password,
        matchingPassword: $scope.newUser.matchingPassword,
        address: $scope.newUser.address
      }, function(response){
        flash.success = $scope.newUser.name + ' foi criado com sucesso.';

        // Close Modal (@todo find another 
        // way other than dom method in controller)
        // document.getElementById('restaurant-form').modal('hide');

        // clean scope from newUser
        $scope.newUser = {};

        $scope.loadUsers();
      }, function(response){
        console.log(response);
        flash.error = 'Erro ao criar usuário.';
      });
    }

    $scope.editUser = function() {     
      userService.put(null, {
        id: $scope.newUser.id,
        name: $scope.newUser.name,
        phone: $scope.newUser.phone,
        email: $scope.newUser.email,
        password: $scope.newUser.password,
        matchingPassword: $scope.newUser.matchingPassword,
        address: $scope.newUser.address
      }, function(response){
        flash.success = $scope.newUser.name + ' foi atualizado com sucesso.';

        // Close Modal (@todo find another 
        // way other than dom method in controller)
        // document.getElementById('restaurant-form').modal('hide');

        // clean scope from newUser
        $scope.newUser = {};

        $scope.loadUsers();
      }, function(response){
        console.log(response);
      });
    }

    $scope.selectUserToRemove = function(id) {
      $scope.selectedUserToRemove = id;
    }

    $scope.removeUser = function() {

      userService.delete({id: $scope.selectedUserToRemove}, null, function(response){
        flash.success = 'Removido com sucesso.';
        $scope.loadUsers();
      }, function(response){
        console.log(response);
      });
    }

    $scope.loadUsers();

  	/*
  	 * Generate new Id
  	 * @notes This shouldn't happen if using a webservice,
  	 * the webservice will assign new ids
  	 */
  	var newId = function () {
  		return $scope.users.length + 1;
  	};

  	/*
  	 * Edit restaurant by id 
  	 */
  	$scope.edit = function(id) {
  		
    	//search restaurants with given id
        for(var i in $scope.users) {
            if($scope.users[i].id == id) {
                //copy of originial object to scope object
                $scope.newUser = angular.copy($scope.users[i]);
            }
        }
    };
}]);