package com.security.SpringToken.service;

import com.security.SpringToken.VO.UserPrincipal;
import com.security.SpringToken.entity.User;
import com.security.SpringToken.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username);
        if(user!= null ){
            return new UserPrincipal(user);
        }else {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Not Found");
        }

    }
}
