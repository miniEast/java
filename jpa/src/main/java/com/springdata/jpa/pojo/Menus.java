package com.springdata.jpa.pojo;


import com.sun.tools.javah.Gen;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_menus")
public class Menus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menuId")
    private Integer menuId;
    @Column(name = "menuName")
    private String menuName;
    @Column(name = "menuUrl")
    private String menuUrl;
    @Column(name = "fatherId")
    private Integer fatherId;


    @ManyToMany
    //当前表中所关联的中间表的外键
    @JoinTable(name = "t_roles_menus", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "menu_id"))
    //映射中间表
    private Set<Roles> roles = new HashSet<>();


    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    @Override
    public String toString() {
        return "Menus{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", fatherId=" + fatherId +
                '}';
    }
}
