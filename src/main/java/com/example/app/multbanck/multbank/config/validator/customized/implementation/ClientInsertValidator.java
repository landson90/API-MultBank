package com.example.app.multbanck.multbank.config.validator.customized.implementation;


import com.example.app.multbanck.multbank.config.validator.customized.ClientInsert;
import com.example.app.multbanck.multbank.config.validator.FieldMessage;
import com.example.app.multbanck.multbank.dto.ClientDTO;
import com.example.app.multbanck.multbank.dto.UserClientDTO;
import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, UserClientDTO> {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void initialize(ClientInsert constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserClientDTO value, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        ClientEntity clientEntity = this.clientRepository.findByCpf(value.getCpf());
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
