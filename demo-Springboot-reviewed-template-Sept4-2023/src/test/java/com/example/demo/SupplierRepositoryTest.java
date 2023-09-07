// package com.example.demo;

// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import com.example.demo.repository.SupplierRepository;

// @DataJpaTest
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// public class SupplierRepositoryTest {
	
// 	    @Autowired
// 	    private SupplierRepository supplierRepository;

// 	    @Test
// 	    public void testExistsBySupplierId_ExistingId_ReturnsTrue() {
// 	        Long existingId = 2L;

// 	        boolean exists = supplierRepository.existsBySupplierId(existingId);

// 	        assertTrue(exists);
// 	    }
	    

// 	    @Test
// 	    public void testExistsBySupplierId_NonExistingId_ReturnsFalse() {
// 	        Long nonExistingId = 100L;

// 	        boolean exists = supplierRepository.existsBySupplierId(nonExistingId);

// 	        assertFalse(exists);
// 	    }
// 	}