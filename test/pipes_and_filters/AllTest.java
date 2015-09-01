package pipes_and_filters;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	CircularShiftProcessorTest.class,
	CPipeTest.class,
	NoiseWordProcessorTest.class,
	SortingProcessorTest.class
})
public class AllTest { }
