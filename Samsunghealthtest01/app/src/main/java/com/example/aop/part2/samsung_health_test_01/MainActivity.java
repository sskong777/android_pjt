package com.example.aop.part2.samsung_health_test_01;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import com.samsung.android.sdk.healthdata.HealthConnectionErrorResult;
import com.samsung.android.sdk.healthdata.HealthConstants;
import com.samsung.android.sdk.healthdata.HealthDataStore;
import com.samsung.android.sdk.healthdata.HealthPermissionManager;

import java.util.HashSet;
import java.util.Set;


public class MainActivity extends Activity {

    public static final String APP_TAG = "Test Samsung Health";

    private static MainActivity mInstance = null;
    private HealthDataStore mStore;
    private HealthConnectionErrorResult mConnError;
    private Set<HealthPermissionManager.PermissionKey> mKeySet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // ...

        super.onCreate(savedInstanceState);
        mInstance = this;
        mKeySet = new HashSet<HealthPermissionManager.PermissionKey>();
        mKeySet.add(new HealthPermissionManager.PermissionKey(HealthConstants.StepCount.HEALTH_DATA_TYPE, HealthPermissionManager.PermissionType.READ));
        // Create a HealthDataStore instance and set its listener
        HealthDataStore.ConnectionListener mConnectionListener = null;
        mStore = new HealthDataStore(this, mConnectionListener);
        // Request the connection to the health data store
        mStore.connectService();
        System.out.println(mStore);
        System.out.println("connect Success!!!!!!!!!!!!!!!!");

    }

    @Override
    public void onDestroy() {
        mStore.disconnectService();
        super.onDestroy();
    }

    private final HealthDataStore.ConnectionListener mConnectionListener = new HealthDataStore.ConnectionListener() {

        @Override
        public void onConnected() {
            Log.d(APP_TAG, "Health data service is connected.");
            HealthPermissionManager pmsManager = new HealthPermissionManager(mStore);

            try {
                // Check whether the permissions that this application needs are acquired
                // Request the permission for reading step counts if it is not acquired

                // Get the current step count and display it if data permission is required
                // ...
            } catch (Exception e) {
                Log.e(APP_TAG, e.getClass().getName() + " - " + e.getMessage());
                Log.e(APP_TAG, "Permission setting fails.");
            }
        }

        @Override
        public void onConnectionFailed(HealthConnectionErrorResult error) {
            Log.d(APP_TAG, "Health data service is not available.");
            showConnectionFailureDialog(error);
        }

        @Override
        public void onDisconnected() {
            Log.d(APP_TAG, "Health data service is disconnected.");
        }



        private void showConnectionFailureDialog(HealthConnectionErrorResult error) {

            mConnError = error;
            String message = "Connection with Samsung Health is not available";

            if (mConnError.hasResolution()) {
                switch(error.getErrorCode()) {
                    case HealthConnectionErrorResult.PLATFORM_NOT_INSTALLED:
                        message = "Please install Samsung Health";
                        break;
                    case HealthConnectionErrorResult.OLD_VERSION_PLATFORM:
                        message = "Please upgrade Samsung Health";
                        break;
                    case HealthConnectionErrorResult.PLATFORM_DISABLED:
                        message = "Please enable Samsung Health";
                        break;
                    case HealthConnectionErrorResult.USER_AGREEMENT_NEEDED:
                        message = "Please agree with Samsung Health policy";
                        break;
                    default:
                        message = "Please make Samsung Health available";
                        break;
                }
            }


        }
    };

}