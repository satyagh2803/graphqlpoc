package com.infy.poc.ProductAggregatorServiceGraphQLPoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.poc.ProductAggregatorServiceGraphQLPoc.graphql.GraphQLService;

import graphql.ExecutionResult;

@RestController
@RequestMapping(path = "/productAggregator")
public class ProductAggregatorController {
	
	@Autowired
	GraphQLService graphQLService;

	@PostMapping
	public ResponseEntity<Object> getProductDetail(@RequestBody String query) {
		ExecutionResult execute = graphQLService.getGraphQL().execute(query);

		return new ResponseEntity<>(execute, HttpStatus.OK);
	}
}
