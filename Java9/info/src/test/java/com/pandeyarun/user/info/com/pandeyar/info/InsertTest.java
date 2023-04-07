package com.pandeyarun.user.info.com.pandeyar.info;
/*
 * Created by pandeyar on 07/12/2017
 */

import com.pandeyarun.db.ConnDB;
import com.pandeyarun.user.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class InsertTest {

    @Test
    public void insert(){
        ConnDB.instance().insertWithStatement(new User("Arun", "Pandey",
                "Expert Software Consultant", 33));
        List<String> result = ConnDB.instance().getUsers();
        assertFalse(result.isEmpty());
    }
}
