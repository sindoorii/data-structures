
package com.tekact.platform.admin.service;
import com.tekact.platform.admin.exception.AdminException;
import com.tekact.platform.admin.model.Organization;
import com.tekact.platform.common.response.CustomPage;

public interface OrganizationService {
    Organization registerOrg(Organization organization) throws AdminException;

    Organization fetchOrg(Integer id, String code) throws AdminException;

    void deleteOrg(Integer id) throws AdminException;

    Organization updateOrg(Integer id, Organization organization) throws AdminException;

    CustomPage<Organization> fetchOrgs(Integer pageNo, Integer pageSize) throws AdminException;
}







