/*global require, requirejs */

'use strict';

requirejs.config({
	paths : {
		'angular' : [ '../lib/angularjs/angular' ],
		'angular-route' : [ '../lib/angularjs/angular-route' ]
	},
	shim : {
		'angular' : {
			exports : 'angular'
		},
		'angular-route' : {
			deps : [ 'angular' ],
			exports : 'angular'
		}
	}
});

require([ 'angular', './controllers', './directives', './filters',
		'./services', 'angular-route' ], function(angular, controllers) {

	// Declare app level module which depends on filters, and services

	angular
			.module(
					'myApp',
					[ 'myApp.filters', 'myApp.services', 'myApp.directives',
							'ngRoute' ]).config(
					[ '$routeProvider', function($routeProvider) {
						$routeProvider.when('/index', {
							templateUrl : 'partials/index.html',
							controller : controllers.Index
						});
						$routeProvider.when('/login', {
							templateUrl : 'partials/login.html',
							controller : controllers.Login
						});
						$routeProvider.when('/register', {
							templateUrl : 'partials/register.html',
							controller : controllers.Register
						});
						$routeProvider.when('/profile', {
							templateUrl : 'partials/profile.html',
							controller : controllers.Profile
						});						
						$routeProvider.when('/admin', {
							templateUrl : 'partials/admin.html',
							controller : controllers.Admin
						});
						$routeProvider.when('/search', {
							templateUrl : 'partials/search.html',
							controller : controllers.Search
						});
						$routeProvider.when('/view2', {
							templateUrl : 'partials/partial2.html',
							controller : controllers.MyCtrl2
						});
						$routeProvider.otherwise({
							redirectTo : '/index'
						});
					} ]);

	angular.bootstrap(document, [ 'myApp' ]);

});
