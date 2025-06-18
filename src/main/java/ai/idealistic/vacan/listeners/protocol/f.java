package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.ChunkCoordIntPair;
import com.comphenix.protocol.wrappers.MultiBlockChangeInfo;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class f extends PacketAdapter {
   public f() {
      super(Register.plugin, ListenerPriority.HIGHEST, new PacketType[]{Server.MULTI_BLOCK_CHANGE});
   }

   public void onPacketSending(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      World var4 = var2.getWorld();
      PacketContainer var5 = var1.getPacket();
      if (!var5.getMultiBlockChangeInfoArrays().getValues().isEmpty()) {
         List var6 = var5.getMultiBlockChangeInfoArrays().getValues();
         ChunkCoordIntPair var7 = ((MultiBlockChangeInfo[])var5.getMultiBlockChangeInfoArrays().getValues().get(0))[0].getChunk();
         Chunk var8 = var2.getWorld().getChunkAt(var7.getChunkX(), var7.getChunkZ());
         ai.idealistic.vacan.functionality.b.a.b(() -> {
            Iterator var3x = var6.iterator();

            while(var3x.hasNext()) {
               MultiBlockChangeInfo[] var4x = (MultiBlockChangeInfo[])var3x.next();
               MultiBlockChangeInfo[] var5 = var4x;
               int var6x = var4x.length;

               for(int var7 = 0; var7 < var6x; ++var7) {
                  MultiBlockChangeInfo var8 = var5[var7];
                  Material var9 = var8.getData().getType();
                  if (var9.toString().equals("SLIME_BLOCK") && var8.getLocation(var4).distance(var3.getLocation()) < 6.0D) {
                     var3.go = 6;
                  }
               }
            }

         });
      }
   }
}
