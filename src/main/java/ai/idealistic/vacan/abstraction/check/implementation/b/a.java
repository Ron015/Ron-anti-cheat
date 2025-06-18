package ai.idealistic.vacan.abstraction.check.implementation.b;

import ai.idealistic.vacan.abstraction.b.f;
import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.abstraction.check.b;
import ai.idealistic.vacan.abstraction.check.e;
import ai.idealistic.vacan.abstraction.d.g;
import ai.idealistic.vacan.abstraction.f.c;
import ai.idealistic.vacan.listeners.protocol.l;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class a extends e {
   private static final double ct = 1.085D;
   private int cu = 0;
   private final ai.idealistic.vacan.abstraction.check.a.a cv;
   private final ai.idealistic.vacan.abstraction.check.a.a cw;
   private final ai.idealistic.vacan.abstraction.check.a.a cx;
   private final ai.idealistic.vacan.abstraction.check.a.a cy;
   private long cz;

   public a(CheckEnums.HackType var1, c var2) {
      super(var1, var2);
      this.cv = new ai.idealistic.vacan.abstraction.check.a.a(this, Check.DataType.JAVA, Check.DetectionType.PACKETS, "positive_net", true);
      this.cw = new ai.idealistic.vacan.abstraction.check.a.a(this, Check.DataType.JAVA, Check.DetectionType.PACKETS, "positive_latency", true);
      this.cx = new ai.idealistic.vacan.abstraction.check.a.a(this, Check.DataType.JAVA, Check.DetectionType.PACKETS, "positive_balance", true);
      this.cy = new ai.idealistic.vacan.abstraction.check.a.a(this, Check.DataType.JAVA, Check.DetectionType.PACKETS, "negative", true);
   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof g) {
         if (this.cx.i() || this.cw.i() || this.cv.i() || this.cy.i()) {
            g var3 = (g)var2;
            long var4 = var3.G();
            f var6 = var3.ac.gH;
            double var7 = ai.idealistic.vacan.utils.b.f.l(50.0D / (double)var4, 2.0D);
            if (var6.be() && var4 > 50L) {
               this.cy.a(() -> {
                  if (var7 < 1.0D) {
                     this.a(this.cy, "negative, multiply: " + var7, 1.0D / var7);
                  }

               });
            } else if (var4 < 50L && var6.bg() > 100L) {
               this.cx.a(() -> {
                  if (var7 >= 1.085D) {
                     this.a(this.cx, "positive(balance), multiply: " + var7, var7);
                  }

               });
            } else if (var4 < 50L && var6.bi() > 8) {
               this.cv.a(() -> {
                  if (var7 >= 1.085D) {
                     this.a(this.cv, "positive(NET), multiply: " + var7, var7);
                  }

               });
            } else if (var4 < 50L && var6.bj() > 40) {
               this.cw.a(() -> {
                  if (var7 >= 1.085D) {
                     this.a(this.cw, "positive(latency), multiply: " + var7, var7);
                  }

               });
            }
         }
      } else if (var2 instanceof PlayerTeleportEvent) {
         this.P();
      } else if (ai.idealistic.vacan.functionality.server.c.bW() && var2 instanceof PacketEvent) {
         PacketType var9 = ((PacketEvent)var2).getPacketType();
         PacketType[] var10 = l.jQ;
         int var5 = var10.length;

         for(int var11 = 0; var11 < var5; ++var11) {
            PacketType var12 = var10[var11];
            if (var12.equals(var9)) {
               this.P();
               break;
            }
         }
      }

   }

   private void P() {
      this.cz = System.currentTimeMillis() + 200L;
      this.cu = 0;
   }

   private void a(b var1, String var2, double var3) {
      this.cu += 70;
      if (this.cu > 100) {
         var1.a(var3, var2, this.ac.bM(), 0, true);
         this.cu -= 10;
      } else if (this.cu > 0) {
         --this.cu;
      }

   }

   protected boolean m() {
      return !this.ac.cb() && this.cz < System.currentTimeMillis() && ai.idealistic.vacan.functionality.d.b.a(this.ac, false, true, true, true, true);
   }
}
