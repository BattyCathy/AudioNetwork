import java.util.ArrayList;

public class AudioDevice {
    private String make;
    private String model;
    private ArrayList<Jack> jacks;

    public AudioDevice(String make, String model, int inputs, int outputs) {
        this.make = make;
        this.model = model;
        this.jacks = new ArrayList<Jack>();

        for (int i = 0; i < inputs; i++) {
            Jack newJack = new Jack(("Input ") + (i + 1), false);
            jacks.add(newJack);
        }

        for (int i = 0; i < outputs; i++) {
            Jack newJack = new Jack(("Output ") + (i + 1), true);
            jacks.add(newJack);
        }
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public ArrayList<Jack> getJacks() {
        return jacks;
    }

    public int getNumInputs() {
        int inputs = 0;
        for (int i = 0; i < jacks.size(); i++) {
            if (!jacks.get(i).isOutput()) {
                inputs++;
            }
        }
        return inputs;
    }

    public int getNumOutputs() {
        int outputs = 0;
        for (int i = 0; i < jacks.size(); i++) {
            if (jacks.get(i).isOutput()) {
                outputs++;
            }
        }
        return outputs;
    }

    public String getJackName(int index) {
        return jacks.get(index).getName();
    }

    public int getJackIndex(String name) {
        for (int i = 0; i < jacks.size(); i++) {
            Jack jack = jacks.get(i);
            if (jack.getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public void makeConnection(AudioDevice toDevice, Jack thisJack, Jack thatJack) {

    }


    public String connectionToString(Jack jack) {
        String ret = this.getMake() + " " +
                this.getModel() + " " +
                jack.getName() + " " +
                this.isOutputToString(jack.isOutput()) + " "
                //TODO
        ;
    }

    public String isOutputToString(boolean isOutput) {
        String ret = "<-";
        if (isOutput) {
            ret = "->";
        }
        return ret;
    }

    public String toString() {

        String inputs = "Inputs: [";
        String outputs = "Outputs: [";

        for (int i = 0; i < jacks.size(); i++) {
            Jack jack = jacks.get(i);
            if (jack.isOutput()) {
                outputs += jack.getName() + ", ";
            } else {
                inputs += jack.getName() + ", ";
            }
        }
        if (outputs.length() > 10) {
            outputs = outputs.substring(0, outputs.length() - 2);
        }
            outputs += ']';

        if (inputs.length() > 10) {
            inputs = inputs.substring(0, inputs.length() - 2);
        }
        inputs += ']';
        String ret = "Make: " + this.make + '\n' +
                "Model: " + this.model + '\n' +
                inputs + '\n' +
                outputs;
        return ret;
    }
}
