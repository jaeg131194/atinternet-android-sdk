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

public class Video extends RichMedia {

    private int duration;

    /**
     * Get duration
     *
     * @return int
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Set a new duration
     *
     * @param duration int
     * @return Video
     */
    public Video setDuration(int duration) {
        this.duration = duration;

        return this;
    }

    /**
     * Set an new name
     *
     * @param name String
     * @return Video
     */
    public Video setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Set a new level 2
     *
     * @param level2 int
     * @return Video
     */
    public Video setLevel2(int level2) {
        this.level2 = level2;

        return this;
    }

    /**
     * Change boolean isBuffering value
     *
     * @param isBuffering boolean
     * @return Video
     */
    public Video setBuffering(boolean isBuffering) {
        this.isBuffering = isBuffering;

        return this;
    }

    /**
     * Change boolean isEmbedded value
     *
     * @param isEmbedded boolean
     * @return Video
     */
    public Video setEmbedded(boolean isEmbedded) {
        this.isEmbedded = isEmbedded;

        return this;
    }

    /**
     * Set a new first chapter
     *
     * @param chapter1 String
     * @return Video
     */
    public Video setChapter1(String chapter1) {
        this.chapter1 = chapter1;
        return this;
    }

    /**
     * Set a new second chapter
     *
     * @param chapter2 String
     * @return Video
     */
    public Video setChapter2(String chapter2) {
        this.chapter2 = chapter2;
        return this;
    }

    /**
     * Set a new third chapter
     *
     * @param chapter3 String
     * @return Video
     */
    public Video setChapter3(String chapter3) {
        this.chapter3 = chapter3;
        return this;
    }

    /**
     * Set a new action
     *
     * @param action RichMedia.Action
     * @return Video
     */
    public Video setAction(Action action) {
        this.action = action;

        return this;
    }

    /**
     * Set a new webdomain
     *
     * @param webDomain String
     * @return Video
     */
    public Video setWebDomain(String webDomain) {
        this.webDomain = webDomain;
        return this;
    }

    Video(MediaPlayer player) {
        super(player);
        broadcastMode = BroadcastMode.Clip;
        type = "video";
    }

    @Override
    void setEvent() {
        super.setEvent();

        if (duration > MAX_DURATION) {
            duration = MAX_DURATION;
        }
        tracker.setParam(Hit.HitParam.MediaDuration.stringValue(), duration);
    }
}
