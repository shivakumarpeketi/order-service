package com.techupdate.os.api.service;

import com.techupdate.os.api.common.Payment;
import com.techupdate.os.api.common.TransactionRequest;
import com.techupdate.os.api.common.TransactionResponse;
import com.techupdate.os.api.entity.Order;
import com.techupdate.os.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse save(TransactionRequest request) {
        String paymentStatus = "";
        Order order = request.getOrder();
        Payment payment = new Payment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice() * order.getQty());

        // REST Call
        Payment paymentResponse = restTemplate.postForObject("http://payment-service/payment/payments", payment, Payment.class);
        if (paymentResponse.getPaymentStatus().equals("Success")) {
            paymentStatus = "Payment succeeded and order placed";
        } else {
            paymentStatus = "Payment Failed so order not placed";
        }
        orderRepository.save(order);
        return new TransactionResponse(order, paymentResponse.getTransactionId(), paymentResponse.getAmount(), paymentStatus);
    }

    /*public static void main(String[] args) {
        System.out.println("hi");
        String[] list = {"kkdjfk", "dkfd", "sdd", "dfjdlkf", "vv"};
        Stream<String> stream = Stream.iterate("list", str -> str + "x");
        System.out.println(stream
                .limit(3)
                .map(s -> s+ "y"));
    }*/

    public Order getOrder(int orderId) throws Exception {
        return orderRepository.getOrder(orderId).orElseThrow(() -> new Exception("Order not found - " + orderId));
    }
}
