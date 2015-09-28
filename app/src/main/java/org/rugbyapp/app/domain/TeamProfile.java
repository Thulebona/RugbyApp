package org.rugbyapp.app.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/18.
 */

public class TeamProfile implements Serializable {

    private Long id;
    private String teamName;
    private String league;
    private String home_Ground;
    private String headCoach;
    private TeamRecords records;
    private List<PlayerProfile> players;

    private TeamProfile(){
    }
    public TeamProfile(Builder builder){
        this.id = builder.id;
        this.teamName = builder.teamName;
        this.league = builder.league;
        this.home_Ground = builder.home_Ground;
        this.headCoach = builder.headCoach;
        this.records = builder.records;
        this.players =builder.players;
    }
    public Long getId() {
        return id;
    }
    public String getTeamName() {
        return teamName;
    }
    public String getLeague() {
        return league;
    }
    public String getHome_Ground() {
        return home_Ground;
    }
    public String getHeadCoach() {
        return headCoach;
    }
    public TeamRecords getRecords() {
        return records;
    }
    public List<PlayerProfile> getPlayers() {
        return players;
    }

     public static class Builder{
        private Long id;
        private String teamName;
        private String league;
        private String home_Ground;
        private String headCoach;
        private TeamRecords records;
        private List<PlayerProfile> players;

        public Builder(String teamName) {
            this.teamName = teamName;
        }
        public Builder id(Long val){
            this.id = val;
            return this;
        }
        public Builder league(String val){
            this.league = val;
            return this;
        }
        public Builder home_Ground(String val){
            this.home_Ground = val;
            return this;
        }
        public Builder headCoach(String val){
            this.headCoach = val;
            return this;
        }
        public Builder records(TeamRecords val){
            this.records = val;
            return this;
        }
        public Builder players(List<PlayerProfile> val){
            this.players = val;
            return this;
        }

        public Builder copy(TeamProfile val){
            this.teamName = val.teamName;
            this.league = val.league;
            this.home_Ground = val.home_Ground;
            this.headCoach = val.headCoach;
            this.records = val.records;
            this.players =val.players;
            this.id = val.id;

            return this;
        }

        public TeamProfile build(){return new TeamProfile((this));}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamProfile that = (TeamProfile) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
