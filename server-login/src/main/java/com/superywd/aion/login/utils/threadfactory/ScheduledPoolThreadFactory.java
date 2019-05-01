package com.superywd.aion.login.utils.threadfactory;

import java.util.concurrent.ThreadFactory;

/**
 * @author: saltman155
 * @date: 2019/3/18 23:51
 */

public class ScheduledPoolThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}
