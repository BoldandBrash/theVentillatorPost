package b.boldandbrash;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuestionsActivity extends AppCompatActivity {
    private TextView question;
    private Button button;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Resources res = getResources();
        question = (TextView) findViewById(R.id.blueQuestion);
        button = (Button) findViewById(R.id.blueSubmit);
        input = (EditText) findViewById(R.id.blueAnswer);

        button.setOnClickListener(new SubmitListener());

        String[] qs = res.getStringArray(R.array.blueOption_coping_questions);
        if (QuestionsCounter.getCount() >= qs.length) {
            alertAndGoHome("Thank you for using the app!");
        } else {
            String q = qs[QuestionsCounter.getCount()];
            question.setText(q);
        }
    }

    private void alert(String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(QuestionsActivity.this).create();
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

    private void alertAndGoHome(String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(QuestionsActivity.this).create();
        alertDialog.setTitle("The Ventillator");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //初始化Intent物件
                        Intent intent = new Intent();
                        //從MainActivity 到Main2Activity
                        intent.setClass(QuestionsActivity.this , HomeScreen.class); // new activity to start
                        //開啟Activity
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private class SubmitListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (input.getText().toString().equals("")) {
                alert("Please enter an answer for the question!\nIt'll really help!");
                return;
            }

            QuestionsCounter.incrementCount();
            //初始化Intent物件
            Intent intent = new Intent();
            //從MainActivity 到Main2Activity
            intent.setClass(QuestionsActivity.this , QuestionsActivity.class); // new activity to start
            //開啟Activity
            startActivity(intent);
        }
    }
}
