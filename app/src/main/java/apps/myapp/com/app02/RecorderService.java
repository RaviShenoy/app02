package apps.myapp.com.app02;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

public class RecorderService extends Service {
    private MediaRecorder mediaRecorder;

    public boolean isRecording() {
        return bIsRecording;
    }

    public void isRecording(boolean bIsRecording) {
        this.bIsRecording = bIsRecording;
    }

    private boolean bIsRecording;

    public RecorderService() {

        String mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/audiorecordtest.3gp";

        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setOutputFile(mFileName);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onStartCommand()
    {
        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            Log.e("Failed", "IO exception");
        }
        mediaRecorder.start();
        bIsRecording = true;
    }

    public void onStopCommand()
    {
        mediaRecorder.stop();
        bIsRecording = false;
    }

}
