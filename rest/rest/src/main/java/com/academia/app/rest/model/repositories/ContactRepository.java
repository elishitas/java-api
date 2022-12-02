package com.academia.app.rest.model.repositories;

import com.academia.app.rest.model.entities.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {
    Optional<ContactEntity> findByNombre(String nombre);
    Optional<ContactEntity> findByCelular(int celular);
}
