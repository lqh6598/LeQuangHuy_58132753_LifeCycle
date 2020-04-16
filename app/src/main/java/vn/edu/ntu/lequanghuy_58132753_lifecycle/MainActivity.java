package vn.edu.ntu.lequanghuy_58132753_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtTG,txtTGduocluu;
        SimpleDateFormat spF = new SimpleDateFormat("HH:mm:ss");
        String date = spF.format(new Date());
        String dateluu="";
        Log.d("LifeCycle","onCreate Called");
        Toast.makeText(getApplicationContext(),"onCreate Called",Toast.LENGTH_SHORT).show();
        txtTG = findViewById(R.id.txtTG);
        txtTG.setText(date);
        // Lấy thời gian đã lưu ( trả lời câu 6 )
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        dateluu = preferences.getString("dateluu","");
        txtTGduocluu = findViewById(R.id.txtTGduocluu);
        txtTGduocluu.setText(dateluu);

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("LifeCycle","onStart Called");
        Toast.makeText(getApplicationContext(),"onStart Called",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("LifeCycle","onRestart Called");
        Toast.makeText(getApplicationContext(),"onRestart Called",Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("LifeCycle","onResume Called");
        Toast.makeText(getApplicationContext(),"onResume Called",Toast.LENGTH_SHORT).show();
        TextView txtTG;
        SimpleDateFormat spF = new SimpleDateFormat("HH:mm:ss");
        String date = spF.format(new Date());
        txtTG = findViewById(R.id.txtTG);
        txtTG.setText(date);

    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d("LifeCycle","onPause Called");
        Toast.makeText(getApplicationContext(),"onPause Called",Toast.LENGTH_SHORT).show();
        // Lưu trạng thái thời gian không thay đổi ( trả lời câu 6 )
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        TextView txtTGluu = findViewById(R.id.txtTG);
        String dateluutam = txtTGluu.getText().toString();
        editor.putString("dateluu",dateluutam);
        editor.commit();
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d("LifeCycle","onStop Called");
        Toast.makeText(getApplicationContext(),"onStop Called",Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("LifeCycle","onDestroy Called");
        Toast.makeText(getApplicationContext(),"onDestroy Called",Toast.LENGTH_SHORT).show();

    }
}
