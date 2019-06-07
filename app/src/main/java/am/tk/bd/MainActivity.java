package am.tk.bd;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.vision.L;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetector;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission_group.CAMERA;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static RecyclerView rv_lot;
    Button btn_next;
    public static ArrayList<String> lotNo;
    ArrayList<Lot> lots;
    public static LotAdapter lotAdapter;
    public static int count  = 0;
    FirebaseDatabase database;
    DatabaseReference myRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_lot = findViewById(R.id.rv_lot);

        Intent intent = getIntent();
        lotNo = intent.getStringArrayListExtra("lots");
        Log.d(TAG, "onCreate: " + lotNo);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        if(lotNo == null){
            lotNo = new ArrayList<>();
        }
        lots = new ArrayList<>();
        for (int i = 0 ; i < lotNo.size(); i++){
            lots.add(new Lot("la"+String.valueOf(i+1), lotNo.get(i) ));
        }
        lotAdapter = new LotAdapter(lots);
        rv_lot.setLayoutManager(new GridLayoutManager(MainActivity.this,
                2,
                LinearLayoutManager.VERTICAL,
                false));
        rv_lot.setAdapter(lotAdapter);
//        HashMap<String,String> hashMap = new HashMap<>();
//        hashMap.put("sjhvbs","vsjdn");
//        Orders order = new Orders("anfjfkn", "bsdbv", "nkjaj", "bvdbz","h",hashMap);
//        myRef.child("Person1").push().child("Orders").push().child("Order1").push().setValue(order);
//        myRef.child("Person1").child("Orders").child("Order1").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                Orders order = dataSnapshot.getValue(Orders.class);
//                HashMap hashMap = order.getLots();
//                Iterator hmIterator = hashMap.entrySet().iterator();
//                while (hmIterator.hasNext()) {
//                    Map.Entry mapElement = (Map.Entry)hmIterator.next();
//                    Lot lot = new Lot(mapElement.getKey().toString(), mapElement.getValue().toString());
//                    lots.add(lot);
//                    lotAdapter.notifyDataSetChanged();
//
//                }
//
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//


//
//        String result = intentThatStarrtedThis.getStringExtra("result");


        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("lots", lotNo);
                startActivity(i);

            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    //    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d(TAG, "onResume: ");
//        Intent intentThatStartedThis = getIntent();
//        String myResult = intentThatStartedThis.getStringExtra("result");
//
//        Lot lot = new Lot("La" + String.valueOf(++count), myResult);
//        lots.add(lot);
//        lotAdapter.notifyDataSetChanged();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.d(TAG, "onRestart: ");
//        Intent intentThatStartedThis = getIntent();
//        String myResult = intentThatStartedThis.getStringExtra("result");
//
//
//
//    }


}
