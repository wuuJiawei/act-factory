package xyz.easyboot.module.core.dao;

import act.db.ebean.EbeanDao;
import act.db.ebean.EbeanQuery;
import xyz.easyboot.module.core.model.SysUser;

/**
 * @author wujiawei0926@yeah.net
 * @see
 * @since 2020/6/19
 */
public class SysUserDao extends EbeanDao<Integer, SysUser> {

    protected SysUserDao() {
        super(Integer.class, SysUser.class);
    }

    /**
     * 根据username查询用户对象
     * @param username
     * @return
     */
    public SysUser findByUserName(String username) {
        return findOneBy("username", username);
    }

    /**
     * 根据username和password查询用户对象
     * @param username
     * @param password
     * @return
     */
    public SysUser findByUsernameAndPassword(String username, String password) {
        return findOneBy("username,password", username, password);
    }

}
