import static org.apache.commons.io.FileUtils.contentEquals;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ChainOfResponsibilityTest {
    private static final String TARGET_TEST_RESOURCES_PATH = "target/test-classes/";
/*
    @DataProvider
    public Object[][] sortTestData() {
        return new Object[][]{
                {"i.txt", "testOutputFileInsertionExpected.txt"},
                "testOutputMerge.txt", "testOutputFileMergeExpected.txt"},
                {"testOutputSelection.txt", "testOutputFileSelectionExpected.txt"},
        };
    }*/

    @Test(description = "")
    public void sortTest() throws IOException {
        String targetOutputFilePath = TARGET_TEST_RESOURCES_PATH + "outputFile.txt";
        Main.main(
                new String[]{
                        "-i",  TARGET_TEST_RESOURCES_PATH + "inputFile.txt",
                        "-o", targetOutputFilePath
                });
        System.setProperty( "user.dir",  TARGET_TEST_RESOURCES_PATH);
         Assert.assertTrue(contentEquals(
                 new File(targetOutputFilePath),
                 new File(TARGET_TEST_RESOURCES_PATH + "expected.txt")
         ));
    }
}
