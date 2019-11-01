package uit.vinh.kk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;

public class MainActivity extends AppCompatActivity {

    private static final int RC_CAMERA = 3000;

    private Button btnImport;
    private ImageView imgImport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImport = findViewById(R.id.btnImport);
        imgImport = findViewById(R.id.imgImport);

        btnImport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ImagePicker.create(MainActivity.this).start();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, final int resultCode, Intent data) {
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            Image images = ImagePicker.getFirstImageOrNull(data);
            Log.i("IMAGE",images.getPath());
            imgImport.setImageURI(Uri.parse(images.getPath()));
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
