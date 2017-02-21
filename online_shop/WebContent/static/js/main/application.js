var app = angular.module("myApp",['ngRoute']);

app.config(['$locationProvider', '$routeProvider',
            function($locationProvider, $routeProvider) {
              $locationProvider.hashPrefix('!');
    $routeProvider.
	when('/page1',{
		templateUrl : 'static/pages/page1.html',
		controller : 'P1Controller'
	}).
	when('/page2',{
		templateUrl : 'static/pages/page2.html',
		controller : 'P1Controller'
	}).
	when('/page3',{
		templateUrl : 'static/pages/page3.html',
		controller : 'P1Controller'
	}).
	when('/page4',{
		templateUrl : 'static/pages/page4.html',
		controller : 'P1Controller'
	}).
	otherwise({
		redirectTo : '/'
	});
}]);