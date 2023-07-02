package com.example.secondprog;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu; import android.view.MenuItem; import android.view.View;
import android.widget.Button; import android.widget.Toast;
public class MainActivity extends AppCompatActivity { private Button button;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
button = findViewById(R.id.button); registerForContextMenu(button);
}
@Override
public void onCreateContextMenu(ContextMenu menu, View v,
ContextMenu.ContextMenuInfo menuInfo) { getMenuInflater().inflate(R.menu.menu,menu); super.onCreateContextMenu(menu, v, menuInfo);
}
@Override
public boolean onContextItemSelected(@NonNull MenuItem item) {
Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
return super.onContextItemSelected(item); }
}