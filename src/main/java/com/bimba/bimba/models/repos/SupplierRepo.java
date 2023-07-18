package com.bimba.bimba.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.bimba.bimba.models.entities.Supplier;

public interface SupplierRepo extends CrudRepository<Supplier,Long> {
    
}
