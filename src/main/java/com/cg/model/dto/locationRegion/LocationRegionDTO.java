package com.cg.model.dto.locationRegion;


import com.cg.model.LocationRegion;
import com.cg.model.Role;
import com.cg.model.User;
import com.cg.model.dto.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LocationRegionDTO {

    private Long id;
    private String provinceId;
    private String provinceName;
    private String districtId;
    private String districtName;
    private String wardId;
    private String wardName;
    private String address;


    public LocationRegion toLocationRegion() {
        return new LocationRegion()
                .setProvinceId(this.provinceId)
                .setProvinceName(this.provinceName)
                .setDistrictId(this.districtId)
                .setDistrictName(this.districtName)
                .setWardId(this.wardId)
                .setWardName(this.wardName)
                .setAddress(this.address);
    }
}
