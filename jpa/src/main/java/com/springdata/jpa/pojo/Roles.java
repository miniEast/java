package com.springdata.jpa.pojo;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    private Integer rolrId;

    @Column(name = "roleName")
    private String roleName;

    @OneToMany(mappedBy = "roles")
    private Set<Users> usersSet = new HashSet<>();
    /**
     * fetch 延迟加载 EAGER 立即加载
     * cascade 维护关系
     * mappedBy 关联对象
     */
    @ManyToMany(mappedBy = "roles",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
//    @JoinTable(name = "t_roles_menus", joinColumns = @JoinColumn(name = "menu_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Menus> menus = new HashSet<>();


    public Set<Menus> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menus> menus) {
        this.menus = menus;
    }

    public Set<Users> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<Users> usersSet) {
        this.usersSet = usersSet;
    }

    public Integer getRolrId() {
        return rolrId;
    }

    public void setRolrId(Integer rolrId) {
        this.rolrId = rolrId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "rolrId=" + rolrId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
