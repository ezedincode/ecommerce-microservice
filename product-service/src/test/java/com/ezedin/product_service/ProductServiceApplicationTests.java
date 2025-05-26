package com.ezedin.product_service;

import com.ezedin.product_service.dto.ProductRequest;
import com.ezedin.product_service.dto.ProductResponse;
import com.ezedin.product_service.repository.ProductRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {
	@Container
	static MongoDBContainer mongoDbContainer = new MongoDBContainer("mongo:4.4.2")
			.withReuse(true);
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ProductRepository productRepository;


	@DynamicPropertySource
	static void setProperties (DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDbContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateProduct() throws Exception {
		String productRequestString =objectMapper.writeValueAsString(getProductRequest());
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(productRequestString))
				.andExpect(status().isCreated());
        Assertions.assertEquals(1, productRepository.findAll().size());

	}
	@Test
	void shouldGetAllProduct() throws Exception {
		MvcResult result =mockMvc.perform(MockMvcRequestBuilders.get("/api/product")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		String responseBody = result.getResponse().getContentAsString();
		List<ProductResponse> products = objectMapper.readValue(
				responseBody,
				new TypeReference<List<ProductResponse>>() {}
		);
		Assertions.assertEquals(productRepository.findAll().size(),products.size());

	}
	private ProductRequest getProductRequest(){
		return ProductRequest.builder()
				.name("samsung s23")
				.description("samsung s23")
				.price(BigDecimal.valueOf(1200))
				.skuCode("1234234")
				.build();
	}

}
