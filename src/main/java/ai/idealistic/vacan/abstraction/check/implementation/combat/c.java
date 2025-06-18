package ai.idealistic.vacan.abstraction.check.implementation.combat;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.abstraction.d.f;
import ai.idealistic.vacan.abstraction.d.g;
import java.util.Collection;
import java.util.List;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class c extends ai.idealistic.vacan.abstraction.check.e {
   private long ap = System.currentTimeMillis();
   private final List<Integer> aq = new ai.idealistic.vacan.utils.a.a();
   private final ai.idealistic.vacan.abstraction.check.b ar;
   private final ai.idealistic.vacan.abstraction.check.b as;
   private final ai.idealistic.vacan.abstraction.check.b at;
   private final ai.idealistic.vacan.abstraction.check.b au;
   private final ai.idealistic.vacan.abstraction.check.b av;
   private final ai.idealistic.vacan.abstraction.check.b aw;
   private final List<Long> ax;
   private final List<Long> ay;

   public c(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);

      for(int var3 = 0; var3 < 7; ++var3) {
         this.aq.add(0);
      }

      this.ax = new ai.idealistic.vacan.utils.a.a();
      this.ay = new ai.idealistic.vacan.utils.a.a();
      this.ar = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, Check.DetectionType.PACKETS, "cps", true);
      this.as = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, Check.DetectionType.PACKETS, "floor_tempo", true, 2000L, 30000L, 40000L, 60000L);
      this.at = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, Check.DetectionType.PACKETS, "deviation", true, 2000L, 30000L, 40000L, 60000L);
      this.au = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, Check.DetectionType.PACKETS, "skewness", true, 2000L, 30000L, 40000L, 60000L);
      this.av = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, Check.DetectionType.PACKETS, "kurtosis", true, 2000L, 30000L, 40000L, 60000L);
      this.aw = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, Check.DetectionType.PACKETS, "variance", true, 2000L, 30000L, 40000L, 60000L);
   }

   protected void a(boolean var1, Object var2) {
      if (!(var2 instanceof BlockBreakEvent) && !(var2 instanceof PlayerDropItemEvent)) {
         if (var2 instanceof f) {
            this.a(((f)var2).bP);
         } else if (var2 instanceof g) {
            this.a((g)var2);
         } else if (var2 instanceof PlayerInteractEvent && this.j()) {
            ((PlayerInteractEvent)var2).setCancelled(true);
         }
      } else {
         this.a((String)null, (String)null, ai.idealistic.vacan.utils.b.a.B(20.0D));
      }

   }

   private void a(long var1) {
      if (this.ar.i() || this.as.i() || this.at.i() || this.au.i() || this.av.i() || this.aw.i()) {
         if (!this.w()) {
            return;
         }

         this.ax.add(var1);
         this.ay.add(var1);
         double var3;
         double var5;
         if (this.ax.size() >= 20) {
            var3 = ai.idealistic.vacan.utils.b.a.b.k(this.ax) * 50.0D;
            var5 = (double)this.hackType.getCheck().a("clicks_per_second_limit", 15);
            double var7 = ai.idealistic.vacan.utils.b.a.b.c((Collection)this.ax);
            double var9 = ai.idealistic.vacan.utils.b.a.b.i(this.ax);
            if (var3 > var5) {
               this.ar.c("limit (" + (int)var3 + "/" + (int)var5 + ")");
            }

            double var11 = Math.abs(Math.floor(var3) - var3);
            if (var11 < 0.07D) {
               if (this.b(1, 2) > 3) {
                  this.as.a(() -> {
                     this.as.c("floor tempo (" + var11 + ")");
                  });
                  this.b(1, -1);
               }
            } else {
               this.b(1, -1);
            }

            if (var9 < 45000.0D) {
               if (this.b(4, 3) > 6) {
                  this.av.a(() -> {
                     this.av.c("kurtosis (" + (int)var9 + ")");
                  });
                  this.b(4, -1);
               }
            } else {
               this.b(4, -2);
            }

            if (var7 < 1100.0D && var7 > 200.0D && var3 > 7.0D) {
               if (this.b(5, 3) > 6) {
                  this.aw.a(() -> {
                     this.aw.c("variance (" + (int)var7 + ")");
                  });
                  this.b(5, -1);
               }
            } else {
               this.b(5, -3);
            }

            this.ax.clear();
         }

         if (this.ay.size() >= 50) {
            var3 = ai.idealistic.vacan.utils.b.a.b.f(this.ay);
            var5 = ai.idealistic.vacan.utils.b.a.b.g(this.ay);
            if (var3 < 50.0D) {
               if (this.b(2, 2) > 3) {
                  this.at.a(() -> {
                     this.at.c("low deviation (" + var3 + ")");
                  });
                  this.b(2, -1);
               }
            } else {
               this.b(2, -1);
            }

            if (var5 < -0.01D) {
               if (this.b(3, 2) > 3) {
                  this.au.a(() -> {
                     this.au.c("invalid skewness (" + var5 + ")");
                  });
                  this.b(3, -1);
               }
            } else {
               this.b(3, -2);
            }

            this.ay.clear();
         }
      }

   }

   private void a(g var1) {
      this.ap = var1.bw;
   }

   private int b(int var1, int var2) {
      this.aq.set(var1, Math.max((Integer)this.aq.get(var1) + var2, 0));
      return (Integer)this.aq.get(var1);
   }

   private boolean w() {
      return System.currentTimeMillis() - this.ap < 70L;
   }

   protected boolean m() {
      return !this.ac.b(6.0D, 6.0D, 6.0D).isEmpty();
   }
}
