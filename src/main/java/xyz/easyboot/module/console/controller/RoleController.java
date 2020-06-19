package xyz.easyboot.module.console.controller;

import act.controller.Controller;
import act.controller.annotation.UrlContext;
import act.db.ebean.EbeanDao;
import org.osgl.mvc.annotation.GetAction;
import xyz.easyboot.common.web.JSONResult;
import xyz.easyboot.module.core.model.SysRole;

import javax.inject.Inject;

/**
 * @author wujiawei0926@yeah.net
 * @see
 * @since 2020/6/18
 */
@Controller("/role")
public class RoleController extends BaseController {

    @Inject
    private EbeanDao<Integer, SysRole> dao;

    @Inject
    private SysRole sysRole;

    @GetAction
    public Iterable<SysRole> list(){
        return dao.findAll();
    }

    @GetAction("one/{id}")
    public SysRole one(Integer id){
        return dao.findById(id);
    }

    @GetAction("list2/m")
    public Iterable<SysRole> listByModel() {
        return dao.q().where().like("role_name", "用户").and().eq("id", "id").order().desc("id").findList();
    }

}
