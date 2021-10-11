package com.example.narsingh.Activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.narsingh.Adapters.HomePageAdapter;
import com.example.narsingh.Adapters.ViewPagerAdapter;
import com.example.narsingh.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.Locale;

public class HomeScreenActivity extends AppCompatActivity {

    WormDotsIndicator dot_3;
    private DrawerLayout drawerLayout;
    NavigationView navigationView;
    ViewPager HomeViewPager,MainViewPager;

    SwipeRefreshLayout swipeRefreshLayout;

    Toolbar toolbar;
    FloatingActionButton BecomeAMemberFloatButton,JoinAsVolunteerFloatButton;

    private Integer[] TopPagerImages={R.drawable.temp1,R.drawable.temp2,R.drawable.t_3,R.drawable.t_4,R.drawable.t_5,R.drawable.t_6,R.drawable.t_7,R.drawable.t_8};
    private Integer[] MainPager={R.drawable.t_1,R.drawable.a_2,R.drawable.t_1,R.drawable.a_2,R.drawable.t_1};
    private String[] Articles={"Navjot Singh Sidhu reiterates demand for removal of Punjab DGP, AG",
            "PM Modi's mother casts her vote in Gandhinagar civic polls",
            "Let's have a race: Kamal Nath throws fitness challenge at MP CM Shivraj Singh Chouhan",
            "EC asks Bengal chief secretary to ensure no celebration over poll results",
            "BJP announces candidates for assembly bypolls of three states"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        hook();
        setNav();
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(this,TopPagerImages);
        HomeViewPager.setAdapter(viewPagerAdapter);
        dot_3.setViewPager(HomeViewPager);
        HomePageAdapter homePageAdapter=new HomePageAdapter(this,MainPager,Articles);
        MainViewPager.setAdapter(homePageAdapter);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(false);
        });
        BecomeAMemberFloatButton.setOnClickListener(view -> {
            Toast.makeText(HomeScreenActivity.this, "BECOME A MEMBER", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(HomeScreenActivity.this,BecomeMember.class));
        });
        JoinAsVolunteerFloatButton.setOnClickListener(view -> {
            Toast.makeText(HomeScreenActivity.this, "BECOME A VOLUNTEER", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(HomeScreenActivity.this,BecomeVolunteer.class));
        });
    }

    @SuppressLint("NonConstantResourceId")
    private void setNav() {
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    break;
                case R.id.nav_aboutUs:
                    break;
                case R.id.ContactUs:
                    startActivity(new Intent(HomeScreenActivity.this,ContactUs.class));
                    break;
                case R.id.gallery_nav:
                    startActivity(new Intent(HomeScreenActivity.this,GalleryActivity.class));
                    break;
                case R.id.SCANNER:
                    startActivity(new Intent(HomeScreenActivity.this,QRcodeScannerActivity.class));
                    Toast.makeText(HomeScreenActivity.this, "SCANNER", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.LANGUAGE:
                    showChangeLanguageDialog();
                    break;
                case R.id.BecomeMember:
                    startActivity(new Intent(HomeScreenActivity.this,BecomeMember.class));
                    break;
                case R.id.Download:
                    break;
                case R.id.Members:
                    startActivity(new Intent(HomeScreenActivity.this,MembersPage.class));
                    break;
                case R.id.upConstituency:
                    break;
                case R.id.nav_ny:
                    break;
                case R.id.nav_newsArt:
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
        toolbar.setTitle("NARSINGH");
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        View headerView = navigationView.getHeaderView(0);
        ImageView imageView=headerView.findViewById(R.id.nav_img);
        imageView.setImageResource(R.drawable.temp1);
        navFloatButtons();
    }


    private void navFloatButtons() {
        View headerView = navigationView.getHeaderView(0);
        ImageView imageView=headerView.findViewById(R.id.nav_img);
        imageView.setImageResource(R.drawable.temp1);
        FloatingActionButton instagramFloatingButton=headerView.findViewById(R.id.instagramFloatNavHeader);
        FloatingActionButton youTubeFloatingButton=headerView.findViewById(R.id.youTubeFloatNavHeader);
        FloatingActionButton twitterFloatingButton=headerView.findViewById(R.id.twitterFloatNavHeader);
        FloatingActionButton kooFloatingNavHeader=headerView.findViewById(R.id.kooFloatingNavHeader);
        FloatingActionButton facebookFloatingNavHeader=headerView.findViewById(R.id.facebookFloatingNavHeader);
        Picasso.get().
                load(getString(R.string.KooLogoLink))
                .into(kooFloatingNavHeader);
        instagramFloatingButton.setOnClickListener(view -> gotoUrl("https://www.facebook.com/BJP4India/"));
        youTubeFloatingButton.setOnClickListener(view -> gotoUrl("https://www.youtube.com/watch?v=W_ItY2pCbXk"));
        twitterFloatingButton.setOnClickListener(view -> gotoUrl("https://twitter.com/imVkohli"));
        kooFloatingNavHeader.setOnClickListener(view -> gotoUrl("https://www.kooapp.com/profile/%4E%4A%50%34%49%4E%44%49%41"));
        facebookFloatingNavHeader.setOnClickListener(view -> gotoUrl("https://www.facebook.com/NJP4INDIA/"));
    }

    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    private void showChangeLanguageDialog() {
        final String[] listItems = {"English","हिंदी"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(HomeScreenActivity.this);
        mBuilder.setTitle("Choose Language...");
        mBuilder.setSingleChoiceItems(listItems,-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i == 1){
                    setLocale("hi");
                    recreate();
                }
                else if(i == 0){
                    setLocale("en");
                    recreate();
                }
                dialogInterface.dismiss();
            }
        });
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();

    }
    private void setLocale(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();

    }
    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLocale(language);
    }

    private void hook() {
        navigationView = findViewById(R.id.navigationView);
        dot_3=findViewById(R.id.dot_3);
        HomeViewPager=findViewById(R.id.HomeViewPager);
        toolbar = findViewById(R.id.toolBar);
        drawerLayout = findViewById(R.id.drawer_layout);
        swipeRefreshLayout=findViewById(R.id.swipeRefresh);
        BecomeAMemberFloatButton=findViewById(R.id.BecomeAMemberFloatButton);
        JoinAsVolunteerFloatButton=findViewById(R.id.JoinAsVolunteerFloatButton);
        MainViewPager=findViewById(R.id.MainViewPager);
    }
}