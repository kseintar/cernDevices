router.factory('deviceService',function ($http) {
    var deviceService = {}



    deviceService.getDevices = function (userId,authToken) {
        return $http.get('api/get_devices/'+userId,{headers: {'authToken': authToken}})
            .then(function (response) {
                console.log(response)
                return response
            })

    };

    deviceService.deleteDevice = function deleteDevice(id,userId,authToken) {
        return $http.delete('api/delete_device/' + id + '/'+ userId,{headers: {'authToken': authToken}})


    };


    deviceService.getDevice = function getDevice(id){
        return $http({
            method : 'GET',
            url : 'api/get_device/' + id
        });
    };

    deviceService.updateDevice = function (device,authToken) {
        return $http.post('api/update_device',device,{headers: {'authToken': authToken}})
            .then(function (response) {
                console.log(response)
                return response
            })

    };

    return deviceService;
});