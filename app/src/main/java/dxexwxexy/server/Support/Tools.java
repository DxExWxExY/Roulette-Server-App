package dxexwxexy.server.Support;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.security.*;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Tools {

    public static String logs = "", ip = "";
    public static int port = findFreePort();

    public static String hashSHA256(String str) throws NoSuchAlgorithmException {
        System.out.print("Enter String to Hash: ");
        byte[] input = str.getBytes();
        MessageDigest hasher = MessageDigest.getInstance("SHA-256");
        hasher.update(input);
        byte[] digest = hasher.digest();
        StringBuilder hexDigest = new StringBuilder();
        for (byte aDigest : digest) {
            hexDigest.append(Integer.toString((aDigest & 0xff) + 0x100, 16).substring(1));
        }
        return String.valueOf(hexDigest);
    }

    public static String getTime() {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        int h = calendar.get(Calendar.HOUR_OF_DAY);
        int m = calendar.get(Calendar.MINUTE);
        int s = calendar.get(Calendar.SECOND);
        return (String.valueOf(h) + ":" + String.valueOf(m) + ":" + String.valueOf(s));
    }

    /**
     * Returns a free port number on localhost.
     *
     * Heavily inspired from org.eclipse.jdt.launching.SocketUtil (to avoid a dependency to JDT just because of this).
     * Slightly improved with close() missing in JDT. And throws exception instead of returning -1.
     *
     * @return a free port number on localhost
     * @throws IllegalStateException if unable to find a free port
     * @author Michael Vorburger
     */
    public static int findFreePort() {
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(0);
            socket.setReuseAddress(true);
            int port = socket.getLocalPort();
            try {
                socket.close();
            } catch (IOException ignored) { }
            return port;
        }
        catch (IOException ignored) { }
        finally {
            if (socket != null) {
                try {
                    socket.close();
                }
                catch (IOException ignored) { }
            }
        }
        throw new IllegalStateException("Could not find a free TCP/IP port to start embedded Jetty HTTP Server on");
    }

    public static String getIP(Context context) {
        WifiManager wm = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        assert wm != null;
        return Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
    }

    public static void updateLog(String log) {
        logs += (log + " - " + Tools.getTime() + "\n--------\n");
    }
}
