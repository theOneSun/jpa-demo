package com.example.demo.taixing;

import lombok.Data;

/**
 * @author sunjian.
 */
@Data
public class PoliceInfo {

    private String sortNum;
    private String isLogin;
    private String photo;
    private String levelId;
    private String organId;
    private String organCode;
    private String organName;
    /**
     * 用户主键
     */
    private String userId;
    /**
     * 用户中心机构代码
     */
    private String selfCode;
    /**
     * 账号
     */
    private String account;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 职务
     */
    private String duties;
    /**
     * 警号
     */
    private String policeCode;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别 1男 2女
     */
    private String sex;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 移动长号
     */
    private String mobile;
    /**
     * 办公电话
     */
    private String phone;
    /**
     * 传真
     */
    private String fax;
    /**
     * 邮箱
     */
    private String mailbox;
    /**
     * 用户状态 2删除，0启用，1停用
     */
    private String status;
    /**
     * 创建者
     */
    private String cretBy;
    /**
     * 创建时间
     */
    private String cretTime;
    /**
     * 更新者
     */
    private String uptBy;
    /**
     * 更新时间
     */
    private String uptTime;
    /**
     * 更新时间
     */
    private String remark;
}
