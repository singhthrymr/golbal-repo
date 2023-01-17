/**
 * Created By Sunil Verma
 * Date: 17/01/23
 * Time: 9:43 AM
 * Project Name: git-practice-backend
 */

package com.practice.user.impl;

import com.practice.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void login() {

        System.out.println("Logged in functionality is called...");

    }
}
