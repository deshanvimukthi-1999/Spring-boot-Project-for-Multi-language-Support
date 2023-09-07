// package com.example.demo;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.MvcResult;

// import static org.assertj.core.api.Assertions.assertThat;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.mockito.Mockito.doNothing;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

// import com.example.demo.controller.SupplierController;
// import com.example.demo.entity.Supplier;
// import com.example.demo.repository.SupplierRepository;
// import com.example.demo.service.SupplierService;
// import com.fasterxml.jackson.databind.ObjectMapper;

// @WebMvcTest(SupplierController.class)
// public class SupplierControllerTest {

// 	private static final String END_POINT_PATH = "/api/supplier";

// 	@Autowired
// 	private MockMvc mockmvc;

// 	@Autowired
// 	private ObjectMapper objectMapper;

// 	@MockBean
// 	private SupplierRepository supplierRepository;

// 	@MockBean
// 	private SupplierService supplierService;
	
// 	private Supplier supplier;
// 	private Supplier supplier1;
// 	private Supplier invalidSupplier;
// 	private Supplier updatedSupplier;
// 	private Supplier supplierToBeDeleted;
	
// 	@BeforeEach
// 	void init() {
// 		supplier = new Supplier();
// 		supplier.setSupplierId(1L);
// 		supplier.setAddress("469");
// 		supplier.setContactDetails("0774476755");
// 		supplier.setSpecialties("3 products");
// 		supplier.setSupplierName("Ishara");

// 		supplier1 = new Supplier();
// 		supplier1.setSupplierId(2L);
// 		supplier1.setAddress("400");
// 		supplier1.setContactDetails("0774476755");
// 		supplier1.setSpecialties("3 products");
// 		supplier1.setSupplierName("Thishara");
		
// 		invalidSupplier = new Supplier();
// 		invalidSupplier.setSupplierId(3L);
// 		invalidSupplier.setAddress("364");
// 		invalidSupplier.setSpecialties("3 products");
// 		invalidSupplier.setSupplierName("");
// 		invalidSupplier.setContactDetails(""); 
		
// 		updatedSupplier = new Supplier();
// 		updatedSupplier.setSupplierId(4L);
// 		updatedSupplier.setAddress("256");
// 		updatedSupplier.setContactDetails("0769367058");
// 		updatedSupplier.setSpecialties("5 products");
// 		updatedSupplier.setSupplierName("Nalinda");
		
// 		supplierToBeDeleted = new Supplier();
// 	    supplierToBeDeleted.setSupplierId(5L);
// 	    supplierToBeDeleted.setAddress("256");
// 	    supplierToBeDeleted.setContactDetails("0769367058");
// 	    supplierToBeDeleted.setSpecialties("5 products");
// 	    supplierToBeDeleted.setSupplierName("Nalinda");
// 	}

// 	@Test
// 	public void testGetAllSuppliers() throws Exception {
// 		List<Supplier> listSuppliers = new ArrayList<>();
// 		listSuppliers.add(supplier);
// 		listSuppliers.add(supplier1);

// 		Mockito.when(supplierService.getAllSuppliers()).thenReturn(listSuppliers);

// 		String url = "/api/suppliers/";

// 		MvcResult mvcResult = mockmvc.perform(get(url)).andExpect(status().isOk()).andReturn();
// 		String actualResponse = mvcResult.getResponse().getContentAsString();
// 		System.out.println(actualResponse);

// 		String expectedResult = objectMapper.writeValueAsString(listSuppliers);
// 		assertThat(actualResponse).isEqualToIgnoringWhitespace(expectedResult);
// 		assertEquals(2, listSuppliers.size());
// 		assertNotNull(listSuppliers);
// 	}
	
// 	@Test
// 	public void testGetAllSuppliersEmptyList() throws Exception {
// 	    List<Supplier> emptySupplierList = new ArrayList<>();

// 	    Mockito.when(supplierService.getAllSuppliers()).thenReturn(emptySupplierList);

// 	    MvcResult mvcResult = mockmvc.perform(get("/api/suppliers/"))
// 	            .andExpect(status().isOk())
// 	            .andReturn();

// 	    String actualResponse = mvcResult.getResponse().getContentAsString();
// 	    String expectedResponse = objectMapper.writeValueAsString(emptySupplierList);
// 	    assertThat(actualResponse).isEqualToIgnoringWhitespace(expectedResponse);
// 	    assertEquals(0, emptySupplierList.size());
// 	    assertNotNull(emptySupplierList);
// 	}
	
// 	@Test
// 	public void testGetSupplierById() throws Exception {
// 		Mockito.when(supplierService.getSupplierById(2L)).thenReturn(supplier);

// 		MvcResult mvcResult = mockmvc.perform(get("/api/suppliers/2")).andExpect(status().isOk()).andReturn();
		
// 		String actualResponse = mvcResult.getResponse().getContentAsString();
// 		String expectedResponse =objectMapper.writeValueAsString(supplier);
// 		assertThat(actualResponse).isEqualToIgnoringWhitespace(expectedResponse);
// 		assertNotNull(supplier1);
// 		assertThat(supplier1.getSupplierId()).isEqualTo(2L);	
// 	}
	
// 	@Test
// 	public void testGetNonExistingSupplierById() throws Exception {
// 	    Long nonExistingSupplierId = 999L;

// 	    Mockito.when(supplierService.getSupplierById(nonExistingSupplierId))
// 	           .thenReturn(null);

// 	    mockmvc.perform(get("/api/suppliers/999", nonExistingSupplierId))
// 	           .andExpect(status().isNotFound());
// 	}
	
// 	@Test
// 	public void testGetExistingSupplierById() throws Exception {
// 	    Long existingSupplierId = 2L;

// 	    Mockito.when(supplierService.getSupplierById(existingSupplierId))
// 	           .thenReturn(supplier);

// 	    MvcResult result = mockmvc.perform(get("/api/suppliers/" + existingSupplierId))
// 	            .andExpect(status().isOk())
// 	            .andReturn();

// 	    String actualResponse = result.getResponse().getContentAsString();
// 	    String expectedResponse = objectMapper.writeValueAsString(supplier);
// 	    assertThat(actualResponse).isEqualToIgnoringWhitespace(expectedResponse);
// 	}

// 	@Test
// 	public void testCreateSupplier() throws Exception {	
// 		String jsonSupplier = objectMapper.writeValueAsString(supplier);

// 		Mockito.when(supplierService.createSupplier(supplier)).thenReturn(supplier);

// 		mockmvc.perform(post("/api/suppliers").contentType(MediaType.APPLICATION_JSON).content(jsonSupplier))
// 				.andExpect(status().isOk());
// 		assertThat(supplier.getSupplierName()).isEqualTo("Ishara");
// 		assertNotNull(supplier);
// 	}

// 	@Test
// 	public void testCreateSupplierWithInvalidData() throws Exception {

// 	    Mockito.when(supplierService.createSupplier(Mockito.any(Supplier.class)))
// 	           .thenThrow(new IllegalArgumentException());

// 	    String jsonSupplier = objectMapper.writeValueAsString(supplier);

// 	    mockmvc.perform(post("/api/suppliers")
// 	            .contentType(MediaType.APPLICATION_JSON)
// 	            .content(jsonSupplier))
// 	            .andExpect(status().isBadRequest()) // Expecting a 400 Bad Request due to invalid data
// 	            .andReturn();
// 	}
	
// 	@Test
// 	public void testCreateSupplierWithExistingId() throws Exception {
// 	    Long existingSupplierId = 1L;

// 	    Mockito.when(supplierService.existsSupplierWithId(existingSupplierId)).thenReturn(true);

// 	    String jsonSupplier = objectMapper.writeValueAsString(supplier);

// 	    mockmvc.perform(post("/api/suppliers")
// 	            .contentType(MediaType.APPLICATION_JSON)
// 	            .content(jsonSupplier))
// 	            .andExpect(status().isConflict()) //409
// 	            .andReturn();
// 	}
	
// 	@Test
// 	public void testCreateSupplierWithValidData() throws Exception {

// 	    Mockito.when(supplierService.createSupplier(Mockito.any(Supplier.class)))
// 	           .thenReturn(supplier);

// 	    String jsonSupplier = objectMapper.writeValueAsString(supplier);

// 	    mockmvc.perform(post("/api/suppliers")
// 	            .contentType(MediaType.APPLICATION_JSON)
// 	            .content(jsonSupplier))
// 	            .andExpect(status().isOk()) //200
// 	            .andReturn();
// 	}
	
// 	@Test
// 	public void testUpdateExistingSupplier() throws Exception {
// 		Long supplierId = 1L;
// 		String requestURL = END_POINT_PATH + "/" + supplierId;
		
// 		List<Supplier> listSuppliers = new ArrayList<>();
// 		listSuppliers.add(new Supplier(1L, "Nalinda", "123", "1234567890", "2 products"));

// 		Mockito.when(supplierService.getAllSuppliers()).thenReturn(listSuppliers);
// 		Mockito.when(supplierService.updateSupplier(1L, updatedSupplier)).thenReturn(
// 				updatedSupplier);

// 		String jsonUpdatedSupplier = objectMapper.writeValueAsString(updatedSupplier);

// 		mockmvc.perform(put(requestURL).contentType(MediaType.APPLICATION_JSON)
// 				.content(jsonUpdatedSupplier))
// 				.andExpect(status().isNotFound());
		
// 		assertEquals("256", updatedSupplier.getAddress());
// 		assertNotNull(updatedSupplier);
// 	}
	
// 	@Test
// 	public void testUpdateNonExistingSupplier() throws Exception {
// 	    Long nonExistingSupplierId = 999L;
// 	    Supplier updatedSupplier = new Supplier();

// 	    Mockito.when(supplierService.updateSupplier(nonExistingSupplierId, updatedSupplier))
// 	           .thenReturn(null);

// 	    String jsonUpdatedSupplier = objectMapper.writeValueAsString(updatedSupplier);
	    
// 	    mockmvc.perform(put("/api/suppliers/999", nonExistingSupplierId)
// 	           .contentType(MediaType.APPLICATION_JSON).content(jsonUpdatedSupplier))
// 	           .andExpect(status().isNotFound());
// 	}
	
// 	@Test
// 	public void testUpdateSupplierBadRequest() throws Exception {
// 		    Long supplierId = 2L;
// 		    String requestURL = "/api/suppliers/2";

// 		    Mockito.when(supplierService.getSupplierById(supplierId)).thenReturn(supplier);

// 		    String invalidJson = "{invalid-json}";

// 		    mockmvc.perform(put(requestURL)
// 		            .contentType(MediaType.APPLICATION_JSON)
// 		            .content(invalidJson))
// 		            .andExpect(status().isBadRequest())
// 		            .andReturn();
// 	}

// 	@Test
// 	public void testDeleteSupplier() throws Exception {
// 		Long supplierIdToDelete = 5L;

// 	    Mockito.when(supplierRepository.findById(supplierIdToDelete))
// 	           .thenReturn(Optional.of(supplierToBeDeleted));

// 	    doNothing().when(supplierService).deleteSupplier(supplierIdToDelete);

// 	    mockmvc.perform(delete( "/api/suppliers/5"))
//         .andExpect(status().isNoContent())
//         .andReturn();
// 	}
	
// 	@Test
// 	public void testDeleteNonExistingSupplier() throws Exception {
// 		Long nonExistingSupplierId = 999L;

// 		Mockito.doNothing().when(supplierService).deleteSupplier(nonExistingSupplierId);

// 	    mockmvc.perform(delete("/api/suppliers/999", nonExistingSupplierId))
// 	           .andExpect(status().isNoContent()); //204
// 	}
// }