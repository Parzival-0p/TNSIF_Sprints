import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Order } from './order.model';
import { OrderService } from './order.service';
declare var bootstrap: any;
@Component({
  standalone: false,
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'order-service-frontend';
  orderDetails: Order[] = [];
  orderToUpdate: Order = {
    orderId: 0,
    customerName: '',
    product: '',
    quantity: 0
  };

  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.getOrders();
  }

  getOrders(): void {
    this.orderService.getOrders().subscribe({
      next: (response) => {
        this.orderDetails = response;
      },
      error: (error) => {
        console.error('Error fetching orders:', error);
      }
    });
  }

  register(orderForm: NgForm): void {
    if (orderForm.valid) {
      const order: Order = orderForm.value;
      this.orderService.createOrder(order).subscribe({
        next: (response) => {
          this.getOrders();
          orderForm.reset();
        },
        error: (error) => {
          console.error('Error creating order:', error);
        }
      });
    }
  }

  edit(order: Order): void {
    this.orderToUpdate = { ...order };
  }

  updateOrder(): void {
    this.orderService.updateOrder(this.orderToUpdate).subscribe({
      next: () => {
        this.getOrders();
        // Close modal programmatically
        const modalElement = document.getElementById('exampleModal');
        const modalInstance = bootstrap.Modal.getInstance(modalElement!);
        modalInstance?.hide();
      },
      error: (error) => {
        console.error('Error updating order:', error);
      }
    });
  }

  deleteOrder(order: Order): void {
    if (confirm('Are you sure you want to delete this order?')) {
      this.orderService.deleteOrder(order.orderId).subscribe({
        next: () => {
          this.getOrders();
        },
        error: (error) => {
          console.error('Error deleting order:', error);
        }
      });
    }
  }
}