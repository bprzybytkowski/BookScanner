package com.soldiersofmobile.bookscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.soldiersofmobile.bookscanner.api.model.VolumeInfo;
import com.squareup.picasso.Picasso;

import butterknife.BindView;


public class BookDetailsActivity extends AppCompatActivity {


    @BindView(R.id.cover)
    ImageView coverImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        VolumeInfo volumeInfo = (VolumeInfo) getIntent().getSerializableExtra(BookScannerActivity.VOLUME_INFO_EXTRA);

        Picasso.with(this)
                .load(volumeInfo.getImageLinks().getThumbnail())
                .into(coverImageView);
    }
}
