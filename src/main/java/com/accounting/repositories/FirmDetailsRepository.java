package com.accounting.repositories;

import com.accounting.dto.FirmDetailsBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirmDetailsRepository extends JpaRepository<FirmDetailsBean, Long> {
}
