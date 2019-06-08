package com.example.sasha.smarthcs.InfoS;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sasha.smarthcs.Daily_INFo.Daily_water_activity;
import com.example.sasha.smarthcs.Main_1.MainActivity;
import com.example.sasha.smarthcs.R;
import com.example.sasha.smarthcs.Recycler_Adapters.RecyclerViewAdapter_Gas;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class WaterInfo extends AppCompatActivity {

    private SlidrInterface slidr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_info);
        slidr = Slidr.attach(this);
        int j = MainActivity.index;
        ImageButton btn=findViewById(R.id.water);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(WaterInfo.this, Daily_water_activity.class);
        startActivity(intent);
    }
});
        TextView resource = findViewById(R.id.resource_w);
        resource.setTextSize(27);
        resource.setText("Израсходовано"+":"+" "+(String.valueOf((int)((Integer.valueOf(MainActivity.GSV.get(2))/MainActivity.water_ideal))) +" " +"м³"));
        TextView sum = findViewById(R.id.sum_w);
        sum.setTextSize(27);
        sum.setText(MainActivity.GSV.get(2)+" "+"Рублей");
        RecyclerView bill_list = findViewById(R.id.bill_list);
        bill_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        RecyclerViewAdapter_Gas adapter = new RecyclerViewAdapter_Gas(getResources());
        bill_list.setAdapter(adapter);
    }
}
