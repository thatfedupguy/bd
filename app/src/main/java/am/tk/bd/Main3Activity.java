package am.tk.bd;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Main3Activity extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    private ZXingScannerView scannerView;
    FirebaseDatabase database;
    DatabaseReference myRef;
    String binCode;
    Boolean isCorrect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        Intent i = getIntent();
        binCode = i.getStringExtra("binCode");
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
        scannerView.setResultHandler(this);
        scannerView.startCamera();


    }
    @Override
    public void handleResult(Result result) {
        final String myResult = result.getText();
        Log.d("QRCodeScanner", result.getText());
        Log.d("QRCodeScanner", result.getBarcodeFormat().toString());
//        myRef.child("Person1").child("Orders").child("Order1").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                Orders order = dataSnapshot.getValue(Orders.class);
//                String bin_code = order.getBin_code();
//                if(bin_code.equals(binCode)){
//                    isCorrect = true;
//                }
//                else{
//                    isCorrect = false;
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
        if(binCode.equals(myResult)){
            isCorrect = true;
            Toast.makeText(Main3Activity.this, "Verification successful", Toast.LENGTH_SHORT);
        }
        else{
            isCorrect = false;
            Toast.makeText(Main3Activity.this, "Verification unsuccessful", Toast.LENGTH_SHORT);

        }

        Intent i = new Intent(Main3Activity.this, MainActivity.class);
        i.putExtra("isCorrect", isCorrect);
        startActivity(i);

    }
}
