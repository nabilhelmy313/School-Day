package com.example.schoolday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.schoolday.student.FragmentAssignment;
import com.example.schoolday.student.FragmentHome;
import com.example.schoolday.teacher.TeacherHomeFragment;

public class MainActivityTeacher extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private final static int ID_HOME = 3;

    MeowBottomNavigation meo;
    ImageView notificationImage, searchImage, goBackChat, editImage, optionMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_teacher);

        goBackChat = findViewById(R.id.go_back_chat);
        notificationImage = findViewById(R.id.image_notification);
        searchImage = findViewById(R.id.image_search);
        meo = findViewById(R.id.bottom_nav);
        editImage = findViewById(R.id.image_edit);
        optionMenu = findViewById(R.id.option_menu);


        editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityTeacher.this, FragmentAssignment.EditActivity.class);
                startActivity(intent);
            }
        });

        optionMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popupMenuShow(v);
            }
        });


        // land scape
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentHome()).commit();
        }


        //code for bottom nav bar
        meo.add(new MeowBottomNavigation.Model(1, R.drawable.ic_timetable));
        meo.add(new MeowBottomNavigation.Model(2, R.drawable.ic_messgaes));
        meo.add(new MeowBottomNavigation.Model(3, R.drawable.ic_home));
        meo.add(new MeowBottomNavigation.Model(4, R.drawable.ic_user_regular));
        meo.add(new MeowBottomNavigation.Model(5, R.drawable.ic_feeds));
        meo.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {


            }
        });
        meo.setOnShowListener(new MeowBottomNavigation.ShowListener() {

            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {


                switch (item.getId()) {
                    case ID_HOME:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TeacherHomeFragment()).commit();
                        searchImage.setVisibility(View.INVISIBLE);
                        editImage.setVisibility(View.INVISIBLE);
                        optionMenu.setVisibility(View.INVISIBLE);
                        goBackChat.setVisibility(View.INVISIBLE);

                        break;




                }
            }

        });
        meo.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                //this method for solving problem of double click on icon


            }
        });

        meo.show(ID_HOME,true);

    }


    private void popupMenuShow(View v) {
        PopupMenu popupMenu = new PopupMenu(MainActivityTeacher.this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.more_actions);
        popupMenu.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.log_out:
                Toast.makeText(MainActivityTeacher.this, "you pressed logout", Toast.LENGTH_SHORT).show();
                return true;

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    }

