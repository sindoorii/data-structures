package com.tekact.platform.admin.repo;

import com.tekact.platform.admin.entity.AppEntity;
import com.tekact.platform.admin.entity.OrganizationEntity;
import com.tekact.platform.common.repo.BaseRepository;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface AppRepo extends BaseRepository <AppEntity,Integer> {

    Optional<AppEntity> findByCodeOrId(String code, Integer id);

    @Where(clause = "org_id = ?0 AND (code=?1 OR id=?2)")
    Optional<AppEntity> findByCodeOrIdAndOrgId( String code, Integer id, Integer orgId);

    @Transactional
    @Query(value = "update app set is_approved=1 where org_id=?1 and app_id=?2", nativeQuery = true)
    @Modifying
    void approveApp(Integer orgId, Integer appId);

}
