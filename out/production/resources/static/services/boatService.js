router.factory('boatService',function ($http) {
    var boatService = {}



    boatService.getBoats = function (userId,authToken) {
        return $http.get('api/get_boats/'+userId,{headers: {'authToken': authToken}})
            .then(function (response) {
                console.log(response)
                return response
            })

    };

    boatService.deleteBoat = function deleteBoat(id,userId,authToken) {
        return $http.delete('api/delete_boat/' + id + '/'+ userId,{headers: {'authToken': authToken}})


    };


    boatService.getBoat = function getBoat(id){
        return $http({
            method : 'GET',
            url : 'api/get_boat/' + id
        });
    };

    boatService.updateBoat = function (boat,authToken) {
        return $http.post('api/update_boat',boat,{headers: {'authToken': authToken}})
            .then(function (response) {
                console.log(response)
                return response
            })

    };

    return boatService;
});