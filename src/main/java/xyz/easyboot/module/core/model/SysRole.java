package xyz.easyboot.module.core.model;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wujiawei0926@yeah.net
 * @see
 * @since 2020/6/18
 */
@Entity
@Table(name = "sys_role")
public class SysRole extends Model {

    public static final Finder<Long, SysRole> find = new Finder<>(SysRole.class);

    /**
     * 角色id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
