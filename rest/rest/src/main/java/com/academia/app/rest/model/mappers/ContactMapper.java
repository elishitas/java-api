package com.academia.app.rest.model.mappers;


import com.academia.app.rest.model.domain.ContactDTO;
import com.academia.app.rest.model.domain.MessageDTO;
import com.academia.app.rest.model.entities.ContactEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContactMapper {
    public ContactEntity contactDTOToContactEntity(ContactDTO contactDTO){
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setNombre(contactDTO.getNombre());
        contactEntity.setCelular(contactDTO.getCelular());
        contactEntity.setId(contactDTO.getId());
        return contactEntity;
    }

    public ContactDTO contactEntityToContactDTO(ContactEntity contactEntity){
        return Optional
                .ofNullable(contactEntity)
                .map(entity -> new ContactDTO(
                        entity.getId(),
                        entity.getNombre(),
                        entity.getCelular()))
                .orElse(new ContactDTO());
    }

    public MessageDTO contactDTOToMessage(ContactDTO contactDTO){
        return Optional
                .ofNullable(contactDTO)
                .map(contact -> new MessageDTO(contact.getId(), "Añadido exitosamente"))
                .orElse(new MessageDTO());
    }

}
