package com.tekact.platform.admin.entity;
import com.tekact.platform.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "address",schema = "platform_schema")
public class AddressEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;
    @Column(name = "ORG_ID", nullable = false, unique = true)
    private  Integer orgId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "line1")
    private String line1;
    @Column(name = "line2")
    private String line2;
    @Column(name = "rank")
    private Integer rank;
    @Column(name = "zip")
    private String zip;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "is_active")
    private int isActive = 1;
    @Column(name = "is_deleted")
    private int isDeleted = 0;

}
