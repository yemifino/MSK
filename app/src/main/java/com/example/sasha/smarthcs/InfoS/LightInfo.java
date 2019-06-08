package com.example.sasha.smarthcs.InfoS;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sasha.smarthcs.Daily_INFo.Daily_light_activity;
import com.example.sasha.smarthcs.Main_1.MainActivity;
import com.example.sasha.smarthcs.R;
import com.example.sasha.smarthcs.Recycler_Adapters.RecyclerViewAdapter_Light;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class LightInfo extends AppCompatActivity {

    private SlidrInterface slidr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_info);
        ImageButton btn=findViewById(R.id.light);

        btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(LightInfo.this, Daily_light_activity.class);
                 startActivity(intent);
             }
         });
        slidr = Slidr.attach(this);

        TextView resource = findViewById(R.id.resource_l);
        resource.setTextSize(27);
        resource.setText("Израсходовано"+":"+"\n"+(String.valueOf((int)((Integer.valueOf(MainActivity.GSV.get(2))/MainActivity.light_ideal))) +" "+"Р/МВт/ч"));
        TextView sum = findViewById(R.id.sum_l);
        sum.setTextSize(27);
        sum.setText(MainActivity.GSV.get(2)+" "+"Рублей");
        RecyclerView bill_list = findViewById(R.id.bill_list);
        bill_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        RecyclerViewAdapter_Light adapter = new RecyclerViewAdapter_Light(getResources());
        bill_list.setAdapter(adapter);
    }
}
