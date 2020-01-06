package io.vicp.wloves.service.impl;

import io.vicp.wloves.base.BusinessException;
import io.vicp.wloves.base.ExceptionEnum;
import io.vicp.wloves.base.ResponseResult;
import io.vicp.wloves.entity.SysUser;
import io.vicp.wloves.mapper.SysUserMapper;
import io.vicp.wloves.service.SysUserService;
import io.vicp.wloves.util.ExceptionUtils;
import io.vicp.wloves.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhuzw
 * @version <b>1.0.0</b>
 * @date 2019/12/31 13:39
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private static final String PASSWORD = "qwer123456";

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public ResponseResult login(String username, String password) {
        SysUser sysUser = sysUserMapper.selectByUsernameAndPassword(username, password);
        if (sysUser == null) {
            ExceptionUtils.throwException(ExceptionEnum.U4002);
        }
        String token = sysUser.getId().toString();
        HttpServletResponse response = RequestUtils.getCurrentResponse();
        Cookie cookie = new Cookie("token", token);
        response.addCookie(cookie);
        ResponseResult result = new ResponseResult(sysUser);
        result.addExtraData("token", token);
        return result;
    }

    @Override
    public ResponseResult logout(String token) {
        HttpServletResponse response = RequestUtils.getCurrentResponse();
        response.addCookie(new Cookie("token", null));
        return new ResponseResult();
    }

    @Override
    public ResponseResult getInfoByToken(String token) {
        SysUser sysUser = getUserByToken(token);
        return new ResponseResult(sysUser);
    }

    @Override
    public ResponseResult updatePwd(String token, String oldPwd, String newPwd) {
        if (oldPwd.equals(newPwd)) {
            throw new BusinessException(ExceptionEnum.U4003);
        }
        SysUser sysUser = getUserByToken(token);
        if (!sysUser.getPassword().equals(oldPwd)) {
            throw new BusinessException(ExceptionEnum.U4004);
        }
        SysUser su = new SysUser();
        su.setId(sysUser.getId());
        su.setPassword(newPwd);
        sysUserMapper.updateByPrimaryKeySelective(su);
        return new ResponseResult();
    }

    private SysUser getUserByToken(String token) {
        Integer sysUserId = Integer.valueOf(token);
        return sysUserMapper.selectByPrimaryKey(sysUserId);
    }
}
