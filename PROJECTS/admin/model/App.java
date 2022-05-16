package com.tekact.platform.admin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class App {

    private Integer id;
    private Integer orgId;
    private String code;
    private String name;
    private String typeCode;
    private String imgUrl;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime updatedDate;
    private String updatedBy;
    private Short isApproved = 0;
    private Short isActive = 1;
    private Short isDeleted = 0;

    @Override
    public String toString() {
        return "App{" +
                "id=" + id +
                ", orgId=" + orgId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", updatedDate=" + updatedDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", isApproved=" + isApproved +
                ", isActive=" + isActive +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
