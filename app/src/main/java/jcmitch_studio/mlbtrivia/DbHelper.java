package jcmitch_studio.mlbtrivia;

/**
 * Created by jerem_000 on 3/28/2015.
 */
  import java.util.ArrayList;
  import java.util.List;
  import android.content.ContentValues;
  import android.content.Context;
  import android.database.Cursor;
  import android.database.sqlite.SQLiteDatabase;
  import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name
    private static final String TABLE_WINNERS = "winners";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_YEAR = "year";
    private static final String KEY_WINNER = "winner"; //correct option
    private static final String KEY_LOSER= "loser"; //option a
    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_WINNERS + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_YEAR
                + " TEXT, " + KEY_WINNER+ " TEXT, "+KEY_LOSER +" TEXT)";
        db.execSQL(sql);
        //addQuestions();
        addWinners();
        //db.close();
    }
    private void addWinners() {
        String[ ][ ] arySeries = new String[45][2];
        arySeries[0][0] = "Giants";//2014
        arySeries[0][1] = "Royals";
        arySeries[1][0] = "Red Sox";//2013
        arySeries[1][1] = "Cardinals";
        arySeries[2][0] = "Giants";//2012
        arySeries[2][1] = "Tigers";
        arySeries[3][0] = "Cardinals";//2011
        arySeries[3][1] = "Rangers";
        arySeries[4][0] = "Giants";//2010
        arySeries[4][1] = "Rangers";
        arySeries[5][0] = "Yankees";//2009
        arySeries[5][1] = "Phillies";
        arySeries[6][0] = "Phillies";//2008
        arySeries[6][1] = "Rays";
        arySeries[7][0] = "Red Sox";//2007
        arySeries[7][1] = "Rockies";
        arySeries[8][0] = "Cardinals";//2006
        arySeries[8][1] = "Tigers";
        arySeries[9][0] = "White Sox";//2005
        arySeries[9][1] = "Astros";
        arySeries[10][0] = "Red Sox";//2004
        arySeries[10][1] = "Cardinals";
        arySeries[11][0] = "Marlins";//2003
        arySeries[11][1] = "Yankees";
        arySeries[12][0] = "Angels";//2002
        arySeries[12][1] = "Giants";
        arySeries[13][0] = "Diamondbacks";//2001
        arySeries[13][1] = "Yankees";
        arySeries[14][0] = "Yankees";//2000
        arySeries[14][1] = "Mets";
        arySeries[15][0] = "Yankees";//1999
        arySeries[15][1] = "Braves";
        arySeries[16][0] = "Yankees";//1998
        arySeries[16][1] = "Padres";
        arySeries[17][0] = "Marlins";//1997
        arySeries[17][1] = "Indians";
        arySeries[18][0] = "Yankees";//1996
        arySeries[18][1] = "Braves";
        arySeries[19][0] = "Braves";//1995
        arySeries[19][1] = "Indians";
        arySeries[20][0] = "No Team";//1994
        arySeries[20][1] = "Yankees";
        arySeries[21][0] = "Blue Jays";//1993
        arySeries[21][1] = "Phillies";
        arySeries[22][0] = "Blue Jays";//1992
        arySeries[22][1] = "Braves";
        arySeries[23][0] = "Twins";//1991
        arySeries[23][1] = "Braves";
        arySeries[24][0] = "Reds";//1990
        arySeries[24][1] = "Athletics";
        arySeries[25][0] = "Athletics";//1989
        arySeries[25][1] = "Giants";
        arySeries[26][0] = "Dodgers";//1988
        arySeries[26][1] = "Athletics";
        arySeries[27][0] = "Twins";//1987
        arySeries[27][1] = "Cardinals";
        arySeries[28][0] = "Mets";//1986
        arySeries[28][1] = "Red Sox";
        arySeries[29][0] = "Royals";//1985
        arySeries[29][1] = "Cardinals";
        arySeries[30][0] = "Tigers";//1984
        arySeries[30][1] = "Padres";
        arySeries[31][0] = "Orioles";//1983
        arySeries[31][1] = "Phillies";
        arySeries[32][0] = "Cardinals";//1982
        arySeries[32][1] = "Brewers";
        arySeries[33][0] = "Dodgers";//1981
        arySeries[33][1] = "Yankees";
        arySeries[34][0] = "Phillies";//1980
        arySeries[34][1] = "Royals";
        arySeries[35][0] = "Pirates";//1979
        arySeries[35][1] = "Orioles";
        arySeries[36][0] = "Yankees";//1978
        arySeries[36][1] = "Dodgers";
        arySeries[37][0] = "Yankees";//1977
        arySeries[37][1] = "Dodgers";
        arySeries[38][0] = "Reds";//1976
        arySeries[38][1] = "Yankees";
        arySeries[39][0] = "Reds";//1975
        arySeries[39][1] = "Red Sox";
        arySeries[40][0] = "Athletics";//1974
        arySeries[40][1] = "Dodgers";
        arySeries[41][0] = "Athletics";//1973
        arySeries[41][1] = "Mets";
        arySeries[42][0] = "Athletics";//1972
        arySeries[42][1] = "Reds";
        arySeries[43][0] = "Pirates";//1971
        arySeries[43][1] = "Orioles";
        arySeries[44][0] = "Orioles";//1970
        arySeries[44][1] = "Reds";

        int i = 0;
        for (i=0; i < 45; i++) {
            addSeries((2014-i), arySeries[i][0], arySeries[i][1]);
        }
    }
    private void addSeries(int year, String winner, String loser) {
        ContentValues values = new ContentValues();
        values.put(KEY_YEAR, Integer.toString(year));
        values.put(KEY_WINNER, winner);
        values.put(KEY_LOSER, loser);
        // Inserting Row
        dbase.insert(TABLE_WINNERS, null, values);
    }
    private void addTeams() {
        String[ ] aryTeams = new String[30];
        aryTeams[0] = "Orioles";
        aryTeams[1] = "Red Sox";
        aryTeams[2] = "White Sox";
        aryTeams[3] = "Indians";
        aryTeams[4] = "Tigers";
        aryTeams[5] = "Astros";
        aryTeams[6] = "Royals";
        aryTeams[7] = "Angels";
        aryTeams[8] = "Twins";
        aryTeams[9] = "Yankees";
        aryTeams[10] = "Athletics";
        aryTeams[11] = "Mariners";
        aryTeams[12] = "Rays";
        aryTeams[13] = "Rangers";
        aryTeams[14] = "Blue Jays";
        aryTeams[15] = "Diamondbacks";
        aryTeams[16] = "Braves";
        aryTeams[17] = "Cubs";
        aryTeams[18] = "Reds";
        aryTeams[19] = "Rockies";
        aryTeams[20] = "Dodgers";
        aryTeams[21] = "Marlins";
        aryTeams[22] = "Brewers";
        aryTeams[23] = "Mets";
        aryTeams[24] = "Phillies";
        aryTeams[25] = "Pirates";
        aryTeams[26] = "Padres";
        aryTeams[27] = "Giants";
        aryTeams[28] = "Cardinals";
        aryTeams[29] = "Nationals";
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WINNERS);
        // Create tables again
        onCreate(db);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_WINNERS;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION("Who won the World Series in "+cursor.getString(1)+"?");
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(2));
                quest.setOPTB(cursor.getString(3));
                quest.setOPTC("foo");
                quest.setOPTD("Bar");
                quest.setOPTE("Blah");
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
}
