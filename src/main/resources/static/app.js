var router = angular.module('router', ['ui.router','ngCookies']);

router.config(function ($stateProvider) {

    $stateProvider
        .state('home',{
            url:'/' ,
            templateUrl: '/components/home/home.html',
            controller:'homeController'
        })
        .state('login',{
            url:'/login' ,
            templateUrl: '/components/login/login.html',
            controller:'loginController'
        })
        .state('signup',{
        url:'/signup' ,
        templateUrl: '/components/signup/signup.html',
        controller:'signupController'
         })


        .state('listDevices',{
            url:'/listDevices' ,
            templateUrl: '/components/devices/list_devices.html',
            controller:'listDevicesController'
        })


})