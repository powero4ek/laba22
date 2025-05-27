interface HighVolt{
    public void print();
}
interface LowVolt{
    public void print();
}
class threeHundVolt implements HighVolt{
    int voltage;

    @Override
    public void print() {
        System.out.println("Напряжение 380 вольт");
    }
}
class twoHundVolt implements LowVolt{
    int voltage;

    @Override
    public void print() {
        System.out.println("Напряжение 220 вольт");
    }
}
class Charging{
    private HighVolt highVolt;
    public Charging(HighVolt highVolt){
        this.highVolt=highVolt;
    }
    public void charge(){
        highVolt.print();
    }
}
class Adapter implements HighVolt{
    LowVolt lowVolt;
    public Adapter(LowVolt lowVolt){
        this.lowVolt = lowVolt;
    }

    @Override
    public void print() {
        lowVolt.print();
    }
}

public class Main {
    public static void main(String[] args) {
        HighVolt v380 = new threeHundVolt();
        Adapter v220 = new Adapter(new twoHundVolt());
        Charging charging = new Charging(v220);
        charging.charge();
    }
}