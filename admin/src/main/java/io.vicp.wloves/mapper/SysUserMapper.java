package io.vicp.wloves.mapper;

import io.vicp.wloves.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author zhuzw
 * @version <b>1.0.0</b>
 * @date 2019/12/31 13:58
 */
@Mapper
@Component
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
