package com.snehasis.user_registration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText name , occupation , degree , score , country;
    AppCompatButton btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.input_name);
        occupation = findViewById(R.id.input_occupation);
        degree = findViewById(R.id.input_degree);
        score = findViewById(R.id.input_score);
        country = findViewById(R.id.input_country);

        btn_submit = findViewById(R.id.btn_submit);

        UserModel user = new UserModel();

        btn_submit.setOnClickListener(v -> {

            user.setName(name.getText().toString());
            user.setOccupation(occupation.getText().toString());
            user.setDegree(degree.getText().toString());
            user.setScore(Integer.parseInt(score.getText().toString()));
            user.setCountry(country.getText().toString());

            Intent intent1 = new Intent(this, DataView.class);
            intent1.putExtra("user_data", user);
            startActivity(intent1);
        });

        Intent intent2 = getIntent();





    }
}