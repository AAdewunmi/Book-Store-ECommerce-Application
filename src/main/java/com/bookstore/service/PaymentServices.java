package com.bookstore.service;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PaymentServices {
	private static final String CLIENT_ID = "";
	private static final String CLIENT_SECRET = "";
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public PaymentServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
	}
	
	
	// authorizePayment() method
	public void authorizePayment(BookOrder order) {
		/*
		 * Payer payer = getPayerInformation(order); RedirectUrls redirectUrls =
		 * getRedirectURLs();
		 * 
		 * List<Transaction> transactions = getTransactionInformation(order);
		 * 
		 * Payment requestPayment = new Payment(); requestPayment.setPayer(payer)
		 * .setRedirectUrls(redirectUrls) .setIntent("authorize")
		 * .setTransactions(transactions);
		 * 
		 * System.out.println("====== REQUEST PAYMENT: ======");
		 * System.out.println(requestPayment);
		 * 
		 * APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, mode);
		 * 
		 * try { Payment authorizedPayment = requestPayment.create(apiContext);
		 * System.out.println("====== AUTHORIZED PAYMENT: ======");
		 * System.out.println(authorizedPayment);
		 * 
		 * String approvalURL = getApprovalURL(authorizedPayment);
		 * 
		 * response.sendRedirect(approvalURL);
		 * 
		 * } catch (PayPalRESTException e) { e.printStackTrace(); throw new
		 * ServletException("Error in authorizing payment."); }
		 */
		
		// get approval link
		
		// redirect to Paypal's payment page
	}
	
	
	// getPayerInformation() method
	/*
	 * private Payer getPayerInformation(BookOrder order) { Payer payer = new
	 * Payer(); payer.setPaymentMethod("paypal");
	 * 
	 * Customer customer = order.getCustomer();
	 * 
	 * PayerInfo payerInfo = new PayerInfo();
	 * payerInfo.setFirstName(customer.getFirstname());
	 * payerInfo.setLastName(customer.getLastname());
	 * payerInfo.setEmail(customer.getEmail()); payer.setPayerInfo(payerInfo);
	 * 
	 * return payer; }
	 */
}
