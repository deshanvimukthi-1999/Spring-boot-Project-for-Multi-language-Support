// package com.example.demo;

// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
// import org.springframework.boot.test.web.server.LocalServerPort;
// import org.springframework.http.MediaType;
// import org.springframework.web.client.RestTemplate;

// import com.example.demo.controller.SupplierController;
// import com.example.demo.entity.Supplier;

// import io.restassured.module.mockmvc.RestAssuredMockMvc;
// import static io.restassured.RestAssured.*;
// import static org.hamcrest.Matchers.*;

// @SpringBootTest(webEnvironment  = WebEnvironment.RANDOM_PORT)
// class DemoApplicationTests {

// 	@LocalServerPort
// 	private int port;
	
// 	@BeforeAll
// 	public static void init() {
// 		new RestTemplate();
// 	}
	
// 	@BeforeEach
//     public void setUp() {
//         RestAssuredMockMvc.standaloneSetup(new SupplierController());
//     }

//     @Test
//     public void testCRUDOperations() {
//         // Create
//         Supplier supplier = new Supplier();
//         supplier.setSupplierId(46L);
//         supplier.setSupplierName("Sanka");
//         supplier.setAddress("469");
// 		supplier.setContactDetails("0774476755");
// 		supplier.setSpecialties("hardware");

//         given()
//             .contentType(MediaType.APPLICATION_JSON_VALUE)
//             .body(supplier)
//         .when()
//             .post("http://localhost:" + port + "/api/suppliers")
//         .then()
//             .statusCode(200)
//             .body("supplierName", equalTo("Sanka"))
//             .body("address", equalTo("469"))
//             .extract().as(Supplier.class);

//         // Read
//         System.out.println("Supplier ID: " + supplier.getSupplierId());
//         get("http://localhost:" + port + "/api/suppliers/{id}", supplier.getSupplierId())
//             .then()
//             .statusCode(200)
//             .body("supplierName", equalTo("Sanka"))
//             .body("address", equalTo("469"));

//         // Update
//         supplier.setAddress("123");
//         given()
//             .contentType(MediaType.APPLICATION_JSON_VALUE)
//             .body(supplier)
//         .when()
//             .put("http://localhost:" + port + "/api/suppliers/{id}", supplier.getSupplierId())
//         .then()
//             .statusCode(200)
//             .body("address", equalTo("123"));

//         // Delete
//         delete("http://localhost:" + port + "/api/suppliers/{id}", supplier.getSupplierId())
//             .then()
//             .statusCode(204);
//     }	
    
//     @Test
//     public void testReadNonExistingSupplier() {
//         Long nonExistingSupplierId = 999L;

//         get("http://localhost:" + port + "/api/suppliers/{id}", nonExistingSupplierId)
//             .then()
//             .statusCode(404);
//     }
    
    
//     @Test
//     public void testDeleteNonExistingSupplier() {
//         Long nonExistingSupplierId = 999L;

//         delete("http://localhost:" + port + "/api/suppliers/{id}", nonExistingSupplierId)
//             .then()
//             .statusCode(204);
//     } 
    
//     @Test
//     public void testUpdateNonExistingSupplier() {
//         Long nonExistingSupplierId = 999L;
//         Supplier updatedSupplier = new Supplier();
//         updatedSupplier.setAddress("456");

//         given()
//             .contentType(MediaType.APPLICATION_JSON_VALUE)
//             .body(updatedSupplier)
//         .when()
//             .put("http://localhost:" + port + "/api/suppliers/{id}", nonExistingSupplierId)
//         .then()
//             .statusCode(404);
//     }
// }
