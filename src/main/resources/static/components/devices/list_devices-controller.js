router.controller('listDevicesController',function ($scope, $http, $state,$cookies,$timeout,deviceService,userService) {

    console.log("list of devices");


    userService.validateUser($cookies.get('id'),$cookies.get('authToken'))
        .then(function (response){

            }, function (response){

                $state.go('home');
            }

        );



    deviceService.getDevices($cookies.get('id'),$cookies.get('authToken'))
            .then(function (response){
                console.log("MESA STO RESPONSE");
                $scope.devices=response.data;


                }, function (response){

                }

            );



    $scope.getDevice = function (id) {
        console.log("get device")
        deviceService.getDevice(id)
            .then(function success(response) {
                    $scope.device = response.data;
                    $scope.device.id = id;
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



    $scope.deleteDevice = function (id) {
        deviceService.deleteDevice(id,$cookies.get('id'),$cookies.get('authToken'))
            .then(function success(response) {
                    $scope.message = 'User deleted!';
                    $scope.User = null;
                    $scope.errorMessage = '';
                    deviceService.getDevices($cookies.get('id'),$cookies.get('authToken'))
                        .then(function (response) {
                                console.log("MESA STO RESPONSE");
                                $scope.devices = response.data;


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


    console.log("update device");
    $scope.updateDevice = function () {
        console.log($scope.device);
        $scope.device.userId=$cookies.get('id');
        deviceService.updateDevice($scope.device,$cookies.get('authToken'))
            .then(function (response){
                $scope.device=null;   //after one update you can add new device
                    console.log("register device");
                deviceService.getDevices($cookies.get('id'),$cookies.get('authToken'))
                    .then(function (response){
                            console.log("MESA STO RESPONSE");
                            $scope.devices=response.data;
                            $scope.success=true;
                            $timeout(function(){$scope.success = false}, 3000);



                        }, function (response){

                            console.log("to lathos m");
                        }

                    )

                }, function (response){}

            )
    };


    $scope.registerDevice = function(){
        $state.go('registerDevice')
    };





})