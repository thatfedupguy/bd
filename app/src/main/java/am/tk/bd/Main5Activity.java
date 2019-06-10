package am.tk.bd;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main5Activity extends AppCompatActivity {

//    ServiceConnection mServiceConnection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            DistanceTraveledService.DistanceTravelBinder distanceTravelBinder = (DistanceTraveledService.DistanceTravelBinder)service;
//            mDistanceTraveledService = distanceTravelBinder.getBinder();
//            bound = true;
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            bound = false;
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }
}
