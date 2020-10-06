package com.example.app.multbanck.multbank.config.validator.customized.implementation;

import com.example.app.multbanck.multbank.config.validator.FieldMessage;
import com.example.app.multbanck.multbank.config.validator.customized.ClientUpdate;
import com.example.app.multbanck.multbank.dto.ClientUpdateDTO;
import com.example.app.multbanck.multbank.model.ClientEntity;
import com.example.app.multbanck.multbank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientUpdateValidator implements ConstraintValidator<ClientUpdate, ClientUpdateDTO> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void initialize(ClientUpdate constraintAnnotation) { }

    @Override
    public boolean isValid(ClientUpdateDTO clientUpdateDTO, ConstraintValidatorContext context) {
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        long urlId = Long.parseLong(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        ClientEntity clientEntity = this.clientRepository.findByCpf(clientUpdateDTO.getCpf());
        if(clientEntity != null && clientEntity.getId().equals(urlId)) {
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
