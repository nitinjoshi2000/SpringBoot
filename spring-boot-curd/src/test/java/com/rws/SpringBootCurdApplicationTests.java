package com.rws;

import com.rws.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.SQLOutput;
import java.util.Collections;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest
class SpringBootCurdApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	ProductRepository productRepository;

	@Test
	void contextLoads() throws Exception {

		when(productRepository.findAll()).thenReturn(
				Collections.emptyList()
		);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products")
				.accept(MediaType.APPLICATION_JSON)
		).andReturn();
		System.out.println(mvcResult.getResponse());

		verify(productRepository).findAll();
	}

}

