package com.mms.hr_service.services;

import com.mms.hr_service.entities.Roles;
import com.mms.hr_service.repos.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    RolesRepository rolesRepository;
    public Iterable<Roles> findAllRoles() {
        return rolesRepository.findAll();
    }

    public ResponseEntity<Object> findRoleById(Long id) {
        Optional<Roles> role = rolesRepository.findById(id);
        if(role.isPresent()) {
            return ResponseEntity.ok().body(role.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Roles createRole(Roles rol) {
        return rolesRepository.save(rol);
    }

    public ResponseEntity<Roles> updateRole(Roles rol) {
        Optional<Roles> employee = rolesRepository.findById(rol.getId());
        if(employee.isPresent()) {
            return ResponseEntity.ok().body(rolesRepository.save(rol));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deleteRole(Long id) {
        rolesRepository.deleteById(id);
    }
}
