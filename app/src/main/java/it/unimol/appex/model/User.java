package it.unimol.appex.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("global")
    public GlobalJson globalJson;
    public class GlobalJson{

        @SerializedName("name")
        public String userName;

        @SerializedName("platform")
        public String platform;

        @SerializedName("level")
        public int level;

        @SerializedName("rank")
        public RankJson rankJson;
        public class RankJson{
            @SerializedName("rankScore")
            public int rankScore;

            @SerializedName("rankImg")
            public String rankImg;

            @SerializedName("rankName")
            public String rankName;
        }

        @SerializedName("arena")
        public ArenaJson arenaJson;
        public class ArenaJson{
            @SerializedName("global.arena.rankScore")
            public int rankArenaScore;

            @SerializedName("global.arena.rankName")
            public String rankArenaName;
        }

    }

    @SerializedName("realtime")
    public RealtimeJson realtimeJson;
    public class RealtimeJson{
        @SerializedName("global.realtime.selectedLegend")
        @Expose
        public String selectedLegend;
    }
}
