router.controller('homeController',function ($scope,$state) {

    console.log("home controller");
    $scope.login=function () {
        $state.go('login')
    }

    $scope.signup=function () {
        console.log("signup");
        $state.go('signup')
    }

})