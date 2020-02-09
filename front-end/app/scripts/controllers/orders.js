'use strict';

angular.module('myOrderApp')
  .controller('OrdersCtrl', [ '$scope', '$store', 'flash', 'RestaurantListService', 'RestaurantService', 'ProductListService', 'ProductService', 'OrderListService', 'OrderService', 'UserListService', 'OrderUpdateService', function ($scope, $store, flash, restaurantListService, restaurantService, productListService, productService, orderListService, orderService, userListService, updateOrderService) {
    
    $scope.orders = [];
    $scope.restaurants = [];
    $scope.products = [];
    $scope.users = [];

    $scope.newOrder = {};
    $scope.newOrder.items = [];

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

    $scope.loadUsers = function(){
        userListService.get(null, null, function(response){
          $scope.users = response.users;
        }, function(response) {
          console.log(response);
        });
    };

    $scope.loadOrders = function() {
      orderListService.get(null, null, function(response){
        $scope.orders = response.orders;
      }, function(response) {
        flash.error = 'Erro ao carregar pedidos.';
        console.log(response);
      });
    }

    $scope.addOrder = function() {

      var items = [];
      angular.forEach($scope.newOrder.items, function(item) {
        items.push({
          itemId: item.product.id,
          quantity: item.quantity
        });
      });

      if(items.length == 0) {
        flash.error = "Não foi informado nenhum item no pedido.";
        return;
      }

      orderService.post(null, {
        userId: $scope.newOrder.user.id,
        restaurantId: $scope.newOrder.restaurant.id,
        items: items
      }, function(response){
        flash.success = 'Pedido adicionado com sucesso.';
        // clean scope from newOrder
        $scope.newOrder = {items:[]};

        $scope.loadOrders();
      }, function(response){
        flash.error = 'Erro ao salvar produto.';
        console.log(response);
      });
    }

    $scope.confirmOrder = function(order) {
      updateOrderService.post(null, {
        orderId: order.id,
        orderStatusEnum: 'CONFIRMED'
      }, function(response) {
        flash.success = 'Pedido atualizado com sucesso.';
        $scope.loadOrders();
      },function(response) {
        flash.error = 'Erro ao atualizar pedido.';
        console.log(response);
      });
    }

    $scope.addItem = function() {
      var newItem = {};
      angular.copy($scope.newItem, newItem);
      $scope.newOrder.items.push(newItem);

      $scope.newItem = {};
    }

    $scope.removeItem = function(index) {

      $scope.newOrder.items.splice(index, 1);
    }

    $scope.loadOrders();
    $scope.loadUsers();
    $scope.loadRestaurants();
    $scope.loadProducts();

  }]);
