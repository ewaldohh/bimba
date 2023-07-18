package com.bimba.bimba.services;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bimba.bimba.models.entities.Supplier;
import com.bimba.bimba.models.repos.SupplierRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SupplierService {
    @Autowired
    private SupplierRepo supplierRepo;

    public Supplier save(Supplier supplier){
        return supplierRepo.save(supplier);
    }

    public Supplier findOne(long id){
        Optional<Supplier> supplier = supplierRepo.findById(id);
        if(!supplier.isPresent()){
            return null;
        }
        return supplier.get();
    }

    public Iterable<Supplier> findAll(){
        return supplierRepo.findAll();
    }

    public void removedOne(Long id){
        supplierRepo.deleteById(id);
    }
}
