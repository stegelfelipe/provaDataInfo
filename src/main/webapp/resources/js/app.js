'use strict';

angular.module('UsuariosApp', [
  'UsuariosApp.services',
  'UsuariosApp.controllers'
  ])
.config(function ($routeProvider, $httpProvider) {
  $routeProvider.when('/user-list', {templateUrl: 'index2.html', controller: 'UserListCtrl'});
  $routeProvider.when('/editarUsuario/:cpf', {templateUrl: 'editarUsuario.html', controller: 'UserDetailCtrl'});
  $routeProvider.when('/incluirUsuario', {templateUrl: 'incluirUsuario.html', controller: 'UserCreationCtrl'});
  

  /* CORS... */
  
  $httpProvider.defaults.useXDomain = true;
  delete $httpProvider.defaults.headers.common['X-Requested-With'];
});