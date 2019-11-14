package na.nampol.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info, macAddress;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login  = (Button)findViewById(R.id.btnLogin);
        Name = (EditText) findViewById(R.id.user_login);
        Password = (EditText)findViewById(R.id.editTextPassword);
        Info  = (TextView)findViewById(R.id.noAttempts);
        macAddress = (TextView) findViewById(R.id.macAddress);
        macAddress.setText("C0:D3:C0:55:9C:63");
        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(Name.getText().toString().equals("ruhapo") && Password.getText().toString().equals("12345") && !macAddress.getText().toString().equals("")){
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    //intent.putExtra("fullname", "Ruhapo Mbazuvara");
                    startActivity(intent);
                }else{
                    Info.setText("Username and/or password and/or Mac address not recognonized");
                }
            }
        });
    }

}
