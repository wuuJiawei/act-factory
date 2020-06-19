package xyz.easyboot.module.console.controller;

import org.osgl.http.H;
import org.osgl.logging.L;
import org.osgl.logging.Logger;
import org.osgl.mvc.annotation.Catch;
import xyz.easyboot.common.exception.BusinessException;
import xyz.easyboot.common.web.AbstractController;
import xyz.easyboot.common.web.JSONResult;

/**
 * @author wujiawei0926@yeah.net
 * @see
 * @since 2020/6/18
 */
public abstract class BaseController extends AbstractController {

    private static Logger logger = L.get(BaseController.class);

    @Catch(value = BusinessException.class, priority = 1)
    public void catchEx(BusinessException ex){
        logger.error(ex, ex.getMessage());
        renderJson(JSONResult.error(ex.getMessage()));
    }

}
