package com.infy.poc.ProductAggregatorServiceGraphQLPoc.graphql.datafetcher;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.infy.poc.ProductAggregatorServiceGraphQLPoc.DTO.Product;
import com.infy.poc.ProductAggregatorServiceGraphQLPoc.DTO.ProductInventory;
import com.infy.poc.ProductAggregatorServiceGraphQLPoc.DTO.ProductInventoryDetail;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ProductInventoryDataFatcher implements DataFetcher<ProductInventoryDetail> {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public ProductInventoryDetail get(DataFetchingEnvironment dataFetchingEnvironment) {

		int productID = dataFetchingEnvironment.getArgument("id");

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		Product product = restTemplate.exchange("https://pspocmacys.appspot.com/product/productService/" + productID,
				HttpMethod.GET, entity, Product.class).getBody();
		System.out.println("outputIs:" + product);

		ProductInventory productInv = restTemplate
				.exchange("https://pspocmacys.appspot.com/product/productInventoryService/" + productID, HttpMethod.GET, entity,
						ProductInventory.class)
				.getBody();
		System.out.println("outputIs:" + productInv);

		ProductInventoryDetail pIDetail = new ProductInventoryDetail();
		pIDetail.setProductID(product.getProductID());
		pIDetail.setProductName(product.getProductName());
		pIDetail.setProductInventory(productInv.getProductInventory());

		return pIDetail;
	}

}
