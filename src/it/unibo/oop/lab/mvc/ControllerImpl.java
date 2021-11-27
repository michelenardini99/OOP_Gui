package it.unibo.oop.lab.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Utente
 *
 */
public class ControllerImpl implements Controller {

    private final List<String> stringHistory = new LinkedList<>();
    private String nextString;


    /**
     * @param nextString
     */
    public void setNextString(final String nextString) {
        this.nextString = nextString;
    }

    /**
     * @return nextString
     */
    public String getNextString() {
        return this.nextString;
    }


    /**
     * @return history
     */
    public List<String> getHistory() {
        return this.stringHistory;
    }

    /*
     * print string
     */
    public void printCurrentString() {
        if (this.nextString == null) {
            throw new IllegalStateException("There is no string set");
        } else {
            stringHistory.add(this.nextString);
            System.out.println(this.nextString);
        }
    }

}
