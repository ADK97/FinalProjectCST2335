package algonquin.cst2335.finalprojectcst2335;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<BearItem> bearList;
    private BearAdapter bearAdapter;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bearList = new ArrayList<>();
        bearAdapter = new BearAdapter(bearList);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(bearAdapter);

        editText = findViewById(R.id.editText);
        Button generateButton = findViewById(R.id.button);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString().trim();

                // Add the input text to the RecyclerView
                if (!inputText.isEmpty()) {
                    bearList.add(new BearItem(inputText));
                    bearAdapter.notifyDataSetChanged();
                }

                // Show a Toast notification
                Toast.makeText(MainActivity.this, "Bear generated!", Toast.LENGTH_SHORT).show();

                // Show a Snackbar notification
                Snackbar.make(v, "Bear generated!", Snackbar.LENGTH_SHORT).show();

                // Show an AlertDialog notification
                showAlertDialog();
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
