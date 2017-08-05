package com.data.api.controller;
  
import java.io.File; 
import java.io.IOException;

import javax.annotation.PostConstruct;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;

import com.data.api.datafetcher.AddressDataFetcher;
import com.data.api.datafetcher.AllPeopleDataFetcher;
import com.data.api.datafetcher.PersonDataFetcher;
 
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@RestController
public class QueryController {
	private final Logger LOGGER = LoggerFactory.getLogger(QueryController.class);
	
	@Value("classpath:person.graphqls")
	private Resource schemaResource;
	
	private GraphQL graphQL;

	@Autowired
	private AllPeopleDataFetcher allPeopleDataFetcher;

	@Autowired
	private PersonDataFetcher personDateFetcher;

	@Autowired
	private AddressDataFetcher addressDataFetcher;
	
	@PostConstruct
	public void loadSchema() throws IOException{
		File schemaFile = schemaResource.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}
	
	private RuntimeWiring buildRuntimeWiring() {  
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring -> typeWiring
								.dataFetcher("allPeople", allPeopleDataFetcher)
								.dataFetcher("person", personDateFetcher))
				.type("Person", typeWiring -> typeWiring
								.dataFetcher("addresses", addressDataFetcher))
				.build();
	}

	@RequestMapping(value="/query", method=RequestMethod.POST)
	public ResponseEntity query(@RequestBody String query){  
		System.out.println(query);
		ExecutionResult result = graphQL.execute(query);
		System.out.println(result.getData().toString());
		LOGGER.info(String.valueOf(result.getErrors()));   
		return ResponseEntity.ok(result.getData());
	}
	
		
}
