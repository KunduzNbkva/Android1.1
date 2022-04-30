package com.example.android11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
private Button btnOpenFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent() != null){   // обращаемся к самому интенту которым было открыто окно
            String result = getIntent().getStringExtra("value");
            Toast.makeText(this,result, Toast.LENGTH_SHORT).show();//всплыващее окно

        }

        btnOpenFragment = findViewById(R.id.btn_open_fragment);
        btnOpenFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_container,new FirstFragment());
                transaction.commit(); // подтверждаем действие
              // single activity
                // нижнее меню как вы думаете где находится во фрагменте или в активити

            }
        });
    }
}