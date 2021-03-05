package com.ql.qlsql.jpa.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/12/4 14:25
 */
@ApiModel(description = "管理员的实体类")
@Entity
@Table(name = "ql_admin")
public class Admin implements Serializable {

    private static final long serialVersionUID = 2927967486414152689L;

    @ApiModelProperty(value = "管理员id", dataType = "Integer")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer id;

    @ApiModelProperty(value = "管理员姓名", dataType = "String")
    @NotNull
    private String userName;

    @ApiModelProperty(value = "管理员密码", dataType = "String")
    @NotNull
    private String password;

    public Admin() {
    }

    public Admin(@NotNull String userName, @NotNull String password) {
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
