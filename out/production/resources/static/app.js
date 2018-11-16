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


        .state('listBoats',{
            url:'/listBoats' ,
            templateUrl: '/components/boats/list_boats.html',
            controller:'listBoatsController'
        })


})