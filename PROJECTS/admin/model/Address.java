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
public class Address {

    private Integer id;
    private  Integer orgId;
    private String name;
    private String line1;
    private String line2;
    private Integer rank;
    private String zip;
    private String city;
    private String state;
    private String country;
    private LocalDateTime createdDate;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime updatedDate;
    private int isActive = 1;
    private int isDeleted = 0;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", orgId='" + orgId + '\'' +
                ", name='" + name + '\'' +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", rank='" + rank+ '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state+ '\'' +
                ", country='" + country+ '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", updatedDate=" + updatedDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", isActive=" + isActive +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
