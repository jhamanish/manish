app.controller('RestController',['$scope','$http',function(scope,http){
	
	http.get('http://rest-service.guides.spring.io/greeting').
		then(function(response){
			scope.greeting = response.data;
		});
}]);

app.controller('RestController2',['$scope','$http',function(scope,http){
	
	http.get('http://localhost:8080/FirstApp/link').
		then(function(response){
			scope.result = response;
		});
}]);

