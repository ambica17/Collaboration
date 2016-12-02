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
	  $scope.searchBtitle = '';
	  
        $scope.getDataFromServer = function() {
                $http({
                        method : 'GET',
                        url : 'GsonCon'
                }).success(function(data, status, headers, config) {
                        $scope.blog = data;  
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
        <input type="text" class="form-control" placeholder="Search Blog title" ng-model="searchBtitle">      
       </div>      
    </div>
  </form>
  
  <table class="table table-bordered table-striped">
    
    <thead>
      <tr>
      <td>
          <a href="#" ng-click="sortType = 'bid'; sortReverse = !sortReverse">
            Blog Id 
            <span ng-show="sortType == 'bid' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'bid' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        
        <td>
          <a href="#" ng-click="sortType = 'btitle'; sortReverse = !sortReverse">
            Blog title
            <span ng-show="sortType == 'btitle' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'btitle' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'bcontent'; sortReverse = !sortReverse">
          Blog Content
            <span ng-show="sortType == 'bcontent' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'bcontent' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'bUserName'; sortReverse = !sortReverse">
          Blog User Name
            <span ng-show="sortType == 'bUserName' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'bUserName' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        
        <td>
          <a href="#" ng-click="sortType = 'creationdatetime'; sortReverse = !sortReverse">
          Blog CreationTime
            <span ng-show="sortType == 'creationdatetime' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'creationdatetime' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
    
      
        
      </tr>
    </thead>
    
    <tbody>
      <tr ng-repeat="roll in blog | orderBy:sortType:sortReverse | filter:searchBtitle">
           		<td>{{roll.bid}}</td>
           		<td>{{roll.btitle}}</td>
           		<td>{{roll.bcontent}}</td>
           		<td>{{roll.bUserName}}</td>
           		<td>{{roll.creationdatetime}}</td>
           		
      </tr>
    </tbody>
    
  </table>
  
</div>

</body>
</html>