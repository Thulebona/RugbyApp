package org.rugbyapp.app.domain;

import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
public class Fixtures implements Serializable {

    private String teamAName;
    private String teamBName;
    //@Column(unique = true)
    private String matchDate;
    private String matchTime;
    private MatchResults results;
    private Venue matchVenue;
    private long  id;

    public Fixtures() {
    }
    public Fixtures(Builder builder) {
        results = builder.results;
        teamAName = builder.teamAName;
        teamBName = builder.teamBName;
        matchDate = builder.matchDate;
        matchTime = builder.matchTime;
        matchVenue = builder.matchVenue;
        id = builder.id;
    }

    public MatchResults getResults() {
        return results;
    }
    public String getTeamAName() {
        return teamAName;
    }
    public String getTeamBName() {
        return teamBName;
    }
    public String getMatchDate() {
        return matchDate;
    }
    public String getMatchTime() {
        return matchTime;
    }
    public Venue getMatchVenue() {
        return matchVenue;
    }
    public long getID() {
        return id;
    }

    public static class Builder{

        private String teamAName;
        private String teamBName;
        private String matchDate;
        private String matchTime;
        private Venue matchVenue;
        private MatchResults results;
        private long  id;

        public Builder(String matchDate){this.matchDate=matchDate;}

        public Builder teamAName(String val){
            this.teamAName = val;
            return this;
        }

        public Builder teamBName(String val){
            this.teamBName = val;
            return this;
        }
        public Builder matchTime(String val){
            this.matchTime = val;
            return this;
        }
        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder matchVenue(Venue val){
            this.matchVenue = val;
            return this;
        }
        public Builder results(MatchResults results){
            this.results = results;
            return this;
        }
        public Builder copy(Fixtures fixture){

            teamAName = fixture.teamAName;
            teamBName = fixture.teamBName;
            matchDate = fixture.matchDate;
            matchTime = fixture.matchTime;
            matchVenue = fixture.matchVenue;
            results = fixture.results;
            id = fixture.id;
            return this;
        }

        public Fixtures build(){return new Fixtures(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fixtures fixtures = (Fixtures) o;

        return id == fixtures.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
