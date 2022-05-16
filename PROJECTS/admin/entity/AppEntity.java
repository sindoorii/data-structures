package com.tekact.platform.admin.entity;

import com.tekact.platform.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "APP")
public class AppEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "org_id")
    private Integer orgId;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type_code")
    private String typeCode;
//
//    @Column(name = "desc")
//    private String desc;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "is_approved")
    private Short isApproved = 0;

    @Column(name = "is_active")
    private Short isActive = 1;

    @Column(name = "is_deleted")
    private Short isDeleted = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppEntity appEntity = (AppEntity) o;
        return id.equals(appEntity.id) && orgId.equals(appEntity.orgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orgId);
    }
}
