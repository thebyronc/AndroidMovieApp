package foiled.movieapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import foiled.movieapp.R;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.movieEditText) EditText mMovieEditText;
    @BindView(R.id.searchButton) Button mSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mMovieEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMovieEditText.setText("");
            }
        });

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String movieSearch = mMovieEditText.getText().toString();
                Toast.makeText(MainActivity.this, movieSearch + " Debug.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, MovieActivity.class);
                intent.putExtra("search", movieSearch);
                startActivity(intent);
            }
        });
    }
}
