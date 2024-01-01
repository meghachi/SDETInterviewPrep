import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

import com.meghabassi.LetterCounter;
import org.slf4j.Logger;
import org.testng.ITest;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

public class LetterCounterTest implements ITest {
    static final Logger log = getLogger(lookup().lookupClass());

    protected static ThreadLocal<String> testName
            = new ThreadLocal<>();

    @BeforeMethod
    public void setUp(Method method, Object[] testData1) {
        this.testName.set(method.getName()+"_"+testData1[0]);
    }


    @DataProvider(name="testData")
    public static Object[][]data(){
        return new Object[][]{
                {"EmptyString","",Collections.emptyMap()},
                {"NullString",null,Collections.emptyMap()},
                {"LetterOnlyWord","abcaab",Map.of('a',3,'b',2,'c',1)},
                {"LetterSymbolWord","aBcde.#99ff;;;;;;",Map.of('a',1,'b',1,'c',1,'d',1,'e',1,'f',2)}
        };


    }



    @Test(dataProvider = "testData")
    public void testLetterCount(String descriptionString,String word,Map<Character,Integer> expectedLetterCountMap) {
        LetterCounter letterCounter =new LetterCounter();
        Map<Character,Integer> actualLetterCountMap=letterCounter.countLettersString(word);

        log.debug("Word is {} \n  Expected Letter Map is {} \n Actual letterMap is {}",word,expectedLetterCountMap,actualLetterCountMap);
        assertThat(actualLetterCountMap).containsAllEntriesOf(expectedLetterCountMap);

    }

    @Override
    public String getTestName() {
        return testName.get();
    }

}

