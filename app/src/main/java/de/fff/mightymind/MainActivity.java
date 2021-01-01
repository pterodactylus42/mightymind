package de.fff.mightymind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ColoredButton one, two, three, four = null;
    private Button submit = null;
    private Button[][] historyButtons;
    private int[][] historyColors;
    private int timesTried = 0;

    private int clickCount = 0;

    private ConstraintLayout.LayoutParams defaultLayoutParams;

    private static final int[] COLORS = {
            Color.YELLOW,
            Color.RED,
            Color.GREEN,
            Color.MAGENTA,
            Color.BLUE,
            Color.CYAN
    };

    private int[] secret = {
            0,
            1,
            2,
            3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (ColoredButton) findViewById(R.id.colorButton1);
        one.setOnClickListener(this);
        two = (ColoredButton) findViewById(R.id.colorButton2);
        two.setOnClickListener(this);
        three = (ColoredButton) findViewById(R.id.colorButton3);
        three.setOnClickListener(this);
        four = (ColoredButton) findViewById(R.id.colorButton4);
        four.setOnClickListener(this);
        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(this);
        submit.setVisibility(View.GONE);

        //Button Array [rows] [cols]
        historyButtons = new Button[7][4];
        initHistoryButtons();

        historyColors = new int[7][4];
        initHistoryColors();

        //todo: create secret combination
        generateSecret();

    }

    private void generateSecret() {
        Random r = new Random();
        int min = 0;
        int max = 6;
        for(int i = 0; i < secret.length; i++) {
            secret[i] = r.nextInt(max);
        }
    }

    private void initHistoryColors() {
        for(int i = 0; i < 7; i ++) {
            for(int j = 0; j < 4; j++) {
                historyColors[i][j] = 0;
            }
        }
    }

    private void initHistoryButtons() {
        //we start at the bottom, numerically
        //and graphically
        historyButtons[0][0] = findViewById(R.id.historyButton00);
        historyButtons[0][0].setVisibility(View.GONE);
        historyButtons[0][1] = findViewById(R.id.historyButton01);
        historyButtons[0][1].setVisibility(View.GONE);
        historyButtons[0][2] = findViewById(R.id.historyButton02);
        historyButtons[0][2].setVisibility(View.GONE);
        historyButtons[0][3] = findViewById(R.id.historyButton03);
        historyButtons[0][3].setVisibility(View.GONE);

        historyButtons[1][0] = findViewById(R.id.historyButton10);
        historyButtons[1][0].setVisibility(View.GONE);
        historyButtons[1][1] = findViewById(R.id.historyButton11);
        historyButtons[1][1].setVisibility(View.GONE);
        historyButtons[1][2] = findViewById(R.id.historyButton12);
        historyButtons[1][2].setVisibility(View.GONE);
        historyButtons[1][3] = findViewById(R.id.historyButton13);
        historyButtons[1][3].setVisibility(View.GONE);

        historyButtons[2][0] = findViewById(R.id.historyButton20);
        historyButtons[2][0].setVisibility(View.GONE);
        historyButtons[2][1] = findViewById(R.id.historyButton21);
        historyButtons[2][1].setVisibility(View.GONE);
        historyButtons[2][2] = findViewById(R.id.historyButton22);
        historyButtons[2][2].setVisibility(View.GONE);
        historyButtons[2][3] = findViewById(R.id.historyButton23);
        historyButtons[2][3].setVisibility(View.GONE);

        historyButtons[3][0] = findViewById(R.id.historyButton30);
        historyButtons[3][0].setVisibility(View.GONE);
        historyButtons[3][1] = findViewById(R.id.historyButton31);
        historyButtons[3][1].setVisibility(View.GONE);
        historyButtons[3][2] = findViewById(R.id.historyButton32);
        historyButtons[3][2].setVisibility(View.GONE);
        historyButtons[3][3] = findViewById(R.id.historyButton33);
        historyButtons[3][3].setVisibility(View.GONE);

        historyButtons[4][0] = findViewById(R.id.historyButton40);
        historyButtons[4][0].setVisibility(View.GONE);
        historyButtons[4][1] = findViewById(R.id.historyButton41);
        historyButtons[4][1].setVisibility(View.GONE);
        historyButtons[4][2] = findViewById(R.id.historyButton42);
        historyButtons[4][2].setVisibility(View.GONE);
        historyButtons[4][3] = findViewById(R.id.historyButton43);
        historyButtons[4][3].setVisibility(View.GONE);

        historyButtons[5][0] = findViewById(R.id.historyButton50);
        historyButtons[5][0].setVisibility(View.GONE);
        historyButtons[5][1] = findViewById(R.id.historyButton51);
        historyButtons[5][1].setVisibility(View.GONE);
        historyButtons[5][2] = findViewById(R.id.historyButton52);
        historyButtons[5][2].setVisibility(View.GONE);
        historyButtons[5][3] = findViewById(R.id.historyButton53);
        historyButtons[5][3].setVisibility(View.GONE);

        historyButtons[6][0] = findViewById(R.id.historyButton60);
        historyButtons[6][0].setVisibility(View.GONE);
        historyButtons[6][1] = findViewById(R.id.historyButton61);
        historyButtons[6][1].setVisibility(View.GONE);
        historyButtons[6][2] = findViewById(R.id.historyButton62);
        historyButtons[6][2].setVisibility(View.GONE);
        historyButtons[6][3] = findViewById(R.id.historyButton63);
        historyButtons[6][3].setVisibility(View.GONE);

        defaultLayoutParams = (ConstraintLayout.LayoutParams) historyButtons[6][3].getLayoutParams();
    }


    public void onClick(View v) {
        submit.setText("try");
        switch(v.getId()) {
            case R.id.colorButton1:
                one.setBackgroundColor(COLORS[clickCount%COLORS.length]);
                one.setMyColor(COLORS[clickCount%COLORS.length]);
                clickCount++;
                break;
            case R.id.colorButton2:
                two.setBackgroundColor(COLORS[clickCount%COLORS.length]);
                two.setMyColor(COLORS[clickCount%COLORS.length]);
                clickCount++;
                break;
            case R.id.colorButton3:
                three.setBackgroundColor(COLORS[clickCount%COLORS.length]);
                three.setMyColor(COLORS[clickCount%COLORS.length]);
                clickCount++;
                break;
            case R.id.colorButton4:
                four.setBackgroundColor(COLORS[clickCount%COLORS.length]);
                four.setMyColor(COLORS[clickCount%COLORS.length]);
                clickCount++;
                break;
            case R.id.submitButton:
                checkCombination();

        }

        if(allButtonsSet()) {
            submit.setVisibility(View.VISIBLE);
        } else {
            submit.setVisibility(View.GONE);
        }

        //Log.d("mainActivity", "onClick: "+ clickCount);

    }


    private boolean allButtonsSet() {

        if(     isColorSet(one.getMyColor())   &&
                isColorSet(two.getMyColor())   &&
                isColorSet(three.getMyColor()) &&
                isColorSet(four.getMyColor())    ) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isColorSet(int col) {
        boolean retVal = false;
        for(int i = 0; i < COLORS.length; i++) {
            if(col == COLORS[i]) retVal = true;
        }
        return retVal;
    }

    private int[] getCombination() {
        int[] combination = {
                0,
                0,
                0,
                0
        };

        for(int i = 0; i < COLORS.length; i++) {
            if(one.getMyColor() == COLORS[i]) {
                combination[0] = i;
            }
        }
        for(int i = 0; i < COLORS.length; i++) {
            if(two.getMyColor() == COLORS[i]) {
                combination[1] = i;
            }
        }
        for(int i = 0; i < COLORS.length; i++) {
            if(three.getMyColor() == COLORS[i]) {
                combination[2] = i;
            }
        }
        for(int i = 0; i < COLORS.length; i++) {
            if(four.getMyColor() == COLORS[i]) {
                combination[3] = i;
            }
        }

        return combination;
    }

    private void checkCombination() {
        int[] combination = getCombination();
        if(isWon(combination)) {
            Log.d("TAG", "user has won");
            //show toast and reset
            Toast.makeText(getApplicationContext(),"You won :-) ", Toast.LENGTH_LONG).show();
/*            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            resetGame();
        } else {
            submit.setText("not valid");
            //Log.d("TAG", "check colors");
            pushCombination(combination);
            //make history visible based on timesTried.....
            updateHistory();
        }
    }

    private void resetGame() {
        initHistoryColors();
        initHistoryButtons();
        timesTried = 0;
        clickCount = 0;
        submit.setVisibility(View.GONE);
        //reset color buttons one to four
        one.setMyColor(0);
        one.setBackgroundColor(Color.LTGRAY);
        two.setMyColor(0);
        two.setBackgroundColor(Color.LTGRAY);
        three.setMyColor(0);
        three.setBackgroundColor(Color.LTGRAY);
        four.setMyColor(0);
        four.setBackgroundColor(Color.LTGRAY);
        generateSecret();
    }

    private void updateHistory() {
        for(int j = 0; j <= timesTried; j++) {
            for (int i = 0; i < 4; i++) {
                //historyButtons[j][i].setLayoutParams(defaultLayoutParams);
                historyButtons[j][i].setBackgroundColor(COLORS[historyColors[j][i]]);

                if(isColorInSecret(historyColors[j][i])) {
                    if(isColorPositionCorrect(historyColors[j][i],i)) {
                        //make it fat
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) historyButtons[j][i].getLayoutParams();
                        layoutParams.height = 70;
                        historyButtons[j][i].setLayoutParams(layoutParams);
                        //Log.d("O", "updateHistory: ");
                    } else {
                        //make it half as fat
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) historyButtons[j][i].getLayoutParams();
                        layoutParams.height = 40;
                        historyButtons[j][i].setLayoutParams(layoutParams);
                        //Log.d("o", "updateHistory: ");
                    }
                } else {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) historyButtons[j][i].getLayoutParams();
                    layoutParams.height = 50;
                    layoutParams.width = 50;
                    historyButtons[j][i].setBackgroundColor(Color.GRAY);
                }

                historyButtons[j][i].setVisibility(View.VISIBLE);
            }
        }

        timesTried++;
        if(timesTried == 7) isLost();
    }

    private void isLost() {
        Toast.makeText(getApplicationContext(),"You lost :-( ", Toast.LENGTH_LONG).show();
        resetGame();
    }

    private boolean isColorPositionCorrect(int color, int index) {
        boolean retVal = false;
        if(color == secret[index]) retVal = true;
        Log.d("TAG", "isColorPositionCorrect: " + retVal + " " + color + " " + secret[index]);
        return retVal;
    }

    private boolean isColorInSecret(int color) {
        boolean retVal = false;
        for(int i = 0; i < secret.length; i++) {
                if(color == secret[i]) retVal = true;
                //Log.d("TAG", "isColorInSecret: " + retVal + color + " " + secret[i]);
        }
        return retVal;
    }

    private void pushCombination(int[] combination) {
        //move old combinations upwards
        for(int i = 6; i > 0; i--) {
            for(int j = 0; j < 4; j ++) {
                historyColors[i][j] = historyColors[i-1][j];
            }
        }
        for(int k = 0; k < combination.length; k++) {
            historyColors[0][k] = combination[k];
        }
    }

    private boolean isWon(int[] combination) {
        if(
                combination[0] == secret[0] &&
                combination[1] == secret[1] &&
                combination[2] == secret[2] &&
                combination[3] == secret[3]
        ) {
            Log.d("TAG", "isWon: true");
            return true;
        } else {
            return false;
        }
    }

}