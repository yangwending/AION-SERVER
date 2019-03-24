package com.superywd.aion.login.utils.threadfactory;

import java.util.concurrent.ThreadFactory;

/**
 * @author: 迷宫的中心
 * @date: 2019/3/18 23:52
 */

public class InstantPoolThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }

}