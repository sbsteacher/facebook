package com.koreait.facebook.user;

import com.koreait.facebook.common.EmailServiceImpl;
import com.koreait.facebook.user.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private EmailServiceImpl email;

    @Autowired
    private UserMapper mapper;

    public int join(UserEntity param) {
        //비밀번호 암호화
        String hashedPw = BCrypt.hashpw(param.getPw(), BCrypt.gensalt());
        param.setPw(hashedPw);
        return mapper.join(param);
    }

    public void sendEmail() {
        String to = "pirbak@daum.net";
        String subject = "제목입니다";
        String txt = "내용입니다";
        email.sendSimpleMessage(to, subject, txt);
    }
}
