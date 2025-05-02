package order.module;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class OrderService {
	
	@Autowired
	
	private OrderRepository orderRepository;
	

	//All order retrieval
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	
	//specific id data retrieval


	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id).orElse(null);
	}

	
	//creation of data

	public Order save(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	
	//updation of data
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}



	//deletion of data

	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		orderRepository.deleteById(id);
		
	}



}
