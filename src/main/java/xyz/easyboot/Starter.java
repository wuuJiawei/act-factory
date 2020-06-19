package xyz.easyboot;

import act.Act;
import act.job.OnAppStart;

/**
 * 启动器
 * @author wujiawei0926@yeah.net
 * @see
 * @since 2020/6/18
 */
public class Starter {

    public static void main(String[] args) throws Exception {
        Act.start("ACT_FACTORY");
    }

    @OnAppStart
    public void onStart() {
        // 启动成功
        System.out.println("启动成功");
    }

}
