package b.boldandbrash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
    private Button recordButton, textButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recordButton = (Button) findViewById(R.id.record);
        textButton = (Button) findViewById(R.id.text);

        recordButton.setOnClickListener(new RecordButtonListener());
        textButton.setOnClickListener(new TextButtonListener());
    }

    private class RecordButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //初始化Intent物件
            Intent intent = new Intent();
            //從MainActivity 到Main2Activity
            intent.setClass(MainActivity.this , MediaRecorderActivity.class); // new activity to start
            //開啟Activity
            startActivity(intent);
        }
    }

    private class TextButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //初始化Intent物件
            Intent intent = new Intent();
            //從MainActivity 到Main2Activity
            intent.setClass(MainActivity.this , TextActivity.class); // new activity to start
            //開啟Activity
            startActivity(intent);
        }
    }
}
