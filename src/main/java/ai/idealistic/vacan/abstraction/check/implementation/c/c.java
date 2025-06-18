package ai.idealistic.vacan.abstraction.check.implementation.c;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import org.bukkit.Location;
import org.bukkit.Material;

public class c extends ai.idealistic.vacan.abstraction.check.e {
   private final ai.idealistic.vacan.abstraction.check.b aj = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, (String)null, true);
   private long bw;
   private final ai.idealistic.vacan.abstraction.b.a.a bk = new ai.idealistic.vacan.abstraction.b.a.a();

   public c(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof ai.idealistic.vacan.abstraction.d.a) {
         this.aj.a(() -> {
            ai.idealistic.vacan.abstraction.d.a var2x = (ai.idealistic.vacan.abstraction.d.a)var2;
            if (!ai.idealistic.vacan.compatibility.a.a.d.e(var2x.fu) && !ai.idealistic.vacan.utils.minecraft.world.c.j(var2x.fu.getType())) {
               Material var3 = var2x.fu.getType();
               if (var3 != Material.FIRE && var3 != Material.AIR && (!MultiVersion.c(MultiVersion.MCVersion.V1_13) || var3 != Material.CAVE_AIR && var3 != Material.VOID_AIR)) {
                  long var4 = System.currentTimeMillis() - this.bw;
                  this.bw = System.currentTimeMillis();
                  byte var6 = 20;
                  long var7 = 150L;
                  if (var4 <= var7 && (var4 > 50L || !this.ac.bX())) {
                     double var9 = (double)var7 / (double)var4;
                     if (this.bk.a(var9, var6) >= 9.0D) {
                        this.aj.a("remaining-ticks: " + this.bk.b(var6) + ", place-ms: " + var4 + ", block: " + ai.idealistic.vacan.utils.minecraft.world.c.ae(var3), (Location)null, var6);
                     }
                  }
               }
            }

         });
      }

   }

   protected boolean m() {
      return !this.ac.cr() && !ai.idealistic.vacan.compatibility.a.b.c.i(this.ac) && !ai.idealistic.vacan.compatibility.a.e.b.a(this.ac, new String[]{"drill", "tractor"});
   }
}
