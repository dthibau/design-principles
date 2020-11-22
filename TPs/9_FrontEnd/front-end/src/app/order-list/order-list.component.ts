import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { OrderItem } from '../orderItem';
import { Produit } from '../produit';
import { ProxyService } from '../proxy.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  orders: Order[]
  productsMap: Map<string, Produit>

  constructor(private proxyService: ProxyService) { }

  ngOnInit() {
    
  }

}
