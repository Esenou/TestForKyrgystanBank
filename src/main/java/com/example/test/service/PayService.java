package com.example.test.service;

import com.example.test.entity.User;
import com.example.test.model.UserModel;
import com.example.test.model.UserPay;
import com.example.test.model.xmlModel.UserModelXml;
import com.example.test.model.xmlModel.UserPayModelXml;

public interface PayService {
    UserPayModelXml pay(UserPay userPay);
    UserModelXml check(UserModel username);
}
