package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.MovingObjectPositionBlock;
import com.comphenix.protocol.wrappers.EnumWrappers.Direction;
import com.comphenix.protocol.wrappers.EnumWrappers.Hand;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class b extends PacketAdapter {
   public b() {
      super(Register.plugin, ListenerPriority.HIGHEST, fo());
   }

   public void onPacketReceiving(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      PacketContainer var4 = var1.getPacket();
      ai.idealistic.vacan.functionality.b.a.b(() -> {
         if (this.a(var4)) {
            if (!var4.getBlockPositionModifier().getValues().isEmpty() || !var4.getMovingBlockPositions().getValues().isEmpty()) {
               BlockPosition var5 = new BlockPosition(0, 0, 0);
               Direction var6 = null;
               if (!var4.getMovingBlockPositions().getValues().isEmpty()) {
                  var5 = ((MovingObjectPositionBlock)var4.getMovingBlockPositions().read(0)).getBlockPosition();
                  var6 = ((MovingObjectPositionBlock)var4.getMovingBlockPositions().read(0)).getDirection();
               }

               if (!var4.getBlockPositionModifier().getValues().isEmpty()) {
                  var5 = (BlockPosition)var4.getBlockPositionModifier().read(0);
                  if (var4.getDirections().getValues().isEmpty()) {
                     int var7 = (Integer)var4.getIntegers().read(0);
                     var6 = Direction.values()[var7];
                  } else {
                     var6 = (Direction)var4.getDirections().read(0);
                  }
               }

               Location var14 = new Location(var3.bV(), (double)var5.toVector().getBlockX(), (double)var5.toVector().getBlockY(), (double)var5.toVector().getBlockZ());
               if (var6 == null) {
                  return;
               }

               var14.add(this.a(BlockFace.valueOf(var6.name())));
               World var8 = var2.getWorld();
               Block var9 = ai.idealistic.vacan.listeners.a.a.c.a(new Location(var8, (double)((int)var14.getX()), (double)((int)var14.getY()), (double)((int)var14.getZ())));
               if (var9 == null) {
                  return;
               }

               boolean var10 = !MultiVersion.c(MultiVersion.MCVersion.V1_9) || var1.getPacket().getHands().read(0) == Hand.MAIN_HAND;
               ItemStack var11 = MultiVersion.c(MultiVersion.MCVersion.V1_9) ? (var10 ? var3.cd().getItemInMainHand() : var3.cd().getItemInOffHand()) : var2.getItemInHand();
               if (var11.getType().isBlock()) {
                  if (!this.d(var3.getLocation(), var9.getLocation())) {
                     Block var12 = var2.getLocation().getBlock();
                     Material var13 = var11.getType();
                     var3.gL.a(new ai.idealistic.vacan.abstraction.d.j(var5, var13));
                     var3.gL.a(new ai.idealistic.vacan.abstraction.d.j(new BlockPosition(var5.getX(), var5.getY() + 1, var5.getZ()), var13));
                     ai.idealistic.vacan.listeners.a.d.a(var3, var9, var12, var1, true);
                     var3.gl = 0;
                  } else {
                     ++var3.gl;
                  }
               } else {
                  ++var3.gl;
               }
            }
         } else {
            ++var3.gl;
         }

      });
   }

   public boolean a(PacketContainer var1) {
      BlockPosition var2 = new BlockPosition(0, 0, 0);
      if (var1.getHands().getValues().isEmpty()) {
         if (!var1.getMovingBlockPositions().getValues().isEmpty()) {
            var2 = ((MovingObjectPositionBlock)var1.getMovingBlockPositions().read(0)).getBlockPosition();
         }

         if (!var1.getBlockPositionModifier().getValues().isEmpty()) {
            var2 = (BlockPosition)var1.getBlockPositionModifier().read(0);
         }

         return var2.getY() != -1;
      } else {
         return (var1.getType().equals(Client.USE_ITEM) || var1.getType().toString().contains("USE_ITEM_ON")) && ((Hand)var1.getHands().read(0)).equals(Hand.MAIN_HAND);
      }
   }

   public boolean d(Location var1, Location var2) {
      double var3 = var1.getX();
      double var5 = var1.getY();
      double var7 = var1.getZ();
      double var9 = 1.0D;
      double var11 = 2.0D;
      double var13 = var3 - var9 / 2.0D;
      double var15 = var3 + var9 / 2.0D;
      double var19 = var5 + var11;
      double var21 = var7 - var9 / 2.0D;
      double var23 = var7 + var9 / 2.0D;
      double var25 = var2.getX();
      double var27 = var2.getY();
      double var29 = var2.getZ();
      return var25 >= var13 && var25 <= var15 && var27 >= var5 && var27 <= var19 && var29 >= var21 && var29 <= var23;
   }

   public Vector a(BlockFace var1) {
      Vector var2 = new Vector(var1.getModX(), var1.getModY(), var1.getModZ());
      if (var1.getModX() != 0 || var1.getModY() != 0 || var1.getModZ() != 0) {
         var2.normalize();
      }

      return var2;
   }

   private static List<PacketType> fo() {
      ArrayList var0 = new ArrayList();
      var0.add(Client.BLOCK_PLACE);
      if (MultiVersion.c(MultiVersion.MCVersion.V1_9)) {
         var0.add(Client.USE_ITEM);
      }

      if (ai.idealistic.vacan.compatibility.b.a.b.F("USE_ITEM_ON")) {
         var0.add(Client.USE_ITEM_ON);
      }

      return var0;
   }
}
