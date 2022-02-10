package com.gabea.mbaapi.model.response;

import com.gabea.mbaapi.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private int code;
    private String msg;
    private List<User> data;


    public static UserResponse success(List<User> data) {
        return new UserResponse(200, "SUCCESSFUL", data);
    }

    public static UserResponse successResponseForSingleUser(User user) {
        List<User> data = new ArrayList<>();
        data.add(user);
        return new UserResponse(200, "SUCCESSFULL", data);
    }

    public static UserResponse personalizedResponseForSingleUser(User user, int code, String msg) {
        List<User> data = new ArrayList<>();
        data.add(user);
        return new UserResponse(code, msg, data);
    }

    public static UserResponse personalizedResponse(List<User> data, int code, String msg) {
        return new UserResponse(code, msg, data);
    }

}
