package com.g0301.mazerunner.model.menu;

import com.g0301.mazerunner.gui.LanternaGUI;
import com.googlecode.lanterna.TextColor;
import org.w3c.dom.Text;

import javax.print.DocFlavor;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public abstract class Menu {
    private final List<String> options;
    private int selectOption=0;
    private final List<String> title;
    TextColor highlightColor = new TextColor.RGB(90, 255, 100);
    TextColor normalColor = new TextColor.RGB(255, 255, 255);

    protected Menu(List<String> options, List<String> title) {
        this.options = options;
        this.title = title;
    }

    public void nextOption(){
        selectOption++;
        if(selectOption>this.options.size()-1)
            selectOption=0;
    }
    public void previousOption(){
        selectOption--;
        if(selectOption<0)
            selectOption=this.options.size()-1;
    }
    public String getOption(int i){
        return options.get(i);
    }
    public boolean isSelected(int i){
        return selectOption==i;
    }

    public int getNumberOfOptions() {
        return options.size();
    }

    public TextColor getOptionColor(int i) {
        if (isSelected(i))
            return highlightColor;
        return normalColor;
    }

    public List<String> getTitle() {
        return title;
    }
    public int getTitleLength() {
        int length = 0;
        for (String line : title) {
            length = Math.max(length, line.length());
        }
        return length;
    }
}
