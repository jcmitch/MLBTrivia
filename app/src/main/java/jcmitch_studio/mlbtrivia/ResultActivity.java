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
        TextView t=(TextView)findViewById(R.id.textResult);
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        if (score < 15) {
            t.setText("Wow, kinda dumb aren't ya?");
        } else if (score < 25) {
            t.setText("Meh... not that great.");
        } else if (score < 40) {
            t.setText("Getting close to a respectable score.");
        } else if (score < 45) {
            t.setText("Alright, pretty good!");
        } else {
            t.setText("PERFECT!!!");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }
}