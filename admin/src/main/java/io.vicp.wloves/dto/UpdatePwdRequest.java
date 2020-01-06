package io.vicp.wloves.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author zhuzw
 * @version <b>1.0.0</b>
 * @date 2020/1/3 17:27
 */
@Data
public class UpdatePwdRequest {

    @NotBlank(message = "旧密码不能为空")
    private String oldPwd;

    @NotBlank(message = "新密码不能为空")
    private String newPwd;
}
