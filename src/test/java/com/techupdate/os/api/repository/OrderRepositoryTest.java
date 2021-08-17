package com.techupdate.os.api.repository;

import com.techupdate.os.api.entity.Order;
import org.assertj.core.api.ObjectAssert;
import org.assertj.core.api.OptionalAssert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest //  ==> which is equal to @ExtendWith(SpringExtension.class)
// use this for spring application context
@DataJpaTest
//@ExtendWith(MockitoExtension.class)
//@WebMvcTest
public class OrderRepositoryTest {

//    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Disabled
    void saveOrder() {
        Order bat = new Order(111, "Bat", 15, 100);
      //  Order savedOrder = orderRepository.save(bat);
        ObjectAssert<Order> orderObjectAssert = assertThat(bat);
     //   orderObjectAssert.isEqualTo(savedOrder);
    }

    @Test
    @Disabled
    void getOrder() {
        Optional<Order> mockOrder = Optional.of(new Order(111, "Bat", 15, 100));
    //    Optional<Order> expectedOrder = orderRepository.findById(111);
//        Order order = expectedOrder.get();
      //  assertThat(expectedOrder).isNotEmpty();
//        assertThat(expected).isTrue();
    }

    @Test
    @DisplayName("Test Java 8 Support")
    @ValueSource
    void testJava8Support(){
        List<Integer> integers = Arrays.asList(2, 3, 5);
        Assertions.assertAll(() -> assertEquals(1, integers.get(0)),
                () -> assertEquals(3, integers.get(1)),
                () -> assertEquals(5, integers.get(2))
        );

    }
}