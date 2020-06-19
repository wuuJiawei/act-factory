package xyz.easyboot.common.web;

import act.controller.Controller;
import org.osgl.mvc.annotation.Catch;
import xyz.easyboot.common.exception.BusinessException;

/**
 * @author wujiawei0926@yeah.net
 * @see
 * @since 2020/6/18
 */
public abstract class AbstractController extends Controller.Util {

    @Catch(value = BusinessException.class, priority = 1)
    public void catchEx(BusinessException ex){
        renderJson(JSONResult.error(ex.getMessage()));
    }

}
