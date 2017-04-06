angular.module('clientApp')
   .controller('SignupCtrl', function ($scope, $http, $log) {
     $scope.signup = function() {
       var payload = {
         email : $scope.email,
         password : $scope.password
       };

       $http.post('app/signup', payload)
           .success(function(data) {
             $log.debug(data);
           });
     };
   });