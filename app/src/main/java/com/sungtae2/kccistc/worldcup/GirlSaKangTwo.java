package com.sungtae2.kccistc.worldcup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Random;

public class GirlSaKangTwo extends AppCompatActivity {

    Random random = new Random();
    ArrayList<Integer> finalelist = new ArrayList<>();
    ArrayList<Integer> finalelist2 = new ArrayList<>();
    Intent intent;
    ArrayList<Integer> selectlist;
    ArrayList<Integer> lastlist;
    ArrayList<Integer> lastlist2;
    ImageButton rightButton;
    ImageButton leftButton;
    int rightImage;
    int leftImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl_sa_kang_two);

        rightButton = findViewById(R.id.palkang_right_button);
        leftButton = findViewById(R.id.palkang_left_button);

        intent = getIntent();
        selectlist =intent.getIntegerArrayListExtra("bbbb");
        lastlist = intent.getIntegerArrayListExtra("cccc");
        lastlist2 = intent.getIntegerArrayListExtra("ffff");


        int randomNumber = random.nextInt(selectlist.size());
        leftButton.setImageResource(selectlist.get(randomNumber));
        leftImage = selectlist.get(randomNumber);//왼쪽이미지를 레프트 이미지가 받는다;
        finalelist.add(selectlist.get(randomNumber));//중복방지를 위해서 리스트2를 만들어주고  처음 리스트에서 정해진 렌덤값을 리스트 2로 넣어준다.
        selectlist.remove(randomNumber);//

        randomNumber = random.nextInt(selectlist.size());
        rightButton.setImageResource(selectlist.get(randomNumber));
        rightImage = selectlist.get(randomNumber);// 오른쪽 버튼에 이미지 값을 넣어준다.
        finalelist.add(selectlist.get(randomNumber));// 랜덤으로 또다시 선택된 그 값을 리스트 2에 넣어준다..
        selectlist.remove(randomNumber);


        leftButton.setOnClickListener(new View.OnClickListener() {       //버튼을 실행할때 사용되는 메소드들과 값들의 움직임들을 넣어놓는곳 앞
            @Override
            public void onClick(View view) {                                           //자동으로 생성되는 곳  위에 new V 에서 엔터
                Intent intent = new Intent(GirlSaKangTwo.this, GirlSaKangThree.class);      //현재 엑티비티에서 다음엑티비티로 넘어간다를 정의해놈
                intent.putExtra("cccc",lastlist);
                finalelist.add(leftImage);                   //왼쪽버튼을 선택한 값들이 셀렉트 리스트에 저장된다.
                finalelist2.add(leftImage);
                intent.putExtra("dddd",finalelist);
                intent.putExtra("ffff",lastlist2);
                intent.putExtra("gggg",finalelist2);
                startActivityForResult(intent,RESULT_OK); //인텐트  엑티비티를 실행
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {   //오른쪽 버튼이미지 클릭시에 실행되는 메소드 시작
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GirlSaKangTwo.this, GirlSaKangThree.class);  //다음 엑티비티 넘어간다.
                intent.putExtra("cccc",lastlist);
                finalelist.add(rightImage);//선택되는 오른쪽이미지들을 셀렉트리스트에 넣어준다.
                finalelist2.add(rightImage);
                intent.putExtra("dddd", finalelist);//리스트를 다음 엑테비티에 가져간다,.
                intent.putExtra("ffff",lastlist2);
                intent.putExtra("gggg",finalelist2);
                startActivityForResult(intent,RESULT_OK);      //인텐트 and 시작 엑티비티1!!!!
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