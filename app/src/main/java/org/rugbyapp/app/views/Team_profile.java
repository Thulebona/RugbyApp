package org.rugbyapp.app.views;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.*;
import org.rugbyapp.app.R;
import org.rugbyapp.app.RestApi.RestApiConnectorClass;
import org.rugbyapp.app.RestApi.UrlPath;
import org.rugbyapp.app.domain.PlayerProfile;
import org.rugbyapp.app.domain.TeamProfile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thule on 2015/09/27.
 */
public class Team_profile extends ActionBarActivity {

    public static Long Ids ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_profile);
        getList(Ids);
    }
    public void getList(Long idList){

        TeamProfile teamProfile = RestApiConnectorClass.read(UrlPath.TeamsProfileLinks.GET_ID,idList,TeamProfile.class);
        ImageView teamLogo =(ImageView)findViewById(R.id.imageView);
        teamLogo.setImageResource(R.drawable.rugby);
        TextView nameOfTeam = (TextView) findViewById(R.id.teamNameTxt);
        nameOfTeam.setText(teamProfile.getTeamName());

        TextView coachName = (TextView) findViewById(R.id.coachNameTxt);
        coachName.setText(teamProfile.getHeadCoach());
        TextView home = (TextView) findViewById(R.id.HomeGrndNameTxt);
        home.setText(teamProfile.getHome_Ground());
        TextView league = (TextView) findViewById(R.id.leagueView);
        league.setText(teamProfile.getLeague());

        ArrayList<String> players = new ArrayList<String>();
        for(PlayerProfile playerProfile: teamProfile.getPlayers()) {
            players.add(playerProfile.getPlayer_name());
            //idList.add(teamProfile.getId());
        }
        ListAdapter teamAd = new ArrayAdapter<String>(Team_profile.this,android.R.layout.simple_list_item_1,players);
        ListView playersList = (ListView)findViewById(R.id.playersList);
        playersList.setAdapter(teamAd);
    }
}
