package com.androidsummit.androidsummitsampleapp.apimenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.androidsummit.androidsummitsampleapp.CardIOSampleActivity;
import com.androidsummit.androidsummitsampleapp.firebase.ExampleFirebaseMessagingActivity;
import com.androidsummit.androidsummitsampleapp.nessie.NessieActivity;
import com.androidsummit.androidsummitsampleapp.R;
import com.androidsummit.androidsummitsampleapp.firebase.ExampleAuthFirebaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * The initial activity that opens when starting the app.  Select an API from this activity to be taken to that APIs implementation page.
 */
public class ApiMenuActivity extends AppCompatActivity {

    private GridView apiMenuGrid;
    private List<ApiMenuItem> apiMenuItemList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.api_menu_activity);

        // TODO: move this setup to an XML file...

        // Set up API Menu Items here
        apiMenuItemList = new ArrayList<>();

        // Nessie
        ApiMenuItem nessieItem = new ApiMenuItem.Builder()
            .title(getString(R.string.nessie_title))
            .imageResource(R.mipmap.nessie_logo)
            .navigationClass(NessieActivity.class.getName())
            .build();
        apiMenuItemList.add(nessieItem);

        // Card.IO
        ApiMenuItem cardioItem = new ApiMenuItem.Builder()
            .title(getString(R.string.cardio_title))
            .imageResource(R.mipmap.cardio)
            .navigationClass(CardIOSampleActivity.class.getName())
            .build();
        apiMenuItemList.add(cardioItem);

        // Firebase Auth
        ApiMenuItem firebaseAuthItem = new ApiMenuItem.Builder()
            .title(getString(R.string.firebase_authui_title))
            .imageResource(R.mipmap.firebase)
            .navigationClass(ExampleAuthFirebaseActivity.class.getName())
            .build();
        apiMenuItemList.add(firebaseAuthItem);

        // Firebase Messaging
        ApiMenuItem firebaseMessagingItem = new ApiMenuItem.Builder()
            .title(getString(R.string.firebase_messaging_title))
            .imageResource(R.mipmap.firebase)
            .navigationClass(ExampleFirebaseMessagingActivity.class.getName())
            .build();
        apiMenuItemList.add(firebaseMessagingItem);

        apiMenuGrid = (GridView) findViewById(R.id.api_menu_gridlayout);
        apiMenuGrid.setAdapter(new ApiMenuGridAdapter(this, apiMenuItemList));
    }


}
