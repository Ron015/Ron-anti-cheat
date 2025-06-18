package ai.idealistic.vacan.abstraction.check.implementation.a;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.GameRule;
import org.bukkit.event.entity.PlayerDeathEvent;

public class a extends ai.idealistic.vacan.abstraction.check.e {
   private final ai.idealistic.vacan.abstraction.check.b aj = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, (String)null, true);
   private long bL;

   public a(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
   }

   protected void a(boolean var1, Object var2) {
      if (var2 == null) {
         this.aj.a(() -> {
            long var1 = System.currentTimeMillis() - this.bL;
            long var3 = 750L;
            if (var1 <= var3 && !this.ac.bC().isDead()) {
               this.bL = 0L;
               this.aj.a("default, ms: " + var1, this.ac.bM(), ai.idealistic.vacan.utils.b.a.B(20.0D));
            }

         });
      } else if (var2 instanceof PlayerDeathEvent) {
         this.F();
      } else if (ai.idealistic.vacan.functionality.server.c.bW() && var2 instanceof PacketEvent) {
         PacketType var3 = ((PacketEvent)var2).getPacketType();
         PacketType[] var4 = ai.idealistic.vacan.listeners.protocol.d.jQ;
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            PacketType var7 = var4[var6];
            if (var7.equals(var3)) {
               this.F();
               break;
            }
         }
      }

   }

   private void F() {
      this.bL = System.currentTimeMillis();
   }

   protected boolean m() {
      return !ai.idealistic.vacan.utils.minecraft.c.b.ay("respawn") && (!MultiVersion.c(MultiVersion.MCVersion.V1_15) || !(Boolean)this.ac.bV().getGameRuleValue(GameRule.DO_IMMEDIATE_RESPAWN));
   }
}
