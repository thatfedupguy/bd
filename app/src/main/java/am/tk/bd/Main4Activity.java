package am.tk.bd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    public static final String TAG = "Main4";
    RecyclerView rv_main;
    ArrayList<Tab> tabs;
    TabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        rv_main = findViewById(R.id.rv_main);
        tabs = new ArrayList<>();
        tabAdapter = new TabAdapter(tabs);
        tabGenerator(5);
        Log.d(TAG, "onCreate: ");

        rv_main.setLayoutManager(new GridLayoutManager(
                this,
                1,
                LinearLayoutManager.VERTICAL,
                false
        ));
        rv_main.setAdapter(tabAdapter);

    }
    public void tabGenerator(int n){
        for(int i = 0 ; i < n ; i++){
            Tab tab1 = new Tab("Inventory", R.drawable.inventory_icon);
            tabs.add(tab1);
            tabAdapter.notifyDataSetChanged();
        }
    }
}
