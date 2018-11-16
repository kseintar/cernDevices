router.factory('userService',function ($http) {
    var userService = {}

    userService.login = function (credentials) {
        return $http.post('api/login',credentials)
            .then(function (response) {
                console.log(response)
                return response
            });

    };


    userService.signup = function (user) {
        return $http.post('api/signup',user)
            .then(function (response) {
                console.log(response)
                return response
            })

    };


    userService.validateUser = function validateUser(id,authToken){

        return $http.get('/api/validate_user/' + id, {headers: {'authToken': authToken}})
            .then(function(response){
                return response;
            });
    };



    return userService;
});