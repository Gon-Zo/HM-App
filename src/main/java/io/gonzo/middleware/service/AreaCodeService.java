package io.gonzo.middleware.service;

import io.gonzo.middleware.domain.AreaCode;
import io.gonzo.middleware.repository.AreaCodeRepository;
import io.gonzo.middleware.web.dto.AreaCodeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AreaCodeService {

    private final AreaCodeRepository repository;

    @Transactional(readOnly = true)
    public List<AreaCode> getByAreaCodeList() {
        Optional<List<AreaCode>> areaCodeListOptional = repository.findByNameIsNot("root");

        if (areaCodeListOptional.isPresent()) {
            return areaCodeListOptional.get()
                    .stream()
                    .filter(areaCode -> !CollectionUtils.isEmpty(areaCode.getSubAreaCodeList()))
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    @Transactional(readOnly = true)
    public List<AreaCodeDTO.IAreaCodeParents> getByParentsTypeAreaList() {
        Optional<List<AreaCodeDTO.IAreaCodeParents>> parentsAreaCodeListOptional = repository.findByNameIsNotAndType("root", "P", AreaCodeDTO.IAreaCodeParents.class);

        if(parentsAreaCodeListOptional.isPresent()){
            return parentsAreaCodeListOptional.get();
        }

        return new ArrayList<>();

    }

}
