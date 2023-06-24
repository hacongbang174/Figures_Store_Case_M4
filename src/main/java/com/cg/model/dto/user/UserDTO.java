package com.cg.model.dto.user;

import com.cg.model.LocationRegion;
import com.cg.model.Role;
import com.cg.model.User;
import com.cg.model.dto.locationRegion.LocationRegionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String phone;
    private LocationRegionDTO locationRegionDTO;
    private RoleDTO role;

    public UserDTO(Long id, String fullName, String username, String email, String phone, LocationRegion locationRegion, Role role ) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.locationRegionDTO = locationRegion.toLocationRegionDTO();
        this.role = role.toRoleDTO();
    }
    public UserDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public User toUser() {
        return new User()
                .setId(id)
                .setFullName(fullName)
                .setUsername(username)
                .setPassword(password)
                .setEmail(email)
                .setPhone(phone)
                .setRole(role.toRole())
                ;
    }
}
