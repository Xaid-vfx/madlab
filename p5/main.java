package nmit.mohan.com.app_sms_email_phone;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
 public class MainActivity extends AppCompatActivity {
 private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
 Button sendBtn;
 Button btnSendEmail;
 Button btnPhone;
 String phoneNo;
 String message;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
sendBtn = (Button) findViewById(R.id.btnSendSMS);
 btnSendEmail = (Button) findViewById(R.id.btnSendEmail);
 btnPhone = (Button) findViewById(R.id.btnDialPhone);
 sendBtn.setOnClickListener(new View.OnClickListener() {
 public void onClick(View view) {
 sendSMSMessage();
 }
 });
 btnSendEmail.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 sendEmail();
 }
}
}
}
});
});
}
  btnPhone.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 PhoneDial();
 }
 
protected void sendEmail() {
Intent emailIntent = new Intent(Intent.ACTION_SEND);
emailIntent.setData(Uri.parse("mailto:"));
emailIntent.setType("text/plain");
emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ba.mohan@gmail.com"});
emailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject Test");
emailIntent.putExtra(Intent.EXTRA_TEXT, "Message Body Test");
startActivity(emailIntent);
protected void sendSMSMessage() {
Intent sendIntent = new Intent(Intent.ACTION_VIEW);
sendIntent.putExtra("sms_body", "default content");
sendIntent.setType("vnd.android-dir/mms-sms");
startActivity(sendIntent);
Toast.makeText(getApplicationContext(), "SMS sent.",
Toast.LENGTH_LONG).show();
 protected void PhoneDial() {
 Intent intent = new Intent(Intent.ACTION_DIAL);
 startActivity(intent); }