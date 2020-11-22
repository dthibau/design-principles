

var userDocumentService = angular.module('userDocumentService', []);

userDocumentService.factory('userDocumentService', 
		function($http) {
			return {
				authenticate : function(membre, callback, errorHandler) {
					$http.post('/members-service/authenticate/', membre).success(callback).error(errorHandler);
				},
				register : function(idIntervenant,callback) {
					$http.post('/members-service/')
					.success(callback);
				},
				getDocuments : function(membre,callback) {
					$http.get('/documents-service/documents/owner/'+membre.email+'/').success(callback);
				}
			};
		} );

