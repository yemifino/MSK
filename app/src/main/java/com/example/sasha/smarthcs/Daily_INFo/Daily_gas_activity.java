package com.example.sasha.smarthcs.Daily_INFo;

import android.annotation.SuppressLint;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sasha.smarthcs.Main_1.MainActivity;
import com.example.sasha.smarthcs.ProfileActivity;
import com.example.sasha.smarthcs.R;
import com.example.sasha.smarthcs.Retrofit.API;
import com.example.sasha.smarthcs.Retrofit.POST_GSV;
import com.example.sasha.smarthcs.Retrofit.has_total;
import com.example.sasha.smarthcs.Retrofit.today_cals.today_gas;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Daily_gas_activity extends AppCompatActivity {
    private SlidrInterface slidr;

    Calendar calendar=Calendar.getInstance();
    int date=calendar.get(Calendar.DATE)-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_daily_gas);
        slidr = Slidr.attach(this);
        onDays();


    }
    void onDays(){
        Retrofit retrofit = new Retrofit.Builder() .baseUrl(MainActivity.LOCAL) .addConverterFactory(GsonConverterFactory.create()) .build();
        final API api = retrofit.create(API.class);
        //  Call<has_gas> call = api.getWater(new POST_GSV(MainActivity.LOGIN));
        Call<today_gas> call=api.getToday_gas(new POST_GSV(MainActivity.LOGIN));
        call.enqueue(new Callback<today_gas>() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onResponse(Call<today_gas> call, Response<today_gas> response) {
                    List<String> arrayLis=response.body().getDay();
                    String parsWorld;
                    String formattedDouble;
                double midNumb = 0;
                TextView text=findViewById(R.id.text_day_gas);
                TextView text_advise=findViewById(R.id.gas_advice);
                List<String> parsList = new ArrayList<>();
                    for (int i=1;i<arrayLis.size();i++){
                        parsWorld=arrayLis.get(i);
                        parsWorld=ProfileActivity.removeChar(parsWorld,0);
                        parsWorld=ProfileActivity.removeChar(parsWorld,0);
                        parsWorld=ProfileActivity.removeChar(parsWorld,0);
                        parsWorld=ProfileActivity.removeChar(parsWorld,3);
                        parsWorld=ProfileActivity.removeChar(parsWorld,3);
                        parsWorld=ProfileActivity.removeChar(parsWorld,3);

                        assert parsList != null;
                        parsList.add(i-1,parsWorld);
                    }



                    for (int i =0;i<29;i++){
                        midNumb+=Double.valueOf(parsList.get(i));
                    }
                midNumb=midNumb/30;
                formattedDouble=String.format("%.2f", Double.valueOf(parsList.get(date-1)));
                text.setText((formattedDouble+" "+"м³"));
                if (midNumb > Double.valueOf(parsList.get(date))){
                    ImageView img=findViewById(R.id.Color_gas);

                    text_advise.setText("Уф,пожалуй стоит меньше тратиться");
                    img.setBackgroundColor(Color.parseColor("#ff5252"));

                }
                else {
                    ImageView img=findViewById(R.id.Color_gas);
                    text_advise.setText("Отлично,вы держитесь молодцом!");
                    img.setBackgroundColor(Color.parseColor("#00e676"));
                }

            }

            @Override
            public void onFailure(Call<today_gas> call, Throwable t) {

            }
        });
    }


}
