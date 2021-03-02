package com.accounting.repositories;

import com.accounting.dto.PrimaryAccountBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryAccountRepository extends JpaRepository<PrimaryAccountBean, Long> {
}
