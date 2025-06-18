package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class i extends PacketAdapter {
   public i() {
      super(Register.plugin, ListenerPriority.MONITOR, new PacketType[]{MultiVersion.c(MultiVersion.MCVersion.V1_17) ? Client.PONG : (MultiVersion.c(MultiVersion.MCVersion.V1_12) ? Client.TRANSACTION : Client.KEEP_ALIVE), MultiVersion.c(MultiVersion.MCVersion.V1_17) ? Server.PING : (MultiVersion.c(MultiVersion.MCVersion.V1_12) ? Server.TRANSACTION : Server.KEEP_ALIVE)});
   }

   public void onPacketReceiving(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      PacketContainer var4 = var1.getPacket();
      int var5;
      if (!var4.getShorts().getFields().isEmpty()) {
         var5 = (Short)var4.getShorts().read(0);
      } else if (!var4.getIntegers().getFields().isEmpty()) {
         var5 = (Integer)var4.getIntegers().read(0);
      } else {
         if (var4.getLongs().getFields().isEmpty()) {
            return;
         }

         var5 = Math.toIntExact((Long)var4.getLongs().read(0));
      }

      if (var5 <= -1939 && var5 >= -1945) {
         var3.gQ = System.currentTimeMillis() - var3.gO;
         var3.gP = System.currentTimeMillis();
         var3.gv = false;
         ai.idealistic.vacan.abstraction.d.h var6 = new ai.idealistic.vacan.abstraction.d.h(var3);
         ai.idealistic.vacan.listeners.a.c.a(var6);
         var3.gL.aU = false;
         Bukkit.getScheduler().runTaskLaterAsynchronously(Register.plugin, () -> {
            a(var3, var3.gN);
         }, 10L);
      }

   }

   public void onPacketSending(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      var3.gv = true;
      var3.gO = System.currentTimeMillis();
   }

   public static void D(ai.idealistic.vacan.abstraction.f.c var0) {
      var0.gN = -1939;
      var0.gt = false;
      a(var0, var0.gN);
   }

   public static void a(ai.idealistic.vacan.abstraction.f.c var0, short var1) {
      PacketContainer var2 = new PacketContainer(MultiVersion.c(MultiVersion.MCVersion.V1_17) ? Server.PING : (MultiVersion.c(MultiVersion.MCVersion.V1_12) ? Server.TRANSACTION : Server.KEEP_ALIVE));
      if (!var2.getShorts().getFields().isEmpty()) {
         var2.getShorts().write(0, var1);
         if (var2.getType().equals(Server.TRANSACTION)) {
            var2.getIntegers().write(0, 0);
            var2.getBooleans().write(0, false);
         }
      } else if (!var2.getIntegers().getFields().isEmpty()) {
         var2.getIntegers().write(0, Integer.valueOf(var1));
      } else {
         if (var2.getLongs().getFields().isEmpty()) {
            return;
         }

         var2.getLongs().write(0, (long)var1);
      }

      ProtocolLibrary.getProtocolManager().sendServerPacket(var0.bC(), var2);
      --var0.gN;
      if (var0.gN < -1945) {
         var0.gN = -1939;
      }

   }
}
