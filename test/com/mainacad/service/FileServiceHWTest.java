package com.mainacad.service;

import com.mainacad.helper.ConnectionInfoHelper;
import com.mainacad.model.ConnectionInfo;
import com.mainacad.service.FileServiceHW;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceHWTest {

    private static final String TEXT_FILE_NAME = "test_text_file.txt";
    private static final String BYTES_FILE_NAME = "test_bytes_file.obj";

    @BeforeAll
    static void setUpBeforeAll() {
        byte[] testBytes = FileServiceHW.getBytesFromFile("cat.jpg");
        FileServiceHW.writeBytesToFile(testBytes, BYTES_FILE_NAME);
    }

    @BeforeEach
    void setUp() {
        FileServiceHW.writeTextToFile("", TEXT_FILE_NAME, false);

        ConnectionInfo connectionInfo = ConnectionInfoHelper.getRandomConnectionInfo();
        FileServiceHW.writeTextToFile(connectionInfo.toString(), TEXT_FILE_NAME, false);
    }

    @AfterEach
    void tearDown() {
        File testTextFile =
                new File(FileServiceHW.FILES_DIR + FileServiceHW.SEP + TEXT_FILE_NAME);
        testTextFile.delete();
    }

    @AfterAll
    static void tearDownAfterAll() {
        File testBytesFile =
                new File(FileServiceHW.FILES_DIR + FileServiceHW.SEP + BYTES_FILE_NAME);
        testBytesFile.delete();
    }

    @Test

    void readTextFromFile() {
        String testText = FileServiceHW.readTextFromFile(TEXT_FILE_NAME);

        assertNotNull(testText);
        assertTrue(testText.contains(" "));
        assertTrue(testText.length() > 22);
    }

    @Test
    void readConectionsFromFile() {
        List<ConnectionInfo> testObj = FileServiceHW.readConnectionsFromFile(TEXT_FILE_NAME);
        assertNotNull(testObj);
        assertTrue(testObj.size() > 0);
        assertNotNull(testObj.get(0).getConnectionTime());
        assertNotNull(testObj.get(0).getUserIp());
        assertNotNull(testObj.get(0).getSessionId());
        assertTrue(testObj.get(0).getSessionId() > 10000 &&
                testObj.get(0).getSessionId() < 99999);
    }

    @Test
    void getBytesFromFile() {
        byte[] testBytes = FileServiceHW.getBytesFromFile(BYTES_FILE_NAME);

        assertNotNull(testBytes);
        assertTrue(testBytes.length > 0);
    }

}