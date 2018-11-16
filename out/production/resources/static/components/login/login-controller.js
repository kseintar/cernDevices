router.controller('loginController',function ($scope, $http,$cookies,$state,userService) {

    console.log("login");
    $scope.login = function () {
      console.log($scope.credentials);
        userService.login($scope.credentials)
            .then(function (response){
                    $cookies.put('id', response.data.userId);
                    $cookies.put('signedIn', 'yes');
                    $cookies.put('authToken', response.data.authToken);
                    $cookies.put('firstName', response.data.firstName);

                    console.log(response.data.firstName);

                    $state.go('listBoats')


            }, function (response){

                $scope.wrongPass=true;
                $timeout(function(){$scope.wrongPass = false}, 1000);
                }

            )
    }

})