package ai.idealistic.vacan.listeners.a.a;

import ai.idealistic.vacan.functionality.server.MultiVersion;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.WorldUnloadEvent;

public class c implements Listener {
   private static final Map<Long, Long> jO = new ConcurrentHashMap();
   public static final boolean jP;

   private static long a(World var0, int var1, int var2) {
      return (31L * (long)var1 + (long)var2) * 31L + (long)var0.getName().hashCode();
   }

   public static boolean b(World var0, int var1, int var2) {
      long var3 = a(var0, var1, var2);
      Long var5 = (Long)jO.get(var3);
      if (var5 != null) {
         if (var5 == -1L) {
            return true;
         }

         if (var5 > System.currentTimeMillis()) {
            return false;
         }
      }

      Chunk[] var6 = var0.getLoadedChunks();
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         Chunk var9 = var6[var8];
         if (var9.getX() == var1 && var9.getZ() == var2) {
            jO.put(var3, -1L);
            return true;
         }
      }

      jO.put(var3, System.currentTimeMillis() + 10000L);
      return false;
   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(ChunkLoadEvent var1) {
      Chunk var2 = var1.getChunk();
      jO.put(a(var2.getWorld(), var2.getX(), var2.getZ()), -1L);
   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(ChunkUnloadEvent var1) {
      Chunk var2 = var1.getChunk();
      jO.remove(a(var2.getWorld(), var2.getX(), var2.getZ()));
   }

   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void a(WorldUnloadEvent var1) {
      World var2 = var1.getWorld();
      ai.idealistic.vacan.listeners.a.a(var2);
      Chunk[] var3 = var2.getLoadedChunks();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Chunk var6 = var3[var5];
         jO.remove(a(var2, var6.getX(), var6.getZ()));
      }

   }

   public static Block a(Location var0) {
      return b(var0.getWorld(), var0.getBlockX() >> 4, var0.getBlockZ() >> 4) ? var0.getWorld().getBlockAt(var0) : null;
   }

   static {
      jP = MultiVersion.c(MultiVersion.MCVersion.V1_17);
   }
}
