package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.entity.Player;

public class c extends PacketAdapter {
   public c() {
      super(Register.plugin, ListenerPriority.NORMAL, new PacketType[]{Client.ARM_ANIMATION, Client.BLOCK_DIG});
   }

   public void onPacketReceiving(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      synchronized(var3) {
         if (var1.getPacket().getType().equals(Client.ARM_ANIMATION)) {
            long var5 = System.currentTimeMillis() - var3.gS;
            if (var5 > 150L) {
               var3.gu = false;
            }

            if (!var3.gu) {
               var3.b(false, new ai.idealistic.vacan.abstraction.d.f(var2, var5));
            }

            var3.gS = System.currentTimeMillis();
         } else if (var1.getPacket().getType().equals(Client.BLOCK_DIG)) {
            String var9 = var1.getPacket().getStructures().getValues().toString();
            var3.gS = System.currentTimeMillis();
            var3.gu = !var9.contains("ABORT");
         }

      }
   }
}
