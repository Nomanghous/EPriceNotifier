package com.logixcess.epricenotifier;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.logixcess.epricenotifier.Utils.Radar;
import com.logixcess.epricenotifier.Utils.Helper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int INITIAL_REQUEST=1337;
    private static final int[] requests = new int[]{INITIAL_REQUEST+3,INITIAL_REQUEST+4,INITIAL_REQUEST+5,INITIAL_REQUEST+6};


    private AlertDialog dialog;
    public static final int REQUEST_GOOGLE_PLAY_SERVICES = 1972;
    public static final int REQUEST_GOOGLE_PLAY_SERVICES_ERROR = 1900;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            checkForPermission();

        startRegistrationService();
        Helper.isAppRunning = true;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @TargetApi(Build.VERSION_CODES.M )
    public  void checkForPermission(){
        int i = 0;
        for(String strPerm : Helper.PERMISSIONS)
        {
            if(ContextCompat.checkSelfPermission(this,strPerm) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{strPerm},requests[i]);
            }
            i++;
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showSettingsAlert() {

        
        dialog = new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Location Service")
                .setMessage("Please activate location service")
                .setPositiveButton("Activate", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivityForResult(intent,1002);
                    }

                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }



    // checks for google play services
    private void startRegistrationService() {

        // for location Service
        Helper help = new Helper();
        if(help.checkForSettings(this.getApplicationContext())){
            Helper.isLocationServiceEnabled = true;
        }
        else
            showSettingsAlert();

        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int code = api.isGooglePlayServicesAvailable(this);
        if (code == ConnectionResult.SUCCESS) {
            onActivityResult(REQUEST_GOOGLE_PLAY_SERVICES, Activity.RESULT_OK, null);
            Helper.isGooglePlayServicesInstalled = true;
            beginAutomation();
        } else if (api.isUserResolvableError(code) &&
                api.showErrorDialogFragment(this, code, REQUEST_GOOGLE_PLAY_SERVICES_ERROR)) {
            // wait for onActivityResult call (see below)
            Helper.isGooglePlayServicesInstalled = false;
            Toast.makeText(this,"Not Found",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, api.getErrorString(code), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int code = api.isGooglePlayServicesAvailable(this);
        if (code == ConnectionResult.SUCCESS) {
            Helper.isGooglePlayServicesInstalled = true;
            beginAutomation();
        }
        else
            Helper.isGooglePlayServicesInstalled = false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case REQUEST_GOOGLE_PLAY_SERVICES:
                if (resultCode == Activity.RESULT_OK) {

                }

                break;
            case REQUEST_GOOGLE_PLAY_SERVICES_ERROR:
                Toast.makeText(this,"Not Found",Toast.LENGTH_SHORT).show();
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.google.android.gms")));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.gms&hl=en")));
                }
                finish();
                break;
            case 1002:
                Helper utils = new Helper();
                if(utils.checkForSettings(this.getApplicationContext())) {
                    Helper.isLocationServiceEnabled = true;
                    beginAutomation();
                }
                else
                    Helper.isLocationServiceEnabled = false;
                utils = null;
                Helper.resultActivity = false;
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void beginAutomation() {
        if(Helper.isGooglePlayServicesInstalled) {
            Radar locationFinder = new Radar(getApplicationContext());
        }else
            Toast.makeText(getApplicationContext(),"Google play services are missing, Features will not work",Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (dialog!=null) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }


}
