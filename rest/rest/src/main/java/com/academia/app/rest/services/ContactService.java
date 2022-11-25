package com.academia.app.rest.services;

import com.academia.app.rest.model.domain.ContactDTO;
import com.academia.app.rest.model.domain.MessageDTO;
import com.academia.app.rest.model.mappers.ContactMapper;
import com.academia.app.rest.model.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactService(ContactRepository contactRepository, ContactMapper contactMapper) {
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
        return Optional
                .ofNullable(contactDTO)
                .map(dto -> contactMapper.contactDTOToContactEntity(dto))
                .map(entity -> contactRepository.save(entity))
                .map(entity -> contactMapper.contactEntityToContactDTO(entity))
                .map(entity -> contactMapper.contactDTOToMessage(entity))
                .orElse(new MessageDTO());
    }

    public ContactDTO findById(Integer id){
        return contactRepository
                .findById(id)
                .map(contact -> contactMapper.contactEntityToContactDTO(contact))
                .get();
    }
}
