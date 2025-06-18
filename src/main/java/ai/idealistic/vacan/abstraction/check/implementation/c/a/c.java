package ai.idealistic.vacan.abstraction.check.implementation.c.a;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.e;
import ai.idealistic.vacan.utils.minecraft.entity.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Location;
import org.bukkit.block.Block;

public class c extends ai.idealistic.vacan.abstraction.check.b {
   private final Map<Integer, ai.idealistic.vacan.abstraction.b.a.a> eB = new ai.idealistic.vacan.utils.a.c(new ConcurrentHashMap(2), 124);

   c(e var1) {
      super(var1, (Check.DataType)null, Check.DetectionType.BUKKIT, "tower", true);
   }

   void a(Block var1, Location var2, int var3, int var4) {
      this.a(() -> {
         Double var5 = ai.idealistic.vacan.utils.b.a.f(this.ac.getLocation(), this.ac.bM());
         if (var5 != null) {
            if (ai.idealistic.vacan.utils.b.a.f(ai.idealistic.vacan.abstraction.g.b.s(var2), var1.getLocation()) <= 1.0D) {
               int var6 = d.a(this.ac, ai.idealistic.vacan.utils.minecraft.entity.e.lD) + 1;
               int var7 = d.x(var6);
               double var8 = d.w(var6);
               double var10 = 0.4765625D;
               int var12 = var3 - var4;
               int var13 = ai.idealistic.vacan.utils.b.a.z(var8 / var10) + var12;
               if (var5 > 0.1D) {
                  var13 += ai.idealistic.vacan.utils.b.a.B(var5 / 0.25D);
               }

               var13 = Math.max(var13, 2);
               ai.idealistic.vacan.abstraction.b.a.a var14 = (ai.idealistic.vacan.abstraction.b.a.a)this.eB.computeIfAbsent(var1.getX() * 31 + var1.getZ(), (var0) -> {
                  return new ai.idealistic.vacan.abstraction.b.a.a();
               });
               if (var14.a(1.0D, var7) > (double)var13) {
                  var14.aO();
                  this.a("tower, placements: " + var13 + ", horizontal: " + var5 + ", vertical: " + var12, this.ac.bM(), 0, true);
               }
            }

         }
      });
   }
}
