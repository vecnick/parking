package com.example.parking.DI;

import android.content.Context;

import com.example.parking.Repositories.UserRepository;
import com.example.parking.network.NetworkLogic;

public class ServiceLocator {

    private static ServiceLocator serviceLocator;
    private Context context;
    private NetworkLogic mNetworkLogic;
    private UserRepository UserRepository;

    public ServiceLocator(Context context) {
        serviceLocator = this;
        this.context = context;
        UserRepository = new UserRepository(context);
    }

    public UserRepository getUserRepository() {
        return UserRepository;
    }

    public void setUserRepository(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public static ServiceLocator getInstance() {
        return serviceLocator;
    }

    public static void init (Context context){
        serviceLocator = new ServiceLocator(context);
    }

    public NetworkLogic getNetworkLogic() {
        return mNetworkLogic;
    }
}
