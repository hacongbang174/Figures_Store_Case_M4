package com.cg.api;


import com.cg.model.dto.user.RoleDTO;
import com.cg.model.dto.user.UserDTO;
import com.cg.service.role.IRoleService;
import com.cg.service.user.IUserService;
import com.cg.utils.AppUtils;
import com.cg.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAPI {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;


    @Autowired
    private AppUtils appUtils;

    @Autowired
    private ValidateUtils validateUtils;


    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
        List<UserDTO> userDTOS = userService.findAllUserDTO();

        if (userDTOS.isEmpty()) {
            return new ResponseEntity<>("No customer found.", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }
    @GetMapping("/roles")
    public ResponseEntity<?> getAllRoles() {
        List<RoleDTO> roleDTOS = roleService.findAllRoleDTO();

        if (roleDTOS.isEmpty()) {
            return new ResponseEntity<>("No roles found.", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(roleDTOS, HttpStatus.OK);
    }

}
