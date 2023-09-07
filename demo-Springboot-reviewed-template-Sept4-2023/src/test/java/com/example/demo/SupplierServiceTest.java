// package com.example.demo;

// import static org.assertj.core.api.Assertions.assertThat;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertNull;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.example.demo.entity.Supplier;
// import com.example.demo.repository.SupplierRepository;
// import com.example.demo.service.SupplierService;

// @SpringBootTest
// public class SupplierServiceTest {

// 	    @Mock
// 	    private SupplierRepository supplierRepository;

// 	    @InjectMocks
// 	    private SupplierService supplierService;

// 	    private Supplier supplier;
// 		private Supplier supplier1;
// 		private Supplier updatedSupplier;
// 		private Supplier supplierToBeDeleted;
		
// 		@BeforeEach
// 		void init() {
// 			supplier = new Supplier();
// 			supplier.setSupplierId(1L);
// 			supplier.setAddress("469");
// 			supplier.setContactDetails("0774476755");
// 			supplier.setSpecialties("3 products");
// 			supplier.setSupplierName("Ishara");

// 			supplier1 = new Supplier();
// 			supplier1.setSupplierId(2L);
// 			supplier1.setAddress("400");
// 			supplier1.setContactDetails("0774476755");
// 			supplier1.setSpecialties("3 products");
// 			supplier1.setSupplierName("Thishara");
			
// 			updatedSupplier = new Supplier();
// 			updatedSupplier.setSupplierId(3L);
// 			updatedSupplier.setAddress("256");
// 			updatedSupplier.setContactDetails("0769367058");
// 			updatedSupplier.setSpecialties("5 products");
// 			updatedSupplier.setSupplierName("Nalinda");
			
// 			supplierToBeDeleted = new Supplier();
// 		    supplierToBeDeleted.setSupplierId(4L);
// 		    supplierToBeDeleted.setAddress("256");
// 		    supplierToBeDeleted.setContactDetails("0769367058");
// 		    supplierToBeDeleted.setSpecialties("5 products");
// 		    supplierToBeDeleted.setSupplierName("Nalinda");
// 		}
		
// 	    @Test
// 	    public void testGetAllSuppliers() {
// 	        List<Supplier> expectedSuppliers = new ArrayList<>();
// 	        expectedSuppliers.add(supplier);
// 	        expectedSuppliers.add(supplier1);

// 	        Mockito.when(supplierRepository.findAll()).thenReturn(expectedSuppliers);

// 	        List<Supplier> actualSuppliers = supplierService.getAllSuppliers();

// 	        assertEquals(expectedSuppliers, actualSuppliers);
// 	        assertEquals(2, expectedSuppliers.size());
// 			assertNotNull(expectedSuppliers);
// 	    }

// 	    @Test
// 	    public void testGetSupplierByIdExisting() {
// 	        Long supplierId = 1L;
			
// 	        Mockito.when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(supplier));

// 	        Supplier actualSupplier = supplierService.getSupplierById(supplierId);

// 	        assertEquals(supplier, actualSupplier);
// 	    }

// 	    @Test
// 	    public void testGetSupplierByIdNonExisting() {
// 	        Long supplierId = 99L;

// 	        Mockito.when(supplierRepository.findById(supplierId)).thenReturn(Optional.empty());

// 	        Supplier actualSupplier = supplierService.getSupplierById(supplierId);

// 	        assertNull(actualSupplier);
// 	    }

// 	    @Test
// 	    public void testCreateSupplier() {
// 	        Mockito.when(supplierRepository.save(supplier1)).thenReturn(supplier1);

// 	        Supplier createdSupplier = supplierService.createSupplier(supplier1);

// 	        assertEquals(supplier1, createdSupplier);
// 	        assertThat(supplier1.getSupplierName()).isEqualTo("Thishara");
// 			assertNotNull(supplier);
// 	    }

// 	    @Test
// 	    public void testUpdateSupplierExisting() {
// 	        Long supplierId = 3L;

// 	        Mockito.when(supplierRepository.existsById(supplierId)).thenReturn(true);
// 	        Mockito.when(supplierRepository.save(updatedSupplier)).thenReturn(updatedSupplier);

// 	        Supplier resultSupplier = supplierService.updateSupplier(supplierId, updatedSupplier);

// 	        assertEquals(updatedSupplier, resultSupplier);
// 	    }

// 	    @Test
// 	    public void testUpdateSupplierNonExisting() {
// 	        Long supplierId = 99L;

// 	        Mockito.when(supplierRepository.existsById(supplierId)).thenReturn(false);

// 	        Supplier resultSupplier = supplierService.updateSupplier(supplierId, updatedSupplier);

// 	        assertNull(resultSupplier);
// 	    }

// 	    @Test
// 	    public void testDeleteSupplier() {
// 	        Long supplierId = 4L;

// 	        supplierService.deleteSupplier(supplierId);

// 	        Mockito.verify(supplierRepository, Mockito.times(1)).deleteById(supplierId);
// 	    }

// 	    @Test
// 	    public void testExistsSupplierWithIdTrue() {
// 	        Long supplierId = 1L;

// 	        Mockito.when(supplierRepository.existsBySupplierId(supplierId)).thenReturn(true);

// 	        boolean result = supplierService.existsSupplierWithId(supplierId);

// 	        assertTrue(result);
// 	    }

// 	    @Test
// 	    public void testExistsSupplierWithIdFalse() {
// 	        Long supplierId = 99L;

// 	        Mockito.when(supplierRepository.existsBySupplierId(supplierId)).thenReturn(false);

// 	        boolean result = supplierService.existsSupplierWithId(supplierId);

// 	        assertFalse(result);
// 	    }
// 	}
