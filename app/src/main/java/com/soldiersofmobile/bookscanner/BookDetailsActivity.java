package com.soldiersofmobile.bookscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.soldiersofmobile.bookscanner.api.model.VolumeInfo;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BookDetailsActivity extends AppCompatActivity {


    @BindView(R.id.cover)
    ImageView coverImageView;

    @BindView(R.id.title)
    TextView titleTextView;

    @BindView(R.id.subtitle)
    TextView subtitleTextView;

    @BindView(R.id.authors)
    TextView authorsTextView;

    @BindView(R.id.description)
    TextView descriptionTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        ButterKnife.bind(this);
        VolumeInfo volumeInfo = (VolumeInfo) getIntent().getSerializableExtra(BookScannerActivity.VOLUME_INFO_EXTRA);

        if (volumeInfo.getImageLinks() != null) {
            Picasso.with(this)
                    .load(volumeInfo.getImageLinks().getThumbnail())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(coverImageView);
        }
        titleTextView.setText(volumeInfo.getTitle());
        subtitleTextView.setText(volumeInfo.getSubtitle());
        StringBuilder authors = new StringBuilder();
        for (String author : volumeInfo.getAuthors()) {
            authors.append(author);
            authors.append(" ");
        }
        authorsTextView.setText(authors);

        descriptionTextView.setText(volumeInfo.getDescription());
    }
}
