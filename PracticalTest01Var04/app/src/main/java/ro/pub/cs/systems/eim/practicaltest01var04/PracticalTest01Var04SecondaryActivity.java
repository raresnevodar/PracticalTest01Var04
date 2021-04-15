package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        Button topButton, bottomButton;
        TextView topText, bottomText;

        topButton = (Button)findViewById(R.id.button);
        bottomButton = (Button)findViewById(R.id.button2);

        topText = (TextView)findViewById(R.id.textView);
        bottomText = (TextView)findViewById(R.id.textView2);

        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(17, intent);
                finish();
            }
        });

        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(18, intent);
                finish();
            }
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            topText.setText(String.valueOf(bundle.getString("topText")));
            bottomText.setText(String.valueOf(bundle.getString("bottomText")));
        }
    }
}