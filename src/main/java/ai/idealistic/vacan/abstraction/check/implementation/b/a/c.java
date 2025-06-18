package ai.idealistic.vacan.abstraction.check.implementation.b.a;

import ai.idealistic.vacan.abstraction.check.Check;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerMoveEvent;

public class c extends ai.idealistic.vacan.abstraction.check.b {
   private int aE = 0;
   private int cD = 0;
   private long cE;

   c(ai.idealistic.vacan.abstraction.check.e var1) {
      super(var1, Check.DataType.JAVA, (Check.DetectionType)null, "ground_spoof", true, 500L, 60000L, 80000L, 120000L);
   }

   void a(PlayerMoveEvent var1) {
      this.a(() -> {
         if (this.cE <= System.currentTimeMillis() && !this.ac.dp().aU() && !this.ac.dp().aV() && !this.ac.dp().aW() && this.ac.cg() == null && !this.ac.cr() && !this.ac.co() && !this.ac.bY()) {
            boolean var2 = this.ac.bI();
            boolean var3 = this.c(var1.getTo().clone()) || this.c(var1.getFrom().clone());
            boolean var4 = false;
            List var5 = this.ac.u(2.0D);
            Iterator var6 = var5.iterator();

            while(var6.hasNext()) {
               Entity var7 = (Entity)var6.next();
               if (var7 instanceof Boat) {
                  var4 = true;
                  break;
               }
            }

            if (this.ac.fl) {
               this.ac.fl = false;
               this.cD = 4;
            }

            if (this.cD > 0) {
               --this.cD;
               return;
            }

            if (var2 && !var3 && !var4) {
               byte var8 = 30;
               this.aE += var8;
               if (this.aE >= var8) {
                  this.c("Invalid ground value: " + var2);
               }
            } else if (var2) {
               this.a(3);
            } else {
               this.a(1);
            }
         } else {
            this.aE = 0;
         }

      });
   }

   private void a(int var1) {
      this.aE -= var1;
      if (this.aE < 0) {
         this.aE = 0;
      }

   }

   private boolean c(Location var1) {
      double var2 = var1.getX();
      double var4 = var1.getY() - 0.1D;
      double var6 = var1.getZ();

      for(int var8 = -1; var8 <= 1; ++var8) {
         for(int var9 = -1; var9 <= 1; ++var9) {
            for(int var10 = -1; var10 <= 1; ++var10) {
               Material var11 = this.ac.gL.k(new Location(this.ac.bV(), var2 + (double)var8 * 0.3D, var4 + (double)var9 * 0.5D, var6 + (double)var10 * 0.3D));
               Material var12 = (new ai.idealistic.vacan.abstraction.g.b(new Location(this.ac.bV(), var2 + (double)var8 * 0.3D, var4 + (double)var9 * 0.5D, var6 + (double)var10 * 0.3D))).dO().dA();
               if (var11 != null && var12 != null && (ai.idealistic.vacan.utils.minecraft.world.c.ab(var11) || ai.idealistic.vacan.utils.minecraft.world.c.ab(var12) || var11.name().contains("GRASS"))) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   void R() {
      this.a(() -> {
         this.cE = System.currentTimeMillis() + 1000L;
      });
   }

   void S() {
      this.a(() -> {
         this.cE = System.currentTimeMillis() + 1000L;
      });
   }
}
