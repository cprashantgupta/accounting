package com.accounting.dao;

import com.accounting.dto.ChildAccountBean;
import com.accounting.dto.FirmDetailsBean;

import java.util.List;

public interface ChildAccountService {

    ChildAccountBean save(FirmDetailsBean firmDetailsBean, Long primaryAcctId, char type);

    List<ChildAccountBean> getAllAccounts(Long primaryAcctId);

    ChildAccountBean findAccount(Long primaryAcctId, Long id);

    void removeAccount(Long primaryAcctId, Long id);
}
