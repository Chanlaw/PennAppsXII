app.factory('readMarket', ['$http', function($http) {
	return $http.get('https://s3.amazonaws.com/market12138/market.json') 
            .success(function(data) { 
              return data; 
            }) 
            .error(function(err) { 
              return err; 
            }); 
}]);