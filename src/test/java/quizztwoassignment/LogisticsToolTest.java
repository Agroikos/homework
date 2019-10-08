package quizztwoassignment;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class LogisticsToolTest extends TestCase {

    @Test
    public void testReadFromFile() {
        LogisticsTool lt = new LogisticsTool("/Users/danolaru/Desktop/Programming/Scoala Informala/homework/src/main/java/quizztwoassignment/inputData.txt");

        List<Package> delivs = lt.readFile(lt.pathToFile);

        assertEquals(27, delivs.size());
    }

    @Test
    public void testDelivsToApahida() {
        LogisticsTool lt = new LogisticsTool("/Users/danolaru/Desktop/Programming/Scoala Informala/homework/src/main/java/quizztwoassignment/inputData.txt");

        List<Package> delivs = lt.readFile(lt.pathToFile);

        List<Package> toApahida = lt.groupDelivsByLocation(delivs)
                .stream()
                .filter(p -> p.get(0).getLocation().equalsIgnoreCase("apahida"))
                .findFirst()
                .get();

        assertEquals(9, toApahida.size());
    }

    @Test
    public void testNumberOfThreads() {
        LogisticsTool lt = new LogisticsTool("/Users/danolaru/Desktop/Programming/Scoala Informala/homework/src/main/java/quizztwoassignment/inputData.txt");
        List<Package> delivs = lt.readFile(lt.pathToFile);

        int effectiveThreadNum = LogisticsTool.delegateToThreads(delivs);

        assertEquals(LocationThread.threadNum, effectiveThreadNum);
    }

}
