package com.example.demo.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SupplierInputDTO;
import com.example.demo.dto.SupplierOutputDTO;
import com.example.demo.entity.Supplier;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SupplierRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;


    @Autowired
    public SupplierService(SupplierRepository supplierRepository, MessageSource messageSource) {
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierOutputDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream().map(Supplier::viewAsOutputDto).toList();
    }

    public SupplierOutputDTO getSupplierById(Long id) {
        return supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("No Supplier entity with id %s exists!", id))).viewAsOutputDto();
    }

    public SupplierOutputDTO createSupplier(SupplierInputDTO supplierDto) {
        Supplier supplier = Supplier.builder().name(supplierDto.getName()).contactDetails(supplierDto.getContactDetails()).address(supplierDto.getAddress()).specialties(supplierDto.getSpecialties()).build();
        return supplierRepository.save(supplier).viewAsOutputDto();
    }

    public SupplierOutputDTO updateSupplier(long id, SupplierInputDTO supplierDto) {
        SupplierOutputDTO existingSupplier = getSupplierById(id);
        Supplier supplier = Supplier.builder().name(supplierDto.getName()).contactDetails(supplierDto.getContactDetails()).address(supplierDto.getAddress()).specialties(supplierDto.getSpecialties()).id(existingSupplier.getId()).build();
        return supplierRepository.save(supplier).viewAsOutputDto();
    }
    
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
    

    public byte[] generateSupplierListPDF(Locale locale) throws IOException, DocumentException {
        List<SupplierOutputDTO> suppliers = getAllSuppliers();

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);
            document.open();

            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);


            ResourceBundle messages;
            try {
                messages = ResourceBundle.getBundle("i18n/messages", locale);
            } catch (MissingResourceException e) {
                messages = ResourceBundle.getBundle("messages_default", Locale.getDefault());
            }

            for (SupplierOutputDTO supplier : suppliers) {
                Paragraph paragraph = new Paragraph();
                paragraph.setFont(font);
                paragraph.add(messages.getString("supplier.id") + ": " + supplier.getId() + "\n");
                paragraph.add(messages.getString("supplier.name") + ": " + supplier.getName() + "\n");
                paragraph.add(messages.getString("supplier.contact") + ": " + supplier.getContactDetails() + "\n");
                paragraph.add(messages.getString("supplier.address") + ": " + supplier.getAddress() + "\n");
                paragraph.add(messages.getString("supplier.specialties") + ": " + supplier.getSpecialties() + "\n");
                paragraph.add("\n");
                document.add(paragraph);
            }

            document.close();

            return outputStream.toByteArray();
        }
    }
}
