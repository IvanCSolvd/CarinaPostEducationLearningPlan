/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.demo.regression.dataprovider;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Carina regression test with retries and it's registration in Zafira.
 * It just generate failure in 75% of cases and on retry should improve statistic
 *
 * @author qpsdemo
 */
public class DataproviderRetryTest2 implements IAbstractTest {

    @Test(dataProvider = "DP1", dataProviderClass = DataproviderRetryTest.class)
    @MethodOwner(owner = "qpsdemo")
    public void testDataproviderRetry2(String testRailColumn, int a, int b, int c) {
        boolean isPassed = (new Random().nextInt(4) == 1) ? true : false;
        Assert.assertTrue(isPassed);

        setCases(testRailColumn.split(","));
        int actual = a * b;
        int expected = c;
        Assert.assertEquals(actual, expected, "Invalid sum result!");
    }

}