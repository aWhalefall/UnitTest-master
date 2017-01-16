package com.czt.saisam.unittest;

/**
 * Created by weichyang on 2016/12/27.
 * 事件
 */
public class TextReleaseEvent {

    private int numberPress;
    private String title;
    private String content;

    public TextReleaseEvent(int numberPress, String title, String content) {
        this.content = content;
        this.numberPress = numberPress;
        this.title = title;
    }


    public int getNumberPress() {
        return numberPress;
    }

    public void setNumberPress(int numberPress) {
        this.numberPress = numberPress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
