package org.rugbyapp.app.domain;

import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
public class PlayerRecords implements Serializable {

    private String recordDate;
    private String recordDescription;

    private PlayerRecords() {
    }
    public PlayerRecords(Builder builder) {
      //  player = builder.player;
        recordDate = builder.recordDate;
        recordDescription = builder.recordDescription;
    }

   /* public PlayerProfile getPlayer() {
        return player;
    }*/
    public String getRecordDate() {
        return recordDate;
    }
    public String getRecordDescription() {
        return recordDescription;
    }

    public static class Builder {
     //   private PlayerProfile player;
        private String recordDate;
        private String recordDescription;

        public Builder(String val) {
            this.recordDate = val;
           // this.player = s;
        }
       /* public Builder recordDate(String val){
            this.recordDate = val;
            return this;
        }*/
        public Builder recordDescription(String val){
            this.recordDescription = val;
            return this;
        }
        public Builder copy(PlayerRecords val){
            this.recordDate = val.recordDate;
            this.recordDescription = val.recordDescription;
            //this.player = val.player;
            return  this;
        }
        public PlayerRecords build(){return new PlayerRecords(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerRecords that = (PlayerRecords) o;
        return !(recordDate != null ? !recordDate.equals(that.recordDate) : that.recordDate != null);
    }

    @Override
    public int hashCode() {
        return recordDate != null ? recordDate.hashCode() : 0;
    }

  /*  public void setPlayer(PlayerProfile player) {
        this.player = player;
    }*/
}
