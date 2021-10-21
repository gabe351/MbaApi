package com.gabea.mbaapi.utils;

import com.gabea.mbaapi.model.Payment;
import com.gabea.mbaapi.model.User;
import com.gabea.mbaapi.model.enums.InstrumentEnum;
import com.gabea.mbaapi.model.enums.SituationEnum;
import com.gabea.mbaapi.model.enums.UserTypeEnum;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class UserBuilder {

    public static List<User> buildUserList() {

        List<User> userList = new ArrayList<>();
        User user = new User(1,"Bia", "bia@email.com", "123", InstrumentEnum.AGBE, UserTypeEnum.DEV, SituationEnum.UP_TO_DATE,
                true, false, Instant.now(), Instant.now());
        User user2 = new User(2,"Gabe", "gabe@email.com", "12", InstrumentEnum.CAIXA, UserTypeEnum.ADMIN, SituationEnum.DEBIT,
                true, false, Instant.now(), Instant.now());
        User user3 = new User(3,"Elisa", "elisa@email.com", "33", InstrumentEnum.AGBE, UserTypeEnum.REGULAR, SituationEnum.UP_TO_DATE,
                true, false, Instant.now(), Instant.now());

        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }
}
