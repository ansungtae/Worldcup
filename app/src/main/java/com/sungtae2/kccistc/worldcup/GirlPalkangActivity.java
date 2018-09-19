package com.sungtae2.kccistc.worldcup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Random;

public class GirlPalkangActivity extends AppCompatActivity {
    ArrayList<Integer> list = new ArrayList<>();        // 리스트를 선언해준다       리스트들을 넣어놓는곳
    ArrayList<Integer> list2 = new ArrayList<>();// 리스트를 선언해준다      중복을 방지하기 위해서 선언한 리스트(리스트에서 랜덤으로 나와진 값들이 저장되는곳
    ArrayList<Integer> selectlist = new ArrayList<>();// 리스트를 선언해준다     8강 이미지뷰에서 선택된 인탠트 값들을 저장해놓는 리스트

    ImageButton leftButton;         //버튼을 선언해준다
    int leftImage;                  //인트(정수) 타입의 이미지들을 선언
    ImageButton rightButton;          //이미지 버튼 오른쪽 클릭을 선언해준다.
    int rightImage;         //인트 이미지마다 가지고 있는 배열 번호가 있는데 그 번호들을 구별하기 위해 선언

    Random random = new Random();       //랜덤메소드를 사용하기 위해 선언해준 메소드 전역변수로 설정해서 받도록 해준다

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl_palkang);



        list.add(R.drawable.sulhyun);             //     리스트 에 들어갈 값들을 넣어준다.
        list.add(R.drawable.son);
        list.add(R.drawable.kangmin);
        list.add(R.drawable.joou);
        list.add(R.drawable.irinn);
        list.add(R.drawable.chunghaz);
        list.add(R.drawable.boboyou);
        list.add(R.drawable.momozzamg);

        leftButton = findViewById(R.id.palkang_left_button);    // 버튼을 찾아주는 메소드
        rightButton = findViewById(R.id.palkang_right_button);      //버튼을 찾아주는 메소드

        int randomNumber = random.nextInt(list.size());     // 안쪽부터 설명 :  리스트 사이즈 만큼의 렌덤으로 돌려진 숫자 1개를 랜덤넘버로 값을 준다.
        leftButton.setImageResource(list.get(randomNumber));//      랜덤으로 얻어진 번호를 리스트에 배열번호와 그 값이정해지고  그값의 이미지 리소스를 왼쪽 버튼에 준다.
        leftImage = list.get(randomNumber);//왼쪽이미지를 레프트 이미지가 받는다;
        list2.add(list.get(randomNumber));//중복방지를 위해서 리스트2를 만들어주고  처음 리스트에서 정해진 렌덤값을 리스트 2로 넣어준다.
        list.remove(randomNumber);// 그리고 그정해진 것을 지운다. 리스트에서


        randomNumber = random.nextInt(list.size());     //마찬가지로 지워진 8개에서 7개로 줄어든 리스트에서 랜덤으로 정해 랜덤넘버로 보내주고
        rightButton.setImageResource(list.get(randomNumber)); // 그정해진 번호로 리스트에서 겟 그다음 이미지 리소스를 정해줌과 동시에 오른쪽 버튼에 넣어준다
        rightImage = list.get(randomNumber);// 오른쪽 버튼에 이미지 값을 넣어준다.
        list2.add(list.get(randomNumber));// 랜덤으로 또다시 선택된 그 값을 리스트 2에 넣어준다..
        list.remove(randomNumber);//그 정해진 값을 지워주고 리스트에는 최종적으로 6개의 리소스가 남도록 해준다

        leftButton.setOnClickListener(new View.OnClickListener() {       //버튼을 실행할때 사용되는 메소드들과 값들의 움직임들을 넣어놓는곳 앞
            @Override
            public void onClick(View view) {                                           //자동으로 생성되는 곳  위에 new V 에서 엔터
                Intent intent = new Intent(GirlPalkangActivity.this,GirlSaKangActivity.class);      //현재 엑티비티에서 다음엑티비티로 넘어간다를 정의해놈
                intent.putExtra("aaaa", list);     // 네임 키 를 정해놓고 또 알0아야 다음 엑티비티에서도 사용할때 사용할수있다. 이 리스트가 다음 엑티비티로 넘어간다
                selectlist.add(leftImage);                   //왼쪽버튼을 선택한 값들이 셀렉트 리스트에 저장된다.
                intent.putExtra("bbbb",selectlist); //바로위에 정의되어있는 선택된 데이터들이 저장되어있는 셀렉트 리스트를 다음 엑티비티에 가지고 가는 것.
                startActivityForResult(intent,RESULT_OK); //인텐트  엑티비티를 실행
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {   //오른쪽 버튼이미지 클릭시에 실행되는 메소드 시작
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GirlPalkangActivity.this,GirlSaKangActivity.class);  //다음 엑티비티 넘어간다.
                intent.putExtra("aaaa", list);//리스트를 다음 엑테비티에 가져간다,.
                selectlist.add(rightImage);//선택되는 오른쪽이미지들을 셀렉트리스트에 넣어준다.
                intent.putExtra("bbbb",selectlist);     //셀렉트 리스트 를 다음 엑티비티에 가저갈때 쓰는 메소드
                startActivityForResult(intent,RESULT_OK);      //인텐트 and 시작 엑티비티1!!!!
            }
        });



                      // 다음에 해야할일
        //다음 엑티비를 정하고 xml을 구상..... 그리고 위에 셀렉트 인텐트를 가져가는걸 해주었으니 4강끝날때까지는 가져가 준다.
            // 2.번째 리스트 를 가져가게되는데 리스트에는 현재 6개가 들어있다 그중에 2개를 또 랜덤으로 뽑도록 해주고 뽑힌것들을 또 리스트 2에 넣어주고 리스트에서는 나온것들을 지워준다. 동시에 선택된
        //셀렉트 리스트를 또 만들어주고 거기에 저장 시킨다. 첫번쨰 셀렉트리스트에 저장시킨게 총 4개가 되는순간 준 결승전(4강)으로 넘어가고 또 거기서 반복 해서 결승정 (2강) 거기서 최종 선택된 것만 남게 하는데
        // 중요한건 셀렉트 리스트가 8강 내에서만 존재하고 만약 4강으로 넘어갈땐 또 그거와 같은 개념의 두번째셀렉트리스트를 만들어서 운영해 주어야 한다는것.

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
