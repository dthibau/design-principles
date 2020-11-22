import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Order } from './order';
import { Produit } from './produit';

@Injectable({
  providedIn: 'root'
})
export class ProxyService {

	private proxyServer = 'http://localhost:8081'
	private ordersUrl =  '/order-service/api/orders/client/1'; 
	private productsUrl = '/product-service/api/produits/reference/';

  constructor(private http: HttpClient) { }

  geProduitByReference(reference): Observable<Produit> {

  }

  getOrders(): Observable<Order[]> {


}
}
