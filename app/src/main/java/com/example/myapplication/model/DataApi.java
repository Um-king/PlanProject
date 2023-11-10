package com.example.myapplication.model;

import com.example.myapplication.model.object.UserData;
import com.example.myapplication.model.object.Users;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface DataApi {
    // @Headers({"Content-Type: application/json"})
    //@FormUrlEncoded
    @POST("getDongProgressFloorReturn")
    Single<UserData>GetData(@Body String userId, String userPw);

}
