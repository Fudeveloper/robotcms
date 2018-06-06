package com.lik.robotcms.service;

import com.lik.robotcms.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lik123
 * @since 2018-06-06
 */
public interface SysUserService extends IService<SysUser> {
    SysUser selectByUsername(String username);
}
