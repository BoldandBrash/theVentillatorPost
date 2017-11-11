package b.boldandbrash;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Questions extends AppCompatActivity {

    int i;
    private TextView question_box = (TextView)findViewById(R.id.coping_question);
    private EditText answer_box = (EditText)findViewById(R.id.coping_response);
    private Resources res = getResources();
    private String[] coping_questions = res.getStringArray(R.array.coping_questions);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        i = 0;
        question_box.setText(coping_questions[i++]);
    }

    public void submitResponse(View v)
    {
        //changes question display and clears the EditText
        question_box.setText(coping_questions[i++]);
        answer_box.setText("");

        //!!!add code to save responses to a file

        if(i <= 6)
        {
            Intent intent = new Intent();

            //!!!add more code to transfer to whichever activity comes next
        }
    }
}
