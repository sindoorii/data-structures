package com.tekact.platform.admin.service;


import com.tekact.platform.admin.entity.AppEntity;
import com.tekact.platform.admin.exception.AdminException;
import com.tekact.platform.admin.model.App;
import com.tekact.platform.admin.repo.AppRepo;
import com.tekact.platform.admin.util.AdminConstants;
import com.tekact.platform.admin.util.AdminErrorCode;
import com.tekact.platform.common.response.CustomPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppRepo appRepo;

    @Override
    public App registerApp(App inApp) {
        AppEntity app = new AppEntity();
        app.setOrgId(inApp.getOrgId());
        app.setName(inApp.getName());
        app.setCode(UUID.randomUUID().toString());
        app.setCreatedBy("test");//TODO - remove hard coding
        app.setName(inApp.getName());
        app.setTypeCode(inApp.getTypeCode());
        appRepo.save(app);
        inApp.setId(app.getId());
        return inApp;
    }

    @Override
    public App fetchApp(Integer orgId, Integer id, String code) throws AdminException  {
        Optional<AppEntity> optEntity = appRepo.findByCodeOrIdAndOrgId(code,id,orgId);
        AppEntity appEntity = getAppEntity(optEntity);
        App app = mapToDto(appEntity);
        return app;
    }

    private App mapToDto(AppEntity appEntity) {
        App app = new App();
        app.setId(appEntity.getId());
        app.setTypeCode(appEntity.getTypeCode());
        app.setCode(appEntity.getCode());
        app.setName(appEntity.getName());
        app.setCreatedDate(appEntity.getCreatedDate());
        app.setCreatedBy(appEntity.getCreatedBy());
        app.setUpdatedDate(appEntity.getUpdatedDate());
        app.setUpdatedBy(appEntity.getUpdatedBy());
        return app;
    }

    private AppEntity getAppEntity(Optional<AppEntity> optEntity) throws AdminException {
        AppEntity appEntity;
        if(optEntity.isPresent()) {
            appEntity = optEntity.get();
        } else {
            throw new AdminException(AdminErrorCode.APP_NOT_FOUND.getCode(),
                    AdminErrorCode.APP_NOT_FOUND.getMessage(),
                    AdminErrorCode.APP_NOT_FOUND.getType());
        }
        return appEntity;
    }

    @Override
    public void deleteApp(Integer orgId, Integer id) throws AdminException  {
        Optional<AppEntity> optEntity = appRepo.findByCodeOrIdAndOrgId(null, id, orgId);
        AppEntity appEntity = getAppEntity(optEntity);
        appRepo.softDelete(id);
    }

    @Override
    public App updateApp(Integer orgId, App inApp) throws AdminException {
        Optional<AppEntity> optEntity = appRepo.findByCodeOrIdAndOrgId(null, inApp.getId(),orgId);
        AppEntity app = getAppEntity(optEntity);
        app.setName(inApp.getName());
        app.setUpdatedBy("test");//TODO - remove hard coding
        app.setTypeCode(inApp.getTypeCode());
        appRepo.save(app);
        return inApp;
    }

    @Override
    public CustomPage<App> fetchApps(Integer orgId, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<AppEntity> pagedEntities = appRepo.findByOrgId(orgId, paging);
        Page<App> dtos = pagedEntities.map(entity -> {
            App dto = mapToDto(entity);
            return dto;
        });
        return new CustomPage<App>(dtos);
    }

    @Override
    public void approveApp(Integer orgId, Integer id) throws AdminException {
        Optional<AppEntity> optEntity = appRepo.findByCodeOrIdAndOrgId(null, id, orgId);
        AppEntity app = getAppEntity(optEntity);
        app.setIsApproved(AdminConstants.APPROVED_STATUS);
        appRepo.save(app);
    }

}
