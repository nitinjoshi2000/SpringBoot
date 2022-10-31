package com.rws.nitin.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class LoginRegisterApiThymeleafApplicationTests {
private Calculator c = new Calculator();

	@Test
	void contextLoads() {
	}

	@Test
	void TestSum(){
		int expectedResult = 10;

		int actualResult = c.doSum(4,4,2);
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	void TestProduct(){
		int expectedResult = 6;

		int actualResult = c.doProduct(3,2);
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	void TestComp(){
		boolean actualResul = c.doCompSums(3,3);
		assertThat(actualResul).isTrue();
	}

}
