package com.san.MyThread;

import java.sql.ResultSet;

/**
 * 查询结果集的封装
 * 最终返回成什么样的数据结构,自己实现
 * @Auther: Gxyx
 * @Date: 2020/11/18/10:59
 */

//策略接口
public interface RowHandler<T> {

    T handle(ResultSet rs);

}
