package com.example.capstoneapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.zip.Inflater;

public class PetInfoActivity extends AppCompatActivity {
    EditText pet_name,pet_breed,pet_age,pet_food,pet_idCard;
    RadioGroup radioGroupNeutering,radioGroupGender,radioGroupMedi,radioGroupInoculation;
    RadioButton petGender_woRbtn,petGender_meRbtn,petNeutering_ok_rbtn,
            petNeutering_no_rbtn,pet_mediOk_rbtn,pet_mediNo_rbtn,
            petinoculation_ok_rbtn,petinoculation_no_rbtn;
    ImageView petImage;
    Button okBtn;
    View Inoculation_Dlg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_info);
        //EditText
        pet_name = (EditText) findViewById(R.id.petnameEdit);
        pet_breed = (EditText) findViewById(R.id.petbreedEdit);
        pet_age = (EditText) findViewById(R.id.petageEdit);
        pet_food = (EditText) findViewById(R.id.petfoodEdit);
        pet_idCard = (EditText) findViewById(R.id.petidcardEdit);
        //RdioGroup
        radioGroupNeutering = (RadioGroup) findViewById(R.id.PetNeuteringGroup);
        radioGroupGender = (RadioGroup) findViewById(R.id.PetGenderGroup);
        radioGroupMedi = (RadioGroup) findViewById(R.id.PetMediGroup);
        radioGroupInoculation = (RadioGroup) findViewById(R.id.PetInoculationGroup);
        //Radiobutton
        petGender_woRbtn = (RadioButton) findViewById(R.id.pet_womenRbtn);
        petGender_meRbtn = (RadioButton) findViewById(R.id.pet_menRbtn);
        petNeutering_ok_rbtn = (RadioButton) findViewById(R.id.pet_neuteringOkRbtn);
        petNeutering_no_rbtn = (RadioButton) findViewById(R.id.pet_neuteringNoRbtn);
        pet_mediOk_rbtn = (RadioButton) findViewById(R.id.petmedi_ok_Rbtn);
        pet_mediNo_rbtn = (RadioButton) findViewById(R.id.petmedi_no_Rbtn);
        petinoculation_ok_rbtn = (RadioButton) findViewById(R.id.pet_inoculation_ok_Rbtn);
        petinoculation_no_rbtn = (RadioButton) findViewById(R.id.pet_inoculation_no_Rbtn);
        //imageview
        petImage = (ImageView) findViewById(R.id.pet_photoImage);
        //Button
        okBtn = (Button) findViewById(R.id.submitokBtn);

        //펫 성별 check
        petGender_woRbtn.setOnCheckedChangeListener(new MyCheckListener());
        petGender_meRbtn.setOnCheckedChangeListener(new MyCheckListener());
        //펫 중성화 check
        petNeutering_ok_rbtn.setOnCheckedChangeListener(new MyCheckListener());
        petNeutering_no_rbtn.setOnCheckedChangeListener(new MyCheckListener());
        //펫 약 check
        pet_mediOk_rbtn.setOnCheckedChangeListener(new MyCheckListener());
        pet_mediNo_rbtn.setOnCheckedChangeListener(new MyCheckListener());
        //펫 예방접종 check
        petinoculation_ok_rbtn.setOnCheckedChangeListener(new MyCheckListener());
        petinoculation_no_rbtn.setOnCheckedChangeListener(new MyCheckListener());
        //이미지 버튼
        petImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //확인 버튼
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
    class MyCheckListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if(petGender_woRbtn.isChecked() == true){
                Toast.makeText(getApplicationContext(),"암컷",Toast.LENGTH_LONG).show();
            }else if (petGender_meRbtn.isChecked() == true){
                Toast.makeText(getApplicationContext(),"수컷",Toast.LENGTH_LONG).show();
            }else if(petNeutering_ok_rbtn.isChecked() == true){
                Toast.makeText(getApplicationContext(),"했어요",Toast.LENGTH_LONG).show();
            }else if(petNeutering_no_rbtn.isChecked() == true){
                Toast.makeText(getApplicationContext(),"안했어요",Toast.LENGTH_LONG).show();
            }else if(petinoculation_ok_rbtn.isChecked() == true){
                Inoculation_Dlg = (View) View.inflate(PetInfoActivity.this, R.layout.dialog_inoculation, null);
                CheckBox petInoDog = (CheckBox) Inoculation_Dlg.findViewById(R.id.petInoDog);
                CheckBox petInoAll = (CheckBox) Inoculation_Dlg.findViewById(R.id.petInoAll);
                CheckBox petInoCovid = (CheckBox) Inoculation_Dlg.findViewById(R.id.petInoAll);
                CheckBox petInoKen = (CheckBox) Inoculation_Dlg.findViewById(R.id.petInoKen);
                AlertDialog.Builder dlg_Inoculation = new AlertDialog.Builder(PetInfoActivity.this);
                dlg_Inoculation.setView(Inoculation_Dlg);
                petInoAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if(isChecked){

                        }else{

                        }
                    }
                });
                petInoCovid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if(isChecked){

                        }else{

                        }
                    }
                });
                petInoKen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if(isChecked){

                        }else{

                        }
                    }
                });
                dlg_Inoculation.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                petInoDog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if(isChecked){

                        }else{

                        }
                    }
                });
                dlg_Inoculation.show();
            }

        }
    }

}