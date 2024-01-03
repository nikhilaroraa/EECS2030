package lab6;

import java.io.*;
import java.util.*;

/**
 * The {@code Container} class is a generic container that can hold objects. It
 * provides methods for adding and removing objects, as well as querying the
 * size of the container.
 * Your implementation of this class or methods should not contains:
 * 1. No System.out.println statements should appear here. Instead, you need to
 * return the result. 2. No Scanner operations should appear here (e.g.,
 * input.nextInt()). Instead, refer to the input parameters of this method.
 *
 *
 */
public class Container {
	public Container() {
		
	}
	
	public void add(Object object) {
		
	}
	
	public Object remove() {
		
	}
	
	public int getSize() {
		
	}
	
}

/**
 * The {@code Queue} class simulates a queue data structure, inserting and
 * removing data by the FIFO (first-in, first-out) rule. It stores orders with a
 * total amount above or equal to 1500 in the queue.
 *
 */
class Queue extends Container {
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */

	
}

/**
 * The {@code Stack} class simulates a stack data structure, inserting and
 * removing data by the FILO (first-in, last-out) rule. It stores orders with a
 * total amount below 1500 in the stack.
 *
 */
class Stack extends Container {
	
	private ArrayList<Order> stack;
	
	public Stack(String fileName) {
		super();
		stack = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                
                if (parts.length == 5) {
                    int orderID = Integer.parseInt(parts[0]);
                    String customerName = parts[1];
                    String productName = parts[2];
                    int quantity = Integer.parseInt(parts[3]);
                    double unitPrice = Double.parseDouble(parts[4]);
                    double totalAmount = quantity * unitPrice;

                    if (totalAmount < 1500) {
                        Order order = new Order(orderID, customerName, productName, quantity, unitPrice);
                        super.add(order);
                        stack.add(order);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	
}

/**
 * The {@code IOHandler} class provides static methods for handling input and
 * output operations with files. It allows reading content from a file and
 * writing content to a file.
 *
 */
class IOHandler {
	
	public IOHandler() {
		
	}
	
	public static List<String> readFile(String fileName){
		
	}
	
	public static void writeFile(String fileName, List<String> content) {
		
	}

	
}

/**
 * The {@code Order} class represents an order in the order processing system.
 * It encapsulates information about the order such as order ID, customer name,
 * product name, quantity, and unit price.
 *
 */
class Order {
	
	private String customerName;
	private int orderId;
	private String productName;
	private int quantity;
	private double unitPrice;
	
	public Order(int orderId, String customerName, String productName, int quantity, double unitPrice) {
		this.customerName = customerName;
		this.orderId = orderId;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	public double getTotalAmount() {
		double total = quantity*unitPrice;
		return Math.round(total*100.0)/100.0;
	}

	@Override
	public String toString() {
		String formattedUnitPrice = String.format("%2f", unitPrice);
		return "[" + customerName + ", " + orderId + ", " + productName	+ ", " + quantity + ", " + formattedUnitPrice + "]";
	}
	
	
	
	
}