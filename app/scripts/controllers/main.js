

/**
 * @ngdoc function
 * @name pennAppsXiiApp.controller: MainCtrl
 * @description
 * # MainCtrl
 * Controller of the pennAppsXiiApp
 */
angular.module('appApp').controller('MainCtrl', function($scope) {
	$scope.title = 'This is a test';
  $scope.labels = [0,1,2,3,4,5];
  $scope.series = ['Last Credence'];
  $scope.data= [50,20,80,30,36,60];

  $scope.onClick = function (points, evt) {
    console.log(points, evt);
  }});

