package com.example.sepri.hitung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    //R.1
    TextView input1, input2, operator, result, notif;
    Button btHitung, btJumlah;

    //V.1
    private int operation = 0;
    private double HasilAkhir = 0.0;
    private String Cek1 = "";
    private String Cek2 = "";

    //M.1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //R.2
        input1 = (TextView) findViewById(R.id.masukan1);
        input2 = (TextView) findViewById(R.id.masukan2);
        operator = (TextView) findViewById(R.id.operan);
        result = (TextView) findViewById(R.id.hasil);
        notif = (TextView) findViewById(R.id.notifikasi);

        //R.3
        btHitung = (Button) findViewById(R.id.hitung);
        btJumlah = (Button) findViewById(R.id.tambah);
    }

    //M.2
    public void klikTambah(View V){
        operation = 1;
        operator.setText("   +   ");
    }

    public void klikHasil(View V){

        Cek1 = input1.getText().toString();
        Cek2 = input1.getText().toString();

        if((Cek1.equalsIgnoreCase("")) || (Cek2.equalsIgnoreCase(""))){
            notif.setText("Kolom tidak boleh kosong");
        }
        else{
            double inputA = Double.parseDouble(input1.getText().toString());
            double inputB = Double.parseDouble(input2.getText().toString());

            switch(operation){
                case 1:
                    HasilAkhir = inputA + inputB;
                    break;

                case 0:
                    notif.setText("Harap pilih operan terlebih dahulu!");
                    break;

                default:
                    notif.setText("Terjadi Kesalahan");
                    break;
            }

            //D.2
            if(operation < 1){
                result.setText("0");
            }

            else{
                String hasilString = String.valueOf(HasilAkhir);
                result.setText(hasilString);
                notif.setText("Lumayan Vroh Bisa Bantu Ngitung");
            }
        }


    }

    public void clearInput1(View V){
        input1.setText("");
        notif.setText("Lumayan Vroh Bisa Bantu Ngitung");
        operation = 0;
    }

    public void clearInput2(View V){
        input2.setText("");
        notif.setText("Lumayan Vroh Bisa Bantu Ngitung");
        operation = 0;
    }


}
