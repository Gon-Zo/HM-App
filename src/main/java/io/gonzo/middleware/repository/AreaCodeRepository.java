package io.gonzo.middleware.repository;

import io.gonzo.middleware.domain.AreaCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaCodeRepository extends JpaRepository<AreaCode, Long> {
}
