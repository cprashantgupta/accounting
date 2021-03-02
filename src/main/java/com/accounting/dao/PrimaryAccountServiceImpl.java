package com.accounting.dao;

import com.accounting.dto.FirmDetailsBean;
import com.accounting.dto.PrimaryAccountBean;
import com.accounting.exception.customeException.AccountDetailsNotFoundException;
import com.accounting.repositories.FirmDetailsRepository;
import com.accounting.repositories.PrimaryAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrimaryAccountServiceImpl implements PrimaryAccountService {

    @Autowired
    private PrimaryAccountRepository primaryAccountRepository;

    @Autowired
    private FirmDetailsRepository firmDetailsRepository;

    public void setPrimaryAccountRepository(PrimaryAccountRepository primaryAccountRepository) {
        this.primaryAccountRepository = primaryAccountRepository;
    }

    public void setFirmDetailsRepository(FirmDetailsRepository firmDetailsRepository) {
        this.firmDetailsRepository = firmDetailsRepository;
    }

    public PrimaryAccountBean save(FirmDetailsBean firmDetailsBean) {
        firmDetailsBean = firmDetailsRepository.save(firmDetailsBean);
        PrimaryAccountBean primaryAccountBean = new PrimaryAccountBean();
        primaryAccountBean.setFirmDetailsBean(firmDetailsBean);
        primaryAccountRepository.save(primaryAccountBean);
        return primaryAccountBean;
    }

    public List<PrimaryAccountBean> getAllAccounts() {
        return primaryAccountRepository.findAll();
    }

    public PrimaryAccountBean findAccount(Long id) {
        PrimaryAccountBean primaryAccountBean = primaryAccountRepository.findById(id).orElse(null);

        if (primaryAccountBean == null)
            throw new AccountDetailsNotFoundException(id);

        return primaryAccountBean;
    }

    public void removeAccount(Long id) {
        primaryAccountRepository.deleteById(id);
    }

}
