/*
This SDK is licensed under the MIT license (MIT)
Copyright (c) 2015- Applied Technologies Internet SAS (registration number B 403 261 258 - Trade and Companies Register of Bordeaux – France)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package com.atinternet.tracker;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

@Config(sdk =21)
@RunWith(RobolectricTestRunner.class)
public class HitTest extends AbstractTestClass {

    private Hit hit;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        hit = new Hit("hit", new Date(), 0, false);
    }

    @Test
    public void multiInstanceTest() {
        Hit hit1 = new Hit("hit2", new Date(), 1, false);
        assertNotSame(hit, hit1);
    }

    @Test
    public void getDateTest() {
        assertNotNull(hit.getDate());
        assertNotSame(new Date(), hit.getDate());
    }

    @Test
    public void getUrlTest() {
        assertEquals("hit", hit.getUrl());
    }

    @Test
    public void getRetryTest() {
        assertEquals(0, hit.getRetry());
    }

    @Test
    public void isOfflineTest() {
        assertFalse(hit.isOffline());
    }
}
