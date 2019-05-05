package com.superywd.aion.model.engine.ai3.metadata;

import java.lang.annotation.*;

/**
 * 该注释用于设置对应的AI脚本的名称
 * @author: saltman155
 * @date: 2019/5/4 22:46
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AIName {

    String name();

}
