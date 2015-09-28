package org.rugbyapp.app.RestApi;


/**
 * Created by codex on 2015/07/21.
 */
public class UrlPath {

    public static final  String URL ="http://rugbyteamprofiles-2leh.rhcloud.com";


    public static class PlayerProfileLinks{
        public static final String POST    = URL+"/api/player/create" ;
        public static final String GET_ID  = URL+"/api/player/" ;
        public static final String PUT     = URL+"###" ;
        public static final String GETALL  = URL+"/api/players" ;
    }
    public static class TeamsProfileLinks{
        public static final String POST    = URL+"/api/team/create" ;
        public static final String GET_ID  = URL+"/api/team/" ;
        public static final String PUT     = URL+"###" ;
        public static final String GETALL  = URL+"/api/teams" ;
    }
    public static class LogTableLinks{
            /*public static final String POST    = URL+"/api/team/create" ;
            public static final String GET_ID  = URL+"/api/team/" ;
            public static final String PUT     = URL+"###" ;*/
            public static final String GETALL  = URL+"/api/table" ;
        }

   /* public static class CategoryLinks {
        public static final String POST    = URL+"/api/cat/create" ;  //@controllers.CategoryController.create
        public static final String GET_ID  = URL+"/api/cat/" ;        //@controllers.CategoryController.getCategory(id)
        public static final String PUT     = URL+"/api/cat/update" ;  //@controllers.CategoryController.update
        public static final String GETALL  = URL+"/api/cat/get/cats" ;  //@controllers.CategoryController.getAll
    }
*/


}