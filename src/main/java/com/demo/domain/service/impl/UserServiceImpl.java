package com.demo.domain.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.domain.dataobject.User;
import com.demo.domain.mapper.UserMapper;
import com.demo.domain.service.UserService;
import com.demo.infrastructure.util.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuxiansong
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findById(long uid) {
        return getBaseMapper().findById(uid);
    }

    @Override
    public PageResult<User> page(User user, Integer current, Integer limit) {
        Page<User> page = new Page<>(current, limit);
        Page<User> res = getBaseMapper().page(page, user);
        return new PageResult(res);
    }

    @Override
    public boolean create(User user) {
        return this.save(user);
    }

    @Override
    public boolean update(User user) {
        return userMapper.updateByIdClickHouse(user);
    }

    @Override
    public void delete(Long id) {
        userMapper.deleteByIdClickHouse(id);
    }
}
