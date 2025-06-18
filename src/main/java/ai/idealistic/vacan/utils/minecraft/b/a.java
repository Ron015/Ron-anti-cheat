package ai.idealistic.vacan.utils.minecraft.b;

import ai.idealistic.vacan.compatibility.b.a.b;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import ai.idealistic.vacan.listeners.protocol.MovementListener;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class a {
   public static Location a(PacketEvent var0) {
      PacketContainer var1 = var0.getPacket();
      return var1.getDoubles().size() >= 3 ? new Location(b.i(var0.getPlayer()), (Double)var1.getDoubles().read(0), (Double)var1.getDoubles().read(1), (Double)var1.getDoubles().read(2)) : null;
   }

   public static boolean a(PacketEvent var0, Location var1, Location var2) {
      PacketType var3 = var0.getPacket().getType();
      return var3.equals(Client.POSITION) && var1.toVector().equals(var2.toVector()) ? true : var3.equals(MultiVersion.c(MultiVersion.MCVersion.V1_17) ? Client.GROUND : Client.FLYING);
   }

   public static boolean b(PacketEvent var0) {
      PacketContainer var1 = var0.getPacket();
      return var1.getBooleans().size() > 0 && (Boolean)var1.getBooleans().read(0);
   }

   public static Set<MovementListener.tpFlags> c(PacketEvent var0) {
      String var1 = ((InternalStructure)var0.getPacket().getStructures().getValues().get(0)).toString();
      HashSet var2 = new HashSet(3);
      var1 = var1.replace("X_ROT", "").replace("Y_ROT", "");
      if (var1.contains("X")) {
         var2.add(MovementListener.tpFlags.X);
      }

      if (var1.contains("Y")) {
         var2.add(MovementListener.tpFlags.Y);
      }

      if (var1.contains("Z")) {
         var2.add(MovementListener.tpFlags.Z);
      }

      return var2;
   }

   public static boolean v(Location var0) {
      return var0.getX() == 1.0D && var0.getY() == 1.0D && var0.getZ() == 1.0D;
   }

   public static Location k(Player var0) {
      return new Location(b.i(var0), 1.0D, 1.0D, 1.0D);
   }

   public static boolean a(PacketType var0) {
      return var0.equals(Client.POSITION) || var0.equals(Client.POSITION_LOOK);
   }

   public static boolean b(PacketType var0) {
      return var0.equals(Client.LOOK) || var0.equals(Client.POSITION_LOOK);
   }
}
