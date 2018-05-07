'use strict';

var services = angular.module('UsuariosApp.services', ['ngResource']);

var baseUrl = 'http://localhost:8080/prova/rest';

services.factory('UsersFactory', function ($resource) {
    return $resource(baseUrl + '/usuarios/', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});

services.factory('UserFactory', function ($resource) {
    return $resource(baseUrl + '/usuarios/:cpf', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {cpf: '@cpf'} },
        delete: { method: 'DELETE', params: {cpf: '@cpf'} }
    })
});