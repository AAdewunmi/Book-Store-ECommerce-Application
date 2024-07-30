package com.bookstore.service;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PaymentServices {
	private static final String CLIENT_ID = "";
	private static final String CLIENT_SECRET = "";
	
	private String mode = "";
	
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
	
	// getRedirectURLs() method
	/*
	 * private RedirectUrls getRedirectURLs() { String requestURL =
	 * request.getRequestURL().toString(); String requestURI =
	 * request.getRequestURI(); String baseURL = requestURL.replace(requestURI,
	 * "").concat(request.getContextPath());
	 * 
	 * RedirectUrls redirectUrls = new RedirectUrls(); String cancelUrl =
	 * baseURL.concat("/view_cart"); String returnUrl =
	 * baseURL.concat("/review_payment");
	 * 
	 * System.out.println("Return URL: " + returnUrl);
	 * System.out.println("Cancel URL: " + cancelUrl);
	 * 
	 * redirectUrls.setCancelUrl(cancelUrl); redirectUrls.setReturnUrl(returnUrl);
	 * 
	 * return redirectUrls; }
	 */
	
	// getAmountDetails() method
	/*
	 * private Amount getAmountDetails(BookOrder order) { Details details = new
	 * Details(); details.setShipping(String.format("%.2f",
	 * order.getShippingFee())); details.setTax(String.format("%.2f",
	 * order.getTax())); details.setSubtotal(String.format("%.2f",
	 * order.getSubtotal()));
	 * 
	 * Amount amount = new Amount(); amount.setCurrency("USD");
	 * amount.setDetails(details); amount.setTotal(String.format("%.2f",
	 * order.getTotal()));
	 * 
	 * return amount; }
	 */
	
	// getRecipientInformation() method
	/*
	 * private ShippingAddress getRecipientInformation(BookOrder order) {
	 * ShippingAddress shippingAddress = new ShippingAddress(); String recipientName
	 * = order.getFirstname() + " " + order.getLastname();
	 * shippingAddress.setRecipientName(recipientName) .setPhone(order.getPhone())
	 * .setLine1(order.getAddressLine1()) .setLine2(order.getAddressLine2())
	 * .setCity(order.getCity()) .setState(order.getState())
	 * .setCountryCode(order.getCountry()) .setPostalCode(order.getZipcode());
	 * 
	 * return shippingAddress; }
	 */
	
	
	// getTransactionInformation()
	/*
	 * private List<Transaction> getTransactionInformation(BookOrder order) {
	 * Transaction transaction = new Transaction();
	 * transaction.setDescription("Books ordered on Evergreen Books"); Amount amount
	 * = getAmountDetails(order); transaction.setAmount(amount);
	 * 
	 * ItemList itemList = new ItemList(); ShippingAddress shippingAddress =
	 * getRecipientInformation(order); itemList.setShippingAddress(shippingAddress);
	 * 
	 * List<Item> paypalItems = new ArrayList<>(); Iterator<OrderDetail> iterator =
	 * order.getOrderDetails().iterator();
	 * 
	 * while (iterator.hasNext()) { OrderDetail orderDetail = iterator.next(); Book
	 * book = orderDetail.getBook(); Integer quantity = orderDetail.getQuantity();
	 * 
	 * Item paypalItem = new Item(); paypalItem.setCurrency("USD")
	 * .setName(book.getTitle()) .setQuantity(String.valueOf(quantity))
	 * .setPrice(String.format("%.2f", book.getPrice()));
	 * 
	 * paypalItems.add(paypalItem); }
	 * 
	 * itemList.setItems(paypalItems); transaction.setItemList(itemList);
	 * 
	 * List<Transaction> listTransaction = new ArrayList<>();
	 * listTransaction.add(transaction);
	 * 
	 * return listTransaction; }
	 */
	
	
	// getApprovalURL()
	/*
	 * private String getApprovalURL(Payment authorizedPayment) { String approvalURL
	 * = null;
	 * 
	 * List<Links> links = authorizedPayment.getLinks();
	 * 
	 * for (Links link : links) { if
	 * (link.getRel().equalsIgnoreCase("approval_url")) { approvalURL =
	 * link.getHref(); break; } }
	 * 
	 * return approvalURL; }
	 */
	
	// reviewPayment()	
	/*
	 * public void reviewPayment() throws ServletException { String paymentId =
	 * request.getParameter("paymentId"); String payerId =
	 * request.getParameter("PayerID");
	 * 
	 * if (paymentId == null || payerId == null) { throw new
	 * ServletException("Error in displaying payment review"); }
	 * 
	 * APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, mode);
	 * 
	 * try { Payment payment = Payment.get(apiContext, paymentId);
	 * 
	 * PayerInfo payerInfo = payment.getPayer().getPayerInfo(); Transaction
	 * transaction = payment.getTransactions().get(0); ShippingAddress
	 * shippingAddress = transaction.getItemList().getShippingAddress();
	 * 
	 * request.setAttribute("payer", payerInfo); request.setAttribute("recipient",
	 * shippingAddress); request.setAttribute("transaction", transaction);
	 * 
	 * String reviewPage = "frontend/review_payment.jsp?paymentId=" + paymentId +
	 * "&PayerID=" + payerId;
	 * request.getRequestDispatcher(reviewPage).forward(request, response);
	 * 
	 * } catch (PayPalRESTException | IOException e) { e.printStackTrace(); throw
	 * new ServletException("Error in getting payment details from PayPal."); } }
	 */
}
