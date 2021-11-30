package edu.wsu.wsufoodies;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("/login")
    default Call<LoginResult> executeLogin(@Body HashMap<String, String> map) {
        return null;
    }

    @POST("/addUser")
    default Call<Void> executeRegister(@Body edu.wsu.wsufoodies.User u) {
        return null;
    }
}
