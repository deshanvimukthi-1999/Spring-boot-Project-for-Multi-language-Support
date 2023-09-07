// package com.example.demo;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNull;

// import org.junit.jupiter.api.Test;

// import com.example.demo.entity.Supplier;

// public class SupplierEntityTest {

// 	    @Test
// 	    public void testConstructorWithAllFields() {
// 	        Long supplierId = 1L;
// 	        String supplierName = "Supplier A";
// 	        String address = "123 Main St";
// 	        String contactDetails = "contact@example.com";
// 	        String specialties = "Electronics";

// 	        Supplier supplier = new Supplier(supplierId, supplierName, address, contactDetails, specialties);

// 	        assertEquals(supplierId, supplier.getSupplierId());
// 	        assertEquals(supplierName, supplier.getSupplierName());
// 	        assertEquals(address, supplier.getAddress());
// 	        assertEquals(contactDetails, supplier.getContactDetails());
// 	        assertEquals(specialties, supplier.getSpecialties());
// 	    }
	    

// 	    @Test
// 	    public void testConstructorWithIdAndAddress() {
// 	        Long existingSupplierId = 2L;
// 	        String supplierName = "Supplier B";
// 	        String address = "456 Oak Ave";

// 	        Supplier supplier = new Supplier(existingSupplierId, supplierName, address);

// 	        assertEquals(existingSupplierId, supplier.getSupplierId());
// 	        assertEquals(supplierName, supplier.getSupplierName());
// 	        assertEquals(address, supplier.getAddress());
// 	        assertNull(supplier.getContactDetails());
// 	        assertNull(supplier.getSpecialties());
// 	    }

// 	    @Test
// 	    public void testGettersAndSetters() {
// 	        Supplier supplier = new Supplier();
// 	        Long supplierId = 3L;
// 	        String supplierName = "Supplier C";
// 	        String address = "789 Elm Rd";
// 	        String contactDetails = "contact@example.com";
// 	        String specialties = "Furniture";

// 	        supplier.setSupplierId(supplierId);
// 	        supplier.setSupplierName(supplierName);
// 	        supplier.setAddress(address);
// 	        supplier.setContactDetails(contactDetails);
// 	        supplier.setSpecialties(specialties);

// 	        assertEquals(supplierId, supplier.getSupplierId());
// 	        assertEquals(supplierName, supplier.getSupplierName());
// 	        assertEquals(address, supplier.getAddress());
// 	        assertEquals(contactDetails, supplier.getContactDetails());
// 	        assertEquals(specialties, supplier.getSpecialties());
// 	    }
// }