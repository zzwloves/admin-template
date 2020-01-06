package io.vicp.wloves.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhuzw
 * @version <b>1.0.0</b>
 * @date 2019/12/31 13:41
 */
@Data
@Table(name = "t_sys_user")
public class SysUser {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @NotBlank(message = "用户名不能为空")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Column(name = "password")
    private String password;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}
