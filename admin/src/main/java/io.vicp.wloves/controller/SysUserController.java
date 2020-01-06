package io.vicp.wloves.controller;

import io.vicp.wloves.base.BaseConstant;
import io.vicp.wloves.base.ResponseResult;
import io.vicp.wloves.dto.UpdatePwdRequest;
import io.vicp.wloves.entity.SysUser;
import io.vicp.wloves.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author zhuzw
 * @version <b>1.0.0</b>
 * @date 2019/12/23 17:35
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody @Valid SysUser sysUser) {

        return sysUserService.login(sysUser.getUsername(), sysUser.getPassword());
    }

    @PostMapping("/logout")
    public ResponseResult getListByPage(@RequestHeader(BaseConstant.HEADER_TOKEN) String token) {

        return sysUserService.logout(token);
    }

    @GetMapping("/getInfo")
    public ResponseResult getSysUserInfo(@RequestParam("token") String token) {

        return sysUserService.getInfoByToken(token);
    }

    @PutMapping("/updatePwd")
    public ResponseResult updatePwd(@RequestBody @Valid UpdatePwdRequest pwdRequest,
                                    @RequestHeader(BaseConstant.HEADER_TOKEN) String token) {

        return sysUserService.updatePwd(token, pwdRequest.getOldPwd(), pwdRequest.getNewPwd());
    }

}
