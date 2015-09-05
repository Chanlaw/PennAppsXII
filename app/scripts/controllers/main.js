
'use strict';
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
    $scope.innerdata = [];
    $scope.market=data;
    $scope.data= [$scope.innerdata];
    var i = 0;
    for (let prediction of $scope.market.predictions){
      $scope.innerdata.push(prediction.price/10)
      $scope.labels.push(i);
      i++;
    }
    });
}]);

