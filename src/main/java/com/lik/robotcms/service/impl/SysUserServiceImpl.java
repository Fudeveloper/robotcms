package com.lik.robotcms.service.impl;

import com.lik.robotcms.entity.SysUser;
import com.lik.robotcms.mapper.SysUserMapper;
import com.lik.robotcms.service.SysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lik123
 * @since 2018-06-06
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectByUsername(String username) {
        return this.baseMapper.selectByUsername(username);
    }
}
