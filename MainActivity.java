package com.example.contactpickerdemo;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;

public class MainActivity extends Activity {

    private static final int PICK_CONTACT_REQUEST = 0;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


   public boolean onTouchEvent(MotionEvent me)
   {
	   if(me.getAction()==MotionEvent.ACTION_DOWN)
	   {
		   //This is invoked when user touches the screen
		   startActivityForResult(new Intent(Intent.ACTION_PICK,
				   ContactsContract.Contacts.CONTENT_URI),
				   PICK_CONTACT_REQUEST);
		   return true;
	   }
	   return false;
   }
   
   protected void onActivityResult(int requestCode, int resultCode,Intent data)
   {
	   if(requestCode == PICK_CONTACT_REQUEST)
	   {
		   if(resultCode == RESULT_OK) 
		   {
			   //The picked contact would be displayed to the user.
			   Uri uri=data.getData();
			   
			   Intent intent = new Intent(Intent.ACTION_VIEW,uri);
			   startActivity(intent);
		   }
	   }
   }
    
}
