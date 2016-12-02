var rbAnalyticsController = angular.module('rbAnalyticsController', []);

rbAnalyticsController.controller("rbAnalyticsCtrl",['$scope','$http',function($scope,$http){
	
	$scope.tweets = [];
	
	$scope.searchTweets = function(searchText){
		
		$http.get("rest/rbAnalytics/"+searchText+"")
	    .success(
	    			function(response) {
	    				$scope.tweets = response;
	    			}
	    );
	};
	
  $scope.clearTweets = function(){
	  $scope.tweets = [];
  };
	 
}]);