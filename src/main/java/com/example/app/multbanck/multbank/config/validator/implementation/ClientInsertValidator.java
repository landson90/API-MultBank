package com.example.app.multbanck.multbank.config.validator.implementation;


import com.example.app.multbanck.multbank.config.validator.ClientInsert;
import com.example.app.multbanck.multbank.config.validator.FieldMessage;
import com.example.app.multbanck.multbank.dto.ClientDTO;
import com.example.app.multbanck.multbank.modal.ClientEntity;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientDTO> {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void initialize(ClientInsert constraintAnnotation) {

    }

    @Override
    public boolean isValid(ClientDTO clientDTO, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        ClientEntity clientEntity = this.clientRepository.findByCpf(clientDTO.getCpf());
        if(clientEntity != null) {
            list.add(new FieldMessage("cpf", "CPF ja cadastrado !"));
        }
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    e.getMessage())
                    .addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
