import static org.apache.commons.io.FileUtils.contentEquals;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ChainOfResponsibilityTest {
   /* private static final String TARGET_TEST_RESOURCES_PATH = "target/test-classes/";

    @DataProvider
    public Object[][] sortTestData() {
        return new Object[][]{
                {Main.INSERTION, "testOutputInsertion.txt", "testOutputFileInsertionExpected.txt"},
                {Main.MERGE, "testOutputMerge.txt", "testOutputFileMergeExpected.txt"},
                {Main.SELECTION, "testOutputSelection.txt", "testOutputFileSelectionExpected.txt"},
        };
    }

    @Test(description = "", dataProvider = "sortTestData")
    public void sortTest(String sortType, String outputFilePath, String outputFileExpectedPath) throws IOException {
        String targetOutputFilePath = TARGET_TEST_RESOURCES_PATH + outputFilePath;
        Main.main(
                new String[]{
                        "-i",  TARGET_TEST_RESOURCES_PATH + "testInputFile.txt",
                        "-o", targetOutputFilePath,
                        "-s", sortType
                });
         Assert.assertTrue(contentEquals(
                 new File(targetOutputFilePath),
                 new File(TARGET_TEST_RESOURCES_PATH + outputFileExpectedPath)
         ));
    }*/
}
