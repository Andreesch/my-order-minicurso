'use strict';

var appServices = angular.module("AppServices", ['ngResource', 'ngRoute']);
var domainURL = "http://192.168.0.9:5000/api/v1";

appServices.factory('RestaurantListService', ['$resource', function(resource) {
	return resource(domainURL + '/restaurant/list', null, {
		get: { method:'GET'}
	});
}]);

appServices.factory('RestaurantService', ['$resource', function(resource) {
	return resource(domainURL + '/restaurant', null, {
		post: { method:'POST'},
		put: {method: 'PUT'},
		delete: {method: 'DELETE'}
	});
}]);

appServices.factory('ProductListService', ['$resource', function(resource) {
	return resource(domainURL + '/product/list', null, {
		get: { method:'GET'}
	});
}]);

appServices.factory('ProductService', ['$resource', function(resource) {
	return resource(domainURL + '/product', null, {
		post: { method:'POST'},
		put: {method: 'PUT'},
		delete: {method: 'DELETE'}
	});
}]);