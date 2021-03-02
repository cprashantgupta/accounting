package com.accounting.repositories;

import com.accounting.dto.ChildAccountBean;
import com.accounting.dto.PrimaryAccountBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildAccountRepository extends JpaRepository<ChildAccountBean, Long> {
}
