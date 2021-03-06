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
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@Config(sdk =21)
@RunWith(RobolectricTestRunner.class)
public class TVTrackingTest extends AbstractTestClass {

    private TVTracking tvTracking;
    private Buffer buffer;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        Configuration configuration = tracker.getConfiguration();
        configuration.put("plugins", "tvtracking");
        tracker = new Tracker(RuntimeEnvironment.application, configuration);
        tvTracking = new TVTracking(tracker);
        buffer = tracker.getBuffer();
        buffer.getPersistentParams().clear();
    }

    @Test
    public void getCampaignURLTest() {
        assertEquals("", tvTracking.getCampaignURL());
    }

    @Test
    public void getVisitDurationURLTest() {
        assertEquals(10, tvTracking.getVisitDuration());
    }

    @Test
    public void setWithoutConfigTest() {
        Configuration configuration = tracker.getConfiguration();
        configuration.put("plugins", "");
        tracker = new Tracker(RuntimeEnvironment.application, configuration);
        tracker.getBuffer().getPersistentParams().clear();
        tvTracking.set();

        assertEquals(0, buffer.getPersistentParams().size());
    }

    @Test
    public void setOneTest() {
        tvTracking.set();

        assertEquals("", tvTracking.getCampaignURL());
        assertEquals(10, tvTracking.getVisitDuration());
        assertEquals(1, buffer.getPersistentParams().size());
        assertEquals("tvt", buffer.getPersistentParams().get(0).getKey());
        assertEquals("true", buffer.getPersistentParams().get(0).getValue().execute());
    }

    @Test
    public void setTwoTest() {
        tvTracking.set("titi.fr");

        assertEquals("titi.fr", tvTracking.getCampaignURL());
        assertEquals(10, tvTracking.getVisitDuration());
        assertEquals(1, buffer.getPersistentParams().size());
        assertEquals("tvt", buffer.getPersistentParams().get(0).getKey());
        assertEquals("true", buffer.getPersistentParams().get(0).getValue().execute());
    }

    @Test
    public void setThreeTest() {
        String url = "test." + new Random().nextInt(500) + ".org";
        int duration = new Random().nextInt(500);
        tvTracking.set(url, duration);

        assertEquals(url, tvTracking.getCampaignURL());
        assertEquals(duration, tvTracking.getVisitDuration());
        assertEquals(1, buffer.getPersistentParams().size());
        assertEquals("tvt", buffer.getPersistentParams().get(0).getKey());
        assertEquals("true", buffer.getPersistentParams().get(0).getValue().execute());
    }

    @Test
    public void unsetTest() {
        tracker = tvTracking.set("test.org", 9);
        assertEquals(1, buffer.getPersistentParams().size());

        tvTracking.unset();
        assertEquals(0, buffer.getPersistentParams().size());
    }
}
