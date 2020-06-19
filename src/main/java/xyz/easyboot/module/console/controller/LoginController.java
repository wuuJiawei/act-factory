package xyz.easyboot.module.console.controller;

import org.osgl.$;
import org.osgl.http.H;
import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.annotation.ResponseContentType;
import org.osgl.mvc.result.Result;
import org.osgl.util.E;
import xyz.easyboot.common.web.JSONResult;
import xyz.easyboot.module.core.dao.SysUserDao;
import xyz.easyboot.module.core.model.SysUser;

import javax.inject.Inject;

/**
 * @author wujiawei0926@yeah.net
 * @see
 * @since 2020/6/18
 */
public class LoginController extends BaseController {

    @Inject
    private SysUserDao userDao;

    @GetAction("/login")
    @ResponseContentType(H.MediaType.HTML)
    public Result index() {
        return render("login.html");
    }

    @GetAction("/login/do")
    public JSONResult<?> login(String username, String password) {
        SysUser user = new SysUser();
        E.illegalArgumentIf(user == null, "账号不存在");

        if (!$.eq(password, user.getPassword())) {
            return JSONResult.error("密码错误");
        }

        return JSONResult.ok(user);
    }

}
