package galang.alarmmanager;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

public class StandUp extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"Inside receiver",Toast.LENGTH_SHORT).show();

        NotificationManagerCompat myManager=NotificationManagerCompat.from(context);
        NotificationCompat.Builder myNotif=new NotificationCompat.Builder(context);
        myNotif.setContentTitle("Stand up notification");
        myNotif.setContentText("You need to Stand up");
        myNotif.setSmallIcon(android.R.drawable.ic_btn_speak_now);

        Intent i1=new Intent(context,StandUpActivity.class);
        PendingIntent pd=PendingIntent.getActivity(context,0,i1,0);
        myNotif.setContentIntent(pd);
        myNotif.setAutoCancel(true);
        myManager.notify(1,myNotif.build());
    }
}
