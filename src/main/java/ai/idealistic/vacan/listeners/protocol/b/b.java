package ai.idealistic.vacan.listeners.protocol.b;

import ai.idealistic.vacan.Register;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

public class b extends PacketAdapter {
   public b() {
      super(Register.plugin, ListenerPriority.HIGHEST, new PacketType[]{Client.ENTITY_ACTION});
   }

   public void onPacketReceiving(PacketEvent var1) {
      ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer());
      if (!var2.bX()) {
         ai.idealistic.vacan.functionality.b.a.b(() -> {
            if (var1.getPacket().getModifier().getValues().size() > 1) {
               String var3 = var1.getPacket().getModifier().getValues().get(1).toString();
               b.a var4 = this.Y(var3);
               if (var3 != null) {
                  if (var4 == b.a.jU) {
                     var2.gs = true;
                  } else if (var4 == b.a.jV) {
                     var2.gs = false;
                  } else if (var4 == b.a.jS) {
                     var2.gr = true;
                  } else if (var4 == b.a.jT) {
                     var2.gr = false;
                  }
               }
            }

         });
      }
   }

   private b.a Y(String var1) {
      b.a[] var2 = b.a.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         b.a var5 = var2[var4];
         if (var5.toString().equals(var1)) {
            return var5;
         }
      }

      return null;
   }

   private static enum a {
      jS,
      jT,
      jU,
      jV;

      // $FF: synthetic method
      private static b.a[] fq() {
         return new b.a[]{jS, jT, jU, jV};
      }
   }
}
