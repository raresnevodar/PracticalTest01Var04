package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ro.pub.cs.systems.eim.practicaltest01var04.ui.main.MainFragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ro.pub.cs.systems.eim.practicaltest01var04.R;
//import ro.pub.cs.systems.eim.practicaltest01var04.general.Constants;
//import ro.pub.cs.systems.eim.practicaltest01var04.service.PracticalTest01Service;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    private EditText topEditText, bottomEditText;
    private Button topButton, displayButton;
    private CheckBox topCheckBox, bottomCheckBox;
    private TextView infoTextView;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String nameString = topEditText.getText().toString();
            String groupString = bottomEditText.getText().toString();
            boolean topCheckBoxChecked = topCheckBox.isChecked();
            boolean bottomCheckBoxChecked = bottomCheckBox.isChecked();

            String infoText = "";
            if (topCheckBoxChecked)
                infoText = infoText + nameString + " ";
            if (bottomCheckBoxChecked)
                infoText = infoText + groupString;

            switch(view.getId()) {
                case R.id.display_info_button:
                    infoTextView.setText(String.valueOf(infoText));
                    break;
                case R.id.navigate_to_secondary_activity_button:
                    //nothing yet
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        topEditText = (EditText)findViewById(R.id.top_edit_text);
        topCheckBox = (CheckBox)findViewById(R.id.top_check_box);

        bottomEditText = (EditText)findViewById(R.id.bottom_edit_text);
        bottomCheckBox = (CheckBox)findViewById(R.id.bottom_check_box);

        topButton = (Button)findViewById(R.id.navigate_to_secondary_activity_button);
        displayButton = (Button)findViewById(R.id.display_info_button);

        infoTextView = (TextView) findViewById(R.id.display_info_text);

        topEditText.setText(String.valueOf(" "));
        bottomEditText.setText(String.valueOf(" "));
        infoTextView.setText(String.valueOf("something"));

        displayButton.setOnClickListener(buttonClickListener);
        topButton.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("topString",  topEditText.getText().toString());
        savedInstanceState.putString("botomString",  bottomEditText.getText().toString());
        savedInstanceState.putBoolean("topCheckBox",  topCheckBox.isChecked());
        savedInstanceState.putBoolean("bottomCheckBox",  bottomCheckBox.isChecked());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("topString"))
            topEditText.setText(savedInstanceState.getString("topString"));
        if (savedInstanceState.containsKey("botomString"))
            bottomEditText.setText(savedInstanceState.getString("botomString"));
        if (savedInstanceState.containsKey("topCheckBox"))
            topCheckBox.setChecked(savedInstanceState.getBoolean("topCheckBox"));
        if (savedInstanceState.containsKey("bottomCheckBox"))
            bottomCheckBox.setChecked(savedInstanceState.getBoolean("bottomCheckBox"));
        Log.d("<<RN>>: ", "succesfuly restored");
    }
}