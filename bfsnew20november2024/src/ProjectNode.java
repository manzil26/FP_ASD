import java.util.*;

class ProjectNode {
    // your code goes here

    String name;
    String leftSubProjectName;
    String rightSubProjectName;

    public ProjectNode(String name) {
        this.name = name;
        this.leftSubProjectName = null;
        this.rightSubProjectName = null;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeftSubProjectName() {
        return leftSubProjectName;
    }

    public void setLeftSubProjectName(String leftSubProjectName) {
        this.leftSubProjectName = leftSubProjectName;
    }

    public String getRightSubProjectName() {
        return rightSubProjectName;
    }

    public void setRightSubProjectName(String rightSubProjectName) {
        this.rightSubProjectName = rightSubProjectName;
    }

}