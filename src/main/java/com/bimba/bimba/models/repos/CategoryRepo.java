package com.bimba.bimba.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.bimba.bimba.models.entities.Category;

public interface CategoryRepo extends CrudRepository<Category,Long> {
    
}
