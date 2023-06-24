package com.cg.model;

import com.cg.model.dto.user.RoleDTO;
import com.cg.model.dto.user.UserDTO;
import com.cg.model.dto.user.UserLoginDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @OneToOne
    @JoinColumn(name = "location_region_id", referencedColumnName = "id")
    private LocationRegion locationRegion;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;

    public UserLoginDTO toUserLoginDTO() {
         return new UserLoginDTO()
                .setUsername(username)
                .setPassword(password);
    }

    public UserDTO toUserDTO() {
        return new  UserDTO()
                .setId(id)
                .setFullName(fullName)
                .setUsername(username)
                .setPassword(password)
                .setEmail(email)
                .setPhone(phone)
                .setLocationRegionDTO(locationRegion.toLocationRegionDTO())
                .setRole(role.toRoleDTO())
                ;
    }
}
