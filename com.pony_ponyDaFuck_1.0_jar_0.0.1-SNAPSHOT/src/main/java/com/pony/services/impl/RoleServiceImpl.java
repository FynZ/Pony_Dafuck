/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pony.services.impl;

import com.pony.models.Role;
import com.pony.repositories.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pony.services.RoleService;

/**
 *
 * @author Gotug
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository _roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this._roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return _roleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Role findById(Long roleId) {

        return _roleRepository.findOne(roleId);
    }

    @Override
    public Role insert(Role role) {

        return _roleRepository.save(role);
    }

    @Override
    public Role update(Long roleId, Role role) {

        Role roleById = _roleRepository.findOne(roleId);

        roleById.setName(role.getName());

        return _roleRepository.save(roleById);
    }

    @Override
    @Transactional
    public void delete(Long roleId) {
        _roleRepository.delete(roleId);
    }
}