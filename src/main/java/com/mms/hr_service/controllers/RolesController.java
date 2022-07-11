package com.mms.hr_service.controllers;

import com.mms.hr_service.entities.Employee;
import com.mms.hr_service.entities.Roles;
import com.mms.hr_service.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/roles")
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @GetMapping("/all")
    public Iterable<Roles> findAllRoles() {
        return rolesService.findAllRoles();
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findRoleById(@PathVariable(value = "id") Long id) {
        return rolesService.findRoleById(id);
    }

    @PostMapping
    public Roles createRole(@RequestBody Roles rol) {
        return rolesService.createRole(rol);
    }

    @PutMapping
    public ResponseEntity<Roles> updateEmployee(@RequestBody Roles rol) {
        return rolesService.updateRole(rol);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable(value = "id") Long id) {
        rolesService.deleteRole(id);
    }
}
