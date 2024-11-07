package com.security.SpringToken.service;

import com.security.SpringToken.VO.UserVO;
import com.security.SpringToken.business.UserBO;
import com.security.SpringToken.configuration.ResponseStructure;
import com.security.SpringToken.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserBO userBO;

    @Autowired
    private ResponseStructure responseStructure;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<ResponseStructure<UserVO>> registerUser(UserVO userVO) {
        userVO = userBO.registerUserDetails(userVO);
        if (userVO != null) {
            responseStructure.setData(userVO);
            responseStructure.setMessage("User Has Been Registered");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
        responseStructure.setData(userVO);
        responseStructure.setMessage("Error in Registering User");
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
    }

    public String verifyUser(User user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUserName());
        return "Login Failed";
    }
}
