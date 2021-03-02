package com.accounting.controller;

import com.accounting.dao.ChildAccountService;
import com.accounting.dto.ChildAccountBean;
import com.accounting.dto.FirmDetailsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/child-account/{primaryAcctId}", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ChildAccountController {

    @Autowired
    private ChildAccountService childAccountService;

    @PostMapping(path = "/{type}")
    public ResponseEntity<Object> save(@Valid @RequestBody FirmDetailsBean firmDetailsBean, @PathVariable Long primaryAcctId, @PathVariable char type) {
        ChildAccountBean childAccountBean = childAccountService.save(firmDetailsBean, primaryAcctId, type);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(childAccountBean.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/getAllAccounts")
    public List<ChildAccountBean> getAllAccounts(@PathVariable Long primaryAcctId) {
        return childAccountService.getAllAccounts(primaryAcctId);
    }

    @GetMapping(path = "/{id}")
    public ChildAccountBean findAccount(@PathVariable Long primaryAcctId, @PathVariable Long id) {
        return childAccountService.findAccount(primaryAcctId, id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity removeAccount(@PathVariable Long primaryAcctId, @PathVariable Long id) {
        childAccountService.removeAccount(primaryAcctId, id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
