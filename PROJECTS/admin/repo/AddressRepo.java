package com.tekact.platform.admin.repo;

import com.tekact.platform.admin.entity.AddressEntity;
import com.tekact.platform.admin.entity.OrganizationEntity;
import com.tekact.platform.common.repo.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepo extends BaseRepository<AddressEntity,Integer> {


    Optional<AddressEntity> findByIdOrOrgId(Integer id, Integer orgId);
}
