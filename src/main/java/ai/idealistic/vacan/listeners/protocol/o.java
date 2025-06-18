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
import com.comphenix.protocol.wrappers.EnumWrappers.Hand;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class o extends PacketAdapter {
   public o() {
      super(Register.plugin, ListenerPriority.NORMAL, fp());
   }

   public void onPacketReceiving(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      PacketContainer var4 = var1.getPacket();
      ai.idealistic.vacan.functionality.b.a.b(() -> {
         if (var4.getType().equals(Client.BLOCK_DIG)) {
            var3.gw = false;
         } else {
            BlockPosition var4x = new BlockPosition(0, 0, 0);
            if (var4.getHands().getValues().isEmpty()) {
               if (!var4.getMovingBlockPositions().getValues().isEmpty()) {
                  var4x = ((MovingObjectPositionBlock)var4.getMovingBlockPositions().read(0)).getBlockPosition();
               }

               if (!var4.getBlockPositionModifier().getValues().isEmpty()) {
                  var4x = (BlockPosition)var4.getBlockPositionModifier().read(0);
               }

               if (var4x.getY() != -1) {
                  return;
               }
            }

            boolean var5 = !MultiVersion.c(MultiVersion.MCVersion.V1_9) || var1.getPacket().getHands().read(0) == Hand.MAIN_HAND;
            ItemStack var6 = MultiVersion.c(MultiVersion.MCVersion.V1_9) ? (var5 ? var3.cd().getItemInMainHand() : var3.cd().getItemInOffHand()) : var2.getItemInHand();
            if (var4.getType().toString().contains("USE_ITEM_ON") && var1.getPacket().getStructures().getValues().toString().contains("Serverbound")) {
               return;
            }

            if (var6.getType().toString().contains("SHIELD") || var6.getType().isEdible() && (var2.getFoodLevel() != 20 || var6.getType().toString().contains("GOLDEN_APPLE")) && !var3.cl().equals(GameMode.CREATIVE)) {
               var3.gw = true;
               var3.gx = !var6.getType().toString().contains("SHIELD") && !var6.getType().toString().contains("GOLDEN_APPLE");
            }
         }

      });
   }

   private static PacketType[] fp() {
      if (MultiVersion.c(MultiVersion.MCVersion.V1_17)) {
         return new PacketType[]{Client.USE_ITEM, Client.BLOCK_DIG};
      } else {
         return ai.idealistic.vacan.compatibility.b.a.b.F("USE_ITEM_ON") ? new PacketType[]{Client.USE_ITEM_ON, Client.BLOCK_PLACE, Client.BLOCK_DIG} : new PacketType[]{Client.BLOCK_PLACE, Client.BLOCK_DIG};
      }
   }
}
