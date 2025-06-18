package ai.idealistic.vacan.abstraction.check.implementation.combat.killaura;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import ai.idealistic.vacan.utils.b.f;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class a extends ai.idealistic.vacan.abstraction.check.b {
   private List<Integer> aW = null;

   a(ai.idealistic.vacan.abstraction.check.e var1) {
      super(var1, (Check.DataType)null, (Check.DetectionType)null, "back_track", true);
   }

   void a(ai.idealistic.vacan.abstraction.d.e var1) {
      this.a(() -> {
         if (var1.fz instanceof Player) {
            if (this.aW == null) {
               this.aW = new ai.idealistic.vacan.utils.a.a();
            }

            ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.i((Player)var1.fz);
            List var3 = var2.bQ();
            boolean var4 = this.ac.a(MultiVersion.MCVersion.V1_8);
            float var5 = var4 ? 0.4F : 0.3F;
            int var6 = 0;

            for(Iterator var7 = var3.iterator(); var7.hasNext(); ++var6) {
               Location var8 = (Location)var7.next();
               if (f.a(this.ac, var8, var1.fz, var5, 3.0F)) {
                  break;
               }
            }

            this.aW.add(var6);
            if (this.aW.size() >= 15) {
               this.x();
            }

         }
      });
   }

   private void x() {
      int var1 = 0;
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;

      int var6;
      for(Iterator var5 = this.aW.iterator(); var5.hasNext(); var1 = var6) {
         var6 = (Integer)var5.next();
         var4 += var6;
         if (var6 > 0 && var1 == 0) {
            ++var2;
         }

         if (var6 == 0) {
            ++var3;
         }
      }

      var4 /= this.aW.size();
      var4 *= 50;
      if (var3 > 5 && var2 > 2) {
         this.c("BackTrack [or past locations abuse] (approximately " + var4 + "ms) [f: " + var2 + ", c: " + var3 + "]");
      }

      this.aW.clear();
   }
}
