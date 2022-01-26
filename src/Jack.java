public class Jack {
    private String name;
    private boolean isOutput;
    private Jack connection;

    public Jack(String name, boolean isOutput) {
        this.name = name;
        this.isOutput = isOutput;
        this.connection = null;
    }

    public boolean isOutput() {
        return isOutput;
    }

    public String getName() {
        return name;
    }

    public Jack getConnection() {
        return this.connection;
    }





    public void setToOutput(boolean isOutput) {
        this.isOutput = isOutput;
    }
}
