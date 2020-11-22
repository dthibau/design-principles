var userDocumentApp = angular.module('userDocumentApp', [
		'ngRoute',
		'userDocumentControllers', 
		'userDocumentService'
]);


userDocumentApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'partials/login.html',
		controller : 'userDocumentsCtrl'
	}).when('/documents', {
		templateUrl : 'partials/documents.html',
		controller : 'documentsCtrl'
	}).otherwise({
		redirectTo : '/'
	});
} ]);
