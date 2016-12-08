var rbAnalyticsController = angular.module('rbAnalyticsController', []);

rbAnalyticsController.controller("rbAnalyticsCtrl",['$scope','$http',function($scope,$http){
	
	$scope.feeds = [];
	$scope.flag = false;
	
	$scope.searchFeeds = function(searchText){
		$scope.loading = true;
		$http.get("rest/rbAnalytics/"+searchText+"")
	    .success(
	    			function(response) {
	    				$scope.feeds = response;
	    				$scope.flag = true;
	    			}
	    ).finally(function() {
	        $scope.loading = false;
	    });
	};
	
  $scope.clearFeeds = function(){
	  $scope.feeds = [];
	  $scope.flag = false;
  };
	 
}]);