package com.tekact.platform.admin.controller;

import com.tekact.platform.admin.entity.AppEntity;
import com.tekact.platform.admin.exception.AdminException;
import com.tekact.platform.admin.model.App;
import com.tekact.platform.admin.service.AppService;
import com.tekact.platform.common.response.CustomPage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/org/{orgId}/app")
@Log4j2
public class AppController {

    @Autowired
    private AppService appService;

    @PostMapping
    public ResponseEntity<App> createApp(@NotNull @PathVariable("orgId") Integer orgId, @RequestBody App app){
        log.info("About to create app with details={}",app);
        app.setOrgId(orgId);
        return new ResponseEntity<>(appService.registerApp(app), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<App> retrieveApp(@NotNull @PathVariable("orgId") Integer orgId, @PathVariable Integer id) throws AdminException {
        log.info("Request received to fetch app with id={}.",id);
        return ResponseEntity.ok(appService.fetchApp(orgId, id, null));
    }

    @GetMapping(value = "")
    public ResponseEntity<App> retrieveApp(@NotNull @PathVariable("orgId") Integer orgId, @RequestParam String code) throws AdminException {
        log.info("Request received to fetch app with code={}.",code);
        return ResponseEntity.ok(appService.fetchApp(orgId, null, code));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteApp(@NotNull @PathVariable("orgId") Integer orgId, @PathVariable Integer id) throws AdminException {
        log.info("Request received to delete app with id={}.",id);
        appService.deleteApp(orgId, id);
        return ResponseEntity.ok(String.format("App with id=%d is deleted", id));
    }

    @PutMapping
    public ResponseEntity<App> updateApp(@NotNull @PathVariable("orgId") Integer orgId, @RequestBody App app) throws AdminException {
        return ResponseEntity.ok(appService.updateApp(orgId, app));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> approveApp(@NotNull @PathVariable("orgId") Integer orgId, @PathVariable Integer id) throws AdminException {
        log.info("Request received to approve app with id={}.",id);
        appService.approveApp(orgId, id);
        return ResponseEntity.ok(String.format("App with id=%d is approved", id));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<CustomPage<App>> retrieveApps(@NotNull @PathVariable("orgId") Integer orgId,
                                                        @RequestParam(defaultValue = "0") Integer pageNo,
                                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                                        @RequestParam(defaultValue = "id") String sortBy)  {
        log.info("Request received to fetch apps");
        return ResponseEntity.ok(appService.fetchApps(orgId, pageNo, pageSize, sortBy));

    }


}
