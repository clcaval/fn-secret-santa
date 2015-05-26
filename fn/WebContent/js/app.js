var app = angular.module("myapp", []);

app.controller("PersonAddCtrl", ['$scope', '$http', function($scope, $http){
		
	$scope.person = {}
	
	$scope.addPerson = function(a, b)
	{
		console.log($scope.person);
		console.log(a);
		console.log(b);
		
		$http.post("rest/fn/insertPerson", $scope.person).success(function(data, status){
			console.log(data);
			console.log(status);
		});
		
	}
	
}]);

app.controller("PersonListCtrl", function($scope, $http){
	
	$http.get("rest/fn/getPersons").success(function(response){
		$scope.persons = response.people;
	});
	
});