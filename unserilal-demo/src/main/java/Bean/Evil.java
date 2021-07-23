package Bean;

import java.io.IOException;

public class Evil {

    static {
        System.out.println("static");
        String cmd = "/System/Applications/Calculator.app/Contents/MacOS/Calculator";
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Evil(){
        System.out.println("constructor");
    }
}

