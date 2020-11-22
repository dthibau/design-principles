import { OrderItem } from './orderItem';

export class Order {
  id: number;

  date: Date;

  orderItems: OrderItem[];
}
