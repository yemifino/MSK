package com.example.sasha.smarthcs.InfoS;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.sasha.smarthcs.Main_1.MainActivity;
import com.example.sasha.smarthcs.R;
import com.example.sasha.smarthcs.Recycler_Adapters.RecyclerViewAdapter_Total;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class TotalInfo extends AppCompatActivity {

    private SlidrInterface slidr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_info);
        slidr = Slidr.attach(this);

        TextView resource = findViewById(R.id.resource_t);
        resource.setTextSize(27);
        resource.setText("К оплате:");
        TextView sum = findViewById(R.id.sum_t);
        sum.setTextSize(27);
        sum.setText(String.valueOf(Integer.valueOf(MainActivity.GSV.get(0))+
                Integer.valueOf(MainActivity.GSV.get(1))+
                Integer.valueOf(MainActivity.GSV.get(2))));
        RecyclerView bill_list = findViewById(R.id.bill_list);
        bill_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,false));
        RecyclerViewAdapter_Total adapter = new RecyclerViewAdapter_Total(getResources());
        bill_list.setAdapter(adapter);
    }
}
