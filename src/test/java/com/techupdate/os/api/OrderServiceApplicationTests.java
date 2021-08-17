package com.techupdate.os.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest
class OrderServiceApplicationTests {

	@Test
	void contextLoads() {
		Calculator c = new Calculator(10, 20);
		int result = c.add();

		assertThat(result).isEqualTo(30);
	}

	private  class  Calculator{
		private int a;
		private int b;

		Calculator(int a, int b){
			this.a = a;
			this.b = b;
		}

		int add(){
			return  a + b;
		}
	}

}
