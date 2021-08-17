package com.techupdate.os.api.common;

import com.techupdate.os.api.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    private Order order;
    private String transactionId;
    private Double amount;
    private String transactionResponse;
}
