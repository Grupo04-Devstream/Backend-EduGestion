package com.example.backendedugestion.repository;

import com.example.backendedugestion.repository.model.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolJpaRepository extends CrudRepository<Rol, Long>{
}
