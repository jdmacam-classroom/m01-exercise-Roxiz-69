package com.example.donkey;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
        TextView Trivia;
        Button buttonNext;
    String [] qoutes = {
            "Be yourself; everyone else is already taken",
            "Nothing is impossible, the word itself says Im possible",
            "Real change, enduring change, happens one step at a time",
            "Be stronger than your excuses",
            "To change your life, you must first change your day",
            "I never said it would be easy, I only said it would be worth it",
            "Every hour you study is proof your believe in your self",
            "Push yourself, because no one else is going to do it for you",
            "Nothing will work unless you do",
            "Believe you can and you're halfway there"
    };
    int loop = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Trivia = findViewById(R.id.textView);
        buttonNext = findViewById(R.id.button);

        buttonNext.setOnClickListener( v -> {
            if (loop < Trivia.length()){Trivia.setText(qoutes[loop]);
                loop++;
            }
            if (loop == Trivia.length()){buttonNext.setEnabled(false);
                buttonNext.setText("Its already Done!");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
}