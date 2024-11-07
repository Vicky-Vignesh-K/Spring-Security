package com.security.SpringToken.business;

import com.security.SpringToken.VO.UserVO;
import com.security.SpringToken.entity.User;
import com.security.SpringToken.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserBO {

    @Autowired
    private IUserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public UserVO registerUserDetails(UserVO userVO) {
        User user = userRepository.save(setUserVOToUser(userVO));
        return setUserToVO(user, userVO);
    }

    public User setUserVOToUser(UserVO userVO) {
        User user = new User();
        user.setUserName(userVO.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(userVO.getPassword()));
        return user;
    }

    public UserVO setUserToVO(User user, UserVO userVO) {
        userVO.setUserId(user.getUserId());
        userVO.setUserName(user.getUserName());
        userVO.setPassword(user.getPassword());
        return userVO;
    }

}
