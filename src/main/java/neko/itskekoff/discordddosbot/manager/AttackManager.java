package neko.itskekoff.discordddosbot.manager;

import java.io.IOException;
import java.net.URISyntaxException;

public interface AttackManager {
    void launch(String ip, int time, String method) throws IOException, InterruptedException, URISyntaxException;
}
