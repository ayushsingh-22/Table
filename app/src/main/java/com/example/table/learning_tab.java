package com.example.table;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class learning_tab extends AppCompatActivity {

    ListView list;  EditText editText; Button start_btn;
    ArrayList<String> list_items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.learning_tab);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        list = findViewById(R.id.list);
        editText = findViewById(R.id.text);
        start_btn = findViewById(R.id.button);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString().trim();

                if (input.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a number to proceed", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    list_items.clear();
                    int num = Integer.parseInt(input);

                    for (int i = 1; i <= 10; i++)
                    {
                        list_items.add(String.valueOf(num) + " x " + i + " = " + (num * i));
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(learning_tab.this, R.layout.custom_list, list_items);
                    list.setAdapter(adapter);
                }
                catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid input: Please enter a valid number", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}