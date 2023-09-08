package com.example.demo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SupplierInputDTO;
import com.example.demo.dto.SupplierOutputDTO;
import com.example.demo.service.SupplierService;
import com.itextpdf.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/suppliers")
@Validated
public class SupplierController {
   
    @Autowired
    private SupplierService supplierService;
   

    @GetMapping
    public ResponseEntity<List<SupplierOutputDTO>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SupplierOutputDTO> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.getSupplierById(id));
    }

    @PostMapping()
    public ResponseEntity<SupplierOutputDTO> createSupplier(@Valid @RequestBody SupplierInputDTO supplierDto) {
        return new ResponseEntity<>(supplierService.createSupplier(supplierDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierOutputDTO> updateSupplier(@PathVariable Long id, @RequestBody SupplierInputDTO supplierDto) {
        return ResponseEntity.ok(supplierService.updateSupplier(id, supplierDto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/export-pdf")
    public ResponseEntity<Void> exportSuppliersToPDF(HttpServletResponse response, @RequestParam(name = "lang", required = false, defaultValue = "en") String language) throws IOException, DocumentException {
        Locale locale = new Locale(language);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=supplier_list.pdf");
        OutputStream outputStream = response.getOutputStream();
        supplierService.generateSupplierListPDF(outputStream, locale);
        outputStream.flush();
        outputStream.close();

        return ResponseEntity.ok().build();
    }

}