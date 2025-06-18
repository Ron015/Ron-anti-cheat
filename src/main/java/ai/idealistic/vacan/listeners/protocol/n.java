package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import java.util.Iterator;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.vehicle.VehicleEnterEvent;

public class n extends PacketAdapter {
   public n() {
      super(Register.plugin, ListenerPriority.NORMAL, new PacketType[]{Client.USE_ENTITY});
   }

   public void onPacketReceiving(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      PacketContainer var4 = var1.getPacket();
      int var5 = (Integer)var4.getIntegers().read(0);
      ai.idealistic.vacan.functionality.b.a.b(() -> {
         if (!var4.getEntityUseActions().getValues().isEmpty()) {
            if (((EntityUseAction)var4.getEntityUseActions().read(0)).equals(EntityUseAction.ATTACK)) {
               return;
            }
         } else if (((WrappedEnumEntityUseAction)var4.getEnumEntityUseActions().read(0)).getAction().equals(EntityUseAction.ATTACK)) {
            return;
         }

         Entity var4x = null;
         Iterator var5x = var3.u(5.0D).iterator();

         while(var5x.hasNext()) {
            Entity var6 = (Entity)var5x.next();
            if (var6.getEntityId() == var5) {
               var4x = var6;
               break;
            }
         }

         if (var4x instanceof Vehicle) {
            var3.b(false, new VehicleEnterEvent((Vehicle)null, var2));
         }

      });
   }
}
