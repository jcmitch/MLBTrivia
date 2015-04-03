package jcmitch_studio.mlbtrivia;

/**
 * Created by jerem_000 on 3/28/2015.
 */
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView message=(TextView)findViewById(R.id.textResult);
        TextView time=(TextView)findViewById(R.id.totalTime);
        Bundle b = getIntent().getExtras();
        int score=b.getInt("score");
        long totalTime=b.getLong("totalTime");
        if (score < 15) {
            message.setText("Wow, kinda dumb aren't ya?");
        } else if (score < 25) {
            message.setText("Meh... not that great.");
        } else if (score < 40) {
            message.setText("Getting close to a respectable score.");
        } else if (score < 45) {
            message.setText("Alright, pretty good!");
        } else {
            message.setText("PERFECT!!!");
        }
        int h   = (int)(totalTime /3600000);
        int m = (int)(totalTime - h*3600000)/60000;
        int s= (int)(totalTime - h*3600000- m*60000)/1000 ;
        String mm = m < 10 ? "0"+m: m+"";
        String ss = s < 10 ? "0"+s: s+"";
        String timeText = "";
        if (h > 0) {
            timeText = "You took too long";
        } else {
            timeText = mm+":"+ss;
        }
        time.setText("Total time: "+timeText);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }
}