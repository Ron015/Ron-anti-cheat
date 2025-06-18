package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import org.bukkit.Location;

public class j extends PacketAdapter {
   public j() {
      super(Register.plugin, ListenerPriority.NORMAL, new PacketType[]{Server.BLOCK_ACTION});
   }

   public void onPacketSending(PacketEvent var1) {
      PacketContainer var2 = var1.getPacket();
      if (var2.getStructures().getValues().toString().contains("piston")) {
         ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer());
         var3.dj().fk = true;
         Location var4 = ((BlockPosition)var2.getBlockPositionModifier().read(0)).toLocation(var3.bV());
         if (this.a(var3.getLocation(), var4, 5)) {
            var3.dj().fl = true;
            var3.dk().fl = true;
            var3.fl = true;
         }
      }

   }

   private boolean a(Location var1, Location var2, int var3) {
      return Math.abs(var1.getX() - var2.getX()) <= (double)var3 && Math.abs(var1.getY() - var2.getY()) <= (double)var3 && Math.abs(var1.getZ() - var2.getZ()) <= (double)var3;
   }
}
