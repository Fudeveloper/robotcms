package com.lik.robotcms.mapper;

import com.lik.robotcms.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lik123
 * @since 2018-06-06
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectByUsername(@Param("username")String username);
}