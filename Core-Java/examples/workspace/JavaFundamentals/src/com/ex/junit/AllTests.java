package com.ex.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MethodsToTestTest.class, MoreMethodsTest.class })
public class AllTests {

}
