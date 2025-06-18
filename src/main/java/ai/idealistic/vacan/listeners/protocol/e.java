package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class e extends PacketAdapter {
   public e() {
      super(Register.plugin, ListenerPriority.NORMAL, new PacketType[]{Server.EXPLOSION});
   }

   public void onPacketSending(PacketEvent var1) {
      PacketContainer var2 = var1.getPacket();
      List var3 = var2.getDoubles().getValues();
      if (var3.size() >= 3) {
         Player var4 = var1.getPlayer();
         ai.idealistic.vacan.abstraction.f.c var5 = ai.idealistic.vacan.functionality.server.c.i(var4);
         Location var6 = new Location(var4.getWorld(), (Double)var3.get(0), (Double)var3.get(1), (Double)var3.get(2));
         if (ai.idealistic.vacan.abstraction.g.b.c(var6, var5.getLocation()) < 10.0D) {
            var5.dj().fm = true;
            var5.dk().fm = true;
         }
      }

   }
}
