package com.example.narsingh.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.narsingh.Adapters.GalleryRecyclerViewAdapter;
import com.example.narsingh.Adapters.images;
import com.example.narsingh.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    RecyclerView galleryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        hook();
        galleryRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        List<images> imagesList=new ArrayList<>();
        imagesList.add(new images(R.drawable.t_1));
        imagesList.add(new images(R.drawable.t_2));
        imagesList.add(new images(R.drawable.t_3));
        imagesList.add(new images(R.drawable.t_4));
        imagesList.add(new images(R.drawable.t_5));
        imagesList.add(new images(R.drawable.t_6));
        imagesList.add(new images(R.drawable.t_7));
        imagesList.add(new images(R.drawable.t_8));
        imagesList.add(new images(R.drawable.t_9));
        imagesList.add(new images(R.drawable.t_10));
        imagesList.add(new images(R.drawable.t_11));
        imagesList.add(new images(R.drawable.t_12));
        imagesList.add(new images(R.drawable.t_13));
        imagesList.add(new images(R.drawable.t_14));
        imagesList.add(new images(R.drawable.t_15));
        imagesList.add(new images(R.drawable.t_16));
        imagesList.add(new images(R.drawable.t_17));
        imagesList.add(new images(R.drawable.t_18));
        imagesList.add(new images(R.drawable.t_19));
        imagesList.add(new images(R.drawable.t_20));
        imagesList.add(new images(R.drawable.t_21));
        imagesList.add(new images(R.drawable.t_22));
        imagesList.add(new images(R.drawable.t_23));
        imagesList.add(new images(R.drawable.t_24));
        imagesList.add(new images(R.drawable.t_25));
        imagesList.add(new images(R.drawable.t_26));
        imagesList.add(new images(R.drawable.t_27));
        imagesList.add(new images(R.drawable.t_28));
        imagesList.add(new images(R.drawable.t_29));
        imagesList.add(new images(R.drawable.t_30));
        imagesList.add(new images(R.drawable.t_31));
        imagesList.add(new images(R.drawable.t_32));
        imagesList.add(new images(R.drawable.t_33));
        imagesList.add(new images(R.drawable.t_34));
        imagesList.add(new images(R.drawable.t_35));
        imagesList.add(new images(R.drawable.t_36));
        imagesList.add(new images(R.drawable.t_37));
        imagesList.add(new images(R.drawable.t_38));
        imagesList.add(new images(R.drawable.t_39));
        imagesList.add(new images(R.drawable.t_40));
        imagesList.add(new images(R.drawable.t_41));
        imagesList.add(new images(R.drawable.t_42));

        galleryRecyclerView.setAdapter(new GalleryRecyclerViewAdapter(imagesList));
    }

    private void hook() {
        galleryRecyclerView=findViewById(R.id.galleryRecyclerView);
    }
}