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

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@Config(sdk =21)
@RunWith(RobolectricTestRunner.class)
public class NuggAdTest extends AbstractTestClass {

    private NuggAd nuggAd;
    private Buffer buffer;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        Configuration configuration = tracker.getConfiguration();
        configuration.put("plugins", "nuggad");
        tracker = new Tracker(RuntimeEnvironment.application, configuration);
        nuggAd = new NuggAd(tracker);
        buffer = tracker.getBuffer();
    }

    @Test
    public void initTest() {
        assertEquals("{}", nuggAd.getNuggAdData().toString());
    }

    @Test
    public void setTest() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nuggad", new JSONObject().put("key", "value"));
        assertEquals(jsonObject, nuggAd.setNuggAdData(jsonObject).getNuggAdData());
    }

    @Test
    public void setEventTest() throws JSONException {
        JSONObject jsonObject = new JSONObject().put("key", "value");
        nuggAd.setNuggAdData(jsonObject).setEvent();

        assertEquals(1, buffer.getVolatileParams().size());
        assertEquals("stc", buffer.getVolatileParams().get(0).getKey());
        assertEquals(new JSONObject().put("nuggad", jsonObject).toString(), buffer.getVolatileParams().get(0).getValue().execute());
    }

}
