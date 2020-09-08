package com.example.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitexample.data.model.Post;
import com.example.retrofitexample.data.model.remote.APIService;
import com.example.retrofitexample.data.model.remote.ApiUtils;
import com.example.retrofitexample.data.model.remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //Post example
    private static final String TAG = "MainActivity";

    private EditText mSetTitle;
    private EditText mSetBody;
    private Button mPostButton;
    private TextView mResponse;
    private APIService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSetTitle = findViewById(R.id.editTextTitle);
        mSetBody = findViewById(R.id.editTextBody);
        mPostButton = findViewById(R.id.buttonPostData);
        mResponse = findViewById(R.id.textViewResponse);

        mApiService = ApiUtils.getApiService();
    }

    public void postData(View view) {
        String title = mSetTitle.getText().toString().trim();
        String body = mSetBody.getText().toString().trim();
        Log.d(TAG, "postData: ");
        sendPost(title, body);
    }

    public void sendPost(String title, String body) {
        mApiService.saveData("+923359298484").enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (response.isSuccessful()) {

                    Post post = response.body();

                    if (post != null) {

                        Log.d(TAG, "onResponse: " + response.body().toString());
                        Log.d(TAG, "onResponse: " + response.body().getMessage());
                        Log.d(TAG, "onResponse: " + response.body().getStatus());
                        Log.d(TAG, "onResponse: " + response.body().getData().getOtp());
                        //mResponse.setText(response.body().getMessage()+" ".concat(response.body().getStatus()+" ").concat(response.body().getData().getOtp()+""));
                        Toast.makeText(MainActivity.this, "post operation is completed.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "post operation is completed.", Toast.LENGTH_SHORT).show();

                    }

                }


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
