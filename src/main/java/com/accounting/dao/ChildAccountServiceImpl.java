package com.accounting.dao;

import com.accounting.dto.ChildAccountBean;
import com.accounting.dto.FirmDetailsBean;
import com.accounting.dto.PrimaryAccountBean;
import com.accounting.exception.customeException.AccountDetailsNotFoundException;
import com.accounting.exception.customeException.UserAccountNotFoundException;
import com.accounting.repositories.ChildAccountRepository;
import com.accounting.repositories.FirmDetailsRepository;
import com.accounting.repositories.PrimaryAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildAccountServiceImpl implements ChildAccountService {

    @Autowired
    private PrimaryAccountRepository primaryAccountRepository;

    @Autowired
    private ChildAccountRepository childAccountRepository;

    @Autowired
    private FirmDetailsRepository firmDetailsRepository;


    public void setChildAccountRepository(ChildAccountRepository childAccountRepository) {
        this.childAccountRepository = childAccountRepository;
    }

    public void setFirmDetailsRepository(FirmDetailsRepository firmDetailsRepository) {
        this.firmDetailsRepository = firmDetailsRepository;
    }

    public ChildAccountBean save(FirmDetailsBean firmDetailsBean, Long primaryAcctId, char type) {

        Optional<PrimaryAccountBean> primaryOptional = primaryAccountRepository.findById(primaryAcctId);
        if (!primaryOptional.isPresent())
            throw new UserAccountNotFoundException(primaryAcctId);

        PrimaryAccountBean primaryAccountBean = primaryOptional.get();
        firmDetailsBean = firmDetailsRepository.save(firmDetailsBean);
        ChildAccountBean childAccountBean = new ChildAccountBean();
        childAccountBean.setPrimaryAccountBean(primaryAccountBean);
        childAccountBean.setFirmDetailsBean(firmDetailsBean);
        childAccountBean.setPartyType(type);
        childAccountRepository.save(childAccountBean);
        return childAccountBean;
    }

    public List<ChildAccountBean> getAllAccounts(Long primaryAcctId) {

        Optional<PrimaryAccountBean> primaryOptional = primaryAccountRepository.findById(primaryAcctId);
        if (!primaryOptional.isPresent())
            throw new UserAccountNotFoundException(primaryAcctId);

        PrimaryAccountBean primaryAccountBean = primaryOptional.get();

        return primaryAccountBean.getChildAccountBeanList();
    }

    public ChildAccountBean findAccount(Long primaryAcctId, Long id) {
        ChildAccountBean childAccountBean = childAccountRepository.findById(id).orElse(null);

        if (childAccountBean == null)
            throw new AccountDetailsNotFoundException(id);

        return childAccountBean;
    }

    public void removeAccount(Long primaryAcctId, Long id) {
        childAccountRepository.deleteById(id);
    }

}
