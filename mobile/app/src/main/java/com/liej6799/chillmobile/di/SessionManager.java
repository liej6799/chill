package com.liej6799.chillmobile.di;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.liej6799.chillmobile.di.sharedpref.CustomSharedPreferences;
import com.liej6799.chillmobile.model.User;
import com.liej6799.chillmobile.util.Resource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SessionManager {

    private static final String TAG = "SessionManager";

    private MediatorLiveData<Resource<User>> cachedUser = new MediatorLiveData<>();
    private CustomSharedPreferences customSharedPreferences;

    @Inject
    public SessionManager(CustomSharedPreferences _customSharedPreferences) {
        customSharedPreferences = _customSharedPreferences;

    }

    public void authenticateUser(final LiveData<Resource<User>> source) {
        if (cachedUser != null) {
            cachedUser.setValue(Resource.loading(null));
            cachedUser.addSource(source, new Observer<Resource<User>>() {
                @Override
                public void onChanged(Resource<User> userResource) {
                    cachedUser.setValue(userResource);
                    cachedUser.removeSource(source);
                }
            });
        } else {
            Log.d(TAG, "authenticate failed");
        }
    }


    public void logOut() {
        Log.d(TAG, "logOut: logging out");
        customSharedPreferences.clearAppAuth();
        cachedUser.setValue(Resource.logout());
    }

    public LiveData<Resource<User>> getAuthUser() {
        return cachedUser;
    }

    public void initialCheckFailed() {
        cachedUser.setValue(Resource.logout());
    }
}
