package cs.aiub.khurshedul.jnina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class custom_sni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_sni);
        Button y=(Button)findViewById(R.id.yesbtn);
        Button n=(Button)findViewById(R.id.nobtn);
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(custom_sni.this, "yes clicked", Toast.LENGTH_SHORT).show();
            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(custom_sni.this, "no clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
