

/**
 * @ngdoc function
 * @name pennAppsXiiApp.controller: MainCtrl
 * @description
 * # MainCtrl
 * Controller of the pennAppsXiiApp
 */
angular.module('appApp').controller('MainCtrl', ['$scope','readMarket', function($scope, readMarket) {
  readMarket.success(function(data) {
  	$scope.title = 'This is a test';
    $scope.labels = [];
    $scope.series = ['Last Credence'];
    innerdata = [];
    $scope.market=data;
    $scope.data= [innerdata];

    });
}]);

