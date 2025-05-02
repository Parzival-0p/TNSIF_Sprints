package order.module;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("table_order")

public class OrderController {
	
	@Autowired
	
	private OrderService orderService; //dependency injection
	
	
	@GetMapping
	public List<Order> getAllOrders()
	{
		return orderService.getAllOrders(); //retrieving all the data
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable int id)
	{
		
		
		Order order = orderService.getOrderById(id);
		
		
		if(order != null)
		{
			
			return ResponseEntity.ok(order);
				
	}
	
	
	else {
		
		return ResponseEntity.notFound().build();
	}
		
		
	}
	
	@PostMapping
	public Order createOrder(@RequestBody Order order)
	
	{
		return orderService.save(order);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Order orderDetails)
	{
		Order order = orderService.getOrderById(id);
				
				
		if(order != null)
		{
			order.setCustomerName(orderDetails.getCustomerName());
			order.setProduct(orderDetails.getProduct());
			order.setQuantity(orderDetails.getQuantity());
			
			
			
			Order updatedOrder = orderService.updateOrder(order);
			
			return ResponseEntity.ok(updatedOrder);
		}
		
		
		else
		{
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable int id)
	{
		Order order = orderService.getOrderById(id);
				
				
		if(order != null)
		{
		
			
			
			orderService.deleteOrder(id);
			
			return ResponseEntity.ok().build();
		}
		
		
		else
		{
			return ResponseEntity.notFound().build();
		}
	
	}

}
