package jcmitch_studio.mlbtrivia;

/**
 * Created by jerem_000 on 3/28/2015.
 */
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Chronometer;
import android.os.SystemClock;

public class QuizActivity extends Activity {
    List<Question> quesList;
    int score=0;
    int totalQuestions = 0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion;
    TextView scoreText;
    Button butA, butB, butC, butD, butE;
    Chronometer gameTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        DbHelper db=new DbHelper(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        scoreText=(TextView)findViewById(R.id.score);
        butA=(Button)findViewById(R.id.button1);
        butB=(Button)findViewById(R.id.button2);
        butC=(Button)findViewById(R.id.button3);
        butD=(Button)findViewById(R.id.button4);
        butE=(Button)findViewById(R.id.button5);
        gameTimer = (Chronometer)findViewById(R.id.gameTimer);
        gameTimer.setBase(SystemClock.elapsedRealtime());
        gameTimer.start();
        setQuestionView();
    }
    public void onClick(View v) {
        Button answer = (Button)findViewById(v.getId());
        if(currentQ.getANSWER().equals(answer.getText())) {
            score++;
        }
        totalQuestions++;
        if(qid<45){
            scoreText.setText(String.valueOf(score) + " of " + String.valueOf(totalQuestions));
            currentQ=quesList.get(qid);
            setQuestionView();
        }else{
            gameTimer.stop();
            long elapsedMillis = SystemClock.elapsedRealtime() - gameTimer.getBase();
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            b.putInt("totalQuestions", totalQuestions);
            b.putLong("totalTime", elapsedMillis);
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            finish();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }
    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        butA.setText(currentQ.getOPTA());
        butB.setText(currentQ.getOPTB());
        butC.setText(currentQ.getOPTC());
        butD.setText(currentQ.getOPTD());
        butE.setText(currentQ.getOPTE());
        qid++;
    }
}