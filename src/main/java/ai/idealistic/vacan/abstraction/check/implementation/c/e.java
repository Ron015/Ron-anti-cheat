package ai.idealistic.vacan.abstraction.check.implementation.c;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.abstraction.profiling.MiningHistory;
import java.util.Collection;
import java.util.Iterator;
import org.bukkit.World.Environment;
import org.bukkit.event.block.BlockBreakEvent;

public class e extends ai.idealistic.vacan.abstraction.check.e {
   private static final double eo = 0.9999D;
   private final ai.idealistic.vacan.abstraction.check.a.a[] ep = new ai.idealistic.vacan.abstraction.check.a.a[Environment.values().length];

   private static double[] a(Environment var0, MiningHistory.MiningOre var1) {
      Collection var2 = ai.idealistic.vacan.functionality.d.d.fi();
      byte var3 = 10;
      if (var2.size() < var3) {
         return new double[0];
      } else {
         int var4 = 0;
         double var5 = 0.0D;
         double var7 = 0.0D;
         Iterator var9 = var2.iterator();

         ai.idealistic.vacan.abstraction.profiling.a var10;
         double var11;
         while(var9.hasNext()) {
            var10 = (ai.idealistic.vacan.abstraction.profiling.a)var9.next();
            var11 = var10.a(var1).a(var0);
            if (var11 > 0.0D) {
               ++var4;
               var5 += var11;
            }
         }

         var5 /= (double)var4;
         var9 = var2.iterator();

         while(var9.hasNext()) {
            var10 = (ai.idealistic.vacan.abstraction.profiling.a)var9.next();
            var11 = var10.a(var1).a(var0);
            if (var11 > 0.0D) {
               double var13 = var11 - var5;
               var7 += var13 * var13;
            }
         }

         double var15 = Math.sqrt(var7 / (double)var4);
         if (var4 >= var3) {
            return new double[]{var5 / (double)var4, Math.sqrt(var15 / (double)var4)};
         } else {
            return new double[0];
         }
      }
   }

   public e(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
      Environment[] var3 = Environment.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Environment var6 = var3[var5];
         this.ep[var6.ordinal()] = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, var6.name().toLowerCase(), true, 1L, 1L, 1L, 1L);
      }

   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof Object[]) {
         Object[] var3 = (Object[])var2;
         Environment var4 = Environment.valueOf(var3[0].toString());
         ai.idealistic.vacan.abstraction.check.a.a var5 = this.ep[var4.ordinal()];
         var5.a(() -> {
            double[] var3x = a(var4, (MiningHistory.MiningOre)var3[2]);
            if (var3x.length > 0) {
               double var4x = ((MiningHistory)var3[1]).a(var4);
               if (var4x > 0.0D) {
                  double var6 = ai.idealistic.vacan.utils.b.a.b.R((var4x - var3x[0]) / var3x[1]);
                  if (var6 >= 0.9999D) {
                     var5.c("Unfair gathering of " + var3[3] + " in " + var4.name().toLowerCase() + " world, surpassed " + ai.idealistic.vacan.utils.b.a.e(var6 * 100.0D, 2.0D) + "% of players");
                  }
               }
            }

         });
      } else if (var2 instanceof BlockBreakEvent) {
         BlockBreakEvent var6 = (BlockBreakEvent)var2;
         if (this.j()) {
            var6.setCancelled(true);
         }
      }

   }
}
