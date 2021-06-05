package kaitka.vishal.meeta.happychat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import kaitka.vishal.meeta.happychat.Adapters.FragmentAdapters;
import kaitka.vishal.meeta.happychat.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        binding.viewPager.setAdapter(new FragmentAdapters(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);

    } //OnCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    } //onCreateOPtionMenu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {

            case R.id.settings:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                Toast.makeText(this, "settings!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                auth.signOut();
                startActivity(new Intent(MainActivity.this, SignInActivity.class));
                break;

            case R.id.groupChat:
                startActivity(new Intent(MainActivity.this, GroupChatActivity.class));
                Toast.makeText(this, "send message to all users!", Toast.LENGTH_SHORT).show();
                break;

        } //switch
        return true;
    }
} //mainAcivityClass