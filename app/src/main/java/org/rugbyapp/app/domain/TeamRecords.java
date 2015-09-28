package org.rugbyapp.app.domain;

import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
public class TeamRecords implements Serializable {
    //@Column(unique = true)
    //private TeamProfile team;
    private String recordDate;
    private String recordDescription;

    private TeamRecords(){
    }
    public TeamRecords(Builder builder) {
      //  team = builder.team;
        recordDate = builder.recordDate;
        recordDescription = builder.recordDescription;
    }

  /*  public TeamProfile getTeamName() {
        return team;
    }*/
    public String getRecordDate() {
        return recordDate;
    }
    public String getRecordDescription() {
        return recordDescription;
    }

    public static class Builder {
       // private TeamProfile team;
        private String recordDate;
        private String recordDescription;

        public Builder(String val){
            this.recordDate = val;
           // this.team = val;
        }
        /*public Builder recordDate(String val){
            this.recordDate = val;
            return this;
        }*/
        public Builder recordDescription(String val){
            this.recordDescription = val;
            return this;
        }
        public Builder copy(TeamRecords val){
          //  this.team = val.team;
            this.recordDate = val.recordDate;
            this.recordDescription = val.recordDescription;
            return  this;
        }
        public TeamRecords build(){return new TeamRecords(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamRecords records = (TeamRecords) o;

        return !(recordDate != null ? !recordDate.equals(records.recordDate) : records.recordDate != null);

    }

    @Override
    public int hashCode() {
        return recordDate != null ? recordDate.hashCode() : 0;
    }
}
