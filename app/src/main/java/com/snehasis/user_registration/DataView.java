package com.snehasis.user_registration;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DataView extends AppCompatActivity {

    TextView name , occupation , degree , score , country;
    AppCompatButton btn_submit ,btn_back ,btn_yes , btn_no;
    LocalDatabase db;
    Dialog dialog ;
    Intent intent1, intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //setting up dialog view
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogue_layout);
//        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setCancelable(false);

        //text views
        name = findViewById(R.id.show_name);
        occupation = findViewById(R.id.show_occupation);
        degree = findViewById(R.id.show_degree);
        score = findViewById(R.id.show_score);
        country = findViewById(R.id.show_country);

        //buttons
        btn_submit = findViewById(R.id.btn_submit_final);
        btn_back = findViewById(R.id.btn_back);

        intent1 = getIntent();//getting data from main activity
        intent2 = getIntent();//starting new activity on save btn click

        UserModel user = (UserModel) intent1.getParcelableExtra("user_data");

        //setting views
        name.setText(user.getName());
        occupation.setText(user.getOccupation());
        degree.setText(user.getDegree());
        score.setText(String.valueOf(user.getScore()));
        country.setText(user.getCountry());

        btn_submit.setOnClickListener(v -> {

            dialog.show();

            btn_yes = dialog.findViewById(R.id.btn_yes);
            btn_no = dialog.findViewById(R.id.btn_no);

            btn_no.setOnClickListener(no -> {
                dialog.dismiss();
            });

            btn_yes.setOnClickListener(yes -> {
                db = new LocalDatabase(this);
                db.add_to_db(user);
                intent2 = new Intent(this, RecyclerViewDisplay.class);
                startActivity(intent2);

                dialog.dismiss();

            });
        });

        btn_back.setOnClickListener(v -> {
            intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);
        });
    }
}