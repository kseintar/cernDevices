router.controller('signupController',function ($scope, $http,$state, userService) {

    console.log("signup");
    $scope.signup = function () {
        console.log($scope.user);
        userService.signup($scope.user)
            .then(function (response){
                $state.go('home')

                }, function (response){}

            )
    }

})