package com.lik.robotcms;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.lik.robotcms.entity.SysUser;
import com.lik.robotcms.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotcmsApplicationTests {

	@Autowired
	private SysUserService sysUserService;

	@Test
	public void contextLoads() {
//        SysUser user = sysUserService.selectOne(new EntityWrapper<SysUser>().eq("username","admin"));
//		Map<String, Object> stringObjectMap =new HashMap<>();

        System.out.println(sysUserService.selectByUsername("admin"));
	}

}
