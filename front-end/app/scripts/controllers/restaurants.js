'use strict';

var app = angular.module('myOrderApp')
	.controller('RestaurantsCtrl', [ '$scope', '$store', 'flash', 'RestaurantListService', 'RestaurantService', function ($scope, $store, flash, restaurantListService, restaurantService) {
    
    // Bind localStorage to scope ( wrapper for $scope.$watch )
    $store.bind( $scope, 'restaurants' );

  	// Get all restaurants from localStorage to scope
  	$scope.restaurants = $store.get('restaurants');

    // Create newRestaurant
    $scope.newRestaurant = {};

    $scope.loadRestaurants = function(){
        restaurantListService.get(null, null, function(response){
          $scope.restaurants = response.restaurants;
          console.log(response);
        }, function(response) {
          console.log(response);
        });
    };

    $scope.addRestaurant = function() {
      restaurantService.post(null, {
        name: $scope.newRestaurant.name,
        phone: $scope.newRestaurant.phone,
        email: $scope.newRestaurant.email
      }, function(response){
        flash.success = $scope.newRestaurant.name + ' was updated successfully.';

        // Close Modal (@todo find another 
        // way other than dom method in controller)
        // document.getElementById('restaurant-form').modal('hide');

        // clean scope from newRestaurant
        $scope.newRestaurant = {};

        $scope.loadRestaurants();
      }, function(response){
        console.log(response);
      });
    }

  	/*
     * Reset defaults
  	 */
  	$scope.defaults = function () {

  		// set scope to default array
  		/*$scope.restaurants = [
	    	{ id: 1, name: 'Burger King', phone: '1234567890', mail: 'info@burgerking.com' },
	    	{ id: 2, name: 'Pizza Hut', phone: '1432567890', mail: 'info@pizzahut.com' },
	    	{ id: 3, name: 'KFC', phone: '1234509876', mail: 'info@kfc.com' },
	    	{ id: 4, name: 'Chili\'s', phone: '6543217890', mail: 'info@chilis.com' },
	    	{ id: 5, name: 'Cook Door', phone: '6789012345', mail: 'info@cookdoor.com' }
	    ];*/

	    // flash message
	    flash.success = 'Restaurants store reseted to defaults successfully.';

  	};

    // If !restaurants call defaults
    if( !$store.get('restaurants') ) {
      $scope.defaults();
    }

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

	/*
	 * Destroy item by Index
	 */
    $scope.destroy = function ($index) {
    	// Delete from array
    	var removed = $scope.restaurants.splice($index, 1);

    	// Show flash message
		flash.success = removed[0].name + ' was deleted successfully.';
    };

    $scope.loadRestaurants();

}]);