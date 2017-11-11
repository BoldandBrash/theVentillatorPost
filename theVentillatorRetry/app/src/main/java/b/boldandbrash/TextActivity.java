package b.boldandbrash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TextActivity extends AppCompatActivity {
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        submit = (Button) findViewById(R.id.textSubmit);
        submit.setOnClickListener(new SubmitListener());
    }

    private class SubmitListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //初始化Intent物件
            Intent intent = new Intent();
            //從MainActivity 到Main2Activity
            intent.setClass(TextActivity.this , QuestionsActivity.class); // new activity to start
            //開啟Activity
            startActivity(intent);
        }
    }
}
