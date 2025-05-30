interface socket380V{
    void ChargingOn();
    void ChargingOff();
}

class Charger380 implements socket380V{
    public void ChargingOn(){
        System.out.println("Charger 380V is on");
    }
    public void ChargingOff(){
        System.out.println("Charger 380V is off");
    }
}

class Rozetka{
    private socket380V socket380V;
    public Rozetka(socket380V socket380V){
        this.socket380V = socket380V;
    }
    public void Test(){
        socket380V.ChargingOn();
        socket380V.ChargingOff();
    }
}

interface socket220V{
    void ChargingOn220V();
    void ChargingOff220V();
}

class Charger220 implements socket220V{
    public void ChargingOn220V() {
        System.out.println("Charger 220V is on");
    }
    public void ChargingOff220V() {
        System.out.println("Charger 220V is off");
    }
}

class SocketAdapter implements socket380V{
    Charger220 charger220;
    public SocketAdapter(Charger220 charger220){
        this.charger220 = charger220;
    }
    public void ChargingOn(){
        charger220.ChargingOn220V();
    }
    public void ChargingOff(){
        charger220.ChargingOff220V();
    }
}

public class Main {
    public static void main(String[] args) {
        socket380V ch380v = new Charger380();
        Rozetka rz = new Rozetka(ch380v);
        rz.Test();
        SocketAdapter ch220v = new SocketAdapter(new Charger220());
        Rozetka rzAdapter = new Rozetka(ch220v);
        rzAdapter.Test();
    }
}
