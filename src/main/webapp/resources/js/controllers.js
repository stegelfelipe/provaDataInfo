'use strict';

/* Controllers */

var app = angular.module('UsuariosApp.controllers', []);


// Clear browser cache (in development mode)

app.run(function ($rootScope, $templateCache) {
  $rootScope.$on('$viewContentLoaded', function () {
    $templateCache.removeAll();
  });
});


app.controller('UserListCtrl', ['$scope', 'UsersFactory', 'UserFactory', '$location',
  function ($scope, UsersFactory, UserFactory, $location) {

    /* callback for ng-click 'editarUsuario': */
    $scope.editarUsuario = function (userCPF) {
      $location.path('/editarUsuario/' + userCPF);
    };

    /* callback for ng-click 'deletarUsuario': */
    $scope.deletarUsuario = function (userCPF) {
      UserFactory.delete({ cpf: userCPF });
      $scope.users = UsersFactory.query();
    };

    /* callback for ng-click 'incluirUsuario': */
    $scope.incluirUsuario = function () {
      $location.path('/incluirUsuario');
    };

    $scope.users = UsersFactory.query();
  }]);

app.controller('UserDetailCtrl', ['$scope', '$routeParams', 'UserFactory', '$location',
  function ($scope, $routeParams, UserFactory, $location) {

    /* callback for ng-click 'updateUsuario': */
    $scope.updateUsuario = function () {
      UserFactory.update($scope.user);
      $location.path('/user-list');
    };

    /* callback for ng-click 'cancel': */
    $scope.cancelar = function () {
      $location.path('/user-list');
    };

    $scope.user = UserFactory.show({cpf: $routeParams.cpf});
  }]);

app.controller('UserCreationCtrl', ['$scope', 'UsersFactory', '$location',
  function ($scope, UsersFactory, $location) {

    /* callback for ng-click 'createUsuario': */
    $scope.createUsuario = function () {
      UsersFactory.create($scope.user);
      $location.path('/user-list');
    }
  }]);