package org.rugbyapp.app.views;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import org.rugbyapp.app.R;
import org.rugbyapp.app.RestApi.RestApiConnectorClass;
import org.rugbyapp.app.RestApi.UrlPath;
import org.rugbyapp.app.domain.TeamProfile;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    List<String> mylist = new ArrayList<String>();
    List<Long> idList = new ArrayList<Long>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        for(TeamProfile teamProfile: RestApiConnectorClass.readAll(UrlPath.TeamsProfileLinks.GETALL.trim())) {
            mylist.add(teamProfile.getTeamName());
            idList.add(teamProfile.getId());
        }

        ListAdapter teamAd = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,mylist);
        ListView myList = (ListView) findViewById(R.id.LogRankingListView);
        myList.setAdapter(teamAd);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Team_profile.Ids = idList.get(i);
                Intent team_profile = new Intent(MainActivity.this, Team_profile.class);
                startActivity(team_profile);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
