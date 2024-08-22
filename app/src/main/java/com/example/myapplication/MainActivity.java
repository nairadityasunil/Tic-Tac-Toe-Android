package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Creating objects of buttons from xml file
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,new_game; // To get instance of the buttons from xml file
    String bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9; // To store values of each button
    TextView txt_turn,txt_winner;
    int flag = 0; // This is to decide whether the turn is of X or O
    int moves_count = 0; // This will keep the count of total number of moves played by both players combined
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_init(); // User Defined Function to initialize button
    }

    public void new_game(View v)
    {
        restart_game();
    }
    private void btn_init() {
        // Initializing all buttons and labels
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);
        txt_turn = findViewById(R.id.txt_turn_now);
        txt_winner = findViewById(R.id.txt_winner);
        txt_turn.setText("X");

    }

    private void restart_game()
    {
        // Resetting values of all the buttons
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        // Resetting the moves counter and the flags to default value
        flag=0;
        moves_count=0;
        txt_turn.setText("");
        txt_winner.setText("");
    }

    public void btn_chk(View v /* Variable of view. As the event is fired on the button, it will have reference of the button. if the event is set on textview, this variable will have the reference of the textview which has invoked the event*/){
        Button btn_current = (Button) v;  // Typecasting the view object on which the onClick event is fired into Button object
        // It is assumed that " X " plays the 1st move
        if (btn_current.getText().toString().equals(""))
        {
            moves_count++;

            // Conditions to print X or O with alternate turns of the players.
            if (flag == 0){
                btn_current.setText("X");
                flag = 1;
                txt_turn.setText("O");
            }
            else{
                btn_current.setText("O");
                flag = 0;
                txt_turn.setText("X");
            }

            // Both players have to play atleast 5 moves combined to decide a winner. Eg: 3 moves of X and 2 moves of O -> At this stage it can be examined if x is winner or not. Thus atleast 5 moves are required from both parties combined.=
            if(moves_count>=5 && moves_count<=9){
                // Getting values of every buttons
                bt1 = b1.getText().toString();
                bt2 = b2.getText().toString();
                bt3 = b3.getText().toString();
                bt4 = b4.getText().toString();
                bt5 = b5.getText().toString();
                bt6 = b6.getText().toString();
                bt7 = b7.getText().toString();
                bt8 = b8.getText().toString();
                bt9 = b9.getText().toString();

                // All the winning conditions
                if(bt1.equals(bt2) && bt2.equals(bt3) && !bt1.equals("")){
                    txt_winner.setText(bt1);
                } else if (bt4.equals(bt5) && bt5.equals(bt6) && !bt4.equals("")) {
                    txt_winner.setText(bt4);
                }else if (bt7.equals(bt8) && bt8.equals(bt9) && !bt7.equals("")) {
                    txt_winner.setText(bt7);
                }else if (bt1.equals(bt4) && bt4.equals(bt7) && !bt1.equals("")) {
                    txt_winner.setText(bt1);
                }else if (bt2.equals(bt5) && bt5.equals(bt8) && !bt2.equals("")) {
                    txt_winner.setText(bt2);
                }else if (bt3.equals(bt6) && bt6.equals(bt9) && !bt3.equals("")) {
                    txt_winner.setText(bt3);
                }else if (bt1.equals(bt5) && bt5.equals(bt9) && !bt1.equals("")) {
                    txt_winner.setText(bt1);
                }else if (bt3.equals(bt5) && bt5.equals(bt7) && !bt3.equals("")) {
                    txt_winner.setText(bt3);
                }
            }
            else if(moves_count > 9){
                txt_winner.setText("NO WINNER");
            }
        }
    }
}