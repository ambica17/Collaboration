<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forum  Information - Converting GSON to JSON</title>

<script	src="//ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
<script>
var app = angular.module('myApp', []);
 
function MyController($scope, $http) {

	 $scope.sortType = 'name'; // set the default sort type
	  $scope.sortReverse = false;  // set the default sort order
	  $scope.searchMessage = '';
	  
        $scope.getDataFromServer = function() {
                $http({
                        method : 'GET',
                        url : 'GsonCon3'
                }).success(function(data, status, headers, config) {
                        $scope.chat= data;  
                }).error(function(data, status, headers, config) {
                        // called asynchronously if an error occurs
                        // or server returns response with an error status.
                });
        };
};



</script>
</head>
<body>

<div class="container" ng-app="myApp" ng-controller="MyController" ng-init="getDataFromServer()">
  
  <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
        <input type="text" class="form-control" placeholder="Search Message" ng-model="searchMessage">      
       </div>      
    </div>
  </form>
  
  <table class="table table-bordered table-striped">
    
    <thead>
      <tr>
      <td>
          <a href="#" ng-click="sortType = 'id'; sortReverse = !sortReverse">
             Id 
            <span ng-show="sortType == 'id' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'id' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        
        <td>
          <a href="#" ng-click="sortType = 'dateandtime'; sortReverse = !sortReverse">
            DateandTime
            <span ng-show="sortType == 'dateandtime' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'dateandtime' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'message'; sortReverse = !sortReverse">
          Message
            <span ng-show="sortType == 'message' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'message' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
          
        
      </tr>
    </thead>
    
    <tbody>
      <tr ng-repeat="roll in chat | orderBy:sortType:sortReverse | filter:searchMessage">
           		<td>{{roll.id}}</td>
           		<td>{{roll.dateandtime}}</td>
           		<td>{{roll.message}}</td>
           		
      </tr>
    </tbody>
    
  </table>
  
</div>

</body>
</html>