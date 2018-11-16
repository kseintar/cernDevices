router.controller('navigationController',function ($scope,$state, $cookies,userService) {

    $scope.user = {};
    $scope.signedIn = {};
    $scope.donotmatch = false;
    $scope.user.firstName = $cookies.get('firstName');
    if($cookies.get('signedIn') === 'yes'){
        $scope.signedIn = true;
        $scope.user.userId = $cookies.get('id');
        $scope.user.authToken = $cookies.get('authToken');
        $scope.user.firstName = $cookies.get('firstName');
        $scope.user.lastName = $cookies.get('lastName');



    }else {
        $cookies.remove('id');

        $cookies.remove('authToken');

        $cookies.put('signedIn', 'no');
        $scope.signedIn = false;
        $scope.user = {};
    }


    $scope.signout = function(){
        $cookies.remove('id');
        $cookies.remove('authToken');
        $cookies.remove('firstName')
        $cookies.put('signedIn', 'no');
        $scope.signedIn = false;
        $scope.user = {};
        $state.go('home')
    };

    $scope.homepage = function () {
        $state.go('home')

    }

    $scope.goBoats = function () {
        $state.go('listBoats')
    }

    $scope.login=function () {
        $state.go('login')
    };

    $scope.signup=function () {
        $state.go('signup')
    };







})

