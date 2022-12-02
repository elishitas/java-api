package com.academia.app.rest.services;

import com.academia.app.rest.exceptions.exceptionskind.ContactFoundException;
import com.academia.app.rest.exceptions.exceptionskind.ContactNotFoundException;
import com.academia.app.rest.model.domain.ContactDTO;
import com.academia.app.rest.model.domain.MessageDTO;
import com.academia.app.rest.model.mappers.ContactMapper;
import com.academia.app.rest.model.repositories.ContactRepository;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactService(ContactRepository contactRepository,
                          ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    public List<ContactDTO> findAll(){
        return contactRepository
                .findAll()
                .stream()
                .map(contactMapper::contactEntityToContactDTO)
                .collect(Collectors.toList());
    }

    public MessageDTO add(ContactDTO contactDTO){
        if(contactRepository.findByNombre(contactDTO.getNombre()).isPresent()) throw new ContactFoundException("El nombre del contacto ya existe");

        if(contactRepository.findByCelular(contactDTO.getCelular()).isPresent()) throw new ContactFoundException("El numero del contacto ya existe");

        return Optional
                .ofNullable(contactDTO)
                .map(dto -> contactMapper.contactDTOToContactEntity(dto))
                .map(entity -> contactRepository.save(entity))
                .map(entity -> contactMapper.contactEntityToContactDTO(entity))
                .map(entity -> contactMapper.contactDTOToMessage(entity))
                .orElse(new MessageDTO());
    }

    public ContactDTO findById(Integer id){
        return Optional
                .ofNullable(id)
                .map(idContacto -> contactRepository.findById(id).orElseThrow(()->new ContactNotFoundException("No se encuenta el contacto con el ID especificado")))
                .map(contactMapper::contactEntityToContactDTO)
                .orElse(new ContactDTO());
    }
}
