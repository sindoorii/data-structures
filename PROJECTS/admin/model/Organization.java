package com.tekact.platform.admin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

    private int id;
    private String code;
    private String typeCode;
    private String name;
    private String gst;
    private String imgUrl;
    private int isActive;
    private int isDeleted;
    private int isApproved;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;


    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", gst'" + gst + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", createdDate=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedDate=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                ", isApproved=" + isApproved +
                ", isActive=" + isActive +
                ", isDeleted=" + isDeleted +
                '}';
    }
}