package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class m extends PacketAdapter {
   public m() {
      super(Register.plugin, ListenerPriority.LOWEST, new PacketType[]{Client.USE_ITEM, Client.BLOCK_DIG});
   }

   public void onPacketReceiving(PacketEvent var1) {
      if (!var1.isCancelled()) {
         Player var2 = var1.getPlayer();
         ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
         if (var3.bX()) {
            return;
         }

         ItemStack var4 = var3.cd().getItemInMainHand();
         if (var4.getType().equals(Material.TRIDENT)) {
            double var5 = Math.toRadians((double)var3.getLocation().getYaw());
            ai.idealistic.vacan.functionality.b.a.b(() -> {
               ai.idealistic.vacan.listeners.a.f.a(new ai.idealistic.vacan.abstraction.d.b(var3, var4, new Vector(-Math.sin(var5), (double)(var3.getLocation().getPitch() / 90.0F), Math.cos(var5))), true);
            });
         }
      }

   }
}
