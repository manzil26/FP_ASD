class EmployeeNode {
    String name;
    String left;
    String right;

    EmployeeNode(String name) {
        this.name = name;
        this.left = null;
        this.right = null;
    }

    public String getName() {
        return name;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }
}