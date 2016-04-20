package cs.aiub.khurshedul.jnina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText e1,e2;
    MainActivity thisActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.log);
        e1=(EditText)findViewById(R.id.user);
        e2=(EditText)findViewById(R.id.pass);
        thisActivity = this;

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().equals("sayem")&&e2.getText().toString().equals("1234")){
                    Intent i=new Intent(MainActivity.this,MapsActivity.class);
                    startActivity(i);
                }
                /*LoginServerConnection loginServerConnection = new LoginServerConnection(e1.getText().toString(), e2.getText().toString(), thisActivity);
                loginServerConnection.start();*/
            }
        });
    }

    /*void gotoMap() {
        Intent i=new Intent(MainActivity.this,MapsActivity.class);
        startActivity(i);
    }*/

}
