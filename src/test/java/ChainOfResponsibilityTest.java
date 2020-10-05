import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.contentEquals;

public class ChainOfResponsibilityTest {
    private static final String TARGET_TEST_RESOURCES_PATH = "target/test-classes/";

    @BeforeClass
    public void init() {
        File source = new File("src/test/resources/chainOfRepositoryTestFiles").getAbsoluteFile();
        System.out.println(source);
        File dest = new File("").getAbsoluteFile();
        try {
            FileUtils.copyDirectory(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(description = "")
    public void sortTest() throws IOException {
        String targetOutputFilePath = TARGET_TEST_RESOURCES_PATH + "outputFile.txt";
        Main.main(
                new String[]{
                        "-i", TARGET_TEST_RESOURCES_PATH + "inputFile.txt",
                        "-o", targetOutputFilePath
                });
        Assert.assertTrue(contentEquals(
                new File(targetOutputFilePath),
                new File(TARGET_TEST_RESOURCES_PATH + "expectedFile.txt")
        ));
    }

    @AfterClass
    public void clear() {
        new File("csvFile.csv").deleteOnExit();
        new File("txtFile.txt").deleteOnExit();
        new File("xmlFile.xml").deleteOnExit();
        new File("jsonFile.json").deleteOnExit();
    }
}
