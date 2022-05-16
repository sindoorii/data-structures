package com.tekact.platform.admin.service;
import com.tekact.platform.admin.entity.AddressEntity;
import com.tekact.platform.admin.entity.OrganizationEntity;
import com.tekact.platform.admin.exception.AdminException;
import com.tekact.platform.admin.model.Address;
import com.tekact.platform.admin.model.App;
import com.tekact.platform.common.response.CustomPage;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Address registerOrgAddress(Address add);
    Address fetchOrgAddress(Integer orgId, Integer id) throws AdminException;
    void deleteOrgAddress(Integer orgId, Integer id) throws AdminException ;
    Address updateOrgAddress(Integer orgId, Address add)  throws AdminException ;
    CustomPage<Address> fetchOrgAddresses(Integer orgId, Integer pageNo, Integer pageSize);
}
