public class AudioDeviceClient {
    public static void main(String[] args) {
        AudioDevice guitar = new AudioDevice("Gibson", "Les Paul", 0, 1);
        AudioDevice amp = new AudioDevice("Fender", "Deluxe", 1, 0);
        System.out.println(guitar.toString());
        System.out.println(amp.toString());
        guitar.getJacks().get(0).makeConnection(amp.getJacks().get(0));
        System.out.println(guitar.getMake() + " " + guitar.getModel() + " " +  guitar.getJacks().get(0).getConnection().getName());
        System.out.println(amp.getJacks().get(0).getConnection().getName());

    }
}
