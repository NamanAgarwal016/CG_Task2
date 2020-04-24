package com.example.cg_task2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autoimageslider.IndicatorAnimations;
import com.example.autoimageslider.SliderAnimations;
import com.example.autoimageslider.SliderView;
import com.example.cg_task2.Model.SliderItem;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {

    private String securityPasscode = "naman123";
    SliderView sliderView;
    private SliderAdapterExample adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        passcode();

        sliderView = findViewById(R.id.imageSlider);

        adapter = new SliderAdapterExample(this);
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.THIN_WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);

        List<SliderItem> sliderItemList = new ArrayList<>();
        SliderItem sliderItem1 = new SliderItem();
        sliderItem1.setDescription("");
        sliderItem1.setImageUrl("https://scontent.fudr1-1.fna.fbcdn.net/v/t1.0-9/47150953_530282957381757_5750737548922060800_n.jpg?_nc_cat=102&_nc_sid=85a577&_nc_ohc=8wqYk2iApIcAX_4WftU&_nc_ht=scontent.fudr1-1.fna&oh=7de83eec7e3c015e7541c23c9df2d717&oe=5EC2DAAA&dl=1");
        sliderItemList.add(sliderItem1);

        SliderItem sliderItem2 = new SliderItem();
        sliderItem2.setDescription("Slider Item");
        sliderItem2.setImageUrl("https://scontent.fudr1-1.fna.fbcdn.net/v/t1.0-9/p960x960/93853263_839273343149382_2109324079050784768_o.png?_nc_cat=109&_nc_sid=8024bb&_nc_ohc=IuXoeYZeS4IAX-GuTCv&_nc_ht=scontent.fudr1-1.fna&oh=18e08bdf0683fe69c0b5fbf0a8a5f93a&oe=5EC2D0FC");
        sliderItemList.add(sliderItem2);

        SliderItem sliderItem3 = new SliderItem();
        sliderItem3.setDescription("Slider Item");
        sliderItem3.setImageUrl("https://scontent.fudr1-1.fna.fbcdn.net/v/t1.0-9/p960x960/93547372_838595109883872_935223437872332800_o.png?_nc_cat=110&_nc_sid=8024bb&_nc_ohc=np02-gBNzD4AX9l5XQz&_nc_ht=scontent.fudr1-1.fna&oh=f6357d0249f3f3dec83f21d956617edd&oe=5EC26686");
        sliderItemList.add(sliderItem3);

        SliderItem sliderItem4 = new SliderItem();
        sliderItem4.setDescription("Slider Item");
        sliderItem4.setImageUrl("https://scontent.fudr1-1.fna.fbcdn.net/v/t1.0-9/p960x960/93914705_838584089884974_7631313559573495808_o.jpg?_nc_cat=105&_nc_sid=8024bb&_nc_ohc=7ka5406449QAX-63Uju&_nc_ht=scontent.fudr1-1.fna&_nc_tp=6&oh=33eb5ca587cb39dd55c90aa935ff21ff&oe=5EC3CBFB");
        sliderItemList.add(sliderItem4);

        SliderItem sliderItem5 = new SliderItem();
        sliderItem5.setDescription("Slider Item");
        sliderItem5.setImageUrl("https://scontent.fudr1-1.fna.fbcdn.net/v/t1.0-9/p960x960/92876221_834649976945052_2649809352059256832_o.jpg?_nc_cat=108&_nc_sid=8024bb&_nc_ohc=iIUthfybz2sAX-upyEs&_nc_ht=scontent.fudr1-1.fna&_nc_tp=6&oh=3ebae176c25e719bb4b1665217566425&oe=5EC4BFD9");
        sliderItemList.add(sliderItem5);

//        //dummy data
//        for (int i = 0; i < 5; i++) {
//            SliderItem sliderItem = new SliderItem();
//            sliderItem.setDescription("Slider Item " + i);
//            if (i % 2 == 0) {
//                sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
//            } else {
//                sliderItem.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
//            }
//            sliderItemList.add(sliderItem);
//        }
        adapter.renewItems(sliderItemList);


    }

    public void passcode(){

        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog, null);
        final EditText passcode = alertLayout.findViewById(R.id.passcode);
        final CheckBox cbToggle = alertLayout.findViewById(R.id.cb_show_pass);

        cbToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // to encode password in dots
                    passcode.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // to display the password in normal text
                    passcode.setTransformationMethod(null);
                }
            }
        });

        AlertDialog.Builder alert = new AlertDialog.Builder(AdminActivity.this);
        alert.setTitle("Counselling Gurus");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent i1 = new Intent(AdminActivity.this, LoginActivity.class);
                startActivity(i1);
                finish();
            }
        });
        alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // String user = etUsername.getText().toString();
                String pass = passcode.getText().toString();

                if (pass.equals(securityPasscode)){
                    Toast.makeText(AdminActivity.this, "You are an authorised member", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(AdminActivity.this,"Incorrect passcode", Toast.LENGTH_SHORT).show();
                    passcode();
                }
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }


    public void removeLastItem(View view) {
        if (adapter.getCount() - 1 >= 0)
            adapter.deleteItem(adapter.getCount() - 1);
    }

    public void addNewItem(View view) {
        SliderItem sliderItem = new SliderItem();
        sliderItem.setDescription("Slider Item Added Manually");
        sliderItem.setImageUrl("https://scontent.fudr1-1.fna.fbcdn.net/v/t1.0-9/26231090_364710003939054_6166190461631253862_n.jpg?_nc_cat=106&_nc_sid=7aed08&_nc_ohc=2rvyfz6aM8cAX9fpUcY&_nc_ht=scontent.fudr1-1.fna&oh=03860aa58463449088fbc7fde0696399&oe=5EC2A15C");
        adapter.addItem(sliderItem);
    }
}
