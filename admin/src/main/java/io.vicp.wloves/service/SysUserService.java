package io.vicp.wloves.service;

import io.vicp.wloves.base.ResponseResult;

/**
 * @author zhuzw
 * @version <b>1.0.0</b>
 * @date 2019/12/31 13:38
 */
public interface SysUserService {

    ResponseResult login(String username, String password);

    ResponseResult logout(String token);

    ResponseResult getInfoByToken(String token);

    ResponseResult updatePwd(String token, String oldPwd, String newPwd);
}
