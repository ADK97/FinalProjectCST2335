package algonquin.cst2335.finalprojectcst2335;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<BearItem> bearList;
    private BearAdapter bearAdapter;
    private EditText editText;
    private ImageView bearImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(bearAdapter);

        editText = findViewById(R.id.editText);
        bearImageView = findViewById(R.id.bearImageView);
        bearList = new ArrayList<>();
        bearAdapter = new BearAdapter(bearList, bearImageView);

        Button generateButton = findViewById(R.id.button);
        Button keepImageButton = findViewById(R.id.keepImageButton);
        Button generateNewImageButton = findViewById(R.id.generateNewImageButton);

        // Set the Toolbar as the ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView bearImageView = findViewById(R.id.bearImageView);
        bearAdapter = new BearAdapter(bearList, bearImageView);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString().trim();

                // using placeholder image for now, use url image later
                bearImageView.setImageResource(R.drawable.bear_image_placeholder);

                // Add the input text to the RecyclerView
                if (!inputText.isEmpty()) {
                    bearList.add(new BearItem(inputText));
                    bearAdapter.notifyDataSetChanged();
                }

                // Show a Toast notification
                Toast.makeText(MainActivity.this, "Bear generated!", Toast.LENGTH_SHORT).show();

                // Show an AlertDialog notification
                showAlertDialog();
            }
        });

        keepImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // save image here, add logic later
                Toast.makeText(MainActivity.this, "Image kept!", Toast.LENGTH_SHORT).show();
            }
        });

        generateNewImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // regenerate image here, add logic later
                Toast.makeText(MainActivity.this, "New image generated!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Bear Generated")
                .setMessage("A new bear has been generated.")
                .setPositiveButton("OK", null)
                .show();
    }
}
