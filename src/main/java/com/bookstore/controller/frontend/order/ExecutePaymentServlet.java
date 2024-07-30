package com.bookstore.controller.frontend.order;

import java.io.IOException;

import com.bookstore.service.OrderServices;
import com.bookstore.service.PaymentServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transaction;


@WebServlet("/execute_payment")
public class ExecutePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecutePaymentServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/*
		 * PaymentServices paymentServices = new PaymentServices(request, response);
		 * 
		 * try { Payment payment = paymentServices.executePayment();
		 * 
		 * OrderServices orderServices = new OrderServices(request, response); Integer
		 * orderId = orderServices.placeOrderPaypal(payment);
		 * 
		 * HttpSession session = request.getSession(); session.setAttribute("orderId",
		 * orderId);
		 * 
		 * PayerInfo payerInfo = payment.getPayer().getPayerInfo(); Transaction
		 * transaction = payment.getTransactions().get(0);
		 * 
		 * session.setAttribute("payer", payerInfo); session.setAttribute("transaction",
		 * transaction);
		 * 
		 * String receiptPage = "frontend/payment_receipt.jsp";
		 * request.getRequestDispatcher(receiptPage).forward(request, response);
		 * 
		 * } catch (PayPalRESTException e) { e.printStackTrace(); throw new
		 * ServletException("Error in executing payment."); }
		 */
	}

}
