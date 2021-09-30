package io.gonzo.middleware.repository;

import io.gonzo.middleware.domain.AreaCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AreaCodeRepository extends JpaRepository<AreaCode, Long> {

    Optional<List<AreaCode>> findByNameIsNot(String name);

    <T> Optional<List<T>> findByNameIsNotAndType(String name, String type, Class<T> className);

}
