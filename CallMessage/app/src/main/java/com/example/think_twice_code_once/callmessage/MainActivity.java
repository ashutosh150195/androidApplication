package com.example.think_twice_code_once.callmessage;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String[] name = new String[] { "ASHUTOSH",
            "JYOTI", "KIRAN", "TWINKLE" , "SUJAY" , "PRIYANKA" , "NEHA" , "PUSHPITA" , "GANESH" , "SHREYA" ,"BULL"};

    public static final String[] phoneNumber = new String[] {
            "8093179191",
            "8093179842",
            "8093179936",
            "8093179614",
            "8093179762",
            "8093179754",
            "8093179915" ,
            "8093179645",
            "8093179448",
            "8093179904",
            "7205626362"};

   public ListView listView;
    public List<RowItem> rowItems;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < name.length; i++) {
            RowItem item = new RowItem(name[i], phoneNumber[i]);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.contacts);

        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
                R.layout.contact_all, rowItems);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title
        menu.add(0, v.getId(), 1, "SEND SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){

        switch (item.getOrder()){
            case 0 :
                makeCall();
                return true ;
            case  1:
                sendSMS();
                return true ;
            default:
                Toast.makeText(getApplicationContext() , "Error Found" , Toast.LENGTH_LONG).show();
                return false ;
        }

//        if(item.getItemId()==0){
//            makeCall(listView);
//            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
//        }
//        else if(item.getItemId()==1){
//            sendSMS(listView);
//            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
//        }else{
//            return false;
//        }
//        return true;

    }

//     private void sendSMS() {
//         listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//             @Override
//             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//             // TODO Auto-generated method stub
//                 String number = phoneNumber[position];
//                 String msg= "Task Completed";

//                 Toast.makeText(getApplicationContext() , phoneNumber[position] , Toast.LENGTH_LONG).show();

//                 //Getting intent and PendingIntent instance
//                 Intent intent=new Intent(getApplicationContext(),MainActivity.class);
//                 PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);

//                 //Get the SmsManager instance and call the sendTextMessage method to send message
//                 SmsManager sms=SmsManager.getDefault();
//                 sms.sendTextMessage(number , null , msg , pi , null);
//                 Toast.makeText(getApplicationContext(), "Message Sent successfully!",
//                         Toast.LENGTH_LONG).show();

//             }});

//     }

//     private void makeCall() {

//         listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//             @Override
//             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                 // TODO Auto-generated method stub
//                 String number = phoneNumber[position];
//                 Toast.makeText(getApplicationContext() , phoneNumber[position] , Toast.LENGTH_LONG).show();
//                  Intent callIntent = new Intent();
//                 callIntent.setAction(Intent.ACTION_CALL);
//                 callIntent.setData(Uri.parse("tel:"+number));
//                 startActivity(callIntent);
//                 Toast.makeText(getApplicationContext(), "Call Sent successfully!",
//                 Toast.LENGTH_LONG).show();
//             }});
//     }
    
    private void sendSMS() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // TODO Auto-generated method stub
                String number = phoneNumber[position];
                String msg= "Task Completed";

//                Toast.makeText(getApplicationContext() , phoneNumber[position] , Toast.LENGTH_LONG).show();
//
//                //Getting intent and PendingIntent instance
                Intent intent=new Intent(Intent.ACTION_SENDTO);
//                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
//
//                //Get the SmsManager instance and call the sendTextMessage method to send message
//                SmsManager sms=SmsManager.getDefault();
//                sms.sendTextMessage(number , null , msg , pi , null);
//                Toast.makeText(getApplicationContext(), "Message Sent successfully!",
//                        Toast.LENGTH_LONG).show();

                intent.setData(Uri.parse("Send To :"+number));
                intent.putExtra("Message Body" , msg);
                intent.putExtra(Intent.EXTRA_STREAM ,number);

                if (intent.resolveActivity(getPackageManager())!= null)
                    startActivity(intent);

            }});

    }

    private void makeCall() {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                String number = phoneNumber[position];
                Toast.makeText(getApplicationContext() , phoneNumber[position] , Toast.LENGTH_LONG).show();
                 Intent callIntent = new Intent();
                callIntent.setAction(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));
                if (callIntent.resolveActivity(getPackageManager())!= null)
                startActivity(callIntent);
//                Toast.makeText(getApplicationContext(), "Call Sent successfully!",
//                Toast.LENGTH_LONG).show();
            }});
    }
}
