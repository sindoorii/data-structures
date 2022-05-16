package com.tekact.platform.admin.service;
import com.tekact.platform.admin.entity.AddressEntity;
import com.tekact.platform.admin.entity.AppEntity;
import com.tekact.platform.admin.entity.OrganizationEntity;
import com.tekact.platform.admin.exception.AdminException;
import com.tekact.platform.admin.model.Address;
import com.tekact.platform.admin.model.App;
import com.tekact.platform.admin.repo.AddressRepo;
import com.tekact.platform.admin.util.AdminErrorCode;
import com.tekact.platform.common.response.CustomPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    public AddressServiceImpl(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public Address registerOrgAddress(Address add) {
        AddressEntity addEntity=new AddressEntity();
        addEntity.setOrgId(add.getOrgId());
        addEntity.setName(add.getName());
        addEntity.setZip(add.getZip());
        addEntity.setRank(add.getRank());
        addEntity.setLine1(add.getLine1());
        addEntity.setLine2(add.getLine2());
        addEntity.setCity(add.getCity());
        addEntity.setState(add.getState());
        addEntity.setCountry(add.getCountry());
        addEntity.setCreatedBy("tester");//TODO for hardcoding
        addressRepo.save(addEntity);
        add.setId(addEntity.getId());
        return add;
    }

    @Override
    public Address fetchOrgAddress(Integer orgId, Integer id) throws AdminException {
        Optional<AddressEntity> optEntity = addressRepo.findByIdOrOrgId(id,orgId);
        AddressEntity addEntity = getAddEntity(optEntity);
        Address add = mapToDto(addEntity);
        return add;
    }

    @Override
    public void deleteOrgAddress(Integer orgId, Integer id) throws AdminException {
        Optional<AddressEntity> optEntity = addressRepo.findByIdOrOrgId( id, orgId);
        AddressEntity addEntity = getAddEntity(optEntity);
        addressRepo.softDelete(id);
    }

    @Override
    public Address updateOrgAddress(Integer orgId, Address add) throws AdminException {
        Optional<AddressEntity> optEntity = addressRepo.findByIdOrOrgId( add.getId(),orgId);
        AddressEntity addEntity = getAddEntity(optEntity);
        addEntity.setName(add.getName());
        addEntity.setZip(add.getZip());
        addEntity.setRank(add.getRank());
        addEntity.setLine1(add.getLine1());
        addEntity.setLine2(add.getLine2());
        addEntity.setCity(add.getCity());
        addEntity.setState(add.getState());
        addEntity.setCountry(add.getCountry());
        addEntity.setUpdatedBy("testing");//TODO for hardcoding
        addressRepo.save(addEntity);
        return add;
    }

    @Override
    public CustomPage<Address> fetchOrgAddresses(Integer orgId, Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<AddressEntity> pagedEntities = addressRepo.findByOrgId(orgId, paging);
        Page<Address> dtos = pagedEntities.map(entity -> {
            Address dto = mapToDto(entity);
            return dto;
        });
        return new CustomPage<Address>(dtos);
    }


    private Address mapToDto(AddressEntity addEntity) {
        Address address=new Address();
        address.setId(addEntity.getId());
        address.setOrgId(addEntity.getOrgId());
        address.setName(addEntity.getName());
        address.setLine2(addEntity.getLine2());
        address.setLine2(addEntity.getLine2());
        address.setCity(addEntity.getCity());
        address.setState(addEntity.getState());
        address.setCountry(addEntity.getCountry());
        address.setRank(addEntity.getRank());
        address.setZip(addEntity.getZip());
//        address.setIsActive(addEntity.getIsActive());
//        address.setIsDeleted(addEntity.getIsDeleted());
//        address.setCreatedBy(addEntity.getCreatedBy());
//        address.setCreatedDate(addEntity.getCreatedDate());
//        address.setUpdatedBy(addEntity.getUpdatedBy());
//        address.setUpdatedDate(addEntity.getUpdatedDate());
        return address;
    }

    private AddressEntity getAddEntity(Optional<AddressEntity> optEntity) throws AdminException {
        AddressEntity addEntity;
        if(optEntity.isPresent()) {
            addEntity = optEntity.get();
        } else {
            throw new AdminException(AdminErrorCode.APP_NOT_FOUND.getCode(),
                    AdminErrorCode.APP_NOT_FOUND.getMessage(),
                    AdminErrorCode.APP_NOT_FOUND.getType());
        }
        return addEntity;
    }

}


