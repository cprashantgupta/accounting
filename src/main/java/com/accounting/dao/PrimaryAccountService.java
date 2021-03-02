package com.accounting.dao;

import com.accounting.dto.FirmDetailsBean;
import com.accounting.dto.PrimaryAccountBean;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PrimaryAccountService {

    PrimaryAccountBean save(FirmDetailsBean firmDetailsBean);

    List<PrimaryAccountBean> getAllAccounts();

    PrimaryAccountBean findAccount(Long id);

    void removeAccount(Long id);
}
