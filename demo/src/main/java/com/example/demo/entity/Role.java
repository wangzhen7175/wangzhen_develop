package com.example.demo.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Role implements Serializable {
    private String roleId;
    private String roleName;
    private String url;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "RoleBean{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
    public String toHtmlString() {
        return "<form method='get' action='"+url+"'><input type='submit' value='"+roleName+"'></form></br>";
    }
    //"<form method='get' action='"+url+"'><input type='submit' value='"+roleName+"'></form>";

}
