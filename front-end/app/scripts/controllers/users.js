'use strict';

var app = angular.module('myOrderApp')
	.controller('UsersCtrl', [ '$scope', '$store', 'flash', 'UserListService', function ($scope, $store, flash, userListService) {

    // Create newUser
    $scope.newUser = {};

    $scope.loadUsers = function(){
        userListService.get(null, null, function(response){
          $scope.users = response.users;
        }, function(response) {
          console.log(response);
        });
    };

    $scope.saveRestaurant = function() {
      if($scope.newRestaurant.id) {
        $scope.editRestaurant();
      } else {
        $scope.addRestaurant();
      }
    }

    $scope.addRestaurant = function() {

      restaurantService.post(null, {
        name: $scope.newRestaurant.name,
        phone: $scope.newRestaurant.phone,
        email: $scope.newRestaurant.email
      }, function(response){
        flash.success = $scope.newRestaurant.name + ' foi atualizado com sucesso.';

        // Close Modal (@todo find another 
        // way other than dom method in controller)
        // document.getElementById('restaurant-form').modal('hide');

        // clean scope from newRestaurant
        $scope.newRestaurant = {};

        $scope.loadUsers();
      }, function(response){
        console.log(response);
      });
    }

    $scope.editRestaurant = function() {     
      restaurantService.put(null, {
        id: $scope.newRestaurant.id,
        name: $scope.newRestaurant.name,
        phone: $scope.newRestaurant.phone,
        email: $scope.newRestaurant.email
      }, function(response){
        flash.success = $scope.newRestaurant.name + ' foi atualizado com sucesso.';

        // Close Modal (@todo find another 
        // way other than dom method in controller)
        // document.getElementById('restaurant-form').modal('hide');

        // clean scope from newRestaurant
        $scope.newRestaurant = {};

        $scope.loadUsers();
      }, function(response){
        console.log(response);
      });
    }

    $scope.selectRestaurantToRemove = function(id) {
      $scope.selectedRestaurantToRemove = id;
    }

    $scope.removeRestaurant = function() {

      restaurantService.delete({id: $scope.selectedRestaurantToRemove}, null, function(response){
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
  		return $scope.restaurants.length + 1;
  	};

  	/*
  	 * Edit restaurant by id 
  	 */
  	$scope.edit = function(id) {
  		
    	//search restaurants with given id
        for(var i in $scope.restaurants) {
            if($scope.restaurants[i].id == id) {
                //copy of originial object to scope object
                $scope.newRestaurant = angular.copy($scope.restaurants[i]);
            }
        }
    };
}]);