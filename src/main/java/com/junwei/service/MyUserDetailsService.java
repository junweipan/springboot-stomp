package com.junwei.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.junwei.entity.Users;
import com.junwei.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //调用usersMapper的方法查询
        QueryWrapper<Users> wrapper = new QueryWrapper();
        //where username=s
        wrapper.eq("username",s);
        Users users = usersMapper.selectOne(wrapper);

        if(users ==null){
            //认证失败
            throw new UsernameNotFoundException("用户不存在!");
        }
        List<GrantedAuthority> auths =
                AuthorityUtils.commaSeparatedStringToAuthorityList("role");

        return new User(users.getUsername(),
                new BCryptPasswordEncoder().encode(users.getPassword()),auths);
    }
}
