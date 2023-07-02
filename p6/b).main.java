package com.example.contentprovider6b;
import android.Manifest;
import android.annotation.SuppressLint; import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract; import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity; import androidx.core.app.ActivityCompat;
@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
public static final int RequestPermissionCode = 1 ; @Override
  S Trisheela
protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
Button button = findViewById(R.id.button); EnableRuntimePermission(); button.setOnClickListener(v -> {
Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
startActivityForResult(intent, 1); });
}
public void EnableRuntimePermission(){
if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.READ_CONTACTS))
{
Toast.makeText(MainActivity.this,"CONTACTS permission allows us to Access
CONTACTS app", Toast.LENGTH_LONG).show(); } else {
ActivityCompat.requestPermissions(MainActivity.this,new String[]{ Manifest.permission.READ_CONTACTS}, RequestPermissionCode);
} }
@Override
public void onActivityResult(int reqCode, int resultCode, Intent data){
super.onActivityResult(reqCode, resultCode, data); if (reqCode == 1) {
if (resultCode == Activity.RESULT_OK) {
Uri contactData = data.getData();
try (Cursor c = managedQuery(contactData, null, null, null, null)) {
if (c.moveToFirst()) { String id =
c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID)); @SuppressLint("Range")
String hasPhone = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
if (hasPhone.equalsIgnoreCase("1")) { Cursor phones =
getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id, null, null);
phones.moveToFirst(); @SuppressLint("Range") String cNumber =
phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
Toast.makeText(getApplicationContext(), cNumber, Toast.LENGTH_SHORT).show();
phones.close(); }
} }
catch(Exception e) {
e.printStackTrace(); }
} }
} }
