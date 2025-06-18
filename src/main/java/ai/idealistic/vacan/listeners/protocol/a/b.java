package ai.idealistic.vacan.listeners.protocol.a;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.abstraction.d.i;
import ai.idealistic.vacan.utils.a.c;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class b extends PacketAdapter {
   private final Map<UUID, Integer> jR = new c(new ConcurrentHashMap(), 1024);

   public b() {
      super(Register.plugin, ListenerPriority.HIGHEST, new PacketType[]{Client.USE_ENTITY, Server.ENTITY_STATUS});
   }

   public void onPacketReceiving(PacketEvent var1) {
      if (var1.getPacketType() == Client.USE_ENTITY) {
         ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer());
         if (var2.bX()) {
            return;
         }

         PacketContainer var3 = var1.getPacket();
         int var4 = (Integer)var3.getIntegers().read(0);
         Player var5 = null;
         Iterator var6 = Bukkit.getOnlinePlayers().iterator();

         while(var6.hasNext()) {
            Player var7 = (Player)var6.next();
            if (var7.getEntityId() == var4) {
               var5 = var7;
               break;
            }
         }

         if (!var3.getEntityUseActions().getValues().isEmpty()) {
            if (!((EntityUseAction)var3.getEntityUseActions().read(0)).equals(EntityUseAction.ATTACK)) {
               return;
            }
         } else if (!((WrappedEnumEntityUseAction)var3.getEnumEntityUseActions().read(0)).getAction().equals(EntityUseAction.ATTACK)) {
            return;
         }

         if (var2.bH()) {
            ai.idealistic.vacan.functionality.c.a.N(var2.bC().getName() + " attack faster than the transaction response.");
         }

         if (var5 != null) {
            ai.idealistic.vacan.listeners.a.a.a(new i(var1.getPlayer(), var5, false));
         }

         this.jR.put(var2.bT(), var4);
      }

   }

   public void onPacketSending(PacketEvent var1) {
      if (var1.getPacketType() == Server.ENTITY_STATUS) {
         ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer());
         if (var2.bX()) {
            return;
         }

         int var3 = (Integer)var1.getPacket().getIntegers().read(0);
         byte var4 = (Byte)var1.getPacket().getBytes().read(0);
         if (var4 != 2) {
            return;
         }

         this.jR.entrySet().removeIf((var3x) -> {
            UUID var4 = (UUID)var3x.getKey();
            int var5 = (Integer)var3x.getValue();
            if (var5 == var3) {
               Player var6 = this.plugin.getServer().getPlayer(var4);
               Entity var7 = ProtocolLibrary.getProtocolManager().getEntityFromID(var2.bV(), var3);
               if (var6 != null && var7 != null) {
                  ai.idealistic.vacan.listeners.a.a.a(new EntityDamageByEntityEvent(var6, var7, DamageCause.ENTITY_ATTACK, 0.0D), true);
               }

               return true;
            } else {
               return false;
            }
         });
      }

   }
}
