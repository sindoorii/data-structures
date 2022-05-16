package com.tekact.platform.admin.entity;



import com.tekact.platform.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "organization",schema = "platform_schema")
public class OrganizationEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;
    @Column(name = "CODE", nullable = false, unique = true)
    private String code;
    @Column(name = "TYPE_CODE", nullable = false)
    private String typeCode;
    @Column(name = "NAME")
    private String name;
    @Column(name="GST")
    private String gst;
    @Column(name="IMG_URL")
    private String imgUrl;
    @Column(name="IS_ACTIVE")
    private int isActive=1;
    @Column(name="IS_DELETED")
    private int isDeleted=0;
    @Column(name="IS_APPROVED")
    private int isApproved=1;
//    @Column(name="CREATED_AT")
//    private LocalDateTime created_at;
//    @Column(name="UPDATED_AT")
//    private LocalDateTime updated_at;
//    @Column(name = "CREATED_BY")
//    private String created_by;
//    @Column(name="UPDATED_BY")
//    private String updated_by;



    @OneToMany(targetEntity = AddressEntity.class,cascade = CascadeType.ALL)
    @JoinTable(name = "organization_address",joinColumns = {@JoinColumn(name = "org_id",referencedColumnName = "id")},
            inverseJoinColumns={ @JoinColumn(name = "address_id",referencedColumnName = "id") })
    private List<AddressEntity> addressentity ;
}
