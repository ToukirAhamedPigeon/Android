package com.example.touki.activitystates;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // TextView textView=(TextView) findViewById(R.id.textHello);
        //textView.setText("On Create");
        Toast.makeText(this, "On Create",
                Toast.LENGTH_SHORT).show();
        RelativeLayout mylayout= new RelativeLayout(this);
        Button myButton=new Button(this);
        myButton.setBackgroundColor(Color.BLACK);
        myButton.setTextColor(Color.WHITE);
        myButton.setText("Click");
        myButton.setId(1);
        RelativeLayout.LayoutParams buttonDetails= new RelativeLayout.LayoutParams(
          RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        mylayout.addView(myButton,buttonDetails);

        final TextView myTextView=new TextView(this);
        myTextView.setId(3);
        myTextView.setText("Hello World");
        myTextView.setTextColor(Color.BLACK);

        RelativeLayout.LayoutParams textViewDetails= new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        textViewDetails.addRule(RelativeLayout.BELOW,myButton.getId());
        textViewDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
       // mylayout.addView(myButton);
        textViewDetails.setMargins(0,50,0,0);
        mylayout.addView(myTextView,textViewDetails);

        final EditText myEditText= new EditText(this);
        myEditText.setId(2);
        RelativeLayout.LayoutParams editTextDetails= new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        editTextDetails.addRule(RelativeLayout.ABOVE,myButton.getId());
        editTextDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);

        Resources resources=getResources();
        int px=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,250,resources.getDisplayMetrics());
        myEditText.setWidth(px);
        editTextDetails.setMargins(0,0,0,50);

        mylayout.addView(myEditText,editTextDetails);

        setContentView(mylayout);


        myButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        String text=myEditText.getText().toString();
                            myTextView.setText(text);
                    }
                }
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
      //  TextView textView=(TextView) findViewById(R.id.textHello);
        //textView.setText("On Start");
        Toast.makeText(this, "On Start",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
       // TextView textView=(TextView) findViewById(R.id.textHello);
       // textView.setText("On Resume");
        Toast.makeText(this, "On Resume",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
      //  TextView textView=(TextView) findViewById(R.id.textHello);
      //  textView.setText("On Pause");
        Toast.makeText(this, "On Pause",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
      //  TextView textView=(TextView) findViewById(R.id.textHello);
      //  textView.setText("On Restart");
        Toast.makeText(this, "On Restart",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
       // TextView textView=(TextView) findViewById(R.id.textHello);
       // textView.setText("On Stop");
        Toast.makeText(this, "On Stop",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // TextView textView=(TextView) findViewById(R.id.textHello);
       // textView.setText("On Destroy");
        Toast.makeText(this, "On Destroy",
                Toast.LENGTH_SHORT).show();
    }
}
