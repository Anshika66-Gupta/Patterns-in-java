interface Device{
    void turnOn();
    void turnOff();
}

class TV implements Device {
    public void turnOn() {
        System.out.println("TV turn on");
    }

    public void turnOff() {
    System.out.println("TV turn off");
    }
}

class Radio implements Device {
    public void turnOn() {
        System.out.println("Radio turn on");
    }

    public void turnOff() {
        System.out.println("Radio turn off");
    }
}

abstract class RemoteControl {
    protected Device device;
    protected RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void togglePower();
}

class AdvancedRemoteControl extends RemoteControl {
    private boolean isOn = false;

    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    public void togglePower() {
    
        if (isOn) {
            device.turnOff();
        } else {
            device.turnOn();
        }
        isOn =!isOn;
}
}

public class BridgePattern {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl remote = new AdvancedRemoteControl(tv);
        
        remote.togglePower();
        remote.togglePower();
        Device radio = new Radio();
        remote = new AdvancedRemoteControl(radio);
        remote.togglePower();
    }
}