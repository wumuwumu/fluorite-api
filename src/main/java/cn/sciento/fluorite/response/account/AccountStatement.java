package cn.sciento.fluorite.response.account;

import java.util.List;

public class AccountStatement {
    private String Permission;

    private List<String> Resource;

    public String getPermission() {
        return Permission;
    }

    public void setPermission(String permission) {
        Permission = permission;
    }

    public List<String> getResource() {
        return Resource;
    }

    public void setResource(List<String> resource) {
        Resource = resource;
    }
}
