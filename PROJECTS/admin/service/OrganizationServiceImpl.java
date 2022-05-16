package com.tekact.platform.admin.service;

import com.tekact.platform.admin.entity.OrganizationEntity;
import com.tekact.platform.admin.exception.AdminException;
import com.tekact.platform.admin.model.Organization;
import com.tekact.platform.admin.repo.OrganizationRepo;
import com.tekact.platform.admin.util.AdminErrorCode;
import com.tekact.platform.common.response.CustomPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepo orgRepo;

    @Override
    public Organization registerOrg(Organization organization) {
        OrganizationEntity org = new OrganizationEntity();
        org.setCode(UUID.randomUUID().toString());
        org.setTypeCode(organization.getTypeCode());
        org.setName(organization.getName());
        org.setGst(organization.getGst());
        org.setImgUrl(organization.getImgUrl());
        org.setCreatedBy("test");//TODO - remove hard coding
        orgRepo.save(org);
         organization.setId(org.getId());
        return organization;
    }


    @Override
    public Organization fetchOrg(Integer id, String code) throws AdminException {
        Optional<OrganizationEntity> optEntity = orgRepo.findByCodeOrId(null, id);
        OrganizationEntity organizationEntity = getOrganizationEntity(optEntity);
        Organization org = mapToDto(organizationEntity);
        return org;
    }

    private Organization mapToDto(OrganizationEntity organizationEntity) {
        Organization org = new Organization();
        org.setId(organizationEntity.getId());
        org.setTypeCode(organizationEntity.getTypeCode());
        org.setCode(organizationEntity.getCode());
        org.setName(organizationEntity.getName());
        org.setGst(organizationEntity.getGst());
        org.setImgUrl(organizationEntity.getImgUrl());
        org.setCreatedBy(organizationEntity.getCreatedBy());
        org.setUpdatedBy(organizationEntity.getUpdatedBy());
        org.setUpdatedAt(organizationEntity.getUpdatedDate());
        org.setCreatedAt(organizationEntity.getCreatedDate());
        org.setIsActive(organizationEntity.getIsActive());
        org.setIsApproved(organizationEntity.getIsApproved());
        org.setIsDeleted(organizationEntity.getIsDeleted());
        return org;
    }

    private OrganizationEntity getOrganizationEntity(Optional<OrganizationEntity> optEntity) throws AdminException {
        OrganizationEntity organizationEntity;
        if (optEntity.isPresent()) {
            organizationEntity = optEntity.get();
        } else {
            throw new AdminException(AdminErrorCode.ORGANIZATION_NOT_FOUND.getCode(),
                    AdminErrorCode.ORGANIZATION_NOT_FOUND.getMessage(),
                    AdminErrorCode.ORGANIZATION_NOT_FOUND.getType());
        }
        return organizationEntity;
    }

    @Override
    public Organization updateOrg(Integer id, Organization org) throws AdminException {

        Optional<OrganizationEntity> orgEntity = orgRepo.findByCodeOrId(null, org.getId());
        OrganizationEntity orgs = getOrganizationEntity(orgEntity);
        orgs.setCode(org.getCode());
        orgs.setTypeCode(org.getTypeCode());
        orgs.setName(org.getName());
        orgs.setGst(org.getGst());
        orgs.setImgUrl(org.getImgUrl());
        orgs.setUpdatedBy("Test");//TODO- remove hard coding
        orgRepo.save(orgs);
        return org;

    }


    @Override
    public void deleteOrg(Integer id) throws AdminException {
        Optional<OrganizationEntity> optEntity = orgRepo.findByCodeOrId(null, id);
        OrganizationEntity organizationEntity = getOrganizationEntity(optEntity);
        orgRepo.softDelete(id);
    }


    @Override
    public CustomPage<Organization> fetchOrgs(Integer pageNo, Integer pageSize) throws AdminException {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<OrganizationEntity> pagedEntities = orgRepo.findAll(paging);
        Page<Organization> dtos = pagedEntities.map(entity -> {
            Organization dto = mapToDto(entity);
            return dto;
        });
        return new CustomPage<Organization>(dtos);
    }

        //return null;

    //}
}



