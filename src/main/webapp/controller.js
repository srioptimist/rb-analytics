var rbAnalyticsController = angular.module('rbAnalyticsController', []);

rbAnalyticsController.controller("rbAnalyticsCtrl",['$scope','$http',function($scope,$http){
	
	$scope.feeds = [];
	$scope.flag = false;
	
	$scope.searchFeeds = function(searchText){
		
		$http.get("rest/rbAnalytics/"+searchText+"")
	    .success(
	    			function(response) {
	    				$scope.feeds = response;
	    				$scope.flag = true;
	    			}
	    );
	};
	
  $scope.clearFeeds = function(){
	  $scope.feeds = [];
	  $scope.flag = false;
  };
	 
}]);