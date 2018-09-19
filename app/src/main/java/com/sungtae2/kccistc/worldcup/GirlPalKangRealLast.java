package com.sungtae2.kccistc.worldcup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Random;

public class GirlPalKangRealLast extends AppCompatActivity {

    Random random = new Random();

    Intent intent;
    ArrayList<Integer> list;
    ArrayList<Integer> selectlist;


    ImageButton rightButton;
    ImageButton leftButton;
    int rightImage;
    int leftImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl_pal_kang_real_last);

        rightButton = findViewById(R.id.palkang_right_button);
        leftButton = findViewById(R.id.palkang_left_button);

        intent = getIntent();
        list = intent.getIntegerArrayListExtra("aaaa");
        selectlist =intent.getIntegerArrayListExtra("bbbb");

        int randomNumber = random.nextInt(list.size());
        leftButton.setImageResource(list.get(randomNumber));
        leftImage = list.get(randomNumber);//왼쪽이미지를 레프트 이미지가 받는다;
        list.remove(randomNumber);//

        randomNumber = random.nextInt(list.size());
        rightButton.setImageResource(list.get(randomNumber));
        rightImage = list.get(randomNumber);// 오른쪽 버튼에 이미지 값을 넣어준다.
        list.remove(randomNumber);


        leftButton.setOnClickListener(new View.OnClickListener() {       //버튼을 실행할때 사용되는 메소드들과 값들의 움직임들을 넣어놓는곳 앞
            @Override
            public void onClick(View view) {                                           //자동으로 생성되는 곳  위에 new V 에서 엔터
                Intent intent = new Intent(GirlPalKangRealLast.this, GirlRealSaKangFirst.class);      //현재 엑티비티에서 다음엑티비티로 넘어간다를 정의해놈
                selectlist.add(leftImage);                   //왼쪽버튼을 선택한 값들이 셀렉트 리스트에 저장된다.
                intent.putExtra("bbbb", selectlist);
                startActivityForResult(intent,RESULT_OK); //인텐트  엑티비티를 실행
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {   //오른쪽 버튼이미지 클릭시에 실행되는 메소드 시작
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GirlPalKangRealLast.this,GirlRealSaKangFirst.class);  //다음 엑티비티 넘어간다.
                selectlist.add(rightImage);
                intent.putExtra("bbbb",selectlist);     //셀렉트 리스트 를 다음 엑티비티에 가저갈때 쓰는 메소드
;                startActivityForResult(intent,RESULT_OK);      //인텐트 and 시작 엑티비티1!!!!
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            setResult(RESULT_OK,new Intent());
            finish();
        }
    }
}