package io.gonzo.middleware.service;

import io.gonzo.middleware.domain.AreaCode;
import io.gonzo.middleware.repository.AreaCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaCodeService {

    private final AreaCodeRepository repository;

    @Transactional(readOnly = true)
    public List<AreaCode> getByAreaCodes() {
        return repository.findAll();
    }

}
