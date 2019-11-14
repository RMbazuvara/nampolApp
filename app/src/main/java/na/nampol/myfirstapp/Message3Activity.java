package na.nampol.myfirstapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Message3Activity extends AppCompatActivity {

    Button btnSearch, btnBarcode;
    EditText idNumber;
    TextView sex, fullname,age;
    ImageView img;
    final Activity activity=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message3);

        btnSearch = findViewById(R.id.button5);
        btnBarcode = findViewById(R.id.button3);
        idNumber = findViewById(R.id.user_message2);
        sex = findViewById(R.id.sex);
        fullname = findViewById(R.id.fullname);
        age = findViewById(R.id.age);
        img = findViewById(R.id.picture);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!idNumber.getText().toString().equals("") && (idNumber.getText().toString().equals("87101600115") || idNumber.getText().toString().equals("87101600115U"))){
                    sex.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                    fullname.setVisibility(View.VISIBLE);
                    age.setVisibility(View.VISIBLE);
                    btnBarcode.setVisibility(View.GONE);
                    idNumber.setVisibility(View.GONE);
                    btnSearch.setVisibility(View.GONE);
                }else{
                    fullname.setText("Person not found");
                    fullname.setVisibility(View.VISIBLE);
                }
            }
        });

        btnBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator in = new IntentIntegrator(activity);
                in.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                in.setPrompt("Please focus the camera on the barcode that need to be scanned");
                in.setCameraId(0);
                in.setBeepEnabled(true);
                in.initiateScan();
            }
        });

    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result !=null){
            if(result.getContents()==null){
                Log.d("ScanID","Cancelled scan");
                Toast.makeText(this,"Cancelled",Toast.LENGTH_LONG).show();

            }else{
                Log.d("ScanID","Scanned");
                idNumber.setText(result.getContents());
            }
        }
    }


}
