package com.mainacad;

import com.mainacad.helper.ConnectionInfoHelper;
import com.mainacad.model.ConnectionInfo;
import com.mainacad.service.FileServiceHW;

import java.util.Date;
import java.util.logging.Logger;

public class ApplicationFunner {
    private static final Logger LOGGER =
            Logger.getLogger(ApplicationFunner.class.getName());

    public static void main(String[] args) {

        for(int i = 1; i <= 5; i++) {
            ConnectionInfo connectionInfo = ConnectionInfoHelper. getRandomConnectionInfo ();
            FileServiceHW.writeTextToFile(connectionInfo.toString(), "connections.txt", true);

        }

        //  FileServiceHW.moveFileToFolder("catp.jpg","catp_copy.jpg");

    }

}

