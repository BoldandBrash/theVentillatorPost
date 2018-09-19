package b.boldandbrash;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RateActivity extends AppCompatActivity {
    Button submit;
    EditText numInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        submit = (Button) findViewById(R.id.rateSubmit);
        submit.setOnClickListener(new SubmitListener());
        numInput = (EditText) findViewById(R.id.rateNum);
    }

    private void alertAndGoHome(String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(RateActivity.this).create();
        alertDialog.setTitle("The Ventillator");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //初始化Intent物件
                        Intent intent = new Intent();
                        //從MainActivity 到Main2Activity
                        intent.setClass(RateActivity.this , HomeScreen.class); // new activity to start
                        //開啟Activity
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void alert(String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(RateActivity.this).create();
        alertDialog.setTitle("The Ventillator");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }


    private class SubmitListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (numInput.getText().toString().equals("")) {
                alert("Please at least give a rating!\nWe would appreciate it!");
                return;
            }

            //初始化Intent物件
            Intent intent = new Intent();
            //從MainActivity 到Main2Activity
            intent.setClass(RateActivity.this , HomeScreen.class); // new activity to start
            //開啟Activity
            startActivity(intent);
        }
    }

}
