/*
 * Created by pandeyar on 24/08/2017
 */

module database {
    requires org.apache.logging.log4j;
    requires java.sql;
    requires user;
    requires com.h2database;
    exports com.pandeyarun.db;
}