package expUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class SilenceURLHandler extends URLStreamHandler {
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        System.out.println("handler click");
        return null;
    }

    @Override
    protected synchronized InetAddress getHostAddress(URL u) {
        System.out.println("getHostAddress");
        System.out.println("^^^^^^^^^^^^^^");
        return null;
    }
}
