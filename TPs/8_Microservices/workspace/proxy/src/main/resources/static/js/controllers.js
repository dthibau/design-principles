var userDocumentControllers = angular.module('userDocumentControllers', []);


userDocumentControllers.controller('userDocumentsCtrl', [
		'$scope',
		'$http',
		'$location',
		'userDocumentService',
		function($scope, $http, $location, userDocumentService) {
			$scope.membre = {email:'Votre email',password:'Votre mot de passe'};
			$scope.$parent.showMessage=false;
			// Enter in the application
			$scope.enter = function() {
				$scope.$parent.showMessage=false;
				userDocumentService.authenticate($scope.membre,function (response) {
					$scope.$parent.membre=response;
					userDocumentService.getDocuments($scope.membre,function (response) {
						$scope.$parent.documents = response;
						return $location.path('/documents');
					});
					
				}, function (error) {
					$scope.$parent.message = 'Unable to authenticate with given credentials';
					$scope.$parent.showMessage=true;
				});
						
			};
			// Register a member
			$scope.register = function() {
				// A COMPLETER
			};

		} ]);

userDocumentControllers.controller('documentsCtrl', [
                                                 		'$scope',
                                                 		'$http',
                                                 		'$location',
                                                 		'userDocumentService',
                                                 		function($scope, $http, $location, userDocumentService) {

                                                 		} ]);

userDocumentControllers.controller('parentCtrl', [
                                              		'$scope',
                                              		function($scope) {
                                              			$scope.message = '';

                                              		} ]);
