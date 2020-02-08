'use strict';

/**
 * @ngdoc overview
 * @name myOrderApp
 * @description
 * # myOrderApp
 *
 * Main module of the application.
 */
angular
  .module('myOrderApp', [
    /*'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'*/
    'ngResource',
    'ngRoute',
    'ngAnimate',
    'angular-flash.service', 
    'angular-flash.flash-alert-directive',
    'AppServices'
  ])
  .config(function ($routeProvider,$locationProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/restaurants', {
        templateUrl: 'views/restaurants/restaurants.html',
        controller: 'RestaurantsCtrl'
      })
      .when('/products', {
        templateUrl: 'views/products/products.html',
        controller: 'ProductsCtrl'
      })
      .when('/orders', {
        templateUrl: 'views/orders/orders.html',
        controller: 'OrdersCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });

    // Set HTML5 Styles Urls.
    // $locationProvider
    //   .html5Mode(true);

    $locationProvider.hashPrefix('');
  });
