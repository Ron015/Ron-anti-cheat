package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class h extends PacketAdapter {
   public h() {
      super(Register.plugin, ListenerPriority.MONITOR, Client.getInstance());
   }

   public void onPacketReceiving(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      PacketContainer var3 = var1.getPacket();
      if (var1.getPlayer().getName().equals("pawsashatoy")) {
         this.c(var2, "i: " + var3.getType().name() + " " + var3.getStructures().getValues());
      }

   }

   private void c(Player var1, String var2) {
      var1.sendMessage(var2);
      Bukkit.getLogger().info(var2);
   }
}
