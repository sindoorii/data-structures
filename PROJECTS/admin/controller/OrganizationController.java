package com.tekact.platform.admin.controller;

import com.tekact.platform.admin.entity.OrganizationEntity;
import com.tekact.platform.admin.exception.AdminException;
import com.tekact.platform.admin.model.Address;
import com.tekact.platform.admin.model.App;
import com.tekact.platform.admin.model.Organization;
import com.tekact.platform.admin.service.AddressService;
import com.tekact.platform.admin.service.OrganizationService;
import com.tekact.platform.common.response.CustomPage;
import liquibase.pro.packaged.A;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
@Log4j2
public class OrganizationController {

    @Autowired
    private OrganizationService orgService;

    @Autowired
    private AddressService addressService;

    @PostMapping("/org/create")
    public ResponseEntity<Organization> createOrg(@NotNull @RequestBody Organization organization) throws AdminException {
        log.info("About to create org with details={}",organization);
        return new ResponseEntity<>(orgService.registerOrg(organization), HttpStatus.CREATED);
    }

    @GetMapping(value = "/org/{id}")
    public ResponseEntity<Organization> retrieveOrg(@NotNull @PathVariable("Id")@RequestParam Integer id) throws AdminException {
        log.info("Request received to fetch app with id={}.",id);
        return ResponseEntity.ok(orgService.fetchOrg( id, null));
    }

    @GetMapping(value = "/org")
    public ResponseEntity<Organization> retrieveOrg(@NotNull @PathVariable("code") @RequestParam String code) throws AdminException {
        log.info("Request received to fetch app with code={}.",code);
        return ResponseEntity.ok(orgService.fetchOrg( null, code));

    }


    @DeleteMapping(value = "/org/{id}")
    public void deleteOrg(@NotNull @PathVariable("Id")@RequestParam Integer id) throws AdminException {
        log.info("Request received to delete org with id={}.",id);
        orgService.deleteOrg(id);
    }
    @PutMapping(value="/org/{id}")
    public ResponseEntity<Organization> updateApp(@NotNull @PathVariable("id")@RequestParam Integer id, @RequestBody Organization org) throws AdminException {
        return ResponseEntity.ok(orgService.updateOrg(id, org));

    }

    @GetMapping(value = "/org/all")
    public ResponseEntity<CustomPage<Organization>> retrieveOrgs(@RequestParam(defaultValue = "0") Integer pageNo,
                                                        @RequestParam(defaultValue = "10") Integer pageSize) throws AdminException {
        log.info("Request received to fetch orgs");
        return ResponseEntity.ok(orgService.fetchOrgs(pageNo, pageSize));

    }


    //ADDRESS
    @PostMapping("/address")
    public ResponseEntity<Address> createOrgAddress(@NotNull  @RequestBody Address add){
        log.info("About to create app with details={}",add);
        return new ResponseEntity<>(addressService.registerOrgAddress(add), HttpStatus.CREATED);
    }

    @GetMapping(value = "/address/{id}")
    public ResponseEntity<Address> fetchAddress(@NotNull @PathVariable("id") Integer id, @PathVariable Integer orgId) throws AdminException {
        log.info("Request received to fetch app with id={}.",id);
        return ResponseEntity.ok(addressService.fetchOrgAddress(orgId, id));
    }

    @DeleteMapping(value = "/address/{id}")
    public ResponseEntity<String> deleteAddress(@NotNull @PathVariable("id") Integer id, @PathVariable Integer orgId) throws AdminException {
        log.info("Request received to delete app with id={}.",id);
        addressService.deleteOrgAddress(orgId, id);
        return ResponseEntity.ok(String.format("App with id=%d is deleted", id));
    }

    @PutMapping(value = "/address/{orgId}")
    public ResponseEntity<Address> updateAddress(@NotNull @PathVariable("orgId") Integer orgId, @RequestBody Address add) throws AdminException {
        return ResponseEntity.ok(addressService.updateOrgAddress(orgId, add));
    }

    @GetMapping(value = "/address/all")
    public ResponseEntity<CustomPage<Address>> retrieveAddresses(@NotNull @PathVariable("orgId") Integer orgId,
                                                        @RequestParam(defaultValue = "0") Integer pageNo,
                                                        @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("Request received to fetch apps");
        return ResponseEntity.ok(addressService.fetchOrgAddresses(orgId, pageNo, pageSize));

    }

    }























