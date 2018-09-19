package b.boldandbrash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    private Button rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        rate = (Button) findViewById(R.id.homeRate);
        rate.setOnClickListener(new SubmitListener());
    }
    public void toTabActivity(View v){
        //初始化Intent物件
        Intent intent = new Intent();
        //從MainActivity 到Main2Activity
        intent.setClass(HomeScreen.this , MainActivity.class);
        //開啟Activity
        startActivity(intent);
    }

    private class SubmitListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            //初始化Intent物件
            Intent intent = new Intent();
            //從MainActivity 到Main2Activity
            intent.setClass(HomeScreen.this , RateActivity.class); // new activity to start
            //開啟Activity
            startActivity(intent);
        }
    }
}
