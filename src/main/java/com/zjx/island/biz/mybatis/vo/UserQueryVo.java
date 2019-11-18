package com.zjx.island.biz.mybatis.vo;

import java.util.List;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/11/18
 */
public class UserQueryVo {

    //在这里包装所需要的查询条件

    //用户查询条件
    private UserCustom userCustom;

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    //传入多个id
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
