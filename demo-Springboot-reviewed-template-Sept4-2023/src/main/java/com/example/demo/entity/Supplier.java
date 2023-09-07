package com.example.demo.entity;

import com.example.demo.dto.SupplierOutputDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "suppliers")
@Getter
@NoArgsConstructor
@SuperBuilder
public class Supplier {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@NotNull(message = "Supplier name is required")
    private String name;
    
    private String address;
    
    @NotNull(message = "Contact details are required")
    private String contactDetails;
    
    @NotNull(message = "specialties are required")
    private String specialties;


    public SupplierOutputDTO viewAsOutputDto(){
        return new SupplierOutputDTO(id, name, address, contactDetails, specialties);
    }
}