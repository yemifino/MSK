package com.example.sasha.smarthcs.InfoS;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sasha.smarthcs.Daily_INFo.Daily_gas_activity;
import com.example.sasha.smarthcs.Main_1.MainActivity;
import com.example.sasha.smarthcs.R;
import com.example.sasha.smarthcs.Recycler_Adapters.RecyclerViewAdapter_Water;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;


public class GazInfo extends AppCompatActivity {

    private SlidrInterface slidr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaz_info);

        slidr = Slidr.attach(this);
 ImageButton btn=findViewById(R.id.gaz);


        int j = MainActivity.index;

        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent intent =new Intent(GazInfo.this, Daily_gas_activity.class);
                                       startActivity(intent);
                                   }
                               });


        TextView resource = findViewById(R.id.resource_g);
        resource.setTextSize(27);
        resource.setText("Израсходовано"+":"+" "+(String.valueOf((int)((Integer.valueOf(MainActivity.GSV.get(0))/MainActivity.gas_ideal))) +" " +"м³"));
        TextView sum = findViewById(R.id.sum_g);
        sum.setTextSize(27);
        sum.setText(MainActivity.GSV.get(0)+" "+"Рублей");
        RecyclerView bill_list = findViewById(R.id.bill_list);
        bill_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        RecyclerViewAdapter_Water adapter = new RecyclerViewAdapter_Water(getResources());
        bill_list.setAdapter(adapter);
    }
}
