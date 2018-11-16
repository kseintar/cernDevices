router.controller('listBoatsController',function ($scope, $http, $state,$cookies,$timeout,boatService,userService) {

    console.log("list of boats");


    userService.validateUser($cookies.get('id'),$cookies.get('authToken'))
        .then(function (response){

            }, function (response){

                $state.go('home');
            }

        );



    boatService.getBoats($cookies.get('id'),$cookies.get('authToken'))
            .then(function (response){
                console.log("MESA STO RESPONSE");
                $scope.boats=response.data;


                }, function (response){

                }

            );



    $scope.getBoat = function (id) {
        console.log("get boat")
        boatService.getBoat(id)
            .then(function success(response) {
                    $scope.boat = response.data;
                    $scope.boat.id = id;
                    $scope.message='';
                    $scope.errorMessage = '';
                },
                function error (response) {
                    $scope.message = '';
                    if (response.status === 404){
                        $scope.errorMessage = 'User not found!';
                    }
                    else {
                        $scope.errorMessage = "Error getting user!";
                    }
                });
    };



    $scope.deleteBoat = function (id) {
        boatService.deleteBoat(id,$cookies.get('id'),$cookies.get('authToken'))
            .then(function success(response) {
                    $scope.message = 'User deleted!';
                    $scope.User = null;
                    $scope.errorMessage = '';
                    boatService.getBoats($cookies.get('id'),$cookies.get('authToken'))
                        .then(function (response) {
                                console.log("MESA STO RESPONSE");
                                $scope.boats = response.data;


                            }, function (response) {

                                console.log("to lathos m");
                            }
                        );
                },
                function error(response) {
                    $scope.errorMessage = 'Error deleting user!';
                    $scope.message = '';
                });

    }


    console.log("update boat");
    $scope.updateBoat = function () {
        console.log($scope.boat);
        $scope.boat.userId=$cookies.get('id');
        boatService.updateBoat($scope.boat,$cookies.get('authToken'))
            .then(function (response){
                $scope.boat=null;   //after one update you can add new boat
                    console.log("register boat");
                boatService.getBoats($cookies.get('id'),$cookies.get('authToken'))
                    .then(function (response){
                            console.log("MESA STO RESPONSE");
                            $scope.boats=response.data;
                            $scope.success=true;
                            $timeout(function(){$scope.success = false}, 3000);



                        }, function (response){

                            console.log("to lathos m");
                        }

                    )

                }, function (response){}

            )
    };


    $scope.registerBoat = function(){
        $state.go('registerBoat')
    };





})