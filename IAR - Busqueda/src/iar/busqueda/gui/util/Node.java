/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iar.busqueda.gui.util;

/**
 *
 * @author Ani Rufinetto
 */

import java.util.ArrayList;

public class Node {

    private String identifier;
    private ArrayList<String> children;
    private Node left;
    private Node right;
    private boolean goal;

    // Constructor
    public Node(String identifier) {
        this.identifier = identifier;
        children = new ArrayList<String>();
        goal=false;
    }

    // Properties
    public String getIdentifier() {
        return identifier;
    }

    public ArrayList<String> getChildren() {
        return children;
    }

    // Public interface
    public void addChild(String identifier) {
        getChildren().add(identifier);
    }

    /**
     * @param identifier the identifier to set
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(ArrayList<String> children) {
        this.children = children;
    }

    /**
     * @return the goal
     */
    public boolean isGoal() {
        return goal;
    }

    /**
     * @param goal the goal to set
     */
    public void setGoal(boolean goal) {
        this.goal = goal;
    }
}


