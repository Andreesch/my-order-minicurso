'use strict';

var app = angular.module('myOrderApp')
	.controller('ProductsCtrl', [ '$scope', '$store', 'flash', 'RestaurantListService', 'RestaurantService', 'ProductListService', 'ProductService', function ($scope, $store, flash, restaurantListService, restaurantService, productListService, productService) {
    
    // Bind localStorage to scope ( wrapper for $scope.$watch )
    //$store.bind( $scope, 'products' );

  	// Get all products from localStorage to scope
  	$scope.products = [];
    $scope.restaurants = [];

    // Create newProduct
    $scope.newProduct = {};

    $scope.loadRestaurants = function(){
        restaurantListService.get(null, null, function(response){
          $scope.restaurants = response.restaurants;
        }, function(response) {
          flash.error = 'Erro ao carregar restaurantes.';
          console.log(response);
        });
    };

    $scope.loadProducts = function(){
        productListService.get(null, null, function(response){
          $scope.products = response.products;
        }, function(response) {
          console.log(response);
        });
    };

    $scope.saveProduct = function() {
      if($scope.newProduct.id) {
        $scope.editProduct();
      } else {
        $scope.addProduct();
      }
    }

    $scope.addProduct = function() {

      productService.post(null, {
        name: $scope.newProduct.name,
        description: $scope.newProduct.description,
        value: $scope.newProduct.value,
        restaurantId: $scope.newProduct.restaurant.id
      }, function(response){
        flash.success = $scope.newProduct.name + ' foi atualizado com sucesso.';

        // Close Modal (@todo find another 
        // way other than dom method in controller)
        // document.getElementById('restaurant-form').modal('hide');

        // clean scope from newProduct
        $scope.newProduct = {};

        $scope.loadProducts();
      }, function(response){
        flash.error = 'Erro ao salvar produto.';
        console.log(response);
      });
    }

    $scope.editProduct = function() {

      productService.put(null, {
        id: $scope.newProduct.id,
        name: $scope.newProduct.name,
        description: $scope.newProduct.description,
        value: $scope.newProduct.value,
        restaurantId: $scope.newProduct.restaurant.id
      }, function(response){
        flash.success = $scope.newProduct.name + ' foi atualizado com sucesso.';

        // Close Modal (@todo find another 
        // way other than dom method in controller)
        // document.getElementById('restaurant-form').modal('hide');

        // clean scope from newProduct
        $scope.newProduct = {};

        $scope.loadProducts();
      }, function(response){
        flash.error = 'Erro ao salvar produto.';
        console.log(response);
      });
    }

    $scope.selectProductToRemove = function(id) {
      $scope.selectedProductToRemove = id;
    }

    $scope.removeProduct = function() {

      productService.delete({id: $scope.selectedProductToRemove}, null, function(response){
        flash.success = 'Removido com sucesso.';
        $scope.loadProducts();
      }, function(response){
        flash.error = "Erro ao remover produto."
        console.log(response);
      });
    }

    $scope.loadRestaurants();
    $scope.loadProducts();

  	/*
  	 * Edit restaurant by id 
  	 */
  	$scope.edit = function(id) {
  		
    	//search products with given id
        for(var i in $scope.products) {
            if($scope.products[i].id == id) {
                //copy of originial object to scope object
                $scope.newProduct = angular.copy($scope.products[i]);

                // Set a edit flag
                $scope.newProduct.edit = true;
            }
        }
    };
}]);