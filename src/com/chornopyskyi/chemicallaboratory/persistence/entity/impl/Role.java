package com.chornopyskyi.chemicallaboratory.persistence.entity.impl;

import com.chornopyskyi.chemicallaboratory.persistence.entity.RolePermissions;

public class Role {

    private final RolePermissions rolePermissions;

    public Role(String role) {
        if (role == "Адміністратор") {
            rolePermissions = new RolePermissions(true, true, true, true, true, true, true);
        }
        else if (role == "Викладач") {
            rolePermissions = new RolePermissions(true, true, true, true, true, true, true);
        }
        else if (role == "Лаборант") {
            rolePermissions = new RolePermissions(false, false, false, false, true, true, true);
        }
        else if (role == "Користувач") {
            rolePermissions = new RolePermissions(false, false, false, false, true, true, false);
        }
        else {
            rolePermissions = null;
        }
    }
}


