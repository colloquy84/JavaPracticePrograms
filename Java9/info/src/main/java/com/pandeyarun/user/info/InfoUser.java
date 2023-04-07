package com.pandeyarun.user.info;

import com.pandeyarun.db.ConnDB;
import com.pandeyarun.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Created by pandeyar on 24/08/2017
 */
public class InfoUser {

    private static final Logger logger = LogManager.getLogger(InfoUser.class);
    public static void main(String[] args){

        User user = new User("Arun", "Pandey", "Expert Software Consultant", 33);
        logger.info(user.toString());
        try {
            ConnDB.instance().insertWithStatement(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }
}