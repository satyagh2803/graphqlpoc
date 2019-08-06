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
	public RestTemplate restTemplate;
	//@Autowired
	//OAuthUser oAuthUser;
	
	public static final String token = "Bearer ya29.GlxbB_0PfTnYmCRINbhQl-YQK70EvsOaYj2J1NyAqe0yektFj6DXVv5G2ZLWRK6k0Vz4pf0uCyB0sgAqulqOqCGwAIuh9z9V9-PNxNmd6m8MATc2xUxKsGIHN0Ylqg";

	

	@Override
	public ProductInventoryDetail get(DataFetchingEnvironment dataFetchingEnvironment) {

		int productID = dataFetchingEnvironment.getArgument("id");

	//	MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
	   // headers.add("Authorization", String.format("%s %s", oAuthUser.getTokenType(), oAuthUser.getAccessToken()));
		
		HttpHeaders headers = new HttpHeaders();
		//headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		//headers.add("Authorization", String.format("%s %s", oAuthUser.getTokenType(), oAuthUser.getAccessToken()));
		headers.add("Authorization", token);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		//System.out.println("Access Token "+oAuthUser.getAccessToken());
		Product product = restTemplate.exchange("https://pspocmacys.appspot.com/product/productService/".trim() + productID,
		HttpMethod.GET, entity, Product.class).getBody();
		System.out.println("outputIs:" + product);

		ProductInventory productInv = restTemplate
				.exchange("https://pspocmacys.appspot.com/product/productInventoryService/".trim() + productID, HttpMethod.GET, entity,
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
