package com.example.test.service.impl;

import com.example.test.entity.Pay;
import com.example.test.entity.User;
import com.example.test.model.UserModel;
import com.example.test.model.UserPay;
import com.example.test.model.xmlModel.UserModelXml;
import com.example.test.model.xmlModel.UserPayModelXml;
import com.example.test.repository.PayRepository;
import com.example.test.repository.UserRepository;
import com.example.test.service.PayService;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {

    private final PayRepository payRepository;

    private final UserRepository userRepository;

    public PayServiceImpl(PayRepository payRepository, UserRepository userRepository) {
        this.payRepository = payRepository;
        this.userRepository = userRepository;
    }


    @Override
    public UserPayModelXml pay(UserPay userPay) {

        User user = userRepository.findByUserName(userPay.getUsername());

        if (user != null) {
            Pay pay = new Pay();
            pay.setPay(userPay.getPay());
            pay.setUser(user);
            Long id = payRepository.save(pay).getId();

            UserPayModelXml userPayModelXml = new UserPayModelXml(id,userPay.getUsername(),userPay.getPay());
            return userPayModelXml;
        }
        return null;
    }

    @Override
    public UserModelXml check(UserModel username) {
        User user = userRepository.findByUserName(username.getUsername());

        if(user!=null){
            UserModelXml userModelXml = new UserModelXml(user.getId(),user.getUserName());
            return userModelXml;
        }
        return null;
    }
}
