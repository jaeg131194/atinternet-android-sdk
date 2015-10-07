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

import static org.junit.Assert.assertEquals;

@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class ScreensTest extends AbstractTestClass {

    private Screens screens;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        screens = new Screens(tracker);
    }

    @Test
    public void addTest() {
        Screen screen = screens.add();
        assertEquals(1, tracker.getBusinessObjects().size());
        assertEquals("", ((Screen) tracker.getBusinessObjects().get(screen.getId())).getName());
    }

    @Test
    public void addWithLevel2Test() {
        Screen screen = screens.add("name").setLevel2(3);
        assertEquals(1, tracker.getBusinessObjects().size());
        assertEquals("name", ((Screen) tracker.getBusinessObjects().get(screen.getId())).getName());
        assertEquals(3, ((Screen) tracker.getBusinessObjects().get(screen.getId())).getLevel2());
    }

    @Test
    public void addWithChaptersTest() {
        Screen screen = screens.add("name", "chapter1", "chapter2", "chapter3");
        assertEquals(1, tracker.getBusinessObjects().size());
        assertEquals("name", ((Screen) tracker.getBusinessObjects().get(screen.getId())).getName());
        assertEquals("chapter1", ((Screen) tracker.getBusinessObjects().get(screen.getId())).getChapter1());
        assertEquals("chapter2", ((Screen) tracker.getBusinessObjects().get(screen.getId())).getChapter2());
        assertEquals("chapter3", ((Screen) tracker.getBusinessObjects().get(screen.getId())).getChapter3());
    }
}