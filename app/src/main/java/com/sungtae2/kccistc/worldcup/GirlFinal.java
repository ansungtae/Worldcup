package com.sungtae2.kccistc.worldcup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class GirlFinal extends AppCompatActivity {



    Intent intent;
    ArrayList<Integer> finale2;

       ImageButton finale_ImageButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl_final);

        finale_ImageButton = findViewById(R.id.finale_Image);

        intent = getIntent();
        finale2 = intent.getIntegerArrayListExtra("hhhh");
        if(finale2 == null) Log.e("gdgd","MULLLLLLLL");
        finale_ImageButton.setImageResource(finale2.get(0));
        finale_ImageButton.setOnClickListener(new View.OnClickListener() {       //버튼을 실행할때 사용되는 메소드들과 값들의 움직임들을 넣어놓는곳 앞
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GirlFinal.this, MainActivity.class);
                intent.putExtra("hhhh",finale2);
                startActivity(intent); //인텐트  엑티비티를 실행
                //setResult(RESULT_OK,new Intent());
            }
        });
    }
}