package com.tekact.platform.admin.repo;

import com.tekact.platform.admin.entity.OrganizationEntity;
import com.tekact.platform.common.repo.BaseRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface OrganizationRepo extends BaseRepository<OrganizationEntity,Integer> {
    Optional<OrganizationEntity> findByCodeOrId(String code, Integer id);
}



