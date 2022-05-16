package com.tekact.platform.admin.service;

import com.tekact.platform.admin.entity.AppEntity;
import com.tekact.platform.admin.exception.AdminException;
import com.tekact.platform.admin.model.App;
import com.tekact.platform.common.response.CustomPage;
import org.springframework.data.domain.Page;

public interface AppService {
    App registerApp(App app);
    App fetchApp(Integer orgId, Integer id, String code) throws AdminException;
    void deleteApp(Integer orgId, Integer id) throws AdminException ;
    App updateApp(Integer orgId, App app)  throws AdminException ;
    CustomPage<App> fetchApps(Integer orgId, Integer pageNo, Integer pageSize, String sortBy);
    void approveApp(Integer orgId, Integer id) throws AdminException;;
}
