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
import org.bukkit.World;
import org.bukkit.entity.Player;

public class g extends PacketAdapter {
   public g() {
      super(Register.plugin, ListenerPriority.HIGHEST, new PacketType[]{Server.MULTI_BLOCK_CHANGE});
   }

   public void onPacketSending(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      World var4 = var2.getWorld();
      PacketContainer var5 = var1.getPacket();
      BlockPosition var6 = (BlockPosition)var5.getSectionPositions().read(0);
      int var7 = var6.getX();
      int var8 = var6.getZ();
      int var9 = var6.getY();
      short[] var10 = (short[])var5.getShortArrays().read(0);
      Object[] var11 = (Object[])var5.getSpecificModifier(Object[].class).read(0);
      ai.idealistic.vacan.functionality.b.a.b(() -> {
         for(int var7x = 0; var7x < var10.length; ++var7x) {
            short var8x = var10[var7x];
            int var9x = var8x >> 8 & 15;
            int var10x = var8x & 15;
            int var11x = var8x >> 4 & 15;
            int var12 = var7 << 4 | var9x;
            int var13 = var9 << 4 | var10x;
            int var14 = var8 << 4 | var11x;
            Location var15 = new Location(var4, (double)(var7 * 16 + var12) / 2.0D, (double)var13, (double)(var8 * 16 + var14) / 2.0D);
            Object var16 = var11[var7x];
            if (var16.toString().toLowerCase().contains("slime_block") && var15.distance(var3.getLocation()) < 14.0D) {
               var3.go = 6;
            }
         }

      });
   }
}
