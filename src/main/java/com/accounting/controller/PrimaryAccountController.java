package com.accounting.controller;

import com.accounting.dao.PrimaryAccountService;
import com.accounting.dto.FirmDetailsBean;
import com.accounting.dto.PrimaryAccountBean;
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
@RequestMapping(value = "/primary-account", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PrimaryAccountController {

    @Autowired
    private PrimaryAccountService primaryAccountService;

    @PostMapping(path = "")
    public ResponseEntity<Object> save(@Valid @RequestBody FirmDetailsBean firmDetailsBean) {
        PrimaryAccountBean primaryAccountBean = primaryAccountService.save(firmDetailsBean);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(primaryAccountBean.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/getAllAccounts")
    public List<PrimaryAccountBean> getAllAccounts() {
        return primaryAccountService.getAllAccounts();
    }

    @GetMapping(path = "/{id}")
    public PrimaryAccountBean findAccount(@PathVariable Long id) {
        return primaryAccountService.findAccount(id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity removeAccount(@PathVariable Long id) {
        primaryAccountService.removeAccount(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
