package main.simulacionParcialMarcos;

import struct.impl.StaticList;

/**
 * Created by marcos on 19/4/17.
 */
public class Metrovias {
    private int workingTimeDuration;
    private StaticList<Window> windows;

    public Metrovias(int workingTimeDuration, int amountOfWindows) {
        this.workingTimeDuration = workingTimeDuration;
        windows=new StaticList<Window>(amountOfWindows);
        windows.goTo(0);
        for (int i = 0; i<amountOfWindows;i++){
            windows.insertNext(new Window());
        }


    }

    public int getWorkingTimeDuration() {
        return workingTimeDuration;
    }

    public StaticList<Window> getWindows() {
        return windows;
    }

}
